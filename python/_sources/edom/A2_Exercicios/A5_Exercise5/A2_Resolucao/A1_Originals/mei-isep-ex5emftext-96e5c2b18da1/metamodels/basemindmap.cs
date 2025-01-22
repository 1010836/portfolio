SYNTAXDEF basemindmap
FOR <http://org/eclipse/dsl/baseMindmap>
START Map

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"Mapa" COLOR #FF0000, BOLD;
	"tem titulo:" COLOR #7F0055, BOLD;
	"criado em:" COLOR #7F0055, BOLD;
	"topico" COLOR #7F0055, BOLD;
	"tem nome:" COLOR #7F0055, BOLD;
	"tem a descricao:" COLOR #7F0055, BOLD;
	"com inicio em:" COLOR #7F0055, BOLD;
	"com fim em:" COLOR #7F0055, BOLD;
	"tem prioridade:" COLOR #7F0055, BOLD;
	"tem pai:" COLOR #7F0055, BOLD;
	"tem subtopicos:" COLOR #7F0055, BOLD;
	"relacao" COLOR #7F0055, BOLD;
	"tem tipo:" COLOR #7F0055, BOLD;
	"tem origem:" COLOR #7F0055, BOLD;  
	"tem destino:" COLOR #7F0055, BOLD;
	"COMMENT" COLOR #005500;
}

RULES {

	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)
	Map ::= 	"Mapa" "{" (
		"tem titulo:" title['"','"']  
		("criado em:" created[])?
		("tem elemento:" elements : Topic, Relationship  )*
	) "}";

	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)	
	Topic ::= "topico" "{" 
		"tem nome:" name['"','"']  
		("tem a descricao:" description['"','"'])?
		("com inicio em:" start[])?
		("com fim em:" end[])? 
		("tem prioridade:" priority[HIGH:"ALTA", MEDIUM:"MEDIA", LOW:"BAIXA"])? 
		("tem pai:" parent[])?
		("tem subtopicos:" subtopics[])*
	"}";

	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)		
	Relationship ::= "relacao" "{" 
		"tem nome:" name['"','"'] 
		"tem tipo:" type[DEPENDENCY:"DEPENDENCIA", INCLUDE:"INCLUSAO", EXTEND:"EXTENSAO"]  
		"tem origem:" source[] 
		"tem destino:" target[]
	"}";
}
	