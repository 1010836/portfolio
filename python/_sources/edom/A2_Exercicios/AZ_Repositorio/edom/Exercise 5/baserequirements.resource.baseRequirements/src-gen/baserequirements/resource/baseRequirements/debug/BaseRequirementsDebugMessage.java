/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class BaseRequirementsDebugMessage {
	
	private static final char DELIMITER = ':';
	private baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes messageType;
	private String[] arguments;
	
	public BaseRequirementsDebugMessage(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public BaseRequirementsDebugMessage(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes getMessageType() {
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
		return baserequirements.resource.baseRequirements.util.BaseRequirementsStringUtil.encode(DELIMITER, parts);
	}
	
	public static BaseRequirementsDebugMessage deserialize(String response) {
		java.util.List<String> parts = baserequirements.resource.baseRequirements.util.BaseRequirementsStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes type = baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes.valueOf(messageType);
		BaseRequirementsDebugMessage message = new BaseRequirementsDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(baserequirements.resource.baseRequirements.debug.EBaseRequirementsDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + baserequirements.resource.baseRequirements.util.BaseRequirementsStringUtil.explode(arguments, ", ") + "]";
	}
	
}
