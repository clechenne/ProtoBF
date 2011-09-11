package org.cl.orders;

import junit.framework.Assert;

import org.cl.exceptions.ShipMoveException;
import org.cl.model.Game;
import org.cl.model.Ship;
import org.cl.utils.TestGame;
import org.junit.Test;

public class TurnStarboardOrderTest {
		
	@Test public void parse() {		
		Order o = OrderParse.parse("0S30");
		
		Assert.assertTrue("TurnStarboardOrder expected", o instanceof TurnStarboardOrder );
		Assert.assertEquals("Bad target", 30, ((TurnStarboardOrder)o).target);
	}

	@Test public void parseGreaterThan30() {
		Order o = OrderParse.parse("0S45");
		
		Assert.assertTrue("TurnStarboardOrder expected", o instanceof TurnStarboardOrder );
		Assert.assertEquals("Bad target", 30, ((TurnStarboardOrder)o).target);
	}
	
	@Test public void starboard45() throws ShipMoveException {
		Game g = new TestGame();
		
		Order o = OrderParse.parse("0S30");
		o.execute(g);
				
		Ship s = g.ships[0];
		
		s.move(50);
		
		// ship.heading45, rot=-90
		// 228.0,188.0
		Assert.assertEquals("Bad x", 218, s.pos.x );
		Assert.assertEquals("Bad y", 190, s.pos.y );
		Assert.assertEquals("Bad target", 0, s.targetHeading );
		
		System.out.println(s.pos);
		
	}

}
