package org.cl.model;

import org.cl.exceptions.ShipMoveException;
import org.cl.util.SpeedBoxInit;


public class Ship {
	public String name;
	public Type type;
	public int speed;
	public String nationality;
	
	// speed
	public int[] speedBoxes;
	// 0 to speedBoxes.size-1
	public int currentSpeedBox;
	
	// position
	public int x;
	public int y;
	public int heading;
	
	public Ship(Type type, int speed) {
		this.speed = speed;
		
		this.type = type;
		
		speedBoxes = SpeedBoxInit.execute(type, speed);
	}

	public void move(int realSpeed) throws ShipMoveException {
		
		if (!check(realSpeed)) {
			throw new ShipMoveException("no more than one speedBox change");
		}
		
		double cos = Math.cos(Math.toRadians(heading));
		double sin = Math.sin(Math.toRadians(heading));
		
		if (heading <= 180) {
			x += (int) (realSpeed*sin);
			y -= (int) (realSpeed*cos);
		} else if (heading <= 270) {
			x += (int) (realSpeed*sin);
			y += (int) (realSpeed*cos);
		} else if (heading <= 360) {
			x += (int) (realSpeed*sin);
			y -= (int) (realSpeed*cos);
		}
		
		// after moving speedBox can change
		if (realSpeed < speedBoxes[currentSpeedBox]) {
			currentSpeedBox--;
		}
		
		if (realSpeed > speedBoxes[currentSpeedBox]) {
			currentSpeedBox++;
		}
	}

	private boolean check(int realSpeed) {
		if (realSpeed < getMinSpeedChange() || realSpeed > getMaxSpeedChange()) {
			return false;
		}
		return true;
			
	}

	private int getMaxSpeedChange() {
		if (currentSpeedBox < speedBoxes.length-1) {
			return speedBoxes[currentSpeedBox+1];
		}
		return speedBoxes[speedBoxes.length-1];
	}

	private int getMinSpeedChange() {
		if (currentSpeedBox > 1) {
			return speedBoxes[currentSpeedBox-1];
		}
		return speedBoxes[0];
	}
}
