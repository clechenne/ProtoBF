package org.cl.table;

import org.cl.model.Damage;
import org.cl.model.hit.Hit;
import org.cl.model.hit.UpperworksHit;
import org.cl.model.hit.VitalHit;
import org.cl.utils.dice.Dice;
import org.cl.utils.dice.Roll;

public class ApHitTable {
	
	Hit hit ;
	int penetrationValue;
	int armorValue;
	
	public void apply(Hit hit, int penetrationValue, int armorValue) {
		this.hit = hit;
		this.penetrationValue = penetrationValue;
		this.armorValue = armorValue;
		
		if (hit instanceof UpperworksHit) {
			upperworks();
		} else if (hit instanceof VitalHit) {
			vital();
		}
	}

	private void vital() {
		int d6 = Dice.rollD6().getIntValue();
		
		// differential
		float dif = penetrationValue / (float) armorValue;
		
		if (dif >= 0.5 && dif < 1.0) {
			switch (d6) {
			case 6 : hit.addDamage(Damage.De); break;
			default : hit.addDamage(Damage.NT); break;
			}
		} 
		else if (dif >= 1.0 && dif < 2.0) {
			switch (d6) {
			case 1 : hit.addDamage(Damage.NT); break;
			case 2 : hit.addDamage(Damage.NT); break;
			case 3 : hit.addDamage(Damage.M); break;
			case 4 : hit.addDamage(Damage.Mx); break;
			case 5 : hit.addDamage(Damage.Di); break;
			case 6 : hit.addDamage(Damage.P); break;
			case 8 : hit.addDamage(Damage.NT); break;
			}
		}
		else if (dif >= 2.0) {
			switch (d6) {
			case 1 : hit.addDamage(Damage.FL); break;
			case 2 : hit.addDamage(Damage.M); break;
			case 3 : hit.addDamage(Damage.Mx); break;
			case 4 : hit.addDamage(Damage.P); break;
			case 5 : hit.addDamage(Damage.Di); break;
			case 6 : hit.addDamage(Damage.Px); break;
			case 8 : hit.addDamage(Damage.NT); break;
			}
		}
		
	}

	private void upperworks() {
		
		int d6 = Dice.rollD6().getIntValue();
		
		// differential
		float dif = penetrationValue / (float) armorValue;
		
		if (dif >= 0.5 && dif < 1.0) {
			switch (d6) {
			case 2 :
			case 3 : 
			case 4 : hit.addDamage(Damage.NT); break;
			case 5 : hit.addDamage(Damage.De); break;
			case 6 : 
			case 7 : hit.addDamage(Damage.T); break;
			default : hit.addDamage(Damage.S); break;
			}
		} 
		else if (dif >= 1.0 && dif < 2.0) {
			switch (d6) {
			case 2 : hit.addDamage(Damage.NT); break;
			case 3 : hit.addDamage(Damage.T); break;
			case 4 : hit.addDamage(Damage.S); break;
			case 5 : hit.addDamage(Damage.De); break;
			default : hit.addDamage(Damage.S); break;
			}
		}
		else if (dif >= 2.0) {
			switch (d6) {
			case 1 : hit.addDamage(Damage.NT); break;
			case 2 : hit.addDamage(Damage.T); break;
			case 3 : hit.addDamage(Damage.S); break;
			case 4 : hit.addDamage(Damage.S); break;
			case 5 : hit.addDamage(Damage.De); break;
			case 6 : hit.addDamage(Damage.T); hit.addDamage(Damage.S); break;
			default : hit.addDamage(Damage.S); hit.addDamage(Damage.De); break;
			}
		}
	}


}
