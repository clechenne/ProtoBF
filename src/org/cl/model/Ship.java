package org.cl.model;

import org.cl.exceptions.ShipMoveException;
import org.cl.util.SpeedBoxInit;
import org.cl.util.TurnCalculator;


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
	public Point pos;
	public int heading;
	public int targetHeading;
	private boolean turnPort;
	
	public Ship(Type type, int speed) {
		pos = new Point(0,0);
		this.speed = speed;
		
		this.type = type;
		
		speedBoxes = SpeedBoxInit.execute(type, speed);
	}

	public void move(int realDistance) throws ShipMoveException {
		
		if (!check(realDistance)) {
			throw new ShipMoveException("no more than one speedBox change");
		}
		
		if (targetHeading > 0) {
			newPositionOnCircle(realDistance);
		}
		
		double cos = Math.cos(Math.toRadians(heading));
		double sin = Math.sin(Math.toRadians(heading));
		
		if (heading <= 180) {
			pos.x += (int) (realDistance*sin);
			pos.y -= (int) (realDistance*cos);
		} else if (heading <= 270) {
			pos.x += (int) (realDistance*sin);
			pos.y += (int) (realDistance*cos);
		} else if (heading <= 360) {
			pos.x += (int) (realDistance*sin);
			pos.y -= (int) (realDistance*cos);
		}
		
		// after moving speedBox can change
		if (realDistance < speedBoxes[currentSpeedBox]) {
			currentSpeedBox--;
		}
		
		if (realDistance > speedBoxes[currentSpeedBox]) {
			currentSpeedBox++;
		}
	}

	private void newPositionOnCircle(int realDistance) {
		TurnCalculator tc = new TurnCalculator(pos, turnPort, realDistance);
		
		pos = tc.execute();
		
		heading += tc.degree;
	}

	private boolean check(int realDistance) {
		if (realDistance < getMinSpeedChange() || realDistance > getMaxSpeedChange()) {
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

	public void turnPort(int target) {
		targetHeading = target;
		turnPort = true;
	}
}
