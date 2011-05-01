package org.cl.core;

import junit.framework.Assert;

import org.cl.model.Game;
import org.cl.orders.Order;
import org.cl.orders.OrderParse;
import org.cl.utils.FactoryTest;
import org.junit.Test;


public class TurnRunnerTest {
	
	@Test
	public void endTurn() {
		Game game = FactoryTest.newGame();
		
		TurnRunner tr = new TurnRunner(game);
		
		Order o = OrderParse.parse("0M90");
		tr.add(o);
		tr.end();
		
		Assert.assertEquals("Bad turn", 2, game.turn);
		
		Assert.assertEquals("Bad x position", 100, game.ships[0].pos.x);
		Assert.assertEquals("Bad y position", 10, game.ships[0].pos.y);
		Assert.assertEquals("Orders found", 0, tr.orders.size());
	}
}
