package org.cl.orders;

import org.cl.model.Game;
import org.cl.model.Ship;

public class GunFireOrder implements Order {
	public int id;
	public int targetId;
	public String ammo;
	
	@Override
	public void execute(Game g) {
		Ship shooter = g.getShip(id);
		if (shooter == null) {
			throw new IllegalArgumentException(id + " is not a real ship id");
		}
		
		Ship target = g.getShip(targetId);
		if (target == null) {
			throw new IllegalArgumentException(id + " is not a real ship id");
		}
		
		shooter.setGunFireTarget(target);
		shooter.setAmmo(ammo);
	}

}
