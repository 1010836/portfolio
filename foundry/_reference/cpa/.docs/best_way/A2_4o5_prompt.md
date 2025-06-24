I need the perfect prompt to use in CHATGPT DEEP RESEARCH to create a report that researchs the best solution to solve this problem:
"I have a python application deployed in azure in containers and K8s.  
This application is composed by an REST API the receives posts to execute what we call "requests" this API does not scale only provides 3 instances that are enough. 
This posts creates a message in a REDIS queue for every "request".
Then there is a worker that scales according to the number o messages we have on the REDIS queue.
This worker is deployed in a container and scales using K8s and KEDA.
This workers access REDIS queue using celery and for every request there is a message in the REDIS queue and the every worker gets a message and run the engine that processes it.
Every worker is a celery APP that can create multiple processes inside the container, one for every core. There are  4 core for every container.
So in every container we  can execute de engine to process 4 requests, one in a new process using one of the cores. 
We have at lest 3 workers all the time available so we can process 3x4=12 requests before K8s and Keda start scaling containers with workers.
When in the REDIS queue we have more then 12 messages K8 and KEDA add a new container that celery can use to create more 4 processes and in every process we can process the request that is represented in the REDIS queue.
To process every request the celery app uses a python package that contains the engine to process the request.
Now we need to allow for the creation os custom engines by our clients.
And we need to use different engines to process different requests that have a field that identifies the engine that the request should use.
This custom engines should be created by our clients and the clients should be able to deploy their engines to our system. The publication of this engines is not controlled by the deployment process of our system. Is a separated deployment process then the process used by my company to deploy our app.
This custom engines must implement a standard interface that we provide to them.
What is the best way to implement this process?"
This report should justify why the selected solution is the best, what are other possibilities and explain step by step in detail the process to implement the selected solution.
There should be snippets of code to explain every required step if applicable (python and power shell commands, etc)