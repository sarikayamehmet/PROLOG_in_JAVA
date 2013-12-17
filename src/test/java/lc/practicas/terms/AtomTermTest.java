package lc.practicas.terms;

import java.util.LinkedList;

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
		public void testEqualsDistinctAtoms(){
			Term term3 = new AtomTerm("bcd");
			Assert.assertFalse( term1.equals(term3));
		}
		
		@Test
		public void testEqualsAtomVsVar(){
			Term varTerm = new VariableTerm("X");
			Assert.assertFalse( term1.equals(varTerm));
		}
		
		@Test
		public void testEqualsAtomVsClause(){
			Term ClauseTerm = new ClauseTerm("hola", null );
			Assert.assertFalse( term1.equals(ClauseTerm));
		}
		
		@Test
		public void testDiscordanceThrowExceptionSameAtom(){
			
			try{
				term1.getDiscordance(term1);
				Assert.fail("No exception was thrown");
			}catch( DiscordanceNotFoundException e ){
				//Pass the test
			}
		}
		
		@Test
		public void testDiscordanceDistinctsAtoms(){
			
			Term term1 = new AtomTerm("jose");
			Term term2 = new AtomTerm("maria");
			Pair pair1 = new Pair(term1, term2);
			try{
				Pair pair2 = term1.getDiscordance(term2);
				Assert.assertTrue( pair1.equals(pair2) );
			}catch( DiscordanceNotFoundException e ){
				Assert.fail("The Terms are distincs");
			}
		}
		
		@Test
		public void testDiscordanceDitinctsTypes(){
			
			Term term1 = new AtomTerm("a");
			Term term2 = new VariableTerm("a");
			Term term3 = new ClauseTerm("a", new LinkedList<Term>() );
			
			Pair pair12 = new Pair( term2 , term1 );
			Pair pair13 = new Pair( term3 , term1 );
			
			Pair test12 = null;
			Pair test13 = null;
			try {
				test12 = term1.getDiscordance(term2);
				test13 = term1.getDiscordance(term3);
			} catch (DiscordanceNotFoundException e) {
				Assert.fail("The terms are differents");
			}
			Assert.assertTrue( test12.equals(pair12));
			Assert.assertTrue( test13.equals(pair13));
			
		}
		
}
