package org.cl.core;

import java.util.ArrayList;
import java.util.List;

import org.cl.model.Game;
import org.cl.orders.Order;
import org.cl.orders.TurnPortOrder;

public class TurnRunner {
	private Game game;
	public List<Order> orders;
	public List<Order> turns;
	
	public TurnRunner(Game game) {
		this.game = game;
		orders = new ArrayList<Order>();
		turns = new ArrayList<Order>();
	}
	
	public void add(Order o) {
		if (o instanceof TurnPortOrder) {
			turns.add(o);
		} else {
			orders.add(o);
		}
	}
		
	public void end() {
		
		if (turns.size() > 0) {
			// turns orders before.
			for (Order o : turns) {
				System.out.println(o);
				o.execute(game);
			}
		}
		
		if (orders.size() > 0) {
			for (Order o : orders) {
				try {	
					System.out.println(o);
					o.execute(game);
				} catch (Throwable t) {
					// TODO: refactor
					t.printStackTrace();
				}
			}
		}
		
		orders.clear();
		turns.clear();
		
		game.turn++;	
	}

}
