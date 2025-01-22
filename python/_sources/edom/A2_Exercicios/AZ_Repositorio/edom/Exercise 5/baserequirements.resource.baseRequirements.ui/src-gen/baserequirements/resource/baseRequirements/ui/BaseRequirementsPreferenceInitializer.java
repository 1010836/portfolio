/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.ui;

/**
 * A class used to initialize default preference values.
 */
public class BaseRequirementsPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = baserequirements.resource.baseRequirements.ui.BaseRequirementsUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(baserequirements.resource.baseRequirements.ui.BaseRequirementsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(baserequirements.resource.baseRequirements.ui.BaseRequirementsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = baserequirements.resource.baseRequirements.ui.BaseRequirementsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new baserequirements.resource.baseRequirements.mopp.BaseRequirementsMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = baserequirements.resource.baseRequirements.ui.BaseRequirementsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new baserequirements.resource.baseRequirements.mopp.BaseRequirementsMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, baserequirements.resource.baseRequirements.IBaseRequirementsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		baserequirements.resource.baseRequirements.ui.BaseRequirementsBracketSet bracketSet = new baserequirements.resource.baseRequirements.ui.BaseRequirementsBracketSet(null, null);
		final java.util.Collection<baserequirements.resource.baseRequirements.IBaseRequirementsBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (baserequirements.resource.baseRequirements.IBaseRequirementsBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + baserequirements.resource.baseRequirements.ui.BaseRequirementsPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, baserequirements.resource.baseRequirements.mopp.BaseRequirementsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			baserequirements.resource.baseRequirements.IBaseRequirementsTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baseRequirements.ui.BaseRequirementsSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
