# Running ATL Transformations Outside Eclipse

This projects shows how to run ATL transformations outside eclipse.

It uses a jar (atl-emftvm-fatjar.jar) that contains all that is required to run an ATL transformation. Please refer to [Executing ATL Tranformations from Java](https://modeling-languages.com/executing-atl-transformations-java/) for further information about this jar.

This is an Eclipse project (ATL). You need to have ATL installed (you should have it if you installed "Eclipse Modeling Tools" or "Eclipse for java and DSL Developers").

You need to find and install "emftvm" using "Help/Eclipse Marketplace..."

**ATTENTION:**

	- Only "standalone" metamodels (i.e., local ecore files) can be used with this jar.
	
	- Transformations that use registered metamodels like, for instance, the UML metamodel (i.e., http://www.eclipse.org/uml2/5.0.0/UML) 
	need to be executed inside eclipse, by using an "ATL EMFTVM Transformation" running configuration. In this project there is an example 
	of such a transformation (UC2Class.atl).	

### Use of EMFTVM

This jar requires that ATL transformations use the "emftvm" format. For that your ATL files should have the following first line:
 
	-- @atlcompiler emftvm

With this line, when you save your atl file, ATL compiles the file and generates an ".emftvm" file that is a model that represents the transformation.

**Note** that this ".emftvm" file is the one to use when running the transformation outside eclipse.

### Example Transformation

You will find in the folder "transformations" an example ATL transformation. This example is based on [ATL/Tutorials - Create a simple ATL transformation](https://wiki.eclipse.org/ATL/Tutorials_-_Create_a_simple_ATL_transformation).

The used metamodels are located in the folder "metamodels". It is recommend that you right click on both of them and execute "Register EPackages".

There is a model instance for Families located in "instances/sample-Families.xmi".

### Running with java

to run the example from a terminal simple type (having the folder of the project as corrent folder):

	java -jar dist/atl-emftvm-fatjar.jar -f transformations/Families2Persons.emftvm -s metamodels/Families.ecore -t metamodels/Persons.ecore -i instances/sample-Families.xmi -o instances/output-Persons.xmi

to display the usage of the jar type:

	java -jar dist/atl-emftvm-fatjar.jar

### Running with ant

If you have [ant](http://ant.apache.org) installed in your system you can also use it. You will find a build.xml file with example target/tasks.



