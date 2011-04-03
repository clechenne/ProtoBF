package org.cl.model;

import junit.framework.Assert;

import org.cl.utils.FactoryTest;
import org.junit.Test;

public class ShipMoveTest {
	
	@Test public void moveAheadHeading90() {
		
		Ship ship = FactoryTest.newShip(90, 18);
		
		ship.move(90);
		
		Assert.assertEquals("Bad position", 190, ship.x);
		Assert.assertEquals("Bad position", 100, ship.y);
	}
	
	@Test public void moveAheadHeading45() {
		
		Ship ship = FactoryTest.newShip(45, 18);
		
		ship.move(90);
		
		Assert.assertEquals("Bad position", 163, ship.x);
		Assert.assertEquals("Bad position", 163, ship.y);
	}

	@Test public void moveAheadHeading0() {
		
		Ship ship = FactoryTest.newShip(0, 18);
		
		ship.move(90);
		
		Assert.assertEquals("Bad position", 100, ship.x);
		Assert.assertEquals("Bad position", 190, ship.y);
	}	
}
