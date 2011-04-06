package org.cl.model;

import org.cl.exceptions.ShipMoveException;

public class Game {
	public String name;
	public int turn;
	
	public Ship[] ships;

	public void moveAlls() {
		for (Ship s : ships) {
			// TODO: Gerer la vitesse reelle.
			try {
				s.move(90);
			} catch (ShipMoveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
