# Import requests library
import requests

# Define the model endpoint
endpoint = "https://api-inference.huggingface.co/models/meta-llama/Llama-2-7b-chat-hf"

# Define your API key
api_key = "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"

# Define your list of questions and answers
qa_list = [
    (
        "What is Llama 2?",
        "Llama 2 is a family of large language models released by Meta.",
    ),
    (
        "How many parameters does Llama 2 have?",
        "Llama 2 has models ranging from 7 billion to 70 billion parameters.",
    ),
    (
        "What is Llama 2-Chat?",
        "Llama 2-Chat is a fine-tuned version of Llama 2 optimized for dialogue applications.",
    ),
]

# Convert your list of questions and answers into a single text
context = ""
for qa in qa_list:
    context += "[INST]" + qa[0] + "[SEP]" + qa[1] + "[SEP]"

# Append your input text to the context text
input_text = context + "How many parameters does Llama 2 have?"

# Define your request headers
headers = {"Authorization": f"Bearer {api_key}"}

# Define your request body
body = {"inputs": input_text}

# Send a POST request
response = requests.post(endpoint, headers=headers, json=body)

# Parse the response
result = response.json()

# Check for errors
if isinstance(result, list) and len(result) > 0 and "error" in result[0]:
    print(result[0]["error"])
else:
    # Get the generated text
    output_text = result[0]["generated_text"]

    print(output_text)

    # Extract the answer
    # answer = output_text.split("/n")[1].strip()

    # Print the answer
    # print(result)
