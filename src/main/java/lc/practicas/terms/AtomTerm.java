package lc.practicas.terms;

public class AtomTerm extends Term {
	
	private String name;
	
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
}
