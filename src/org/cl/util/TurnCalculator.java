package org.cl.util;

import org.cl.model.Point;

public class TurnCalculator {
	Point p0;
	boolean turnPort ;
	int distanceToTurn;
	int TS_5_RADIUS = 40;
	
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
		
		Point nP = new Point(0, 0);
		
		System.out.println("distance=" + distanceToTurn);
		
		if (distanceToTurn > 0) {
			degree = Converter.distanceToDegree(distanceToTurn);
			
			double cos = Math.sin(Math.toRadians(degree));
			double sin = Math.cos(Math.toRadians(degree));
			
			// TODO: delete sysout
			
			
			//nP.x = (int)(factorX * TS_5_DIAMETER + p0.x);
			
			if (! turnPort)
				nP.x = (int)(TS_5_RADIUS * ( 1-cos) + p0.x);
			else
				nP.x = (int)( p0.x - TS_5_RADIUS * ( 1-cos));
			
			nP.y = (int)(sin * TS_5_RADIUS + p0.y);
		
			System.out.println("deg=" + degree + ", cos=" + cos + ", sin=" + sin + ", x=" + nP.x + ", y=" + nP.y);
		} else {
			nP.x = p0.x;
			nP.y = p0.y;
		}
		return nP;
	}

}
