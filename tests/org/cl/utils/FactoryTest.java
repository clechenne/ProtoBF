package org.cl.utils;

import org.cl.model.Ship;
import org.cl.model.Type;

public class FactoryTest {

	public static Ship newShip(int heading, int speed, int currentSpeedBox) {
		
		Ship inst = new Ship(Type.BB, speed);
		
		inst.heading = heading;
		inst.pos.x = 100;
		inst.pos.y = 100;
		inst.currentSpeedBox = currentSpeedBox;
		
		return inst;
	}

}
