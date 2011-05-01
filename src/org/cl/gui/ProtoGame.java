package org.cl.gui;

import org.cl.model.Game;
import org.cl.model.Point;
import org.cl.model.Ship;
import org.cl.model.Type;

public class ProtoGame extends Game {
	
	public ProtoGame() {
		
		ships = new Ship[2];
		
		ships[0] = new Ship(0, Type.BB, 18);
		ships[0].name = "BB1";
		ships[0].pos = new Point(50, 50);
		ships[0].heading = 90;
		ships[0].currentSpeedBox = 2;
		
		ships[1] = new Ship(1, Type.BB, 18);
		ships[1].name = "BB2";
		ships[1].pos = new Point(100, 100);
		ships[1].heading = 90;
		ships[1].currentSpeedBox = 2;
	}
}
