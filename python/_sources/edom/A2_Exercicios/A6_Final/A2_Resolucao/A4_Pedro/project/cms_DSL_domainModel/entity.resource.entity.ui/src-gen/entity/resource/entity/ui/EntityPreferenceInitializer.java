/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.ui;

/**
 * A class used to initialize default preference values.
 */
public class EntityPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = entity.resource.entity.ui.EntityUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(entity.resource.entity.ui.EntityPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(entity.resource.entity.ui.EntityPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = entity.resource.entity.ui.EntityUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new entity.resource.entity.mopp.EntityMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = entity.resource.entity.ui.EntityUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new entity.resource.entity.mopp.EntityMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, entity.resource.entity.IEntityMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		entity.resource.entity.ui.EntityBracketSet bracketSet = new entity.resource.entity.ui.EntityBracketSet(null, null);
		final java.util.Collection<entity.resource.entity.IEntityBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (entity.resource.entity.IEntityBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + entity.resource.entity.ui.EntityPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, entity.resource.entity.mopp.EntityMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			entity.resource.entity.IEntityTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(entity.resource.entity.ui.EntitySyntaxColoringHelper.getPreferenceKey(languageID, tokenName, entity.resource.entity.ui.EntitySyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(entity.resource.entity.ui.EntitySyntaxColoringHelper.getPreferenceKey(languageID, tokenName, entity.resource.entity.ui.EntitySyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(entity.resource.entity.ui.EntitySyntaxColoringHelper.getPreferenceKey(languageID, tokenName, entity.resource.entity.ui.EntitySyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(entity.resource.entity.ui.EntitySyntaxColoringHelper.getPreferenceKey(languageID, tokenName, entity.resource.entity.ui.EntitySyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(entity.resource.entity.ui.EntitySyntaxColoringHelper.getPreferenceKey(languageID, tokenName, entity.resource.entity.ui.EntitySyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(entity.resource.entity.ui.EntitySyntaxColoringHelper.getPreferenceKey(languageID, tokenName, entity.resource.entity.ui.EntitySyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
