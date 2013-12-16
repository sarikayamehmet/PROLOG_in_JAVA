package lc.practicas.terms;

public class Pair< L , R > {
	private L left;
	private R right;
	
	public Pair( L termLeft , R termRight ){
		this.left = termLeft;
		this.right = termRight;
	}

	public L getLeft() {
		return left;
	}

	public void setLeft(L left) {
		this.left = left;
	}

	public R getRight() {
		return right;
	}

	public void setRight(R right) {
		this.right = right;
	}
	
	
}
