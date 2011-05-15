package org.cl.model;

import junit.framework.Assert;

import org.cl.exceptions.ShipMoveException;
import org.cl.util.TurnCalculator;
import org.junit.Test;

public class TurnCaculatorTest {
	
	@Test public void portDistance0() throws ShipMoveException {
		doIt(100, 100, true, 0, 100, 100);
	}

	@Test public void portDistance30() throws ShipMoveException {
		doIt(100, 100, true, 30, 125, 108);
	}
	
	@Test public void portDistance69() throws ShipMoveException {
		doIt(100, 100, true, 69, 140, 140);
	}
	
	@Test public void portDistance92() throws ShipMoveException {
		doIt(100, 100, true, 92, 134, 160);
	}

	@Test public void portDistance138() throws ShipMoveException {
		doIt(100, 100, true, 138, 100, 180);
	}
	
	@Test public void starboardDistance0() throws ShipMoveException {
		doIt(100, 100, false, 0, 100, 100);
	}
	
	@Test public void starboardDistance30() throws ShipMoveException {
		doIt(100, 100, false, 30, 125, 91);
	}
	
	private void doIt(int x, int y, boolean port, int distance, int expX, int expY) {
		TurnCalculator tc = new TurnCalculator(new Point(x, y), port, distance);
		
		Point nP = tc.execute();
		
		//System.out.println(nP.x + "," + nP.y);
		Assert.assertEquals("Bad new X", expX, nP.x);
		Assert.assertEquals("Bad new Y", expY, nP.y);
	}
	
}
