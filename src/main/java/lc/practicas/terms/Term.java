package lc.practicas.terms;


public class Term {

	private TypeTerm typeTerm;

	public TypeTerm getTypeTerm(){
		return this.typeTerm;
	}
	
	public boolean equalsTypeTerm( Term term ){
		
		return this.typeTerm == term.getTypeTerm() ; 
	}
}
