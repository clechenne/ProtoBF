package org.cl.model;

import junit.framework.Assert;

import org.cl.exceptions.ShipMoveException;
import org.cl.utils.FactoryTest;
import org.junit.Test;

public class ShipTurnTest {

	@Test public void turnStarboardHeagindInOneMove() {
		
		Ship ship = FactoryTest.newShip(0, 0, 18, 2);
		
		try {
			ship.turnStarboard(30);
			
			ship.move(69);
			
		} catch (ShipMoveException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
		
		//System.out.println(ship.heading);
		Assert.assertEquals("Bad new heading", 30, ship.heading);
		
		// next move, no turn
		try {	
			ship.move(69);
		} catch (ShipMoveException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
		Assert.assertEquals("Bad new heading", 30, ship.heading);
	}
	
	@Test public void turnInOneMove() {
		
		Ship ship = FactoryTest.newShip(0, 0, 18, 3);
		
		try {
			ship.turnStarboard(90);
			
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
}
