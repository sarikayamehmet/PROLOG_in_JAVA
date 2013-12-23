package lc.practicas.terms;

import junit.framework.Assert;
import org.junit.Test;

public class PairTest {

	Term atomTerm1 = new AtomTerm("aa");
	Term atomTerm2 = new AtomTerm("ab");
	Term variableTerm1 = new VariableTerm("X");
	Term variableTerm2 = new VariableTerm("Y");
	Term clauseTerm = new ClauseTerm("dd",null);
	
	@Test
	public void testEqualsPairAtoms(){
		Pair pair1 = new Pair(atomTerm1, atomTerm2);
		Pair pair2 = new Pair(atomTerm1, atomTerm2);
		Pair pair3 = new Pair(atomTerm2 , atomTerm1);
		
		Assert.assertTrue( pair1.equals(pair2) );
		Assert.assertTrue( pair1.equals(pair1) );
		Assert.assertTrue( pair3.equals(pair1) );
	}
	
	@Test
	public void testDistinctsPairAtoms(){
		Pair pair1 = new Pair(atomTerm1, atomTerm2);
		Pair pair2 = new Pair(atomTerm1, atomTerm2);
		
		Assert.assertTrue( pair1.equals(pair2) );
		Assert.assertTrue( pair1.equals(pair1) );
	}
	
	@Test
	public void testVariablePair(){
		Pair pair1 = new Pair(variableTerm1, variableTerm2);
		Pair pair2 = new Pair(variableTerm1, variableTerm1);
		
		Assert.assertFalse( pair1.equals(pair2) );
	}
	
	@Test
	public void testContainVariables(){
		Pair pair1 = new Pair( atomTerm1 , atomTerm2 );
		Assert.assertFalse( "The pair no contains variables", pair1.containsVariables());
		
		Pair pair2 = new Pair( clauseTerm , clauseTerm );
		Assert.assertFalse( "The pair no contains variables", pair2.containsVariables());
		
		Pair pair3 = new Pair( variableTerm1 , variableTerm2);
		Assert.assertTrue( "The pair contains variables" , pair3.containsVariables());
		
		Pair pair4 = new Pair( variableTerm1 , clauseTerm);
		Assert.assertTrue( "The pair contains variables" , pair4.containsVariables());
		
		Pair pair5 = new Pair( atomTerm1 , variableTerm1 );
		Assert.assertTrue( "The pair contains variables" , pair5.containsVariables());	
	}
}
