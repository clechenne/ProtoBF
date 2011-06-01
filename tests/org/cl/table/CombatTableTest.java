package org.cl.table;

import junit.framework.Assert;

import org.cl.model.Range;
import org.cl.model.hit.Hit;
import org.cl.model.hit.MissHit;
import org.cl.model.hit.UpperworksHit;
import org.cl.model.hit.VitalHit;
import org.cl.utils.dice.Dice;
import org.cl.utils.dice.MockDice;
import org.junit.Before;
import org.junit.Test;

public class CombatTableTest {
	
	private MockDice dice;
	
	@Before public void before() {
		dice = new MockDice();
		Dice.register(dice);	
	}
	
	@Test public void rule406WithOneMissOneVitalsOneUpperworks() {
		
		Table406 table = new Table406();
		table.setRange(Range.SHORT);
		
		dice.addDice(9);
		
		Hit hit = table.roll();
		Assert.assertTrue("MissHit expected", hit instanceof MissHit );
		
		dice.addDice(1);
		hit = table.roll();
		Assert.assertTrue("VitalHit expected", hit instanceof VitalHit );
		
		dice.addDice(2);
		hit = table.roll();
		Assert.assertTrue("UpperworksHit expected", hit instanceof UpperworksHit );
	}
}
