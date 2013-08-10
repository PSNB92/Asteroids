package org.psnbtech.util;

/**
 * Vector2 represents a 2-dimensional vector.
 * @author Brendan Jones
 */
public class Vector2 {
	
	/**
	 * The x value of the vector.
	 */
	public double x;
	
	/**
	 * The y value of the vector.
	 */
	public double y;
	
	/**
	 * Creates a new Vector from an angle. The length of this vector will be 1.
	 * @param angle The angle.
	 */
	public Vector2(double angle) {
		this.x = Math.cos(angle);
		this.y = Math.sin(angle);
	}
	
	/**
	 * Creates a new Vector with the desired values.
	 * @param x The x value.
	 * @param y The y value.
	 */
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates a new Vector and copies the components from the old.
	 * @param vec The vector to copy.
	 */
	public Vector2(Vector2 vec) {
		this.x = vec.x;
		this.y = vec.y;
	}
	
	/**
	 * Sets the components of this vector.
	 * @param x The x component.
	 * @param y The y component.
	 * @return This vector for chaining.
	 */
	public Vector2 set(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	/**
	 * Adds the components of a vector to this one.
	 * @param vec The vector to add.
	 * @return This vector for chaining.
	 */
	public Vector2 add(Vector2 vec) {
		this.x += vec.x;
		this.y += vec.y;
		return this;
	}
	
	/**
	 * Scales the components of this vector.
	 * @param scalar The scalar value.
	 * @return This vector for chaining.
	 */
	public Vector2 scale(double scalar) {
		this.x *= scalar;
		this.y *= scalar;
		return this;
	}
	
	/**
	 * Normalizes this Vector (giving it a length of 1.0).
	 * @return This vector for chaining.
	 */
	public Vector2 normalize() {
		double length = getLengthSquared();
		if(length != 0.0f && length != 1.0f) {
			length = Math.sqrt(length);
			this.x /= length;
			this.y /= length;
		}
		return this;
	}
	
	/**
	 * Gets the squared length of this Vector.
	 * @return The squared length.
	 */
	public double getLengthSquared() {
		return (x * x + y * y);
	}

	/**
	 * Gets the squared distance to another Vector.
	 * @param vec The other vector.
	 * @return The squared distance.
	 */
	public double getDistanceToSquared(Vector2 vec) {
		double dx = this.x - vec.x;
		double dy = this.y - vec.y;
		return (dx * dx + dy * dy);
	}
	
}
