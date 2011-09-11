package org.cl.orders;

import junit.framework.Assert;

import org.cl.model.Game;
import org.cl.model.Ship;
import org.cl.utils.FactoryTest;
import org.junit.Test;

public class MoveOrderTest {
		
	@Test public void parse() {		
		Order o = OrderParse.parse("0M30");
		
		Assert.assertTrue("MoveOrder expected", o instanceof MoveOrder );
		Assert.assertEquals("Bad distance", 30, ((MoveOrder)o).distToMove);
	}
	
	@Test public void execute() {
		Order o = OrderParse.parse("0M90");
		
		Game game = FactoryTest.newGame();
		game.ships[0].heading = 0;
		
		o.execute(game);
		
		Ship ship = game.ships[0];
		
		Assert.assertEquals("Bad position", 100, ship.pos.x);
		Assert.assertEquals("Bad position", 60, ship.pos.y);

	}

}
