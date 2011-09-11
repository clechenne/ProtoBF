package org.cl.model;

import org.cl.exceptions.ShipMoveException;
import org.cl.util.Converter;
import org.cl.util.SpeedBoxInit;
import org.cl.util.TurnCalculator;


public class Ship {
	public int id;
	public String name;
	public Type type;
	public int size;
	
	public int speed;
	public Side side;
	
	// Armor
	public int armorVitals ;
	public int armorUpperworks;
	
	public Level upperworksProtection;
	public Level floodProtection;
	public Level stability;
	public Level seawayRating;
	
	// speed
	public int[] speedBoxes;
	// 0 to speedBoxes.size-1
	public int currentSpeedBox;
	
	// position
	//public Point oldPos;
	public PointBF pos;
	public int heading;
	public int targetHeading;
	
	// port = babord, starboard = tribord.
	private boolean turnPort;
	
	public Weapon weapons[];
	
	public Ship gunFireTarget;

	// H / A
	public String ammo;
	
	// Historique des mvts
	private Path path;
	
	public Ship(int id, Type type, int speed) {
		this.id = id;
		pos = new PointBF(0,0);
		this.speed = speed;
		
		this.type = type;
		
		speedBoxes = SpeedBoxInit.execute(type, speed);
		
		path = new Path();
		
	}

	public void move(int realDistance) throws ShipMoveException {
		
		if (!check(realDistance)) {
			throw new ShipMoveException("no more than one speedBox change");
		}
		
		if (targetHeading > 0) {
			
			PointBF center =  null;
			
			int angle = 0;
			
			if (!turnPort) {
				center = pos.compute(40, heading+90);
				angle = -180 + heading + targetHeading;
			} else {
				center = pos.compute(40, heading-90);
				angle = heading - targetHeading;
			}
					
			System.out.println("center=" + center);			
			System.out.println("heading=" + heading);			
			System.out.println("angle="+angle);
			
			path.add(new PointBF(pos.x, pos.y));
			pos.x = center.x +  (int)(40*Math.cos(Math.toRadians(angle)));
			pos.y = center.y +  (int)(40*Math.sin(Math.toRadians(angle)));
			
			if (!turnPort) {
				heading += targetHeading;
			} else {
				heading -= targetHeading;
			}
						
			targetHeading = 0 ;
			
		} else {
			path.add(new PointBF(pos.x, pos.y));
			pos = pos.compute(realDistance, heading);
		}

		System.out.println("*****");
		System.out.println(path);
		System.out.println(pos);
		System.out.println("*****");
		
		// after moving speedBox can change
		if (realDistance < speedBoxes[currentSpeedBox]) {
			currentSpeedBox--;
		}
		
		if (realDistance > speedBoxes[currentSpeedBox]) {
			currentSpeedBox++;
		}
	}
	
	public void turnPort(int target) {
		targetHeading = target;
		turnPort = true;
	}

	public void turnStarboard(int target) {
		targetHeading = target;
		turnPort = false;
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

	public int getCurrentSpeed() {
		return speedBoxes[currentSpeedBox];
	}

	public void setGunFireTarget(Ship target) {
		gunFireTarget = target;
	}

	public void setAmmo(String ammo) {
		this.ammo = ammo;
		
	}

	public Path getPath() {
		return path;
	}



}
