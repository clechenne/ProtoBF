package org.cl.util;

import org.cl.model.PointBF;

public class TurnCalculator {
	
	PointBF p0;
	int heading;
	boolean turnPort ;
	int distanceToTurn;
	int TS_5_RADIUS = 40;
	
	public int degree=-1;
	
	public TurnCalculator(PointBF p, boolean turnPort, int distanceToTurn, int heading) {
		p0 = p;
		this.turnPort = turnPort;
		this.distanceToTurn = distanceToTurn;
		this.heading = heading;
		if (distanceToTurn > 138) {
			throw new IllegalArgumentException("distanceToTurn > 138");
		}
	}

	public PointBF execute() {
		
		double angle = 45;
		
		PointBF centre = p0.compute(40, heading+90);
		
		System.out.println("distance=" + distanceToTurn);
		
		double x = ( p0.x - centre.x ) * Math.cos( angle * Math.PI / 180 ) - ( p0.y - centre.y ) * Math.sin( angle * Math.PI / 180 );
		double y = ( p0.x - centre.x ) * Math.sin( angle * Math.PI / 180 ) + ( p0.y - centre.y ) * Math.cos( angle * Math.PI / 180 );
		
		return new PointBF((int)x, (int)y);
	}

}
