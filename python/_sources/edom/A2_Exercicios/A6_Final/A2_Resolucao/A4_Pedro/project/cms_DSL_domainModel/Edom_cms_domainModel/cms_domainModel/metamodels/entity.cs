SYNTAXDEF entity
FOR <http://org/eclipse/dsl/entity>
START Model


TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}


TOKENSTYLES {
	"Model" COLOR #7F0055, BOLD;
	"Title" COLOR #7F0055, BOLD;
	"rootEntities" COLOR #7F0055, BOLD;
	"Entity" COLOR #7F0055, BOLD;
	"Name" COLOR #7F0055, BOLD;
	"attributes" COLOR #7F0055, BOLD;
	"relations" COLOR #7F0055, BOLD;
	"Attribute" COLOR #7F0055, BOLD;
	"Type" COLOR #7F0055, BOLD;
	"Relation" COLOR #7F0055, BOLD;
	"RelEntity" COLOR #7F0055, BOLD;
}


RULES {
	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)
	Model ::= "Model" "{" ( 
		"Title" ":" Title['"','"']
		("has entities" ":" rootEntities: Entity)* 
	)"}";
	
	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)
	Entity ::= "Entity" "{" (
		 "Name" ":" Name['"','"']
		("attributes" ":" attributes: Attribute)*
		("relations" ":" relations: Relation)* 
	)"}";
	
	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)
	Attribute ::= "Attribute" "{" 
		("Name" ":" Name['"','"']
		("Type" ":" Type[String:"String", Float:"Float", Integer:"Integer", Boolean:"Boolean"])* 
	)"}";
	
	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)
	Relation ::= "Relation" "{" 
		("Name" ":" Name['"','"']
		"Type" ":" Type[one:"one", many:"many"]
		("RelEntity" ":" RelEntity[])* 
	)"}";
}