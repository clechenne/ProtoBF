package org.cl.model;

public class Game {
	public String name;
	public int turn;
	
	public Ship[] ships;

	public void moveAlls() {
		for (Ship s : ships) {
			// TODO: Gerer la vitesse reelle.
			s.move(90);
		}
	}
}
