package org.cl.core;

import junit.framework.Assert;

import org.cl.model.Game;
import org.junit.BeforeClass;
import org.junit.Test;


public class TurnRunnerTest {
	
	private static Game game;
	
	@BeforeClass public static void init() {
		game = new Game();
		game.turn = 1;
	}
	
	@Test
	public void endTurn() {
		TurnRunner tr = new TurnRunner(game);
		tr.end();
		Assert.assertEquals("Bad turn", 2, game.turn);
	}
}
