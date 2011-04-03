package org.cl.utils;

import org.cl.model.Ship;
import org.cl.model.Type;

public class FactoryTest {

	public static Ship newShip(int heading, int speed) {
		
		Ship inst = new Ship(Type.BB, speed);
		
		inst.heading = heading;
		inst.x = 100;
		inst.y = 100;
		inst.currentSpeedBox = 5;
		
		return inst;
	}

}
