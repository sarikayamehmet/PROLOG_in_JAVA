package lc.practicas.terms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ClauseTerm extends Term {

	private String functor;
	private List<Term> termList;
	
	public ClauseTerm( String functor , List<Term> termList ){
		this.functor = functor;
		this.termList = termList;
		this.typeTerm = TypeTerm.clause;
	}
	
	public String getFunctor()
	{
		return functor;
	}
	
	public List<Term> getTermList(){
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
			List<Term> clauseTermList = clauseTerm.getTermList();
			isEquals = this.equalsList( clauseTermList );
		}
		return isEquals;
	}
	
	private boolean equalsFunctor( ClauseTerm clauseTerm ){
		return this.functor.equals(clauseTerm.getFunctor());
	}
	
	private boolean equalsList( List<Term> clauseTermList ){
		boolean isEquals = true;
		if( ! equalsLengths( this.termList ,  clauseTermList ) ){
			isEquals = false;
		}else{
			isEquals = compareElementsLists( this.termList , clauseTermList );
		}
		return isEquals;
	}
	
	private boolean equalsLengths( List<Term> list1 , List<Term> list2 ){
		return list1.size() == list2.size();
	}

	private boolean compareElementsLists( List<Term> list1 , List<Term> list2 ){
		boolean isEquals = true;
		Iterator<Term> iterator1 = list1.iterator();
		Iterator<Term> iterator2 = list2.iterator();
		while( iterator1.hasNext()
				&& iterator2.hasNext()
				&& isEquals ){
			Term term1 = iterator1.next();
			Term term2 = iterator2.next();
			isEquals = term1.equals(term2);
		}
		return isEquals;
	}
	
	@Override
	public Pair getDiscordance( Term term ) throws DiscordanceNotFoundException {
		Pair discordancePair = null;
		if( !this.equalsTypeTerm(term) 
				|| ! this.equalsFunctor( (ClauseTerm) term )
				|| ! this.equalsLengths( this.termList , ( (ClauseTerm) term ).getTermList() ) ){
			discordancePair = new Pair( this, term );
		}else{
			List<Term> auxTermsList = ( (ClauseTerm) term ).getTermList();
			Iterator<Term> iterator1 = this.termList.iterator();
			Iterator<Term> iterator2 = auxTermsList.iterator();
			Term auxTerm1 = null;
			Term auxTerm2 = null;
			boolean equals = true;
			while( iterator1.hasNext()
					&& iterator2.hasNext() 
					&& equals ){
				auxTerm1 = iterator1.next();
				auxTerm2 = iterator2.next();
				equals = auxTerm1.equals( auxTerm2 );
			}
			
			if( equals ){
				throw new DiscordanceNotFoundException();
			}else{
				discordancePair = auxTerm1.getDiscordance( auxTerm2 );			
			}	
		}
		return discordancePair;
	}
	
	@Override
	public boolean containsTerm( Term term ){
		boolean contains = false;
		if( super.containsTerm( term ) ){
			contains = true;
		}else{
			Iterator<Term> iterator = termList.iterator();
			while( iterator.hasNext() ){
				Term aux = iterator.next();
				contains = aux.containsTerm( term );
			}
		}
		return contains;
	}
	
	@Override
	public Term getReplace( Term variable , Term value ){
		List<Term> termListAux = new LinkedList<Term>();
		Iterator<Term> iterator = termList.iterator();
		while( iterator.hasNext() ){
			Term elementList = iterator.next();
			Term newTerm = elementList.getReplace( variable , value );
			termListAux.add( newTerm );
		}	
		Term toret = new ClauseTerm( this.functor, termListAux );
		return toret;
	}
	
	@Override
	public int hashCode(){
		int hashCode;
		hashCode = functor.hashCode() * 100;
		hashCode = hashCode + termList.size();
		return hashCode;
	}
	
	@Override
	public boolean isFinal(){
		boolean isFinal = true;
		Iterator<Term> iterator = termList.iterator();
		while( iterator.hasNext() && isFinal ){
			Term term = iterator.next();
			isFinal = term.isFinal();
		}
		return isFinal;
	}
	
	@Override
	public String toString(){
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append(this.functor);
		sbuilder.append("(");
		Iterator<Term> iterator = termList.iterator();
		while( iterator.hasNext() ){
			Term term = iterator.next();
			sbuilder.append(term.toString());
		}
		sbuilder.append(")");
		return sbuilder.toString();
	}
	
}
