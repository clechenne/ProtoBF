package org.cl.table;

import java.util.ArrayList;
import java.util.List;

import org.cl.model.Damage;

class CombatTestCase {

	int roll1;
	int roll2;
	int penVal;
	int armVal;
	
	List<Damage> expected;
	
	public CombatTestCase(int roll, int k, int l, Damage ...damages) {
		expected = new ArrayList<Damage>();
		
		roll1 = roll;
		penVal = k;
		armVal = l;
		for (Damage d : damages)  {
			expected.add(d);
		}
	}
}
