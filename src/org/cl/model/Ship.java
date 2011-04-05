package org.cl.model;


public class Ship {
	public String name;
	public Type type;
	public int speed;
	
	// speed
	public float[] speedBoxes;
	public int currentSpeedBox;
	
	// position
	public int x;
	public int y;
	public int heading;
	
	public Ship(Type type, int speed) {
		this.speed = speed;
		speedBoxes = new float[type.nbSpeedBoxes];
	}

	public void move(int speed) {
		
		double cos = Math.cos(Math.toRadians(heading));
		double sin = Math.sin(Math.toRadians(heading));
		
		if (heading <= 180) {
			x += (int) (speed*sin);
			y -= (int) (speed*cos);
		} else if (heading <= 270) {
			x += (int) (speed*sin);
			y += (int) (speed*cos);
		} else if (heading <= 360) {
			x += (int) (speed*sin);
			y -= (int) (speed*cos);
		}
	}
}
