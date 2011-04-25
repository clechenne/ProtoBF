package org.cl.model;

import junit.framework.Assert;

import org.cl.exceptions.ShipMoveException;
import org.cl.utils.FactoryTest;
import org.junit.Test;

public class ChangingSpeedTest {
	
	/**
	 * Rule 3.3
	 * @throws ShipMoveException 
	 */
	@Test(expected=ShipMoveException.class)
	public void changeKo() throws ShipMoveException {
		// 18 => 108 - 90 - 72 - 54 - 36 - 18
		Ship ship = FactoryTest.newShip(0, 18, 4);
		
		ship.move(54);
	}
	
	@Test
	public void changeOk() throws ShipMoveException {
		// 18 => 108 - 90 - 72 - 54 - 36 - 18
		Ship ship = FactoryTest.newShip(0, 18, 4);
		
		// spBox 4 -> 5
		ship.move(72);
		
		Assert.assertEquals("Bad speedBox", 3, ship.currentSpeedBox);
	}	
}
