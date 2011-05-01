package org.cl.orders;

import org.cl.exceptions.OrderException;
import org.cl.exceptions.ShipMoveException;
import org.cl.model.Game;
import org.cl.model.Ship;

public class MoveOrder implements Order {
	
	public int id;
	public int distToMove;
	
	@Override
	public void execute(Game g) {
		Ship ship = g.getShip(id);
		if (ship != null) {
			try {
				ship.move(distToMove);
			} catch (ShipMoveException e) {
				// TODO Auto-generated catch block
				throw new OrderException(ship, e);
			}
		}
	}
	
	public String toString() {
		return id + " is moving " + distToMove;
	}

}
