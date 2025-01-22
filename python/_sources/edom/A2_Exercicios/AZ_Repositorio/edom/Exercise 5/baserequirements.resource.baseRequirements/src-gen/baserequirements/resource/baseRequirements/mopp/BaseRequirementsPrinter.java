/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package baserequirements.resource.baseRequirements.mopp;

public class BaseRequirementsPrinter implements baserequirements.resource.baseRequirements.IBaseRequirementsTextPrinter {
	
	protected baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolverFactory tokenResolverFactory = new baserequirements.resource.baseRequirements.mopp.BaseRequirementsTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public BaseRequirementsPrinter(java.io.OutputStream outputStream, baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource) {
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
		
		if (element instanceof baserequirements.Model) {
			print_baserequirements_Model((baserequirements.Model) element, globaltab, out);
			return;
		}
		if (element instanceof baserequirements.RequirementGroup) {
			print_baserequirements_RequirementGroup((baserequirements.RequirementGroup) element, globaltab, out);
			return;
		}
		if (element instanceof baserequirements.Requirement) {
			print_baserequirements_Requirement((baserequirements.Requirement) element, globaltab, out);
			return;
		}
		if (element instanceof baserequirements.Version) {
			print_baserequirements_Version((baserequirements.Version) element, globaltab, out);
			return;
		}
		if (element instanceof baserequirements.Comment) {
			print_baserequirements_Comment((baserequirements.Comment) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected baserequirements.resource.baseRequirements.mopp.BaseRequirementsReferenceResolverSwitch getReferenceResolverSwitch() {
		return (baserequirements.resource.baseRequirements.mopp.BaseRequirementsReferenceResolverSwitch) new baserequirements.resource.baseRequirements.mopp.BaseRequirementsMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		baserequirements.resource.baseRequirements.IBaseRequirementsTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new baserequirements.resource.baseRequirements.mopp.BaseRequirementsProblem(errorMessage, baserequirements.resource.baseRequirements.BaseRequirementsEProblemType.PRINT_PROBLEM, baserequirements.resource.baseRequirements.BaseRequirementsEProblemSeverity.WARNING), cause);
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
	
	public baserequirements.resource.baseRequirements.IBaseRequirementsTextResource getResource() {
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
	
	public void print_baserequirements_Model(baserequirements.Model element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.MODEL__TITLE));
		printCountingMap.put("title", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.MODEL__GROUPS));
		printCountingMap.put("groups", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Model");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_baserequirements_Model_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_baserequirements_Model_0(baserequirements.Model element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("title");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("title");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.MODEL__TITLE));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.MODEL__TITLE), element));
				out.print(" ");
			}
			printCountingMap.put("title", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_baserequirements_Model_0_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_baserequirements_Model_0_0(baserequirements.Model element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("groups");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("groups");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.MODEL__GROUPS));
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
			printCountingMap.put("groups", count - 1);
		}
	}
	
	
	public void print_baserequirements_RequirementGroup(baserequirements.RequirementGroup element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION));
		printCountingMap.put("description", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN));
		printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT));
		printCountingMap.put("parent", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS));
		printCountingMap.put("requirements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("RequirementGroup");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_baserequirements_RequirementGroup_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_baserequirements_RequirementGroup_0(baserequirements.RequirementGroup element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("name");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__NAME));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__NAME), element));
				out.print(" ");
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_RequirementGroup_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_RequirementGroup_0_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_baserequirements_RequirementGroup_0_2(element, localtab, out1, printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_RequirementGroup_0_3(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_baserequirements_RequirementGroup_0_4(element, localtab, out1, printCountingMap1);
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
	
	public void print_baserequirements_RequirementGroup_0_0(baserequirements.RequirementGroup element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("description");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("description");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__DESCRIPTION), element));
				out.print(" ");
			}
			printCountingMap.put("description", count - 1);
		}
	}
	
	public void print_baserequirements_RequirementGroup_0_1(baserequirements.RequirementGroup element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("id");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__ID));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
	}
	
	public void print_baserequirements_RequirementGroup_0_2(baserequirements.RequirementGroup element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("children");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
	}
	
	public void print_baserequirements_RequirementGroup_0_3(baserequirements.RequirementGroup element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("parent");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("parent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementGroupParentReferenceResolver().deResolve((baserequirements.RequirementGroup) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT)), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__PARENT), element));
				out.print(" ");
			}
			printCountingMap.put("parent", count - 1);
		}
	}
	
	public void print_baserequirements_RequirementGroup_0_4(baserequirements.RequirementGroup element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("requirements");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("requirements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT_GROUP__REQUIREMENTS));
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
			printCountingMap.put("requirements", count - 1);
		}
	}
	
	
	public void print_baserequirements_Requirement(baserequirements.Requirement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(14);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TITLE));
		printCountingMap.put("title", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DESCRIPTION));
		printCountingMap.put("description", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PRIORITY));
		printCountingMap.put("priority", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__AUTHOR));
		printCountingMap.put("author", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__CREATED));
		printCountingMap.put("created", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__ID));
		printCountingMap.put("id", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE));
		printCountingMap.put("state", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION));
		printCountingMap.put("resolution", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__VERSION));
		printCountingMap.put("version", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__COMMENTS));
		printCountingMap.put("comments", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES));
		printCountingMap.put("dependencies", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT));
		printCountingMap.put("parent", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__CHILDREN));
		printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Requirement");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_baserequirements_Requirement_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_baserequirements_Requirement_0(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("title");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("title");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TITLE));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TITLE), element));
				out.print(" ");
			}
			printCountingMap.put("title", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_3(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_4(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_5(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_6(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_7(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_8(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_baserequirements_Requirement_0_9(element, localtab, out1, printCountingMap1);
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
			print_baserequirements_Requirement_0_10(element, localtab, out1, printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Requirement_0_11(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_baserequirements_Requirement_0_12(element, localtab, out1, printCountingMap1);
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
	
	public void print_baserequirements_Requirement_0_0(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("description");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("description");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DESCRIPTION));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DESCRIPTION), element));
				out.print(" ");
			}
			printCountingMap.put("description", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_1(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("type");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__TYPE));
			if (o != null) {
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_2(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("priority");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("priority");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PRIORITY));
			if (o != null) {
			}
			printCountingMap.put("priority", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_3(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("author");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("author");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__AUTHOR));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__AUTHOR), element));
				out.print(" ");
			}
			printCountingMap.put("author", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_4(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("created");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("created");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__CREATED));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__CREATED), element));
				out.print(" ");
			}
			printCountingMap.put("created", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_5(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("id");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("id");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__ID));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__ID), element));
				out.print(" ");
			}
			printCountingMap.put("id", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_6(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("state");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("state");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__STATE));
			if (o != null) {
			}
			printCountingMap.put("state", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_7(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("resolution");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (EnumTerminal)
		count = printCountingMap.get("resolution");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__RESOLUTION));
			if (o != null) {
			}
			printCountingMap.put("resolution", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_8(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("version");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("version");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__VERSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("version", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_9(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("comments");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("comments");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__COMMENTS));
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
			printCountingMap.put("comments", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_10(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("dependencies");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("dependencies");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementDependenciesReferenceResolver().deResolve((baserequirements.Requirement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES)), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__DEPENDENCIES), element));
				out.print(" ");
			}
			printCountingMap.put("dependencies", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_11(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("parent");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("parent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRequirementParentReferenceResolver().deResolve((baserequirements.Requirement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT)), element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__PARENT), element));
				out.print(" ");
			}
			printCountingMap.put("parent", count - 1);
		}
	}
	
	public void print_baserequirements_Requirement_0_12(baserequirements.Requirement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("children");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.REQUIREMENT__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
	}
	
	
	public void print_baserequirements_Version(baserequirements.Version element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MAJOR));
		printCountingMap.put("major", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MINOR));
		printCountingMap.put("minor", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__SERVICE));
		printCountingMap.put("service", temp == null ? 0 : 1);
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Version");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_baserequirements_Version_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_baserequirements_Version_0(baserequirements.Version element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("major");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("major");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MAJOR));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MAJOR), element));
				out.print(" ");
			}
			printCountingMap.put("major", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Version_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_baserequirements_Version_0_1(element, localtab, out1, printCountingMap1);
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
	
	public void print_baserequirements_Version_0_0(baserequirements.Version element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("minor");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("minor");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MINOR));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__MINOR), element));
				out.print(" ");
			}
			printCountingMap.put("minor", count - 1);
		}
	}
	
	public void print_baserequirements_Version_0_1(baserequirements.Version element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("service");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("service");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__SERVICE));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.VERSION__SERVICE), element));
				out.print(" ");
			}
			printCountingMap.put("service", count - 1);
		}
	}
	
	
	public void print_baserequirements_Comment(baserequirements.Comment element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__SUBJECT));
		printCountingMap.put("subject", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__BODY));
		printCountingMap.put("body", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__AUTHOR));
		printCountingMap.put("author", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__CREATED));
		printCountingMap.put("created", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__CHILDREN));
		printCountingMap.put("children", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		// DEFINITION PART BEGINS (CsString)
		out.print("Comment");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_baserequirements_Comment_0(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		out.print(" ");
	}
	
	public void print_baserequirements_Comment_0(baserequirements.Comment element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("subject");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("subject");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__SUBJECT));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__SUBJECT), element));
				out.print(" ");
			}
			printCountingMap.put("subject", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Comment_0_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Comment_0_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_baserequirements_Comment_0_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_baserequirements_Comment_0_3(element, localtab, out1, printCountingMap1);
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
	
	public void print_baserequirements_Comment_0_0(baserequirements.Comment element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("body");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("body");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__BODY));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__BODY), element));
				out.print(" ");
			}
			printCountingMap.put("body", count - 1);
		}
	}
	
	public void print_baserequirements_Comment_0_1(baserequirements.Comment element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("author");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderInQuotes)
		count = printCountingMap.get("author");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__AUTHOR));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__AUTHOR), element));
				out.print(" ");
			}
			printCountingMap.put("author", count - 1);
		}
	}
	
	public void print_baserequirements_Comment_0_2(baserequirements.Comment element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("created");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("created");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__CREATED));
			if (o != null) {
				baserequirements.resource.baseRequirements.IBaseRequirementsTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__CREATED), element));
				out.print(" ");
			}
			printCountingMap.put("created", count - 1);
		}
	}
	
	public void print_baserequirements_Comment_0_3(baserequirements.Comment element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("children");
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("children");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(baserequirements.BaserequirementsPackage.COMMENT__CHILDREN));
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
			printCountingMap.put("children", count - 1);
		}
	}
	
	
}
