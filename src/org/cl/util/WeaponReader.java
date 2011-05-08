package org.cl.util;

import java.util.StringTokenizer;

import org.cl.model.Category;
import org.cl.model.Position;
import org.cl.model.Weapon;

public class WeaponReader {
	
	public static Weapon parse(String desc) {
		
		Weapon weap = new Weapon();
		
		//4#30cm#MAIN#60#1#16#13#10
		String [] tokens = new String[9];
		
		StringTokenizer st = new StringTokenizer(desc, "#");
		int i=0;
		while (st.hasMoreElements()) {
			tokens[i++] = st.nextToken();
		}
		
		weap.quantity = Integer.parseInt(tokens[0]);
		weap.name = tokens[1];
		weap.category = Category.fromString(tokens[2]);
		weap.size = Integer.parseInt(tokens[3]);
		weap.rof = Integer.parseInt(tokens[4]);
		weap.penetration = new int[3];
		weap.penetration[0] = Integer.parseInt(tokens[5]);
		weap.penetration[1] = Integer.parseInt(tokens[6]);
		weap.penetration[2] = Integer.parseInt(tokens[7]);
		
		String[] pos = new String[4];
		i=0;
		st = new StringTokenizer(tokens[8], "-");
		while (st.hasMoreElements()) {
			pos[i++] = st.nextToken();
		}

		for (String s : pos) {
			if (s!= null && s.length() > 0) {
				Position p = Position.fromString(s);
				weap.positions.add(p);
			}
		}
		
		return weap;
		
	}
}
