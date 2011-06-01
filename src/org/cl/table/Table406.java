package org.cl.table;

import org.cl.model.Range;
import org.cl.model.hit.Hit;
import org.cl.model.hit.MissHit;
import org.cl.model.hit.UpperworksHit;
import org.cl.model.hit.VitalHit;
import org.cl.utils.dice.Dice;
import org.cl.utils.dice.Roll;

public class Table406 {
	
	private Range range;
	
	public void setRange(Range s) {
		range = s;
	}

	public Hit roll() {
		Hit hit = null;
		
		if (range == Range.SHORT) {
			Roll roll = Dice.rollD4();
			hit = hitFromRoll(roll);
		} else if (range == Range.MEDIUM) {
			Roll roll = Dice.rollD6();
			hit = hitFromRoll(roll);
		} else if (range == Range.LONG) {
			Roll roll = Dice.rollD12();
			hit = hitFromRoll(roll);
		} else {
			hit = new MissHit();
		}
		return hit;
	}

	private Hit hitFromRoll(Roll roll) {
		
		if (roll.getIntValue() == 1) {
			return new VitalHit();
		} else if (roll.getIntValue() == 2) {
			return new UpperworksHit();
		} else {
			return new MissHit();
		}
	}
}
