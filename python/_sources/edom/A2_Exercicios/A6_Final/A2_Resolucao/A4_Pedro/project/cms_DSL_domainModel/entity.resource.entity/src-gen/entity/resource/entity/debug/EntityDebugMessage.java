/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class EntityDebugMessage {
	
	private static final char DELIMITER = ':';
	private entity.resource.entity.debug.EEntityDebugMessageTypes messageType;
	private String[] arguments;
	
	public EntityDebugMessage(entity.resource.entity.debug.EEntityDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public EntityDebugMessage(entity.resource.entity.debug.EEntityDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public entity.resource.entity.debug.EEntityDebugMessageTypes getMessageType() {
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
		return entity.resource.entity.util.EntityStringUtil.encode(DELIMITER, parts);
	}
	
	public static EntityDebugMessage deserialize(String response) {
		java.util.List<String> parts = entity.resource.entity.util.EntityStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		entity.resource.entity.debug.EEntityDebugMessageTypes type = entity.resource.entity.debug.EEntityDebugMessageTypes.valueOf(messageType);
		EntityDebugMessage message = new EntityDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(entity.resource.entity.debug.EEntityDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + entity.resource.entity.util.EntityStringUtil.explode(arguments, ", ") + "]";
	}
	
}
