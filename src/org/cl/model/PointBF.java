package org.cl.model;

public class PointBF {
	
	public PointBF(int i, int j) {
		x = i;
		y = j;
	}
	
	public int x;
	public int y;
	
	public PointBF compute(int distance, int heading) {
		PointBF pointN = new PointBF(0, 0);
		
		int rot = -90+heading;     
		pointN.x = x +  (int)(40*Math.cos(Math.toRadians(rot)));
		pointN.y = y +  (int)(40*Math.sin(Math.toRadians(rot)));
//
//	       
//		double cos = Math.cos(Math.toRadians(heading));
//		double sin = Math.sin(Math.toRadians(heading));
//		
//		
//		if (heading <= 180) {
//			pointN.x = x + (int) (distance*sin);
//			pointN.y = y - (int) (distance*cos);
//		} else if (heading <= 270) {
//			pointN.x = x + (int) (distance*sin);
//			pointN.y = y + (int) (distance*cos);
//		} else if (heading <= 360) {
//			pointN.x = x + (int) (distance*sin);
//			pointN.y = y - (int) (distance*cos);
//		}
		return pointN;
	}
	public String toString() {
		return "("+x+","+y+")";
	}
}
