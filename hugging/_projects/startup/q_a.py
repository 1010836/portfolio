import json
import requests

API_URL = "https://api-inference.huggingface.co/models/meta-llama/Llama-2-7b-chat-hf"
headers = {"Authorization": "Bearer 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"}


context = (
    "John lives in New York City. He works at ABC Inc. His office is in Manhattan."
)
question = "Where does John work?"
data = {
    "inputs": {"question": question, "context": context},
    "options": {"wait_for_model": True},
}


response = requests.post(API_URL, headers=headers, json=data)
print(response)

# answer = json.loads(response.content.decode("utf-8"))[0]["answer"]
# print(answer)

# response = requests.post(model_url, headers=headers, json=data)
# answer = json.loads(response.content.decode('utf-8'))[0]['answer']
# print(answer)

# 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
