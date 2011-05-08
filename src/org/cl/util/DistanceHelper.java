package org.cl.util;

import org.cl.model.Distance;
import org.cl.model.Ship;

public class DistanceHelper {
	
	public static Distance compute(Ship a, Ship b) {
		
		int d = (int) Math.sqrt((b.pos.x - a.pos.x) * (b.pos.x - a.pos.x) + (b.pos.y - a.pos.y)*(b.pos.y - a.pos.y));
		
		if (d <= 200*Scale.get()) {
			return Distance.SHORT;
		} else if (200*Scale.get() < d && d <= 400*Scale.get()) {
			return Distance.MEDIUM;
		} else if (400*Scale.get() < d && d <= 600*Scale.get()) {
			return Distance.LONG;
		}
		
		return Distance.ELONG;
	}
}
