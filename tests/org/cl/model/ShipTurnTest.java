package org.cl.model;

import junit.framework.Assert;

import org.cl.exceptions.ShipMoveException;
import org.cl.utils.FactoryTest;
import org.junit.Test;

public class ShipTurnTest {
		
	@Test public void turnPortHeagindInOneMove() {
		
		Ship ship = FactoryTest.newShip(0, 0, 18, 3);
		
		try {
			ship.turnPort(90);
			
			ship.move(69);
			
		} catch (ShipMoveException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
		
		//System.out.println(ship.heading);
		Assert.assertEquals("Bad new heading", 90, ship.heading);
		
		// next move, no turn
		try {	
			ship.move(69);
		} catch (ShipMoveException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
		Assert.assertEquals("Bad new heading", 90, ship.heading);
	}

	@Test public void turnPortHeagindInTwoMoves() {
		
		Ship ship = FactoryTest.newShip(0, 0, 18, 3);
		
		try {
			ship.turnPort(115);
			
			ship.move(69);
			
		} catch (ShipMoveException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
		
		//System.out.println(ship.heading);
		Assert.assertEquals("Bad new heading", 90, ship.heading);
		
		// next move, one turn
		try {	
			ship.move(69);
		} catch (ShipMoveException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
		
		Assert.assertEquals("Bad new heading", 115, ship.heading);
	}
}
