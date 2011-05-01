package org.cl.exceptions;

import org.cl.model.Ship;

public class OrderException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5300902860171857965L;
	
	public Ship ship;
	
	public OrderException(Ship ship, ShipMoveException e) {
		super(e);
		this.ship = ship;
	}

}
