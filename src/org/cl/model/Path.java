package org.cl.model;

import java.util.Stack;

public class Path {
	
	public static int MAX_PATH = 10;
	
	Stack<PointBF> points = new Stack<PointBF>();
	
	public int getNb() {
		return points.size();
	}

	public void add(PointBF point) {
		if (points.size() < MAX_PATH) {
			points.push(point);
		} else {
			points.remove(points.size()-1);
			points.push(point);
		}
	}

	public PointBF[] getAlls() {
		PointBF [] alls = points.toArray(new PointBF[0]);
		return alls;
	}

	public String toString() {
		String res = "";
        for (org.cl.model.PointBF p : getAlls()) {
        	res += p + " <-> ";
        }
        return res;
	}
}
