# 1. imports
import os
import pickle
from flask import Flask, jsonify, request
from flask_cors import CORS

# 2. create flask_app
flask_app = Flask(__name__)
CORS(flask_app)

# 3. initialize emptyDictionary
data_store = {}

# 4. load data from:disk
if os.path.exists('data_store.pkl'):
    with open('data_store.pkl', 'rb') as f:
        data_store = pickle.load(f)

# 5. endpoint: /
@flask_app.route('/')
def explain():
    return '''
    <html>
        <body>
            <h1>REST API to save and retrieve key-value pairs</h1>
            <br>
            <br>
            <hr>
            <h2>Endpoints:</h1>
            <ol>
                <li>curl -X POST -H "Content-Type: application/json" -d '{"key":"myKey", "value":"myValue"}' http://URL/store</li>
                <li>curl http://URL/retrieve/KEY</li>
            </ol> 
        </body>
    </html>
    '''

# 6. endpoint: store
@flask_app.route('/store', methods=['POST'])
def store():

    # 1. get parameters
    key = request.json['key']
    value = request.json['value']
    
    # 2. add keyValuePair to:dictionary
    data_store[key] = value

    # 3. save to:disk
    with open('data_store.pkl', 'wb') as f:
        pickle.dump(data_store, f)

    # 4. output
    return jsonify({'message': 'Stored successfully'}), 200

# 7. endpoint: retrieve
@flask_app.route('/retrieve/<key>', methods=['GET'])
def retrieve(key):
    
    # 1. output data
    if key in data_store:
        return jsonify({key: data_store[key]}), 200
    
    # 1. output error
    return jsonify({'message': 'Key not found'}), 404

# 8. run flask_app
if __name__ == '__main__':
    flask_app.run()    