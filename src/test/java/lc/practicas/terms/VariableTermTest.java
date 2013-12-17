package lc.practicas.terms;

import org.junit.Test;
import junit.framework.Assert;

public class VariableTermTest {

	Term term1 = new VariableTerm("X");
	
	@Test 
	public void testSameVariable(){
		Term term2 = new VariableTerm("X");
		Assert.assertTrue( term1.equals(term1));
		Assert.assertTrue( term1.equals(term2));
	}
	
	@Test 
	public void testDistinctVariables(){
		Term term2 = new VariableTerm("Y");
		Assert.assertFalse( term1.equals(term2));
	}
	
	@Test
	public void testVariableVsAtom(){
		Term term2 = new AtomTerm("X");
		Assert.assertFalse( term1.equals(term2));
	}
	
	@Test
	public void testVariableVsClause(){
		Term term2 = new ClauseTerm("g", null);
		Assert.assertFalse( term1.equals(term2));
	}
	
}
