package lc.practicas.terms;

import junit.framework.Assert;
import org.junit.Test;

public class AtomTermTest {
	
	Term term1 = new AtomTerm("abc");

		@Test
		public void testEqualsAtoms(){
			Term term2 = new AtomTerm("abc");
			Assert.assertTrue(  term1.equals(term2));
		}
		
		@Test
		public void testDistinctAtoms(){
			Term term3 = new AtomTerm("bcd");
			Assert.assertFalse( term1.equals(term3));
		}
		
		@Test
		public void testAtomVsVar(){
			Term varTerm = new VariableTerm("X");
			Assert.assertFalse( term1.equals(varTerm));
		}
		
		@Test
		public void testAtomVsClause(){
			Term ClauseTerm = new ClauseTerm("hola", null );
			Assert.assertFalse( term1.equals(ClauseTerm));
		}
}
