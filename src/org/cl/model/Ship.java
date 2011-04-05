package org.cl.model;


public class Ship {
	public String name;
	public Type type;
	public int speed;
	public String nationality;
	
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

	public void move(int realSpeed) {
		
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
	}
}
