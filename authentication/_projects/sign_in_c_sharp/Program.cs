// Add a new endpoint to receive the form post from the authorization server
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Authentication.OpenIdConnect;
using Microsoft.IdentityModel.Protocols.OpenIdConnect;
using System.Security.Claims;
using System.Text;

// The id_token is stored in a cookie to simplify this sample
// However this way of using sessions is forbidden because the id_token might be pretty big.
// It should be stored in the backend
string StoreIdToken(TokenValidatedContext ctx)
{
    var token = ctx.ProtocolMessage.IdToken;
    ctx.Response.Cookies.Append("id_token", token);
    return "session_id";
}

void RemoveIdToken(HttpResponse ctx)
{
    ctx.Cookies.Delete("id_token");
}

string RetrieveIdToken(HttpRequest ctx)
{
    return ctx.Cookies["id_token"] ?? "";
}

List<Claim> TransformClaims(IEnumerable<Claim> inputClaims)
{
    // get the accounts for which the user has access to a specific service
    var accounts_with_access = inputClaims
      .Where(c => c.Type == "extended_role")
      .Select(c =>
      {
          var splitted = c.Value.Split(", ");
          return new
          {
              Service = splitted[0],
              Account = splitted[1]
          };
      })
      .Where(ar => ar.Service == "BAL")
      .Select(ar => ar.Account)
      .ToList();

    // remove the 'extended_role' claims to reduce cookie size
    var transformedClaims = inputClaims.Where(c => c.Type != "extended_role").ToList();

    // ... and add the new account claims
    transformedClaims.AddRange(accounts_with_access.Select(r => new Claim("account", r)));
    return transformedClaims;
}

string RenderHomePage(IEnumerable<Claim> claims)
{
    var writer = new StringBuilder();

    // show claims
    writer.AppendLine("<table>");
    foreach (var claim in claims)
    {
        writer.AppendLine($"<tr><td>{claim.Type}</td><td>{claim.Value}</td></tr>");
    }
    writer.AppendLine("</table>");

    // show logout link
    writer.AppendLine("<p><a href='/logout'>federated logout</a></p>");

    return writer.ToString();
}

var builder = WebApplication.CreateBuilder(args);
builder.WebHost.UseSetting("https_port", "5001");
builder.WebHost.UseUrls("http://localhost:5119", "https://localhost:5001");

// pulse-os.assistant: from sign-in service
string CLIENT_ID = "db2b2a25-1e17-4c08-a244-288db1a5ddec";
string CLIENT_SECRET = "zeG8Q~HovGDRlyJX8n1vGsXdQ6eZKztuzst1jbPo";
string SAMESITE_NONE_COOKIE_NAME = "SameSiteNone";

var services = builder.Services;

