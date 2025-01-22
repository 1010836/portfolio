/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

public class EntityGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static EntityGrammarInformationProvider INSTANCE = new EntityGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_0_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Model", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_0_0_0_1 = new entity.resource.entity.grammar.EntityKeyword("{", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_0_0_0_2_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Title", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_0_0_0_2_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityPlaceholder ENTITY_0_0_0_2_0_0_2 = new entity.resource.entity.grammar.EntityPlaceholder(entity.EntityPackage.eINSTANCE.getModel().getEStructuralFeature(entity.EntityPackage.MODEL__TITLE), "QUOTED_34_34", entity.resource.entity.grammar.EntityCardinality.ONE, 0);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_0_0_0_2_0_0_3_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("has entities", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_0_0_0_2_0_0_3_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityContainment ENTITY_0_0_0_2_0_0_3_0_0_2 = new entity.resource.entity.grammar.EntityContainment(entity.EntityPackage.eINSTANCE.getModel().getEStructuralFeature(entity.EntityPackage.MODEL__ROOT_ENTITIES), entity.resource.entity.grammar.EntityCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {entity.EntityPackage.eINSTANCE.getEntity(), }, 0);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_0_0_0_2_0_0_3_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_0_0_0_2_0_0_3_0_0_0, ENTITY_0_0_0_2_0_0_3_0_0_1, ENTITY_0_0_0_2_0_0_3_0_0_2);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_0_0_0_2_0_0_3_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_0_0_0_2_0_0_3_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_0_0_0_2_0_0_3 = new entity.resource.entity.grammar.EntityCompound(ENTITY_0_0_0_2_0_0_3_0, entity.resource.entity.grammar.EntityCardinality.STAR);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_0_0_0_2_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_0_0_0_2_0_0_0, ENTITY_0_0_0_2_0_0_1, ENTITY_0_0_0_2_0_0_2, ENTITY_0_0_0_2_0_0_3);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_0_0_0_2_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_0_0_0_2_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_0_0_0_2 = new entity.resource.entity.grammar.EntityCompound(ENTITY_0_0_0_2_0, entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_0_0_0_3 = new entity.resource.entity.grammar.EntityKeyword("}", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_0_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_0_0_0_0, ENTITY_0_0_0_1, ENTITY_0_0_0_2, ENTITY_0_0_0_3);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_0_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_0_0_0);
	public final static entity.resource.entity.grammar.EntityRule ENTITY_0 = new entity.resource.entity.grammar.EntityRule(entity.EntityPackage.eINSTANCE.getModel(), ENTITY_0_0, entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Entity", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_1 = new entity.resource.entity.grammar.EntityKeyword("{", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_2_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Name", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_2_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityPlaceholder ENTITY_1_0_0_2_0_0_2 = new entity.resource.entity.grammar.EntityPlaceholder(entity.EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(entity.EntityPackage.ENTITY__NAME), "QUOTED_34_34", entity.resource.entity.grammar.EntityCardinality.ONE, 0);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_2_0_0_3_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("attributes", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_2_0_0_3_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityContainment ENTITY_1_0_0_2_0_0_3_0_0_2 = new entity.resource.entity.grammar.EntityContainment(entity.EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(entity.EntityPackage.ENTITY__ATTRIBUTES), entity.resource.entity.grammar.EntityCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {entity.EntityPackage.eINSTANCE.getAttribute(), }, 0);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_1_0_0_2_0_0_3_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_1_0_0_2_0_0_3_0_0_0, ENTITY_1_0_0_2_0_0_3_0_0_1, ENTITY_1_0_0_2_0_0_3_0_0_2);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_1_0_0_2_0_0_3_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_1_0_0_2_0_0_3_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_1_0_0_2_0_0_3 = new entity.resource.entity.grammar.EntityCompound(ENTITY_1_0_0_2_0_0_3_0, entity.resource.entity.grammar.EntityCardinality.STAR);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_2_0_0_4_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("relations", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_2_0_0_4_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityContainment ENTITY_1_0_0_2_0_0_4_0_0_2 = new entity.resource.entity.grammar.EntityContainment(entity.EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(entity.EntityPackage.ENTITY__RELATIONS), entity.resource.entity.grammar.EntityCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {entity.EntityPackage.eINSTANCE.getRelation(), }, 0);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_1_0_0_2_0_0_4_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_1_0_0_2_0_0_4_0_0_0, ENTITY_1_0_0_2_0_0_4_0_0_1, ENTITY_1_0_0_2_0_0_4_0_0_2);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_1_0_0_2_0_0_4_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_1_0_0_2_0_0_4_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_1_0_0_2_0_0_4 = new entity.resource.entity.grammar.EntityCompound(ENTITY_1_0_0_2_0_0_4_0, entity.resource.entity.grammar.EntityCardinality.STAR);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_1_0_0_2_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_1_0_0_2_0_0_0, ENTITY_1_0_0_2_0_0_1, ENTITY_1_0_0_2_0_0_2, ENTITY_1_0_0_2_0_0_3, ENTITY_1_0_0_2_0_0_4);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_1_0_0_2_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_1_0_0_2_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_1_0_0_2 = new entity.resource.entity.grammar.EntityCompound(ENTITY_1_0_0_2_0, entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_1_0_0_3 = new entity.resource.entity.grammar.EntityKeyword("}", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_1_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_1_0_0_0, ENTITY_1_0_0_1, ENTITY_1_0_0_2, ENTITY_1_0_0_3);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_1_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_1_0_0);
	public final static entity.resource.entity.grammar.EntityRule ENTITY_1 = new entity.resource.entity.grammar.EntityRule(entity.EntityPackage.eINSTANCE.getEntity(), ENTITY_1_0, entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_2_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Attribute", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_2_0_0_1 = new entity.resource.entity.grammar.EntityKeyword("{", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_2_0_0_2_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Name", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_2_0_0_2_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityPlaceholder ENTITY_2_0_0_2_0_0_2 = new entity.resource.entity.grammar.EntityPlaceholder(entity.EntityPackage.eINSTANCE.getAttribute().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__NAME), "QUOTED_34_34", entity.resource.entity.grammar.EntityCardinality.ONE, 0);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_2_0_0_2_0_0_3_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Type", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_2_0_0_2_0_0_3_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityEnumerationTerminal ENTITY_2_0_0_2_0_0_3_0_0_2 = new entity.resource.entity.grammar.EntityEnumerationTerminal(entity.EntityPackage.eINSTANCE.getAttribute().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__TYPE), new String[] {"String", "String", "Float", "Float", "Integer", "Integer", "Boolean", "Boolean", }, entity.resource.entity.grammar.EntityCardinality.ONE, 0);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_2_0_0_2_0_0_3_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_2_0_0_2_0_0_3_0_0_0, ENTITY_2_0_0_2_0_0_3_0_0_1, ENTITY_2_0_0_2_0_0_3_0_0_2);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_2_0_0_2_0_0_3_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_2_0_0_2_0_0_3_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_2_0_0_2_0_0_3 = new entity.resource.entity.grammar.EntityCompound(ENTITY_2_0_0_2_0_0_3_0, entity.resource.entity.grammar.EntityCardinality.STAR);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_2_0_0_2_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_2_0_0_2_0_0_0, ENTITY_2_0_0_2_0_0_1, ENTITY_2_0_0_2_0_0_2, ENTITY_2_0_0_2_0_0_3);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_2_0_0_2_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_2_0_0_2_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_2_0_0_2 = new entity.resource.entity.grammar.EntityCompound(ENTITY_2_0_0_2_0, entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_2_0_0_3 = new entity.resource.entity.grammar.EntityKeyword("}", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_2_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_2_0_0_0, ENTITY_2_0_0_1, ENTITY_2_0_0_2, ENTITY_2_0_0_3);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_2_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_2_0_0);
	public final static entity.resource.entity.grammar.EntityRule ENTITY_2 = new entity.resource.entity.grammar.EntityRule(entity.EntityPackage.eINSTANCE.getAttribute(), ENTITY_2_0, entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Relation", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_1 = new entity.resource.entity.grammar.EntityKeyword("{", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_2_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("Name", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_2_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityPlaceholder ENTITY_3_0_0_2_0_0_2 = new entity.resource.entity.grammar.EntityPlaceholder(entity.EntityPackage.eINSTANCE.getRelation().getEStructuralFeature(entity.EntityPackage.RELATION__NAME), "QUOTED_34_34", entity.resource.entity.grammar.EntityCardinality.ONE, 0);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_2_0_0_3 = new entity.resource.entity.grammar.EntityKeyword("Type", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_2_0_0_4 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityEnumerationTerminal ENTITY_3_0_0_2_0_0_5 = new entity.resource.entity.grammar.EntityEnumerationTerminal(entity.EntityPackage.eINSTANCE.getRelation().getEStructuralFeature(entity.EntityPackage.RELATION__TYPE), new String[] {"one", "one", "many", "many", }, entity.resource.entity.grammar.EntityCardinality.ONE, 0);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_2_0_0_6_0_0_0 = new entity.resource.entity.grammar.EntityKeyword("RelEntity", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_2_0_0_6_0_0_1 = new entity.resource.entity.grammar.EntityKeyword(":", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityPlaceholder ENTITY_3_0_0_2_0_0_6_0_0_2 = new entity.resource.entity.grammar.EntityPlaceholder(entity.EntityPackage.eINSTANCE.getRelation().getEStructuralFeature(entity.EntityPackage.RELATION__REL_ENTITY), "TEXT", entity.resource.entity.grammar.EntityCardinality.ONE, 0);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_3_0_0_2_0_0_6_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_3_0_0_2_0_0_6_0_0_0, ENTITY_3_0_0_2_0_0_6_0_0_1, ENTITY_3_0_0_2_0_0_6_0_0_2);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_3_0_0_2_0_0_6_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_3_0_0_2_0_0_6_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_3_0_0_2_0_0_6 = new entity.resource.entity.grammar.EntityCompound(ENTITY_3_0_0_2_0_0_6_0, entity.resource.entity.grammar.EntityCardinality.STAR);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_3_0_0_2_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_3_0_0_2_0_0_0, ENTITY_3_0_0_2_0_0_1, ENTITY_3_0_0_2_0_0_2, ENTITY_3_0_0_2_0_0_3, ENTITY_3_0_0_2_0_0_4, ENTITY_3_0_0_2_0_0_5, ENTITY_3_0_0_2_0_0_6);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_3_0_0_2_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_3_0_0_2_0_0);
	public final static entity.resource.entity.grammar.EntityCompound ENTITY_3_0_0_2 = new entity.resource.entity.grammar.EntityCompound(ENTITY_3_0_0_2_0, entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntityKeyword ENTITY_3_0_0_3 = new entity.resource.entity.grammar.EntityKeyword("}", entity.resource.entity.grammar.EntityCardinality.ONE);
	public final static entity.resource.entity.grammar.EntitySequence ENTITY_3_0_0 = new entity.resource.entity.grammar.EntitySequence(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_3_0_0_0, ENTITY_3_0_0_1, ENTITY_3_0_0_2, ENTITY_3_0_0_3);
	public final static entity.resource.entity.grammar.EntityChoice ENTITY_3_0 = new entity.resource.entity.grammar.EntityChoice(entity.resource.entity.grammar.EntityCardinality.ONE, ENTITY_3_0_0);
	public final static entity.resource.entity.grammar.EntityRule ENTITY_3 = new entity.resource.entity.grammar.EntityRule(entity.EntityPackage.eINSTANCE.getRelation(), ENTITY_3_0, entity.resource.entity.grammar.EntityCardinality.ONE);
	
	public static String getSyntaxElementID(entity.resource.entity.grammar.EntitySyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : entity.resource.entity.grammar.EntityGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static entity.resource.entity.grammar.EntitySyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (entity.resource.entity.grammar.EntitySyntaxElement) entity.resource.entity.grammar.EntityGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static entity.resource.entity.grammar.EntityRule[] RULES = new entity.resource.entity.grammar.EntityRule[] {
		ENTITY_0,
		ENTITY_1,
		ENTITY_2,
		ENTITY_3,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (entity.resource.entity.grammar.EntityRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(entity.resource.entity.grammar.EntitySyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof entity.resource.entity.grammar.EntityKeyword) {
			keywords.add(((entity.resource.entity.grammar.EntityKeyword) element).getValue());
		} else if (element instanceof entity.resource.entity.grammar.EntityBooleanTerminal) {
			keywords.add(((entity.resource.entity.grammar.EntityBooleanTerminal) element).getTrueLiteral());
			keywords.add(((entity.resource.entity.grammar.EntityBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof entity.resource.entity.grammar.EntityEnumerationTerminal) {
			entity.resource.entity.grammar.EntityEnumerationTerminal terminal = (entity.resource.entity.grammar.EntityEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (entity.resource.entity.grammar.EntitySyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
