SYNTAXDEF baseRequirements
FOR <http://org/eclipse/dsl/baseRequirements>
START Model


TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}


TOKENSTYLES {
	"Model" COLOR #7F0055, BOLD;
	"title" COLOR #7F0055, BOLD;
	"groups" COLOR #7F0055, BOLD;
	"RequirementGroup" COLOR #7F0055, BOLD;
	"name" COLOR #7F0055, BOLD;
	"description" COLOR #7F0055, BOLD;
	"id" COLOR #7F0055, BOLD;
	"children" COLOR #7F0055, BOLD;
	"parent" COLOR #7F0055, BOLD;
	"requirements" COLOR #7F0055, BOLD;
	"Requirement" COLOR #7F0055, BOLD;
	"type" COLOR #7F0055, BOLD;
	"priority" COLOR #7F0055, BOLD;
	"author" COLOR #7F0055, BOLD;
	"created" COLOR #7F0055, BOLD;
	"state" COLOR #7F0055, BOLD;
	"resolution" COLOR #7F0055, BOLD;
	"version" COLOR #7F0055, BOLD;
	"comments" COLOR #7F0055, BOLD;
	"dependencies" COLOR #7F0055, BOLD;
	"Version" COLOR #7F0055, BOLD;
	"major" COLOR #7F0055, BOLD;
	"minor" COLOR #7F0055, BOLD;
	"service" COLOR #7F0055, BOLD;
	"Comment" COLOR #7F0055, BOLD;
	"subject" COLOR #7F0055, BOLD;
	"body" COLOR #7F0055, BOLD;
}


RULES {

	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)
	Model ::= "Model" "{" 
			  ("title" ":" title['"','"'] 
			  ("groups" ":" groups: RequirementGroup)*
	)"}";
	
	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)	  
	RequirementGroup ::= "RequirementGroup" "{" 
				("name" ":" name['"','"'] 
				("description" ":" description['"','"'])?
				("id" ":" id['"','"'])?
				("children" ":" children)* 
				("parent" ":" parent[])?
				("requirements" ":" requirements)* 
	 )"}";
	
	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)	
	Requirement ::= "Requirement" "{" 
			("title" ":" title['"','"']
			("description" ":" description['"','"'])? 
			("type" ":" type[FUNCTIONAL:"FUNCTIONAL", NONFUNCTIONAL:"NONFUNCTIONAL"])? 
			("priority" ":" priority[HIGH:"HIGH", MEDIUM:"MEDIUM", LOW:"LOW"])?
			("author" ":" author['"','"'])?
			("created" ":" created[])?
			("id" ":" id['"','"'])? 
			("state" ":" state[NEW:"NEW", REVIEWED:"REVIEWED", APPROVED:"APPROVED", RESOLVED:"RESOLVED"])?
			("resolution" ":" resolution[INVALID:"INVALID", ACCEPTED:"ACCEPTED", IMPLEMENTED:"IMPLEMENTED", LATER:"LATER"])?
			("version" ":" version)? 
			("comments" ":" comments)*
			("dependencies" ":" dependencies[])*
			("parent" ":" parent[])?
			("children" ":" children)* 
	 )"}";
	
	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)		 
	Version ::= "Version" "{" 
			("major" ":" major[] 
			("minor" ":" minor[])?
			("service" ":" service[])* 
	)"}";
	
	@SuppressWarnings(minOccurenceMismatch, maxOccurenceMismatch)	
	Comment ::= "Comment" "{" 
			("subject" ":" subject['"','"']
			("body" ":" body['"','"'])? 
			("author" ":" author['"','"'])?
			("created" ":" created[])?
			("children" ":" children)* 
	)"}";
}