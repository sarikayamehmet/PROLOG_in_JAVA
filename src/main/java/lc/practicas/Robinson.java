package lc.practicas;

import java.util.Stack;

import lc.practicas.terms.DiscordanceNotFoundException;
import lc.practicas.terms.Pair;
import lc.practicas.terms.Term;

public class Robinson {

	private Stack< Pair > stackTerms;
	private Stack< Pair > stackReplacements;
	
	public Robinson(){
		stackTerms = new Stack<Pair>();
		stackReplacements = new Stack<Pair>();
	}
	
	public boolean unify( Term term1 , Term term2 ){
		boolean unifies;
		unifies = equalsTerms( term1 , term2 );
		if( ! unifies ){
			try{
				Pair discordancePair = term1.getDiscordance(term2);
				if( discordancePair.containsVariables() ){
					Term value = discordancePair.getRight();
					Term variable = discordancePair.getLeft();
					if( value.containsTerm( variable ) ){
						//Occur check
						unifies = false;
					}else{
						Term newTerm1 = term1.getReplace( variable , value );
						Term newTerm2 = term2.getReplace( variable , value );
						unifies = unify( newTerm1 , newTerm2 );
					}
				}
			}catch(DiscordanceNotFoundException e ){
				unifies = true;
			}
		}
		return unifies;
	}
	
	
	private boolean equalsTerms( Term term1 , Term term2 ){
		return term1.equals(term2);
	}
	
}
