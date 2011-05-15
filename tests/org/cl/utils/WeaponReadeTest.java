package org.cl.utils;

import junit.framework.Assert;

import org.cl.model.Category;
import org.cl.model.Weapon;
import org.cl.util.WeaponReader;
import org.junit.Test;

public class WeaponReadeTest {
	

	@Test public void mikasaMainGun() {
		Weapon weap = WeaponReader.parse("4#30cm#MAIN#60#1#16#13#10#A-Z");
		
		Assert.assertEquals("Quantity invalid", 4, weap.quantity);
		Assert.assertEquals("Type invalid", "30cm", weap.name);
		Assert.assertEquals("Type invalid", Category.MAIN, weap.category);
		Assert.assertEquals("Size invalid", 60, weap.size);
		Assert.assertEquals("ROF invalid", 1, weap.rof);
		Assert.assertEquals("Penetration short", 16, weap.penetration[0]);
		Assert.assertEquals("Penetration medium", 13, weap.penetration[1]);
		Assert.assertEquals("Penetration medium", 10, weap.penetration[2]);
		Assert.assertEquals("Position invalid", 'A', weap.positions[0]);
		Assert.assertEquals("Position invalid", 'Z', weap.positions[1]);
	}
	
	@Test public void mikasaSec() {
		Weapon weap = WeaponReader.parse("4#30cm#SECONDARY#60#1#5#3#2#2#");
		
		Assert.assertEquals("Type invalid", Category.SECONDARY, weap.category);
		Assert.assertEquals("Position invalid", '2', weap.positions[0]);
	}
	
	@Test public void mikasaTer() {
		Weapon weap = WeaponReader.parse("4#30cm#TERTIARY#60#1#1#0#0# #");
		
		Assert.assertEquals("Type invalid", Category.TERTIARY, weap.category);
	}
	
	@Test public void mikasaTorpedoes() {
		Weapon weap = WeaponReader.parse("4#46cm#TORPEDOES#120#1#0#0#0# #");
		
		Assert.assertEquals("Type invalid", Category.TORPEDOES, weap.category);
	}
	
}
