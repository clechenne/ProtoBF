package org.cl.model;

import junit.framework.Assert;

import org.cl.utils.FactoryTest;
import org.junit.Test;

public class ShipMoveTest {
	
	private void core(int heading, int speed, int expectedX, int expectedY) {
		Ship ship = FactoryTest.newShip(heading, speed);
		
		ship.move(90);
		
		Assert.assertEquals("Bad position", expectedX, ship.x);
		Assert.assertEquals("Bad position", expectedY, ship.y);
	}
	
	@Test public void moveAheadHeading90() {		
		core(90, 18, 190, 100);
	}
	
	@Test public void moveAheadHeading45() {
		core(45, 18, 163, 37);
	}

	@Test public void moveAheadHeading0() {
		core(0, 18, 100, 10);
	}
	
	@Test public void moveAheadHeading135() {
		core(135, 18, 163, 163);
	}
	
	@Test public void moveAheadHeading180() {
		core(180, 18, 100, 190);
	}
	
	@Test public void moveAheadHeading270() {
		core(270, 18, 10, 100);
	}
	
	@Test public void moveAheadHeading315() {
		core(315, 18, 37, 37);
	}
}