services
  .AddAuthentication(
    options =>
    {
        options.DefaultScheme = CookieAuthenticationDefaults.AuthenticationScheme;
        options.DefaultChallengeScheme = OpenIdConnectDefaults.AuthenticationScheme;
    }
  )

  // we use cookies for everything but the challenge (ie first time authentication in a session)
  // The SAMESITE_NONE_COOKIE_NAME cookie is here because the frontchannel logout works with
  // a crossdomain request. The logout must be able to remove the cookie.
  // This cookie is required for the session.
  .AddCookie(options =>
  {
      options.Events.OnSignedIn = ctx =>
      {
          ctx.Response.Cookies.Append(
            SAMESITE_NONE_COOKIE_NAME,
            "whatever",
            new CookieOptions { SameSite = SameSiteMode.None, HttpOnly = true, Secure = true });
          return Task.CompletedTask;
      };

      options.Events.OnSigningOut = ctx =>
      {
          ctx.Response.Cookies.Delete(SAMESITE_NONE_COOKIE_NAME);
          return Task.CompletedTask;
      };

      options.Events.OnValidatePrincipal = ctx =>
      {
          var cookie = ctx.Request.Cookies[SAMESITE_NONE_COOKIE_NAME];
          if (string.IsNullOrEmpty(cookie))
          {
              // a frontchannel logout has occured.
              ctx.RejectPrincipal();
          }
          return Task.CompletedTask;
      };
  })

  // here we configure the OpenID Connect authentication
  .AddOpenIdConnect(options =>
  {
      options.ClientId = CLIENT_ID;
      options.ClientSecret = CLIENT_SECRET;

      // for production use https://signin.cegid.com/signin.cegid.com/v2.0/.well-known/openid-configuration?p=B2C_1A_SIGNINOIDC-V2
      options.MetadataAddress = "https://inte-signin.cegid.com/inte-signin.cegid.com/v2.0/.well-known/openid-configuration?p=B2C_1A_SIGNINOIDC-V2";
      options.Scope.Clear();
      options.Scope.Add(OpenIdConnectScope.OpenId);
      options.Scope.Add("https://example.com/calendar.read");
      options.ResponseType = OpenIdConnectResponseType.IdTokenToken;

      // if the client is confidential
      options.ResponseType = OpenIdConnectResponseType.Code;
      // options.ResponseMode = OpenIdConnectResponseMode.FormPost;

      options.UsePkce = false;

      // this event will be triggered at the end of authentication
      // the goal is to avoid storing everything in the cookies
      options.Events.OnTokenValidated = ctx =>
      {
          var principal = ctx.Principal;
          if (principal == null)
          {
              return Task.CompletedTask;
          }

          var sessionId = StoreIdToken(ctx);

          var transformedClaims = TransformClaims(principal.Claims);

          if (!transformedClaims.Any(c => c.Type == "account_id"))
          {
              ctx.Fail("user has no access right on the service");
          }
          transformedClaims.Add(new Claim("session_id", sessionId));
          var identity = new ClaimsIdentity(transformedClaims, principal.Identity.AuthenticationType);
          ctx.Principal = new ClaimsPrincipal(identity);
          return Task.CompletedTask;
      };

      options.Events.OnRedirectToIdentityProviderForSignOut = ctx =>
      {
          // a real storage would need the session id to retrieve the id_token
          ctx.ProtocolMessage.IdTokenHint = RetrieveIdToken(ctx.Request);
          return Task.CompletedTask;
      };

      options.Events.OnSignedOutCallbackRedirect = ctx =>
      {
          RemoveIdToken(ctx.Response);
          return Task.CompletedTask;
      };
  });

services.AddAuthorization();

var app = builder
  .Build();
app.UseAuthentication();
app.UseAuthorization();

app.MapGet(
    "/",
    async (ctx) =>
    {
        if (ctx.User.Identity.IsAuthenticated)
        {
            await ctx.Response.WriteAsync(RenderHomePage(ctx.User.Claims));
        }
        else
        {
            ctx.Response.Redirect("/log-in");
        }
    }
);

app.MapGet(
    "/log-in",
    async (ctx) =>
    {
        await ctx.Response.WriteAsync("Log in page");
    }
).RequireAuthorization();

app.MapGet(
    "/logout",
    async (ctx) =>
    {
        if (string.IsNullOrEmpty(RetrieveIdToken(ctx.Request)))
        {
            // For some reason we have lost the id_token
            // in this case we cannot do a federated logout.
            // We stil perform a local logout to avoid
            // blocking the user.
            await ctx.SignOutAsync(CookieAuthenticationDefaults.AuthenticationScheme);
        }
        else
        {
            await ctx.SignOutAsync(CookieAuthenticationDefaults.AuthenticationScheme);
            await ctx.SignOutAsync(OpenIdConnectDefaults.AuthenticationScheme);
        }
    }
);

app.MapGet(
    "/local-logout",
    async (ctx) =>
    {
        RemoveIdToken(ctx.Response);
        await ctx.SignOutAsync(CookieAuthenticationDefaults.AuthenticationScheme);
    }
);

app.Run();
