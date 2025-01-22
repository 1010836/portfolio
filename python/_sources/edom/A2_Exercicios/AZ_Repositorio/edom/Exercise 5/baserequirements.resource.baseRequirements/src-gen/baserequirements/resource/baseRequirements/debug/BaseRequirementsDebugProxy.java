/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class BaseRequirementsDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugTarget debugTarget;
	
	private baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugCommunicationHelper communicationHelper = new baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugCommunicationHelper();
	
	public BaseRequirementsDebugProxy(baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
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
		sendCommand(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.EXIT);
	}
	
	public baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage getStack() {
		return sendCommandAndRead(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage message = new baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage message = new baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage response = sendCommandAndRead(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage response = sendCommandAndRead(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugVariable[] variables  = new baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = baserequirements.resource.baseRequirements.util.BaseRequirementsStringUtil.convertFromString(varString);
			
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
			org.eclipse.debug.core.model.IValue value = new baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugVariable variable = new baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes command, String... parameters) {
		baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage message = new baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage sendCommandAndRead(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes command, String... parameters) {
		baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage message = new baserequirements.resource.baseRequirements.debug.BaseRequirementsDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
