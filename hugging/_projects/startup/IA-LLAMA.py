import requests

API_URL = "https://api-inference.huggingface.co/models/nordGARA/IA-LLAMA"
headers = {"Authorization": "Bearer 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"}


def query(payload):
    response = requests.post(API_URL, headers=headers, json=payload)
    return response.json()


output = query(
    {
        "inputs": {
            "question": "What's my name?",
            "context": "My name is Clara and I live in Berkeley.",
        },
    }
)

print(output)
