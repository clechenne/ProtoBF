package org.cl.orders;

import org.cl.model.Game;
import org.cl.model.Ship;

public class TurnStarboardOrder implements Order {
	
	public int id;
	public int target;
	
	@Override
	public void execute(Game g) {
		Ship ship = g.getShip(id);
		if (ship != null) {
			ship.turnStarboard(target);
		}
	}
	
	public String toString() {
		return id + " STARBOARD " + target ;
	}

}
