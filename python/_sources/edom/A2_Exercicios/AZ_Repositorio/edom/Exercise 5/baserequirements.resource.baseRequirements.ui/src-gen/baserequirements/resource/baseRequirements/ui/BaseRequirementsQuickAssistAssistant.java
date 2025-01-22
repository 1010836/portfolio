/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

public class BaseRequirementsQuickAssistAssistant extends org.eclipse.jface.text.quickassist.QuickAssistAssistant implements org.eclipse.jface.text.quickassist.IQuickAssistAssistant {
	
	public BaseRequirementsQuickAssistAssistant(baserequirements.resource.baseRequirements.IBaseRequirementsResourceProvider resourceProvider, baserequirements.resource.baseRequirements.ui.IBaseRequirementsAnnotationModelProvider annotationModelProvider) {
		setQuickAssistProcessor(new baserequirements.resource.baseRequirements.ui.BaseRequirementsQuickAssistProcessor(resourceProvider, annotationModelProvider));
		setInformationControlCreator(new org.eclipse.jface.text.AbstractReusableInformationControlCreator() {
			public org.eclipse.jface.text.IInformationControl doCreateInformationControl(org.eclipse.swt.widgets.Shell parent) {
				return new org.eclipse.jface.text.DefaultInformationControl(parent, (org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter) null);
			}
		});
	}
	
	public boolean canAssist(org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext invocationContext) {
		return false;
	}
	
	public boolean canFix(org.eclipse.jface.text.source.Annotation annotation) {
		return true;
	}
	
}
