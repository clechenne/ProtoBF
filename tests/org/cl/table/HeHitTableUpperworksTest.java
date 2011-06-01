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

public class HeHitTableUpperworksTest {
	
	private MockDice dice;
	
	private static List<CombatTestCase> cases;
	
	@BeforeClass static public void  populate() {
		cases = new ArrayList<CombatTestCase>();
		
		// % >= 10
		cases.add(new CombatTestCase(8, 10, 90, Damage.S));
		cases.add(new CombatTestCase(7, 10, 90, Damage.S));
		cases.add(new CombatTestCase(6, 10, 90, Damage.S));
		cases.add(new CombatTestCase(5, 10, 90, Damage.T));
		cases.add(new CombatTestCase(4, 10, 90, Damage.T));
		cases.add(new CombatTestCase(3, 10, 90, Damage.NT));
		cases.add(new CombatTestCase(2, 10, 90, Damage.NT));
		cases.add(new CombatTestCase(1, 10, 90, Damage.NT));
		
		// % >= 50
		int shellSize = 46;
		cases.add(new CombatTestCase(8, shellSize, 90, Damage.S, Damage.T));
		cases.add(new CombatTestCase(7, shellSize, 90, Damage.S));
		cases.add(new CombatTestCase(6, shellSize, 90, Damage.S));
		cases.add(new CombatTestCase(5, shellSize, 90, Damage.De));
		cases.add(new CombatTestCase(4, shellSize, 90, Damage.T));
		cases.add(new CombatTestCase(3, shellSize, 90, Damage.T));
		cases.add(new CombatTestCase(2, shellSize, 90, Damage.NT));
		cases.add(new CombatTestCase(1, shellSize, 90, Damage.NT));	

		// % >= 100
		shellSize = 91;
		cases.add(new CombatTestCase(8, shellSize, 90, Damage.S, Damage.De));
		cases.add(new CombatTestCase(7, shellSize, 90, Damage.S2));
		cases.add(new CombatTestCase(6, shellSize, 90, Damage.S2));
		cases.add(new CombatTestCase(5, shellSize, 90, Damage.De));
		cases.add(new CombatTestCase(4, shellSize, 90, Damage.S));
		cases.add(new CombatTestCase(3, shellSize, 90, Damage.T));
		cases.add(new CombatTestCase(2, shellSize, 90, Damage.T));
		cases.add(new CombatTestCase(1, shellSize, 90, Damage.NT));	

		// % >= 200
		shellSize = 181;
		cases.add(new CombatTestCase(8, shellSize, 90, Damage.S2, Damage.De));
		cases.add(new CombatTestCase(7, shellSize, 90, Damage.S2));
		cases.add(new CombatTestCase(6, shellSize, 90, Damage.S2));
		cases.add(new CombatTestCase(5, shellSize, 90, Damage.De));
		cases.add(new CombatTestCase(4, shellSize, 90, Damage.DC));
		cases.add(new CombatTestCase(3, shellSize, 90, Damage.T2));
		cases.add(new CombatTestCase(2, shellSize, 90, Damage.T));
		cases.add(new CombatTestCase(1, shellSize, 90, Damage.T));	

		// % >= 400
		shellSize = 362;
		cases.add(new CombatTestCase(8, shellSize, 90, Damage.De, Damage.Di, Damage.S));
		cases.add(new CombatTestCase(7, shellSize, 90, Damage.T2, Damage.S3));
		cases.add(new CombatTestCase(6, shellSize, 90, Damage.T2, Damage.S3));
		cases.add(new CombatTestCase(5, shellSize, 90, Damage.De));
		cases.add(new CombatTestCase(4, shellSize, 90, Damage.DC2));
		cases.add(new CombatTestCase(3, shellSize, 90, Damage.S2));
		cases.add(new CombatTestCase(2, shellSize, 90, Damage.T2));
		cases.add(new CombatTestCase(1, shellSize, 90, Damage.T2));	

	}
	
	@Before public void before() {
		dice = new MockDice();
		Dice.register(dice);	
	}
	
	@Test public void upperworks() {
		
		int idTest=0 ;
		for (CombatTestCase c : cases) {
			Hit hit = new UpperworksHit();
			
			HeHitTable table = new HeHitTable();
			
			dice.addDice(c.roll1);
			
			table.apply(hit, c.penVal, c.armVal);
			
			List<Damage> real = hit.getDamages();
			
			Assert.assertTrue("idTest=" + idTest, real.size() == c.expected.size());
			Assert.assertEquals("idTest=" + idTest, c.expected.get(0), real.get(0));
			
			idTest++;
		}

	}
}
 
