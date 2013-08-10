package org.psnbtech.entity;

import java.awt.Polygon;

/**
 * Stores information on the different sized asteroids.
 * @author Brendan Jones
 *
 */
public enum AsteroidSize {
	
	/**
	 * Small Asteroids have a radius of 15, and are worth 100 points.
	 */
	Small(15.0, 100),
			
	/**
	 * Medium asteroids have a radius of 25, and are worth 50 points.
	 */
	Medium(25.0, 50),
	
	/**
	 * Large asteroids have a radius of 40, and are worth 20 points.
	 */
	Large(40.0, 20);
	
	/**
	 * The number of points on the Asteroid.
	 */
	private static final int NUMBER_OF_POINTS = 5;
	
	/**
	 * The polygon for this type of Asteroid.
	 */
	public final Polygon polygon;
	
	/**
	 * The radius of this type of Asteroid.
	 */
	public final double radius;
	
	/**
	 * The number of points earned for killing this type of Asteroid.
	 */
	public final int killValue;
	
	/**
	 * Creates a new type of Asteroid.
	 * @param radius The radius.
	 * @param value The kill value.
	 */
	private AsteroidSize(double radius, int value) {
		this.polygon = generatePolygon(radius);
		this.radius = radius + 1.0;
		this.killValue = value;
	}
	
	/**
	 * Generates a regular polygon of size radius.
	 * @param radius The radius of the Polygon.
	 * @return The generated Polygon.
	 */
	private static Polygon generatePolygon(double radius) {
		//Create an array to store the coordinates.
		int[] x = new int[NUMBER_OF_POINTS];
		int[] y = new int[NUMBER_OF_POINTS];
		
		//Generate the points in the polygon.
		double angle = (2 * Math.PI / NUMBER_OF_POINTS);
		for(int i = 0; i < NUMBER_OF_POINTS; i++) {
			x[i] = (int) (radius * Math.sin(i * angle));
			y[i] = (int) (radius * Math.cos(i * angle));
		}
		
		//Create a new polygon from the generated points and return it.
		return new Polygon(x, y, NUMBER_OF_POINTS);
	}

}
