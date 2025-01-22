/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class BaserequirementsDebugMessage {
	
	private static final char DELIMITER = ':';
	private baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes messageType;
	private String[] arguments;
	
	public BaserequirementsDebugMessage(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public BaserequirementsDebugMessage(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return baserequirements.resource.baserequirements.util.BaserequirementsStringUtil.encode(DELIMITER, parts);
	}
	
	public static BaserequirementsDebugMessage deserialize(String response) {
		java.util.List<String> parts = baserequirements.resource.baserequirements.util.BaserequirementsStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes type = baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.valueOf(messageType);
		BaserequirementsDebugMessage message = new BaserequirementsDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + baserequirements.resource.baserequirements.util.BaserequirementsStringUtil.explode(arguments, ", ") + "]";
	}
	
}
