package org.cl.table;

import org.cl.model.Damage;
import org.cl.model.hit.Hit;
import org.cl.model.hit.UpperworksHit;
import org.cl.model.hit.VitalHit;
import org.cl.utils.dice.Dice;

public class HeHitTable {
	Hit hit ;
	int shellSize;
	int targetSize;
	
	public void apply(Hit hit, int shellSize, int targetSize) {
		this.hit = hit;
		this.shellSize = shellSize;
		this.targetSize = targetSize;
		
		if (hit instanceof UpperworksHit) {
			upperworks();
		} else if (hit instanceof VitalHit) {
			vital();
		}
	}

	private void vital() {
		int d6 = Dice.rollD6().getIntValue();
		
		// differential
		float dif = shellSize / (float) targetSize;
		
		if (dif >= 0.5 && dif < 1.0) {
			switch (d6) {
			case 1 : hit.addDamage(Damage.NT); break;
			case 2 : hit.addDamage(Damage.NT); break;
			case 3 : hit.addDamage(Damage.NT); break;
			case 4 : hit.addDamage(Damage.NT); break;
			case 5 : hit.addDamage(Damage.NT); break;
			case 6 : hit.addDamage(Damage.M); break;
			case 7 : hit.addDamage(Damage.M); break;
			case 8 : hit.addDamage(Damage.NT); break;
			}
		}
		else if (dif >= 1.0 && dif < 2.0) {
			switch (d6) {
			case 1 : hit.addDamage(Damage.NT); break;
			case 2 : hit.addDamage(Damage.NT); break;
			case 3 : hit.addDamage(Damage.NT); break;
			case 4 : hit.addDamage(Damage.NT); break;
			case 5 : hit.addDamage(Damage.M); break;
			case 6 : hit.addDamage(Damage.FL); break;
			case 7 : hit.addDamage(Damage.FL); break;
			case 8 : hit.addDamage(Damage.NT); break;
			}
		}
		else if (dif >= 2.0 && dif < 4.0) {
			switch (d6) {
			case 1 : hit.addDamage(Damage.NT); break;
			case 2 : hit.addDamage(Damage.NT); break;
			case 3 : hit.addDamage(Damage.NT); break;
			case 4 : hit.addDamage(Damage.M); break;
			case 5 : hit.addDamage(Damage.FL); break;
			case 6 : hit.addDamage(Damage.FL); break;
			case 7 : hit.addDamage(Damage.FL); break;
			case 8 : hit.addDamage(Damage.NT); break;
			}
		}		
		else if (dif >= 4.0) {
			switch (d6) {
			case 1 : hit.addDamage(Damage.S); hit.addDamage(Damage.T); break;
			case 2 : hit.addDamage(Damage.M); break;
			case 3 : hit.addDamage(Damage.M); break;
			case 4 : hit.addDamage(Damage.FL); break;
			case 5 : hit.addDamage(Damage.Di); break;
			case 6 : hit.addDamage(Damage.Di); hit.addDamage(Damage.FL); break;
			case 7 : hit.addDamage(Damage.Di); hit.addDamage(Damage.FL); break;
			case 8 : hit.addDamage(Damage.NT); break;
			}			
		}
		
	}

	private void upperworks() {
		
		int d6 = Dice.rollD6().getIntValue();
		
		// differential
		float dif = shellSize / (float) targetSize;
		
		if (dif >= 0.1 && dif < 0.5) {
			switch (d6) {
			case 1 :
			case 2 :
			case 3 : hit.addDamage(Damage.NT); break;
			case 4 : hit.addDamage(Damage.T); break;
			case 5 : hit.addDamage(Damage.T); break;
			case 6 : 
			case 7 : 
			case 8 : hit.addDamage(Damage.S); break;
			}
		} 
		else if (dif >= 0.5 && dif < 1.0) {
			switch (d6) {
			case 1 :
			case 2 : hit.addDamage(Damage.NT); break;
			case 3 :
			case 4 : hit.addDamage(Damage.T); break;
			case 5 : hit.addDamage(Damage.De); break;
			case 6 : 
			case 7 : hit.addDamage(Damage.S); break;
			case 8 : hit.addDamage(Damage.S); hit.addDamage(Damage.T);break;
			}
		}
		else if (dif >= 1.0 && dif < 2.0) {
			switch (d6) {
			case 1 : hit.addDamage(Damage.NT); break;
			case 2 :
			case 3 : hit.addDamage(Damage.T); break;
			case 4 : hit.addDamage(Damage.S); break;
			case 5 : hit.addDamage(Damage.De); break;
			case 6 : 
			case 7 : hit.addDamage(Damage.S2); break;
			case 8 : hit.addDamage(Damage.S); hit.addDamage(Damage.De);break;
			}
		}
		else if (dif >= 2.0 && dif < 4.0) {
			switch (d6) {
			case 1 :
			case 2 : hit.addDamage(Damage.T); break;
			case 3 : hit.addDamage(Damage.T2); break;
			case 4 : hit.addDamage(Damage.DC); break;
			case 5 : hit.addDamage(Damage.De); break;
			case 6 : 
			case 7 : hit.addDamage(Damage.S2); break;
			case 8 : hit.addDamage(Damage.S2); hit.addDamage(Damage.De);break;
			}
		}		
		else if (dif >= 4.0) {
			switch (d6) {
			case 1 :
			case 2 : hit.addDamage(Damage.T2); break;
			case 3 : hit.addDamage(Damage.S2); break;
			case 4 : hit.addDamage(Damage.DC2); break;
			case 5 : hit.addDamage(Damage.De); break;
			case 6 : 
			case 7 : hit.addDamage(Damage.T2); hit.addDamage(Damage.S3); break;
			case 8 : hit.addDamage(Damage.De); hit.addDamage(Damage.Di); hit.addDamage(Damage.S); break;
			}			
		}
	}

}
