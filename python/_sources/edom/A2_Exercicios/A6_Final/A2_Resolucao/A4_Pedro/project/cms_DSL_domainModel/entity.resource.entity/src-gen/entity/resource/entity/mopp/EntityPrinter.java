/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package entity.resource.entity.mopp;

public class EntityPrinter implements entity.resource.entity.IEntityTextPrinter {
	
	protected entity.resource.entity.IEntityTokenResolverFactory tokenResolverFactory = new entity.resource.entity.mopp.EntityTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private entity.resource.entity.IEntityTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public EntityPrinter(java.io.OutputStream outputStream, entity.resource.entity.IEntityTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof entity.Model) {
			print_entity_Model((entity.Model) element, globaltab, out);
			return;
		}
		if (element instanceof entity.Entity) {
			print_entity_Entity((entity.Entity) element, globaltab, out);
			return;
		}
		if (element instanceof entity.Attribute) {
			print_entity_Attribute((entity.Attribute) element, globaltab, out);
			return;
		}
		if (element instanceof entity.Relation) {
			print_entity_Relation((entity.Relation) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected entity.resource.entity.mopp.EntityReferenceResolverSwitch getReferenceResolverSwitch() {
		return (entity.resource.entity.mopp.EntityReferenceResolverSwitch) new entity.resource.entity.mopp.EntityMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		entity.resource.entity.IEntityTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new entity.resource.entity.mopp.EntityProblem(errorMessage, entity.resource.entity.EntityEProblemType.PRINT_PROBLEM, entity.resource.entity.EntityEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public entity.resource.entity.IEntityTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_entity_Model(entity.Model element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.MODEL__TITLE));
		printCountingMap.put("Title", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.MODEL__ROOT_ENTITIES));
		printCountingMap.put("rootEntities", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Model");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_entity_Model_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_entity_Model_0(entity.Model element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Title");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("Title");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.MODEL__TITLE));
			if (o != null) {
				entity.resource.entity.IEntityTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(entity.EntityPackage.MODEL__TITLE), element));
				out.print(" ");
			}
			printCountingMap.put("Title", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_entity_Model_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_entity_Model_0_0(entity.Model element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("has entities");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rootEntities");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.MODEL__ROOT_ENTITIES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rootEntities", count - 1);
		}
	}
	
	
	public void print_entity_Entity(entity.Entity element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__ATTRIBUTES));
		printCountingMap.put("attributes", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__RELATIONS));
		printCountingMap.put("relations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Entity");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_entity_Entity_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_entity_Entity_0(entity.Entity element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Name");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__NAME));
			if (o != null) {
				entity.resource.entity.IEntityTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_entity_Entity_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_entity_Entity_0_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_entity_Entity_0_0(entity.Entity element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("attributes");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("attributes");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__ATTRIBUTES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("attributes", count - 1);
		}
	}
	
	public void print_entity_Entity_0_1(entity.Entity element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("relations");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("relations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ENTITY__RELATIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("relations", count - 1);
		}
	}
	
	
	public void print_entity_Attribute(entity.Attribute element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__TYPE));
		printCountingMap.put("Type", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Attribute");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_entity_Attribute_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_entity_Attribute_0(entity.Attribute element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Name");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__NAME));
			if (o != null) {
				entity.resource.entity.IEntityTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_entity_Attribute_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_entity_Attribute_0_0(entity.Attribute element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("Type");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("Type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.ATTRIBUTE__TYPE));
			if (o != null) {
			}
			printCountingMap.put("Type", count - 1);
		}
	}
	
	
	public void print_entity_Relation(entity.Relation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__NAME));
		printCountingMap.put("Name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__TYPE));
		printCountingMap.put("Type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__REL_ENTITY));
		printCountingMap.put("RelEntity", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Relation");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_entity_Relation_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_entity_Relation_0(entity.Relation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("Name");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("Name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__NAME));
			if (o != null) {
				entity.resource.entity.IEntityTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("Name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("Type");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("Type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__TYPE));
			if (o != null) {
			}
			printCountingMap.put("Type", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_entity_Relation_0_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	
	public void print_entity_Relation_0_0(entity.Relation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("RelEntity");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("RelEntity");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__REL_ENTITY));
			if (o != null) {
				entity.resource.entity.IEntityTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRelationRelEntityReferenceResolver().deResolve((entity.Entity) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__REL_ENTITY)), element.eClass().getEStructuralFeature(entity.EntityPackage.RELATION__REL_ENTITY), element));
				out.print(" ");
			}
			printCountingMap.put("RelEntity", count - 1);
		}
	}
	
	
}
