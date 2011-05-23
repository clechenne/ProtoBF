package org.cl.orders;

import junit.framework.Assert;

import org.junit.Test;

public class GunFireOrderTest {
		
	@Test public void parse() {		
		Order o = OrderParse.parse("0G2H");
		
		Assert.assertTrue("GunFireOrder expected", o instanceof GunFireOrder );
		Assert.assertEquals("Bad id", 2, ((GunFireOrder)o).targetId);
		Assert.assertEquals("Bad type", "H", ((GunFireOrder)o).ammo);
	}
	
}
