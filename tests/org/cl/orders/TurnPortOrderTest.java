package org.cl.orders;

import junit.framework.Assert;

import org.junit.Test;

public class TurnPortOrderTest {
		
	@Test public void parse() {
		Order o = OrderParse.parse("0P30");
		
		Assert.assertTrue("TurnPortOrder expected", o instanceof TurnPortOrder );
		Assert.assertEquals("Bad target", 30, ((TurnPortOrder)o).target);
	}
	
	@Test public void parseGreaterThan180() {
		Order o = OrderParse.parse("0P181");
		
		Assert.assertTrue("TurnPortOrder expected", o instanceof TurnPortOrder );
		Assert.assertEquals("Bad target", 180, ((TurnPortOrder)o).target);
	}
}
