package org.cl.util;

import org.cl.model.Range;
import org.cl.model.Ship;

public class DistanceHelper {
	
	public static Range compute(Ship a, Ship b) {
		
		int d = (int) Math.sqrt((b.pos.x - a.pos.x) * (b.pos.x - a.pos.x) + (b.pos.y - a.pos.y)*(b.pos.y - a.pos.y));
		
		if (d <= 200*Scale.get()) {
			return Range.SHORT;
		} else if (200*Scale.get() < d && d <= 400*Scale.get()) {
			return Range.MEDIUM;
		} else if (400*Scale.get() < d && d <= 600*Scale.get()) {
			return Range.LONG;
		}
		
		return Range.ELONG;
	}
}
