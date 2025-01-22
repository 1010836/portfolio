# region 1. import
from fastapi import FastAPI
from fastapi.responses import FileResponse, HTMLResponse
import requests
import secrets
import hashlib
import base64
import urllib.parse
import uvicorn
from fastapi import Request
# endregion

# region 2. postman

# Configure Postman Proxy settings
# PROXY_HOST = "localhost"
# PROXY_PORT = 5559
# PROXY_URL = f"http://{PROXY_HOST}:{PROXY_PORT}"

# Set up proxy configuration
# proxies = {
#     "http": PROXY_URL,
#     "https": PROXY_URL,
# }

# example of a request with proxy
# response = requests.post(url, data=data_as_form_data, headers=headers, proxies=proxies, verify=False)

# endregion

# region 3. global
code_verifier = secrets.token_urlsafe(32)
# endregion

# region 4. FastApi

# region    4.1 app
app = FastAPI()
# endregion

# region    4.2 favicon.ico
@app.get("/favicon.ico", include_in_schema=False)
async def favicon():
    return FileResponse("favicon.ico")
# endregion

# region    4.3 main

# region        4.3.1 route

@app.get("/", response_class=HTMLResponse)
async def main():

    auth_details = prepare_authorization()

    html_content = f"""
    <html>
        <body>
            <h1>Test App for Cegid Account Login</h1>
            <p>This is a test APP to demonstrate the Cegid account login.</p>
            <p>State: {auth_details['state']}</p>
            <p>Code Verifier: {auth_details['code_verifier']}</p>
            <p>Code Challenge: {auth_details['code_challenge']}</p>
            <p>Authorization URL: <a href="{auth_details['auth_url']}">Login Here</a></p>
        </body>
    </html>
    """

    result = HTMLResponse(content=html_content)

    return result

# endregion

# region        4.3.2 prepare_authorization()

def prepare_authorization():

    state = secrets.token_urlsafe(32)
    
    code_challenge = base64.urlsafe_b64encode(
        hashlib.sha256(code_verifier.encode('utf-8')).digest()
    ).decode('utf-8').rstrip('=')

    url = "https://inte-oauth.cegid.com/authorize"
    params = {
        "response_type": "code",
        "client_id": "business-os-inte.app.skunk.tests",
        "redirect_uri": "http://localhost:8990/callback",
        "scope": "business-os-inte.build.rw business-os-inte.request.rw offline_access",
        "state": state,
        "code_challenge": code_challenge,
        "code_challenge_method": "S256"
    }
    auth_url = f"{url}?{urllib.parse.urlencode(params)}"

    result = {
        "state": state,
        "code_verifier": code_verifier,
        "code_challenge": code_challenge,
        "auth_url": auth_url
    }

    return result

# endregion

# endregion

# region    4.4 callback

# region       4.4.1 route
@app.get("/callback")
async def api_auth_callback(request: Request):

    code = request.query_params.get('code')
    state = request.query_params.get('state')

    if not code:
        
        error = request.query_params.get('error')

        if error:
            
            html_content = f"""
            <html>
                <body>
                    <h1>Authorization Error</h1>
                    <p>Error: {error}</p>
                </body>
            </html>
            """

            result = HTMLResponse(content=html_content, status_code=400)

            return result

    # Exchange the authorization code for tokens
    token_response = exchange_code_for_token(code)

    if "error" in token_response:
        html_content = f"""
        <html>
            <body>
                <h1>Token Exchange Error</h1>
                <p>Error: {token_response['error']}</p>
            </body>
        </html>
        """
        return HTMLResponse(content=html_content, status_code=400)

    access_token = token_response.get("access_token")
    refresh_token = token_response.get("refresh_token")

    html_content = f"""
    <html>
        <body>
            <h1>Authorization Successful</h1>
            <p>Access Token: {access_token}</p>
            <p>Refresh Token: {refresh_token}</p>
        </body>
    </html>
    """
    result = HTMLResponse(content=html_content, status_code=200)

    return result

# endregion

# region       4.4.2 exchange_code_for_token()
def exchange_code_for_token(code):

    url = "https://inte-oauth.cegid.com/token"

    data = {
        "grant_type": "authorization_code",
        "code": code,
        "redirect_uri": "http://localhost:8990/callback",
        "client_id": "business-os-inte.app.skunk.tests",
        "code_verifier": code_verifier
    }

    auth_header = "Basic " + base64.b64encode(
        f"business-os-inte.app.skunk.tests:".encode("utf-8")
    ).decode("utf-8")

    headers = {
        "content-type": "application/x-www-form-urlencoded",
        "Authorization": auth_header,
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36"
    }
    data_as_form_data = urllib.parse.urlencode(data)

    try:
        response = requests.post(url, data=data_as_form_data, headers=headers) #, proxies=proxies, verify=False)
        response.raise_for_status()
    except requests.exceptions.RequestException as e:
        return {"error": str(e)}

    try:
        result = response.json()
    except ValueError:
        return {"error": "Invalid JSON response"}

    return result

# endregion

# endregion

# endregion

# region 5. run
uvicorn.run(app, host="127.0.0.1", port=8990)
# endregion