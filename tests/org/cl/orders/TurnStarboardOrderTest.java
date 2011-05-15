package org.cl.orders;

import junit.framework.Assert;

import org.junit.Test;

public class TurnStarboardOrderTest {
		
	@Test public void parse() {		
		Order o = OrderParse.parse("0S30");
		
		Assert.assertTrue("TurnPortOrder expected", o instanceof TurnStarboardOrder );
		Assert.assertEquals("Bad target", 30, ((TurnStarboardOrder)o).target);
	}

}
