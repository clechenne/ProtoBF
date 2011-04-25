package org.cl.core;

import junit.framework.Assert;

import org.cl.model.Game;
import org.cl.model.Ship;
import org.cl.utils.FactoryTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class TurnRunnerTest {
	
	private static Game game;
	
	@BeforeClass public static void init() {
		game = new Game();
		game.turn = 1;
		game.ships = new Ship[1];
		game.ships[0] = FactoryTest.newShip(90, 18, 4);
	}
	
	@Test
	public void endTurn() {
		TurnRunner tr = new TurnRunner(game);
		tr.end();
		Assert.assertEquals("Bad turn", 2, game.turn);
		
		Assert.assertEquals("Bad x position", 190, game.ships[0].pos.x);
		Assert.assertEquals("Bad y position", 100, game.ships[0].pos.y);
		
	}
}
