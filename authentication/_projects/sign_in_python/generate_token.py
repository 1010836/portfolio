import jwt
import json
import datetime
from cryptography.hazmat.primitives.asymmetric import rsa
from cryptography.hazmat.primitives import serialization

def generate_rsa_key_pair():
    
    # Generate a new RSA private key and extract its public key
    private_key = rsa.generate_private_key(public_exponent=65537, key_size=2048)
    public_key = private_key.public_key()
    
    # Serialize the private key in PEM format (no encryption here)
    private_pem = private_key.private_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PrivateFormat.PKCS8,
        encryption_algorithm=serialization.NoEncryption()
    )
    
    # Serialize the public key in PEM format
    public_pem = public_key.public_bytes(
        encoding=serialization.Encoding.PEM,
        format=serialization.PublicFormat.SubjectPublicKeyInfo
    )
    
    return private_pem, public_pem

def create_oauth2_token():

    # Generate RSA keys for signing (or load your own keys)
    private_key_pem, public_key_pem = generate_rsa_key_pair()

    # Define the token payload with standard JWT claims
    now = datetime.datetime.utcnow()
    payload = {
        "iss": "your-issuer",                      # The issuer of the token
        "sub": "user123",                          # The subject (user id)
        "aud": "your-audience",                    # The audience for which this token is intended
        "iat": now,                                # Issued at time
        "exp": now + datetime.timedelta(hours=1)   # Expiration time (1 hour from now)
    }

    # Sign the token using the RSA private key and RS256 algorithm
    token = jwt.encode(payload, private_key_pem, algorithm="RS256")
    
    # Construct the JSON response similar to what an OAuth2 server would return
    token_response = {
        "access_token": token,
        "token_type": "Bearer",
        "expires_in": 3600  # Expiry time in seconds
    }
    
    return token_response, public_key_pem

if __name__ == '__main__':

    token_response, public_key = create_oauth2_token()
    print("OAuth2 Token Response:")
    print(json.dumps(token_response, indent=2))
    
    # Optionally, print the public key used for verification
    print("\nPublic Key (PEM):")
    print(public_key.decode('utf-8'))
