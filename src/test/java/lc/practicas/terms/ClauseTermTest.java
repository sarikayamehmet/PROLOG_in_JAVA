package lc.practicas.terms;

import java.util.LinkedList;

import junit.framework.Assert;
import org.junit.Test;

public class ClauseTermTest {

	LinkedList<Term> list = new LinkedList<Term>();
	LinkedList<Term> list2 = new LinkedList<Term>();
	Term atomTerm1 = new AtomTerm("hola");
	Term atomTerm2 = new AtomTerm("adios");
	Term clauseTerm1 = new ClauseTerm("g", list);
	Term clauseTerm2 = new ClauseTerm("f", list);
	Term clauseTerm3 = new ClauseTerm("f", list);
	
	
	@Test
	public void testEqualsClauseWithEmptyList(){
		Assert.assertTrue( clauseTerm1.equals(clauseTerm1) ); 
	}
	
	@Test
	public void testEqualsClauseWithSameList(){
		LinkedList<Term> list12 = new LinkedList<Term>();
		list12.add(atomTerm1);
		list12.add(atomTerm2);
		list12.add(atomTerm1);
		Term clauseTerm12 = new ClauseTerm("g", list12 );
		Term clauseTerm22 = new ClauseTerm("g" , list12 );
		Assert.assertTrue( clauseTerm12.equals( clauseTerm22 ));
	}
	
	@Test
	public void testDistinctClauseFuntor(){
		LinkedList<Term> list12 = new LinkedList<Term>();
		list12.add(atomTerm1);
		list12.add(atomTerm2);
		list12.add(atomTerm1);
		Term clauseTerm12 = new ClauseTerm("g", list12 );
		Term clauseTerm22 = new ClauseTerm("f" , list12 );
		Assert.assertFalse( clauseTerm12.equals( clauseTerm22 ));
	}
	
	@Test
	public void testDistinctNumberTerms(){
		LinkedList<Term> list12 = new LinkedList<Term>();
		list12.add(atomTerm1);
		list12.add(atomTerm2);
		list12.add(atomTerm1);
		LinkedList<Term> list11 = new LinkedList<Term>();
		list11.add(atomTerm1);
		list11.add(atomTerm2);
		Term clauseTerm12 = new ClauseTerm("g", list11);
		Term clauseTerm22 = new ClauseTerm("g" , list12 );
		Assert.assertFalse( clauseTerm12.equals( clauseTerm22 ));
	}
	
	@Test 
	public void testDistinctsTerms(){
		
		Term atomTerm = new AtomTerm("a");
		Term variableTerm = new VariableTerm("X");
		
		Assert.assertFalse( clauseTerm1.equals(atomTerm));
		Assert.assertFalse( clauseTerm1.equals(variableTerm));
	}
	
	
	@Test
	public void testGetDiscordanceOtherTerms(){
		Pair pairAtomClause = new Pair(clauseTerm1, atomTerm1);
		Pair test;
		try {
			test = clauseTerm1.getDiscordance(atomTerm1);
			Assert.assertTrue(test.equals(pairAtomClause));
		} catch (DiscordanceNotFoundException e) {
			Assert.fail("The terms are distincts");
		}
		
		Term variableTerm = new VariableTerm("X");
		Pair pairVariableClause = new Pair( clauseTerm1 , variableTerm );
		try {
			test = clauseTerm1.getDiscordance(variableTerm);
			Assert.assertTrue(test.equals(pairVariableClause));
		} catch (DiscordanceNotFoundException e) {
			Assert.fail("The terms are distincts");
		}
		
	}
	
	@Test
	public void testDiscordanceElementClause(){
		LinkedList<Term> list11 = new LinkedList<Term>();
		LinkedList<Term> list12 = new LinkedList<Term>();
		
		list11.add(atomTerm1);
		list12.add(atomTerm1);

		list11.add(atomTerm1);
		list12.add(atomTerm1);

		list11.add(atomTerm1);
		list12.add(atomTerm2);
		
		Term clause1 = new ClauseTerm( "g" , list11 );
		Term clause2 = new ClauseTerm( "g" , list12 );
			
		Pair test1 = new Pair(atomTerm1, atomTerm2);
		Pair test2;
		try{
			test2 = clause1.getDiscordance(clause2);
			Assert.assertTrue( "The clausures should be differents", test1.equals(test2) );
		}catch(DiscordanceNotFoundException e ){
			Assert.fail("The terms are distincts");
		}
				
	}
}
