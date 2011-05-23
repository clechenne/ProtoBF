package org.cl.orders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderParse {

	public static Order parse(String orderString) {
		Order o = null;
		String type = null;
		
		// format 0M30
		Pattern p = Pattern.compile("([0-9]{1,3})(\\w)([0-9]{1,3})([AH]{0,1})");
		Matcher m = p.matcher(orderString);
		if (m.matches() && ( m.groupCount() == 3 || m.groupCount() == 4) ) {
			type = m.group(2);
		} else {
			throw new IllegalArgumentException(orderString + " is invalid");
		}
		
		if ("M".equals(type)) {
			Integer id = Integer.parseInt(m.group(1));
			Integer distance = Integer.parseInt(m.group(3));
			MoveOrder move = new MoveOrder();
			
			move.distToMove = distance;
			move.id = id;
			o = move;
		} else if ("P".equals(type)) {
			Integer id = Integer.parseInt(m.group(1));
			Integer target = Integer.parseInt(m.group(3));
			TurnPortOrder move = new TurnPortOrder();
			if (target > 180)
				target = 180;
			move.target = target;
			move.id = id;
			o = move;
		} else if ("S".equals(type)) {
			Integer id = Integer.parseInt(m.group(1));
			Integer target = Integer.parseInt(m.group(3));
			TurnStarboardOrder move = new TurnStarboardOrder();
			
			if (target > 180)
				target = 180;
			move.target = target;
			move.id = id;
			o = move;
			
		} else if ("G".equals(type)) {
			Integer id = Integer.parseInt(m.group(1));
			Integer targetId = Integer.parseInt(m.group(3));
			GunFireOrder newO = new GunFireOrder();

			newO.targetId = targetId;
			newO.id = id;
			newO.ammo = m.group(4);
			o = newO;
			
		};
		
		return o;
	}

}
