package org.cl.util;

import org.cl.model.Point;

public class TurnCalculator {
	Point p0;
	boolean turnPort ;
	int distanceToTurn;
	int TS_5_DIAMETER = 40;
	
	public int degree=-1;
	
	public TurnCalculator(Point p, boolean turnPort, int distanceToTurn) {
		p0 = p;
		this.turnPort = turnPort;
		this.distanceToTurn = distanceToTurn;
		if (distanceToTurn > 138) {
			throw new IllegalArgumentException("distanceToTurn > 138");
		}
	}

	public Point execute() {
		
		Point nP = new Point(0, 0 );
		
		degree = Converter.distanceToDegree(distanceToTurn);
		
		double factorX = Math.sin(Math.toRadians(degree));
		double factorY = Math.cos(Math.toRadians(degree));
		
		// TODO: delete sysout
		System.out.println(degree + ", facX=" + factorX + ", facY=" + factorY);
		nP.x = (int)(factorX * TS_5_DIAMETER + p0.x);
		
		nP.y = (int)((1-factorY) * TS_5_DIAMETER + p0.y);
		
		return nP;
	}

}
