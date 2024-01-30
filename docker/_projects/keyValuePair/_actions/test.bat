curl -X POST -H "Content-Type: application/json" -d "{\"key\":\"address\", \"value\":\"http\"}" http://127.0.0.1:5000/store
curl http://127.0.0.1:5000/retrieve/address