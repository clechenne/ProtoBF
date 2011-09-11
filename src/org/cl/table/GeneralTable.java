package org.cl.table;

import org.cl.model.Damage;
import org.cl.model.hit.Hit;
import org.cl.model.hit.UpperworksHit;
import org.cl.model.hit.VitalHit;
import org.cl.utils.dice.Dice;

public class GeneralTable {

	public void applyDe(Hit hit) {
		if (hit instanceof UpperworksHit) {
			upperworks(hit);
		} else if (hit instanceof VitalHit) {
			vital(hit);
		}
	}

	private void vital(Hit hit) {
		int d6 = Dice.rollD6().getIntValue();
		switch (d6) {
		case 1 : hit.addDamage(Damage.S); hit.addDamage(Damage.T); break;
		case 2 : hit.addDamage(Damage.TT); break;
		case 3 : hit.addDamage(Damage.FL25); break;
		case 4 : hit.addDamage(Damage.M); break;
		case 5 : hit.addDamage(Damage.M); break;
		case 6 : hit.addDamage(Damage.NT); break;
		}
		
	}

	private void upperworks(Hit hit) {
		int d6 = Dice.rollD6().getIntValue();
		switch (d6) {
		case 1 : hit.addDamage(Damage.NT); break;
		case 2 : hit.addDamage(Damage.WI); break;
		case 3 : hit.addDamage(Damage.LT); break;
		case 4 : hit.addDamage(Damage.BR); break;
		case 5 : hit.addDamage(Damage.DC); break;
		case 6 : hit.addDamage(Damage.FU); break;
		}
	}

}
