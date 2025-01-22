/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class EntityFollowSetProvider {
	
	public final static entity.resource.entity.IEntityExpectedElement TERMINALS[] = new entity.resource.entity.IEntityExpectedElement[39];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[3];
	
	public final static entity.resource.entity.mopp.EntityContainedFeature[] LINKS = new entity.resource.entity.mopp.EntityContainedFeature[3];
	
	public final static entity.resource.entity.mopp.EntityContainedFeature[] EMPTY_LINK_ARRAY = new entity.resource.entity.mopp.EntityContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_0);
		TERMINALS[1] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_1);
		TERMINALS[2] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_0);
		TERMINALS[3] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_1);
		TERMINALS[4] = new entity.resource.entity.mopp.EntityExpectedStructuralFeature(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_2);
		TERMINALS[5] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_3_0_0_0);
		TERMINALS[6] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_3);
		TERMINALS[7] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_0_0_0_2_0_0_3_0_0_1);
		TERMINALS[8] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_0);
		TERMINALS[9] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_1);
		TERMINALS[10] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_0);
		TERMINALS[11] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_1);
		TERMINALS[12] = new entity.resource.entity.mopp.EntityExpectedStructuralFeature(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_2);
		TERMINALS[13] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_3_0_0_0);
		TERMINALS[14] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_4_0_0_0);
		TERMINALS[15] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_3);
		TERMINALS[16] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_3_0_0_1);
		TERMINALS[17] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_0);
		TERMINALS[18] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_1_0_0_2_0_0_4_0_0_1);
		TERMINALS[19] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_0);
		TERMINALS[20] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_1);
		TERMINALS[21] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_0);
		TERMINALS[22] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_1);
		TERMINALS[23] = new entity.resource.entity.mopp.EntityExpectedStructuralFeature(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_2);
		TERMINALS[24] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_0);
		TERMINALS[25] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_3);
		TERMINALS[26] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_1);
		TERMINALS[27] = new entity.resource.entity.mopp.EntityExpectedEnumerationTerminal(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_2_0_0_2_0_0_3_0_0_2);
		TERMINALS[28] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_1);
		TERMINALS[29] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_0);
		TERMINALS[30] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_1);
		TERMINALS[31] = new entity.resource.entity.mopp.EntityExpectedStructuralFeature(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_2);
		TERMINALS[32] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_3);
		TERMINALS[33] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_4);
		TERMINALS[34] = new entity.resource.entity.mopp.EntityExpectedEnumerationTerminal(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_5);
		TERMINALS[35] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_6_0_0_0);
		TERMINALS[36] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_3);
		TERMINALS[37] = new entity.resource.entity.mopp.EntityExpectedCsString(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_6_0_0_1);
		TERMINALS[38] = new entity.resource.entity.mopp.EntityExpectedStructuralFeature(entity.resource.entity.grammar.EntityGrammarInformationProvider.ENTITY_3_0_0_2_0_0_6_0_0_2);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = entity.EntityPackage.eINSTANCE.getModel().getEStructuralFeature(entity.EntityPackage.MODEL__ROOT_ENTITIES);
		FEATURES[1] = entity.EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(entity.EntityPackage.ENTITY__ATTRIBUTES);
		FEATURES[2] = entity.EntityPackage.eINSTANCE.getEntity().getEStructuralFeature(entity.EntityPackage.ENTITY__RELATIONS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new entity.resource.entity.mopp.EntityContainedFeature(entity.EntityPackage.eINSTANCE.getEntity(), FEATURES[0]);
		LINKS[1] = new entity.resource.entity.mopp.EntityContainedFeature(entity.EntityPackage.eINSTANCE.getAttribute(), FEATURES[1]);
		LINKS[2] = new entity.resource.entity.mopp.EntityContainedFeature(entity.EntityPackage.eINSTANCE.getRelation(), FEATURES[2]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[8], new entity.resource.entity.mopp.EntityContainedFeature[] {new entity.resource.entity.mopp.EntityContainedFeature(entity.EntityPackage.eINSTANCE.getEntity(), FEATURES[0]), });
		TERMINALS[8].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[17], new entity.resource.entity.mopp.EntityContainedFeature[] {new entity.resource.entity.mopp.EntityContainedFeature(entity.EntityPackage.eINSTANCE.getAttribute(), FEATURES[1]), });
		TERMINALS[14].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[19], new entity.resource.entity.mopp.EntityContainedFeature[] {new entity.resource.entity.mopp.EntityContainedFeature(entity.EntityPackage.eINSTANCE.getRelation(), FEATURES[2]), });
		TERMINALS[15].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[20], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[21], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[22], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[23].addFollower(TERMINALS[24], EMPTY_LINK_ARRAY);
		TERMINALS[23].addFollower(TERMINALS[25], EMPTY_LINK_ARRAY);
		TERMINALS[24].addFollower(TERMINALS[26], EMPTY_LINK_ARRAY);
		TERMINALS[26].addFollower(TERMINALS[27], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[25].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[19].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[29], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[30], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[31], EMPTY_LINK_ARRAY);
		TERMINALS[31].addFollower(TERMINALS[32], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[33], EMPTY_LINK_ARRAY);
		TERMINALS[33].addFollower(TERMINALS[34], EMPTY_LINK_ARRAY);
		TERMINALS[35].addFollower(TERMINALS[37], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[38], EMPTY_LINK_ARRAY);
		TERMINALS[38].addFollower(TERMINALS[35], EMPTY_LINK_ARRAY);
		TERMINALS[38].addFollower(TERMINALS[36], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
