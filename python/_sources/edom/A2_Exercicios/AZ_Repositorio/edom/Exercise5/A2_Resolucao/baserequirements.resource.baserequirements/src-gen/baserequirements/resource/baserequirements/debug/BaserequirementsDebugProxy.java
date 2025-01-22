/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class BaserequirementsDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private baserequirements.resource.baserequirements.debug.BaserequirementsDebugTarget debugTarget;
	
	private baserequirements.resource.baserequirements.debug.BaserequirementsDebugCommunicationHelper communicationHelper = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugCommunicationHelper();
	
	public BaserequirementsDebugProxy(baserequirements.resource.baserequirements.debug.BaserequirementsDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
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
		sendCommand(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.EXIT);
	}
	
	public baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage getStack() {
		return sendCommandAndRead(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage message = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage message = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage response = sendCommandAndRead(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage response = sendCommandAndRead(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		baserequirements.resource.baserequirements.debug.BaserequirementsDebugVariable[] variables  = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = baserequirements.resource.baserequirements.util.BaserequirementsStringUtil.convertFromString(varString);
			
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
			org.eclipse.debug.core.model.IValue value = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			baserequirements.resource.baserequirements.debug.BaserequirementsDebugVariable variable = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes command, String... parameters) {
		baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage message = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage sendCommandAndRead(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes command, String... parameters) {
		baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage message = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
