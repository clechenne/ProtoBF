package org.cl.core;

import java.util.ArrayList;
import java.util.List;

import org.cl.model.Game;
import org.cl.orders.Order;

public class TurnRunner {
	private Game game;
	public List<Order> orders;
	
	public TurnRunner(Game game) {
		this.game = game;
		orders = new ArrayList<Order>();
	}
	
	public void add(Order o) {
		orders.add(o);
	}
	
	public void end() {
		for (Order o : orders) {
			try {
				
				System.out.println(o);
				
				o.execute(game);
			} catch (Throwable t) {
				// TODO: refactor
				t.printStackTrace();
			}
		}
		
		orders.clear();
		
		game.turn++;	
	}

}
