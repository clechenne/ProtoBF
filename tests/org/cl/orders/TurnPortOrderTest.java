package org.cl.orders;

import junit.framework.Assert;

import org.cl.exceptions.ShipMoveException;
import org.cl.model.Game;
import org.cl.model.Ship;
import org.cl.utils.TestGame;
import org.junit.Test;

public class TurnPortOrderTest {
		
	@Test public void parse() {
		Order o = OrderParse.parse("0P30");
		
		Assert.assertTrue("TurnPortOrder expected", o instanceof TurnPortOrder );
		Assert.assertEquals("Bad target", 30, ((TurnPortOrder)o).target);
	}
	
	@Test public void parseGreaterThan180() {
		Order o = OrderParse.parse("0P31");
		
		Assert.assertTrue("TurnPortOrder expected", o instanceof TurnPortOrder );
		Assert.assertEquals("Bad target", 30, ((TurnPortOrder)o).target);
	}

	@Test public void turn30() throws ShipMoveException {
		Game g = new TestGame();
		
		Order o = OrderParse.parse("0P30");
		o.execute(g);
				
		Ship s = g.ships[0];
		
		s.move(50);
		//ship.heading45, rot=15
		//210.0,182.0
		Assert.assertEquals("Bad x", 210, s.pos.x );
		Assert.assertEquals("Bad y", 182, s.pos.y );
		Assert.assertEquals("Bad target", 0, s.targetHeading );
		
		System.out.println(s.pos);
		
	}
}
