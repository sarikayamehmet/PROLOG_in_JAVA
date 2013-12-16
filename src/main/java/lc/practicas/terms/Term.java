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
	
	public abstract Pair< Term , Term > getDiscordance( Term term ) throws DiscordanceNotFound;
	
}
