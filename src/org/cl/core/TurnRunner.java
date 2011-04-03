package org.cl.core;

import org.cl.model.Game;

public class TurnRunner {
	private Game game;
	
	public TurnRunner(Game game) {
		this.game = game;
	}

	public void end() {
		game.turn++;	
	}

}
