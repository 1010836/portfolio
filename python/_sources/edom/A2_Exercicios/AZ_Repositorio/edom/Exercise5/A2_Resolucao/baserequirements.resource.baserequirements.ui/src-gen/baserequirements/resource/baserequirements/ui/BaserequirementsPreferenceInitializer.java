/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baserequirements.ui;

/**
 * A class used to initialize default preference values.
 */
public class BaserequirementsPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = baserequirements.resource.baserequirements.ui.BaserequirementsUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(baserequirements.resource.baserequirements.ui.BaserequirementsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(baserequirements.resource.baserequirements.ui.BaserequirementsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = baserequirements.resource.baserequirements.ui.BaserequirementsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new baserequirements.resource.baserequirements.mopp.BaserequirementsMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = baserequirements.resource.baserequirements.ui.BaserequirementsUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new baserequirements.resource.baserequirements.mopp.BaserequirementsMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, baserequirements.resource.baserequirements.IBaserequirementsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		baserequirements.resource.baserequirements.ui.BaserequirementsBracketSet bracketSet = new baserequirements.resource.baserequirements.ui.BaserequirementsBracketSet(null, null);
		final java.util.Collection<baserequirements.resource.baserequirements.IBaserequirementsBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (baserequirements.resource.baserequirements.IBaserequirementsBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + baserequirements.resource.baserequirements.ui.BaserequirementsPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, baserequirements.resource.baserequirements.mopp.BaserequirementsMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			baserequirements.resource.baserequirements.IBaserequirementsTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, baserequirements.resource.baserequirements.ui.BaserequirementsSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
