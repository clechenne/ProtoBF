package org.cl.model.hit;

import java.util.ArrayList;
import java.util.List;

import org.cl.model.Damage;

abstract public class CoreHit implements Hit {
	protected List<Damage> damages;
	
	public CoreHit() {
		damages = new ArrayList<Damage>();
	}
	
	@Override
	public void addDamage(Damage nt) {
		damages.add(nt);
	}
	
	@Override
	public List<Damage> getDamages() {
		return damages;
	}
	
}
