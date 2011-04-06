package org.cl.utils;

import junit.framework.Assert;

import org.cl.model.Type;
import org.cl.util.SpeedBoxInit;
import org.junit.Test;

public class SpeedBoxInitTest {
	
	@Test public void speed5Knots() {
		// 30 - 25 -20 - 15 - 10 - 5
		int[] speedBoxes = SpeedBoxInit.execute(Type.BB, 5);
		
		Assert.assertEquals("SB invalid", 5, speedBoxes[0]);
		Assert.assertEquals("SB invalid", 10, speedBoxes[1]);
		Assert.assertEquals("SB invalid", 15, speedBoxes[2]);
		Assert.assertEquals("SB invalid", 20, speedBoxes[3]);
		Assert.assertEquals("SB invalid", 25, speedBoxes[4]);
		Assert.assertEquals("SB invalid", 30, speedBoxes[5]);
	}
	
	@Test public void speed10Knots() {
		// 60 - 50 - 40 - 30 - 20 - 10
		int[] speedBoxes = SpeedBoxInit.execute(Type.BB, 10);
		
		Assert.assertEquals("SB invalid", 10, speedBoxes[0]);
		Assert.assertEquals("SB invalid", 20, speedBoxes[1]);
		Assert.assertEquals("SB invalid", 30, speedBoxes[2]);
		Assert.assertEquals("SB invalid", 40, speedBoxes[3]);
		Assert.assertEquals("SB invalid", 50, speedBoxes[4]);
		Assert.assertEquals("SB invalid", 60, speedBoxes[5]);
	}

	@Test public void speed15Knots() {
		// 90 - 75 - 60 - 45 - 30 - 15
		int[] speedBoxes = SpeedBoxInit.execute(Type.BB, 15);
		
		Assert.assertEquals("SB invalid", 15, speedBoxes[0]);
		Assert.assertEquals("SB invalid", 30, speedBoxes[1]);
		Assert.assertEquals("SB invalid", 45, speedBoxes[2]);
		Assert.assertEquals("SB invalid", 60, speedBoxes[3]);
		Assert.assertEquals("SB invalid", 75, speedBoxes[4]);
		Assert.assertEquals("SB invalid", 90, speedBoxes[5]);
	}
	
	@Test public void speed18Knots() {
		// 108 - 90 - 72 - 54 - 36 - 18
		int[] speedBoxes = SpeedBoxInit.execute(Type.BB, 18);
		
		Assert.assertEquals("SB invalid", 18, speedBoxes[0]);
		Assert.assertEquals("SB invalid", 36, speedBoxes[1]);
		Assert.assertEquals("SB invalid", 54, speedBoxes[2]);
		Assert.assertEquals("SB invalid", 72, speedBoxes[3]);
		Assert.assertEquals("SB invalid", 90, speedBoxes[4]);
		Assert.assertEquals("SB invalid", 108, speedBoxes[5]);
	}

	@Test public void speed22Knots() {
		// 132 - 110 - 88 - 66 - 44 - 22
		int[] speedBoxes = SpeedBoxInit.execute(Type.BB, 22);
		
		Assert.assertEquals("SB invalid", 22, speedBoxes[0]);
		Assert.assertEquals("SB invalid", 44, speedBoxes[1]);
		Assert.assertEquals("SB invalid", 66, speedBoxes[2]);
		Assert.assertEquals("SB invalid", 88, speedBoxes[3]);
		Assert.assertEquals("SB invalid", 110, speedBoxes[4]);
		Assert.assertEquals("SB invalid", 132, speedBoxes[5]);
	}

	@Test public void speed25Knots() {
		// 150 - 125 - 100 - 75 - 50 - 25
		int[] speedBoxes = SpeedBoxInit.execute(Type.BB, 25);
		
		Assert.assertEquals("SB invalid", 25, speedBoxes[0]);
		Assert.assertEquals("SB invalid", 50, speedBoxes[1]);
		Assert.assertEquals("SB invalid", 75, speedBoxes[2]);
		Assert.assertEquals("SB invalid", 100, speedBoxes[3]);
		Assert.assertEquals("SB invalid", 125, speedBoxes[4]);
		Assert.assertEquals("SB invalid", 150, speedBoxes[5]);
	}
}
