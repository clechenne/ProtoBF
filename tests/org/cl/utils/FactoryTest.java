package org.cl.utils;

import org.cl.model.Game;
import org.cl.model.Ship;
import org.cl.model.Type;

public class FactoryTest {

	public static Ship newShip(int id, int heading, int speed, int currentSpeedBox) {
		
		Ship inst = new Ship(0, Type.BB, speed);
		inst.id = id;
		inst.heading = heading;
		inst.pos.x = 100;
		inst.pos.y = 100;
		inst.currentSpeedBox = currentSpeedBox;
		
		return inst;
	}
	
	public static Game newGame() {
		Game game = new Game();
		game.turn = 1;
		game.ships = new Ship[1];
		game.ships[0] = FactoryTest.newShip(0, 0, 18, 4);
		
		return game;
	}

}
