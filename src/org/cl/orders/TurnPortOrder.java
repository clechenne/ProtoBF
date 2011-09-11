package org.cl.orders;

import org.cl.model.Game;
import org.cl.model.Ship;

public class TurnPortOrder implements Order {
	
	public int id;
	public int target;
	
	@Override
	public void execute(Game g) {
		Ship ship = g.getShip(id);
		if (ship != null) {
			ship.turnPort(target);
		}
	}
	
	public String toString() {
		return id + " PORT " + target ;
	}

}
