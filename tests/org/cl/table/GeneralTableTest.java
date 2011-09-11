package org.cl.table;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.cl.model.Damage;
import org.cl.model.hit.Hit;
import org.cl.model.hit.UpperworksHit;
import org.cl.model.hit.VitalHit;
import org.cl.utils.dice.Dice;
import org.cl.utils.dice.MockDice;
import org.junit.Before;
import org.junit.Test;

public class GeneralTableTest {
	
	private MockDice dice;
	
	
	@Before public void before() {
		dice = new MockDice();
		Dice.register(dice);	
	}
	
	@Test public void deUpperworks() {
		
		Hit hit = new UpperworksHit();
		doIt(1, hit, Damage.NT);
		doIt(2, hit, Damage.WI);
		doIt(3, hit, Damage.LT);
		doIt(4, hit, Damage.BR);
		doIt(5, hit, Damage.DC);
		doIt(6, hit, Damage.FU);
	}
	
	@Test public void deVital() {
		
		Hit hit = new VitalHit();
		doIt(1, hit, Damage.S, Damage.T);
		doIt(2, hit, Damage.TT);
		doIt(3, hit, Damage.FL25);
		doIt(4, hit, Damage.M);
		doIt(5, hit, Damage.M);
		doIt(6, hit, Damage.NT);
	}
	
	private void doIt(int roll, Hit hit, Damage ...damages) {
		
		List<Damage> expected = new ArrayList<Damage>();
		for (Damage d : damages)  {
			expected.add(d);
		}
		
		dice.addDice(roll);
		
		GeneralTable tb = new GeneralTable();
		
		tb.applyDe(hit);
		
		Assert.assertTrue("Invalid test case", hit.getDamages().size() == expected.size());
		Assert.assertEquals("Bad damage", expected.get(0), hit.getDamages().get(0));
		// just for test
		hit.getDamages().clear();
	}
}
 
