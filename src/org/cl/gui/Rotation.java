package org.cl.gui;

import java.awt.Point;

public class Rotation {

	private static Point point = new Point( 100, 0 );
	private static Point centre = new Point ( 100, 100 );
	private static double angle = 45;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double x = ( point.x - centre.x ) * Math.cos( angle * Math.PI / 180 ) - ( point.y - centre.y ) * Math.sin( angle * Math.PI / 180 );
		double y = ( point.x - centre.x ) * Math.sin( angle * Math.PI / 180 ) + ( point.y - centre.y ) * Math.cos( angle * Math.PI / 180 );

		System.out.println( " nouveau point x : " + Math.round( x + centre.x ) );
		System.out.println( " nouveau point y : " + Math.round( y + centre.y ) );
	}

}
