package org.cl.util;

import org.cl.model.Type;

/**
 * Speed Scale implementation for small scale.
 * 
 * @author christophe
 *
 */
public class SpeedBoxInit {

	public static int[] execute(Type type, int speed) {
		int[] speedBoxes = new int[type.nbSpeedBoxes];
		
		if (speed == 18) {
			// 108 - 90 - 72 - 54 - 36 - 18
			speedBoxes[0] = 18;
			speedBoxes[1] = 36;
			speedBoxes[2] = 54;
			speedBoxes[3] = 72;
			speedBoxes[4] = 90;
			speedBoxes[5] = 108;
		} else if (speed == 5) {
			speedBoxes[0] = 5;
			speedBoxes[1] = 10;
			speedBoxes[2] = 15;
			speedBoxes[3] = 20;
			speedBoxes[4] = 25;
			speedBoxes[5] = 30;			
		} else if (speed == 10) {
			speedBoxes[0] = 10;
			speedBoxes[1] = 20;
			speedBoxes[2] = 30;
			speedBoxes[3] = 40;
			speedBoxes[4] = 50;
			speedBoxes[5] = 60;			
		} else if (speed == 15) {
			speedBoxes[0] = 15;
			speedBoxes[1] = 30;
			speedBoxes[2] = 45;
			speedBoxes[3] = 60;
			speedBoxes[4] = 75;
			speedBoxes[5] = 90;			
		} else if (speed == 22) {
			speedBoxes[0] = 22;
			speedBoxes[1] = 44;
			speedBoxes[2] = 66;
			speedBoxes[3] = 88;
			speedBoxes[4] = 110;
			speedBoxes[5] = 132;			
		} else if (speed == 25) {
			speedBoxes[0] = 25;
			speedBoxes[1] = 50;
			speedBoxes[2] = 75;
			speedBoxes[3] = 100;
			speedBoxes[4] = 125;
			speedBoxes[5] = 150;			
		} else {
			throw new IllegalArgumentException(speed + " is invalid");
		}
		
		return speedBoxes;
	}

}
