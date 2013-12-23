package lc.practicas.terms;

public class Pair{
	private Term leftTerm;
	private Term rightTerm;
	
	public Pair( Term termLeft , Term termRight ){
		this.leftTerm = termLeft;
		this.rightTerm = termRight;
		this.reorder();
	}

	public Term getLeft() {
		return leftTerm;
	}

	public void setLeft(Term left) {
		this.leftTerm = left;
		this.reorder();
	}

	public Term getRight() {
		return rightTerm;
	}

	public void setRight( Term right) {
		this.rightTerm = right;
		this.reorder();
	}
	
	public boolean equals( Pair pair ){
		boolean isEquals = false;
		if( this.leftTerm.equals( pair.getLeft() ) 
			&& this.rightTerm.equals( pair.getRight() ) ){
			
			isEquals = true;
		}
		if( this.leftTerm.equals( pair.getRight())
			&& this.rightTerm.equals( pair.getLeft() ) ){
			
			isEquals = true;
		}
		
		return isEquals;
	}


	public boolean containsVariables() {
		boolean containsVariables = 
				this.leftTerm.getTypeTerm() == TypeTerm.variable
				|| this.rightTerm.getTypeTerm() == TypeTerm.variable ;
		
		return containsVariables;
	}
	
	
	private void reorder() {
		if( leftTerm.getTypeTerm() != TypeTerm.variable 
				&& rightTerm.getTypeTerm() == TypeTerm.variable ){
			Term aux = leftTerm;
			leftTerm = rightTerm;
			rightTerm = aux;
		}
	}
}
