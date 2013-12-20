package lc.practicas.terms;


public abstract class Term {

	protected TypeTerm typeTerm;

	protected TypeTerm getTypeTerm(){
		return this.typeTerm;
	}
	
	protected boolean equalsTypeTerm( Term term ){
		
		return this.typeTerm == term.getTypeTerm() ; 
	}
	
	public abstract boolean equals( Term term );
	
	public abstract Pair getDiscordance( Term term ) throws DiscordanceNotFoundException;

	public boolean containsTerm(Term term){
		return this.equals(term);
	}
	
	public Term getReplace( Term variable , Term value ) {
		Term toret;
		if( ! this.equals( variable ) ){
			toret = this;
		}else{
			toret = value;
		}
		return toret;
	}
}
