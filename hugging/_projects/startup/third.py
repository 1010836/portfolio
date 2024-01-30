# Import requests library
import requests

# Define the model endpoint
endpoint = "https://api-inference.huggingface.co/models/meta-llama/Llama-2-7b-chat-hf"

# Define your API key
api_key = "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"

# Define your input text
text = "The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, whose company designed and built the tower.[SEP]How tall is the Eiffel Tower?"

# Define your request headers
headers = {"Authorization": f"Bearer {api_key}"}

# Define your request body
body = {"inputs": text}

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

    # Extract the answer
    answer = output_text.split("\n")[1].strip()

    # Print the answer
    print(answer)
