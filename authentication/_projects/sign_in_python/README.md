# CEGID ACCOUNT APP

## Description

This project contains python examples to demonstrate how to implement multiple OAUTH2 flows

## CEGID TOKEN CLIENT APP

```json
{
    "id": "skunk.tests",
    "applicationSuiteId": "business-os-inte",
    "accessTokenValiditySeconds": 3600,
    "allowClientCredentials": false,
    "allowOfflineAccess": true,
    "applicationType": "AuthorizationCodeWithPkce",
    "clientId": "business-os-inte.app.skunk.tests",
    "clientIdAlias": null,
    "internalDescription": "Test app to be used by skunk works",
    "redirectUris": [
        "http://localhost:8990/callback",
        "https://st-pulse-api.azurewebsites.net/docs/oauth2-redirect"
    ],
    "refreshTokenValiditySeconds": 86400,
    "requireClientSecret": false,
    "reusableRefreshToken": true,
    "scopes": [
        {
            "scopeId": "business-os-inte.build.rw",
            "granted": true
        },
        {
            "scopeId": "business-os-inte.request.rw",
            "granted": true
        },
        {
            "scopeId": "devisfact-dev.aiapi.global",
            "granted": true
        }
    ],
    "signinApplicationClientId": null
}
```

# Install

PDM install

# Run

python -m main.py
