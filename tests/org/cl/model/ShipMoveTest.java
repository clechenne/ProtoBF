package org.cl.model;

import junit.framework.Assert;

import org.cl.exceptions.ShipMoveException;
import org.cl.utils.FactoryTest;
import org.junit.Test;

public class ShipMoveTest {
	
	private void core(int heading, int speed, int expectedX, int expectedY) {
		Ship ship = FactoryTest.newShip(0, heading, speed, 4);
		
		try {
			ship.move(90);
		} catch (ShipMoveException e) {
			// TODO Auto-generated catch block
			throw new IllegalStateException(e);
		}
		
		Assert.assertEquals("Bad position", expectedX, ship.pos.x);
		Assert.assertEquals("Bad position", expectedY, ship.pos.y);
	}
	
	@Test public void moveAheadHeading0() {
		core(0, 18, 100, 60);
	}

	@Test public void moveAheadHeading45() {
		core(45, 18, 128, 72);
	}

	@Test public void moveAheadHeading90() {		
		core(90, 18, 140, 100);
	}
	
	@Test public void moveAheadHeading135() {
		core(135, 18, 128, 128);
	}
	
	@Test public void moveAheadHeading180() {
		core(180, 18, 100, 140);
	}

	@Test public void moveAheadHeading225() {
		core(225, 18, 72, 128);
	}
	
	@Test public void moveAheadHeading270() {
		core(270, 18, 60, 100);
	}
	
	@Test public void moveAheadHeading315() {
		core(315, 18, 72, 72);
	}
}
