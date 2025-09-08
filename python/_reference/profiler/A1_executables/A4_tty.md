# Docker TTY

## 1. Docker Image

### 1.1 description
    
    1. for a textual console application to be interactive
        1.1 the container must be created with a pseudo-TTY (teletype) session enabled
        1.2 its standard input (`stdin`) kept open

    2. when creating your `Dockerfile`
        2.1 you need to ensure the final `CMD` or `ENTRYPOINT` instruction 
        2.2 runs your application directly

```dockerfile
# Start from a Python base image
FROM python:3.10-slim

# Set the working directory
WORKDIR /app

# Copy the application files (your 'dist' folder from PyInstaller)
COPY dist/myapp /app/myapp

# Command to run the application
CMD ["./myapp"]
```

    3. the key is that when you deploy this to Azure Container Instances - ACI
        3.1 you will instruct Azure to run it in an interactive mode

## 2. deploy container to ACI

    1. when creating the container instance 
        1.1 using the Azure CLI
    2 need to include two specific flags:

*   `--tty`: 

    This allocates a pseudo-TTY, which is essential for most console and textual user interface (TUI) applications.

*   `--interactive`: 
    
    This keeps the standard input (`stdin`) open, allowing the user to type and interact with the application.

### 2.1 Example

```bash
az container create \
    --resource-group YourResourceGroup \
    --name my-textual-app-instance \
    --image yourregistry.azurecr.io/pyinstaller-textual-app:latest \
    --restart-policy Never \
    --interactive \
    --tty
```

#### 2.1.1 Restart Policy:
    1. for an interactive, single-session application, 
        1.1 setting `--restart-policy Never` or `OnFailure` is often best
    2.  this ensures that once a user is done and exits the application,
        2.1 the container stops and you are no longer paying for it

## 3. provide users access

    1. once the container is running, 
        1.1 users will not "log in" in the traditional sense
    2. instead, they will **attach** their local console 
        2.1 to the running container's input and output streams
    2. this is done using a single Azure CLI command

```bash
az container attach --resource-group YourResourceGroup --name my-textual-app-instance
```

### 3.1 what

    1.  the Azure CLI authenticates the user. 
        1.1 They must have the Azure CLI installed and be logged in with `az login`

    2.  it establishes a connection to the specified container instance

    3.  their local terminal is "attached" to 
        3.1 the running application inside the container

    4.  anything the textual app prints to the console will appear on the user's terminal

    5.  anything the user types into their terminal will be sent as input to the textual app

    6. this provides a direct, interactive session with your application, 
        6.1 isolated within its own container.

### The Multi-User Workflow

To manage multiple simultaneous users, your workflow would look like this:

1.  **For each user session, deploy a new container instance.** You would likely script this process. The script would generate a unique container name for each user (e.g., `textual-app-user-john-doe`).
2.  **Provide the user with their specific `az container attach` command.** This command will include the unique name of the container instance created for them.
3.  **Clean up.** When the user is finished and exits the application, the container will stop (due to the `Never` restart policy). You should have a process to periodically delete stopped containers (`az container delete`) to keep your Azure environment clean and avoid costs associated with storing stopped containers.

### Alternative: `az container exec` (Less Ideal for this Use Case)

Azure also offers the `az container exec` command, which is useful for debugging by allowing you to run a new process *inside* an already running container. For example, you could run a shell like `/bin/bash` to poke around the container's file system.

However, `az container exec` is **not** the right tool for connecting to your primary application because:

*   **It starts a new process.** `attach` connects to the main process that was started with the container (your app). `exec` would start a second, separate process.
*   **It's for "out-of-band" access.** Think of it as opening a side door for debugging, not walking through the front door to use the app.

For a user to access and use your textual application as intended, **`az container attach` is the correct method**.
