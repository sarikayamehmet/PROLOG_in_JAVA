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
		
		Assert.assertTrue( pair1.equals(pair2) );
		Assert.assertTrue( pair1.equals(pair1) );
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
	
	
}
