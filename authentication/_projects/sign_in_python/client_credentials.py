# region 1. import
import requests
import base64
import urllib.parse
import uvicorn
# endregion

# region 2. postman

# region   2.1 settings
PROXY_HOST = "localhost"
PROXY_PORT = 5559
PROXY_URL = f"http://{PROXY_HOST}:{PROXY_PORT}"
# endregion

# region   2.2 proxy
proxies = {
    "http": PROXY_URL,
    "https": PROXY_URL,
}
# endregion

# region   2.3 example
# response = requests.post(url, data=data_as_form_data, headers=headers, proxies=proxies, verify=False)
# endregion

# endregion

# region 3. get_client_credentials_access_token()

def get_client_credentials_access_token():

    url = "https://inte-oauth.cegid.com/token"

    data = {
        "grant_type": "client_credentials",
        "client_id": "backend",
        "client_secret": "3bGz9OZE2Gd9A0xz-JkKey2SpWtnNn5LJ_AndMrqN10", 
        "scope": "business-os-dev.build.rw business-os-dev.request.rw"
    }

    auth_header = "Basic " + base64.b64encode(
        f"backend:3bGz9OZE2Gd9A0xz-JkKey2SpWtnNn5LJ_AndMrqN10".encode("utf-8")
    ).decode("utf-8")

    headers = {
        "content-type": "application/x-www-form-urlencoded",
        # "Authorization": auth_header,
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36"
    }
    data_as_form_data = urllib.parse.urlencode(data)

    try:
        response = requests.post(url, data=data_as_form_data, headers=headers, proxies=proxies, verify=False)
        response.raise_for_status()
    except requests.exceptions.RequestException as e:
        return {"error": "on get: " + str(e)}

    try:
        result = response.json()
    except ValueError:
        return {"error": "Invalid JSON response"}

    return result

# endregion

# region 4. run

result = get_client_credentials_access_token()
print(result)

# endregion