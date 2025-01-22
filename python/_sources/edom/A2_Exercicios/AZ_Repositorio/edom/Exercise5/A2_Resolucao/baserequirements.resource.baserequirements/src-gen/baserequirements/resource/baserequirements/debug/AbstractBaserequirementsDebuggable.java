/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.debug;

public abstract class AbstractBaserequirementsDebuggable {
	
	/**
	 * The list of breakpoints, where each breakpoint is represented by its location
	 * (a string) and the line number
	 */
	private java.util.List<baserequirements.resource.baserequirements.util.BaserequirementsPair<String, Integer>> lineBreakpoints = new java.util.ArrayList<baserequirements.resource.baserequirements.util.BaserequirementsPair<String, Integer>>();
	private java.io.PrintStream outputStream;
	private java.net.ServerSocket server;
	private boolean debugMode;
	private boolean suspend;
	
	private baserequirements.resource.baserequirements.debug.BaserequirementsDebugCommunicationHelper communicationHelper = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugCommunicationHelper();
	
	public void startEventSocket(int eventPort) {
		try {
			// starting event server socket (waiting for connection)...
			server = new java.net.ServerSocket(eventPort);
			java.net.Socket accept = server.accept();
			// starting event server socket done (connection established).
			outputStream = new java.io.PrintStream(accept.getOutputStream());
		} catch (Exception e) {
			new baserequirements.resource.baserequirements.util.BaserequirementsRuntimeUtil().logError("Can't create socket connection while launching.", e);
		}
	}
	
	public void stopEventSocket() {
		try {
			server.close();
		} catch (java.io.IOException e) {
			new baserequirements.resource.baserequirements.util.BaserequirementsRuntimeUtil().logError("Exception while closing socket.", e);
		}
	}
	
	public void sendEvent(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes command, boolean sendOnlyInDebugMode, String... arguments) {
		if (isDebugMode() || !sendOnlyInDebugMode) {
			baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage message = new baserequirements.resource.baserequirements.debug.BaserequirementsDebugMessage(command, arguments);
			communicationHelper.sendEvent(message, outputStream);
		}
	}
	
	public void evaluateLineBreakpoint(org.eclipse.emf.common.util.URI uri, int currentLine) {
		if (isDebugMode()) {
			String platformString = uri.toPlatformString(true);
			org.eclipse.core.resources.IResource member = org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
			if (member == null) {
				return;
			}
			String location = member.getRawLocation().toPortableString();
			for (int i = 0; i < lineBreakpoints.size(); i++) {
				baserequirements.resource.baserequirements.util.BaserequirementsPair<String, Integer> breakpointLocationAndLine = lineBreakpoints.get(i);
				String breakpointLocation = breakpointLocationAndLine.getLeft();
				Integer breakpointLine = breakpointLocationAndLine.getRight();
				if (breakpointLine.intValue() == currentLine && breakpointLocation.equals(location)) {
					// suspending...
					setSuspend(true);
					sendEvent(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.SUSPENDED, true, new String[] {"breakpoint", "" + currentLine});
					break;
				}
			}
			waitIfSuspended();
		}
	}
	
	public void waitIfSuspended() {
		try {
			while (isSuspend()) {
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
		}
		sendEvent(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.RESUMED, true);
	}
	
	public void addLineBreakpoint(String location, int line) {
		lineBreakpoints.add(new baserequirements.resource.baserequirements.util.BaserequirementsPair<String, Integer>(location, new Integer(line)));
	}
	
	public void removeLineBreakpoint(String location, int line) {
		lineBreakpoints.remove(new baserequirements.resource.baserequirements.util.BaserequirementsPair<String, Integer>(location, new Integer(line)));
	}
	
	public void resume() {
		setSuspend(false);
	}
	
	public void terminate() {
		sendEvent(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.TERMINATED, false);
		stopEventSocket();
	}
	
	public boolean isDebugMode() {
		return debugMode;
	}
	
	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}
	
	public boolean isSuspend() {
		return suspend;
	}
	
	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}
	
	/**
	 * This method must be called before the actual execution of the interpreter or
	 * generated code. Its purpose is to send an event to the debug server to signal
	 * that the debuggable has started and wait until the server has installed all
	 * breakpoints and signals to resume (i.e., to start the actual execution).
	 */
	public void startUpAndWait() {
		// suspend here after startup to wait for the installation of deferred breakpoints
		if (isDebugMode()) {
			sendEvent(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.STARTED, true);
			setSuspend(true);
			// wait until server sends the RESUME event
			while (isSuspend()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
			// confirm that the debuggable was resumed
			sendEvent(baserequirements.resource.baserequirements.debug.EBaserequirementsDebugMessageTypes.RESUMED, true);
		}
	}
	
	public abstract void stepOver();
	public abstract void stepInto();
	public abstract void stepReturn();
	public abstract String[] getStack();
	public abstract java.util.Map<String, Object> getFrameVariables(String stackFrame);
}
