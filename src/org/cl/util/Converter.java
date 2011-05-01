package org.cl.util;


public class Converter {
	
	public static int distanceToDegree(int distance) {
		return (int)Math.round((180*distance) / (double)138);
	}
	
	public static int degreeToDistance(int degree) {
		return (138*degree) / 180;
	}
}
