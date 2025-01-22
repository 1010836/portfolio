/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui.launch;

/**
 * A class that provides the tabs for the launch configuration.
 */
public class BaseRequirementsLaunchConfigurationTabGroup extends org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup {
	
	public void createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog dialog, String mode) {
		// Set the overrideLaunchConfigurationTabGroup option to false to implement this
		// method.
		setTabs(new org.eclipse.debug.ui.ILaunchConfigurationTab[] {new baserequirements.resource.baseRequirements.ui.launch.BaseRequirementsLaunchConfigurationMainTab()});
	}
	
}
