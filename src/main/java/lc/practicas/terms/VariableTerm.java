package lc.practicas.terms;

public class VariableTerm extends Term {
	
	private String name;
	
	public VariableTerm( String name ){
		this.name = name;
		this.typeTerm = TypeTerm.variable;
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
			isEquals = equalsName( (VariableTerm) term);
		}
		return isEquals;
	}
	
	private boolean equalsName( VariableTerm term ){
		return this.name.equals( term.getName() );
	}
	
	@Override
	public Pair getDiscordance(Term term) throws DiscordanceNotFoundException {
		Pair discordancePair = null;
		if( !this.equals(term) ){
			discordancePair = new Pair(this, term);
		}else{
			throw new DiscordanceNotFoundException();
		}
		return discordancePair;
	}
	
	@Override
	public boolean isFinal(){
		return false;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
