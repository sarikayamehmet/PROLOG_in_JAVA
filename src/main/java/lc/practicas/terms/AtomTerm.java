package lc.practicas.terms;

public class AtomTerm extends Term {
	
	private String name;
	
	public AtomTerm( String name ){
		this.name = name;
		this.typeTerm = TypeTerm.atom;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean equals( Term term ){
		boolean isEquals = true;
		if( ! super.equalsTypeTerm(term) ){
			isEquals = false;
		}else{
			isEquals = equalsName( (AtomTerm) term);
		}
		return isEquals;
	}
	
	private boolean equalsName( AtomTerm term ){
		return this.name.equals( term.getName() );
	}

	@Override
	public Pair<Term, Term> getDiscordance(Term term) throws DiscordanceNotFound {
		Pair<Term,Term> discordancePair = null;
		if( !this.equals(term) ){
			discordancePair = new Pair<Term, Term>(this, term);
		}else{
			throw new DiscordanceNotFound();
		}
		return discordancePair;
	}

	

}
