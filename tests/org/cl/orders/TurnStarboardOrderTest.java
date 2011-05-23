package org.cl.orders;

import junit.framework.Assert;

import org.junit.Test;

public class TurnStarboardOrderTest {
		
	@Test public void parse() {		
		Order o = OrderParse.parse("0S30");
		
		Assert.assertTrue("TurnStarboardOrder expected", o instanceof TurnStarboardOrder );
		Assert.assertEquals("Bad target", 30, ((TurnStarboardOrder)o).target);
	}

	@Test public void parseGreaterThan180() {
		Order o = OrderParse.parse("0S181");
		
		Assert.assertTrue("TurnStarboardOrder expected", o instanceof TurnStarboardOrder );
		Assert.assertEquals("Bad target", 180, ((TurnStarboardOrder)o).target);
	}

}
