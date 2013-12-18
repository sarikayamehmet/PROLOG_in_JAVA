package lc.practicas.terms;

import java.util.LinkedList;

public class ClauseTerm extends Term {

	private String functor;
	private LinkedList<Term> termList = new LinkedList<Term>();
	
	public ClauseTerm( String functor , LinkedList<Term> termList ){
		this.functor = functor;
		this.termList = termList;
		this.typeTerm = TypeTerm.clause;
	}
	
	public String getFunctor()
	{
		return functor;
	}
	
	public LinkedList<Term> getTermList(){
		return this.termList;
	}
	
	public boolean equals( Term term ){
		boolean isEquals = true;
		if( ! super.equalsTypeTerm(term) ){
			isEquals = false;
		}else{
			isEquals = this.equalsClauses((ClauseTerm) term );
		}

		return isEquals;
	}
	
	private boolean equalsClauses( ClauseTerm clauseTerm ){
		boolean isEquals = true;
		if( ! this.equalsFunctor( clauseTerm )){
			isEquals = false;
		}else{
			LinkedList<Term> clauseTermList = clauseTerm.getTermList();
			isEquals = this.equalsList( clauseTermList );
		}
		return isEquals;
	}
	
	private boolean equalsFunctor( ClauseTerm clauseTerm ){
		return this.functor.equals(clauseTerm.getFunctor());
	}
	
	private boolean equalsList( LinkedList<Term> clauseTermList ){
		boolean isEquals = true;
		if( ! equalsLengths( this.termList ,  clauseTermList ) ){
			isEquals = false;
		}else{
			isEquals = compareElementsLists( this.termList , clauseTermList );
		}
		return isEquals;
	}
	
	private boolean equalsLengths( LinkedList<Term> list1 , LinkedList<Term> list2 ){
		return list1.size() == list2.size();
	}

	private boolean compareElementsLists( LinkedList<Term> list1 , LinkedList<Term> list2 ){
		boolean isEquals = true;
		int listSize = list1.size();
		int index = 0 ;
		while( index < listSize && isEquals ){
			Term term1 = list1.get(index);
			Term term2 = list2.get(index);
			isEquals = term1.equals(term2);
			index++;
		}
		return isEquals;
	}
	
	@Override
	public Pair getDiscordance( Term term ) throws DiscordanceNotFoundException {
		Pair discordancePair = null;
		if( !this.equalsTypeTerm(term) 
				|| ! this.equalsFunctor( (ClauseTerm) term )
				|| ! this.equalsLengths( this.termList , ((ClauseTerm) term ).getTermList() ) ){
			discordancePair = new Pair(this, term);
		}else{
			LinkedList<Term> auxTermsList = ((ClauseTerm) term ).getTermList();
			int size = this.termList.size();
			int index = 0;
			boolean equals = true;
			while( index < size && equals ){
				equals = this.termList.get(index).equals( auxTermsList.get(index) );
				if( equals ){
					index++;
				}
			}
			
			if( equals ){
				throw new DiscordanceNotFoundException();
			}else{
				Term term1 = this.termList.get(index);
				Term term2 = auxTermsList.get(index);
				discordancePair = term1.getDiscordance(term2);			
			}	
		}
		return discordancePair;
	}
}
