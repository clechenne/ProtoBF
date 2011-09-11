package org.cl.model;

import junit.framework.Assert;

import org.cl.exceptions.ShipMoveException;
import org.cl.utils.FactoryTest;
import org.junit.Test;

public class ShipMoveHistTest {
		
	@Test public void onePath() {
		Ship ship = FactoryTest.newShip(0, 18, 18, 4);
		move(ship);
		
		Path path = ship.getPath();
		Assert.assertEquals("Bad path", 1, path.getNb());	
	}
	
	@Test public void moreMoveThanPath() {
		Path.MAX_PATH = 1;
		
		Ship ship = FactoryTest.newShip(0, 18, 18, 4);
		
		move(ship);
		move(ship);
		
		Path path = ship.getPath();
		Assert.assertEquals("Bad path", 1, path.getNb());	
	}
	
	private void move(Ship ship) {
		try {
			ship.move(90);
		} catch (ShipMoveException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
	}



}
