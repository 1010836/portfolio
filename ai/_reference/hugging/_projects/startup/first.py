import requests

API_URL = "https://api-inference.huggingface.co/models/meta-llama/Llama-2-7b-hf"
headers = {"Authorization": "Bearer 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"}


def query(payload):
    response = requests.post(API_URL, headers=headers, json=payload)
    return response.json()


output = query(
    {
        "inputs": """\
<<SYS>>
John lives in New York City. He works at ABC Inc. His office is in Manhattan.
<</SYS>>

[INST]
Where does John work?
[/INST]
""",
    }
)

print(output)

# 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
