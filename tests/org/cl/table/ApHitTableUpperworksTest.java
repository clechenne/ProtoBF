package org.cl.table;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.cl.model.Damage;
import org.cl.model.hit.Hit;
import org.cl.model.hit.UpperworksHit;
import org.cl.utils.dice.Dice;
import org.cl.utils.dice.MockDice;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApHitTableUpperworksTest {
	
	private MockDice dice;
	
	private static List<CombatTestCase> cases;
	
	@BeforeClass static public void  populate() {
		cases = new ArrayList<CombatTestCase>();
		
		// Upperworks >= 50%
		cases.add(new CombatTestCase(8, 3, 4, Damage.S));
		cases.add(new CombatTestCase(6, 3, 4, Damage.T));
		cases.add(new CombatTestCase(5, 3, 4, Damage.De));
		cases.add(new CombatTestCase(4, 3, 4, Damage.NT));
		
		// Upperworks >= 100%
		cases.add(new CombatTestCase(8, 6, 4, Damage.S));
		cases.add(new CombatTestCase(6, 6, 4, Damage.S));
		cases.add(new CombatTestCase(5, 6, 4, Damage.De));
		cases.add(new CombatTestCase(4, 6, 4, Damage.S));
		cases.add(new CombatTestCase(3, 6, 4, Damage.T));
		cases.add(new CombatTestCase(2, 6, 4, Damage.NT));
		
		// Upperworks >= 200%
		cases.add(new CombatTestCase(8, 8, 4, Damage.S, Damage.De));
		cases.add(new CombatTestCase(6, 8, 4, Damage.T, Damage.S));
		cases.add(new CombatTestCase(5, 8, 4, Damage.De));
		cases.add(new CombatTestCase(4, 8, 4, Damage.S));
		cases.add(new CombatTestCase(3, 8, 4, Damage.S));
		cases.add(new CombatTestCase(2, 8, 4, Damage.T));
		cases.add(new CombatTestCase(1, 8, 4, Damage.NT));
	}
	
	@Before public void before() {
		dice = new MockDice();
		Dice.register(dice);	
	}
	
	@Test public void upperworks() {
		
		int idTest=0 ;
		for (CombatTestCase c : cases) {
			Hit hit = new UpperworksHit();
			
			ApHitTable table = new ApHitTable();
			
			dice.addDice(c.roll1);
			
			table.apply(hit, c.penVal, c.armVal);
			
			List<Damage> real = hit.getDamages();
			
			Assert.assertTrue("idTest=" + idTest, real.size() == c.expected.size());
			Assert.assertEquals("idTest=" + idTest, c.expected.get(0), real.get(0));
			
			idTest++;
		}

	}
}
 
