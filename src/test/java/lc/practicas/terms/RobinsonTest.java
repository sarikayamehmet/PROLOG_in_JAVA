package lc.practicas.terms;

import java.util.LinkedList;

import junit.framework.Assert;
import lc.practicas.Robinson;

import org.junit.Test;

public class RobinsonTest {

	@Test
	public void testUnifies(){
		
		Term atomTermA = new AtomTerm("a");
		Term variableTermX = new VariableTerm("X");
		Term variableTermY = new VariableTerm("Y");
		
		LinkedList<Term> list1 = new LinkedList<Term>();
		list1.add(atomTermA);
		list1.add(variableTermX);
		
		LinkedList<Term> list2 = new LinkedList<Term>();
		list2.add(variableTermX);
		list2.add(variableTermY);
		
		Term clauseTerm1 = new ClauseTerm( "p" , list1 );
		Term clauseTerm2 = new ClauseTerm( "p" , list2 );
		
		Robinson robinson = new Robinson();
		
		Assert.assertTrue( robinson.unify( clauseTerm1 , clauseTerm2 ) );
	}
	
}
