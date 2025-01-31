/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class EntityDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private entity.resource.entity.debug.EntityDebugTarget debugTarget;
	
	private entity.resource.entity.debug.EntityDebugCommunicationHelper communicationHelper = new entity.resource.entity.debug.EntityDebugCommunicationHelper();
	
	public EntityDebugProxy(entity.resource.entity.debug.EntityDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(entity.resource.entity.debug.EEntityDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(entity.resource.entity.debug.EEntityDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(entity.resource.entity.debug.EEntityDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(entity.resource.entity.debug.EEntityDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(entity.resource.entity.debug.EEntityDebugMessageTypes.EXIT);
	}
	
	public entity.resource.entity.debug.EntityDebugMessage getStack() {
		return sendCommandAndRead(entity.resource.entity.debug.EEntityDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		entity.resource.entity.debug.EntityDebugMessage message = new entity.resource.entity.debug.EntityDebugMessage(entity.resource.entity.debug.EEntityDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		entity.resource.entity.debug.EntityDebugMessage message = new entity.resource.entity.debug.EntityDebugMessage(entity.resource.entity.debug.EEntityDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		entity.resource.entity.debug.EntityDebugMessage response = sendCommandAndRead(entity.resource.entity.debug.EEntityDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		entity.resource.entity.debug.EntityDebugMessage response = sendCommandAndRead(entity.resource.entity.debug.EEntityDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		entity.resource.entity.debug.EntityDebugVariable[] variables  = new entity.resource.entity.debug.EntityDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = entity.resource.entity.util.EntityStringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new entity.resource.entity.debug.EntityDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			entity.resource.entity.debug.EntityDebugVariable variable = new entity.resource.entity.debug.EntityDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(entity.resource.entity.debug.EEntityDebugMessageTypes command, String... parameters) {
		entity.resource.entity.debug.EntityDebugMessage message = new entity.resource.entity.debug.EntityDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private entity.resource.entity.debug.EntityDebugMessage sendCommandAndRead(entity.resource.entity.debug.EEntityDebugMessageTypes command, String... parameters) {
		entity.resource.entity.debug.EntityDebugMessage message = new entity.resource.entity.debug.EntityDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
