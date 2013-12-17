package lc.practicas.terms;

public class Pair{
	private Term left;
	private Term right;
	
	public Pair( Term termLeft , Term termRight ){
		this.left = termLeft;
		this.right = termRight;
	}

	public Term getLeft() {
		return left;
	}

	public void setLeft(Term left) {
		this.left = left;
	}

	public Term getRight() {
		return right;
	}

	public void setRight( Term right) {
		this.right = right;
	}
	
	public boolean equals( Pair pair ){
		boolean isEquals = false;
		if( this.left.equals( pair.getLeft() ) 
			&& this.right.equals(pair.getRight() ) ){
			
			isEquals = true;
		}
		
		return isEquals;
	}
	
}
