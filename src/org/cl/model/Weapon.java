package org.cl.model;

import java.util.ArrayList;
import java.util.List;

public class Weapon {
	public int quantity ;
	public String name;
	public Category category;
	public int size;
	public int rof;
	public int penetration[];
	public List<Position> positions;
	
	public Weapon() {
		positions = new ArrayList<Position>();
	}
}
