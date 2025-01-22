/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui.launch;

/**
 * A class that provides the tabs for the launch configuration.
 */
public class EntityLaunchConfigurationTabGroup extends org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup {
	
	public void createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog dialog, String mode) {
		// Set the overrideLaunchConfigurationTabGroup option to false to implement this
		// method.
		setTabs(new org.eclipse.debug.ui.ILaunchConfigurationTab[] {new entity.resource.entity.ui.launch.EntityLaunchConfigurationMainTab()});
	}
	
}
