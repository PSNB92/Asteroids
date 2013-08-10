package org.psnbtech.entity;

import java.awt.Graphics2D;

import org.psnbtech.Game;
import org.psnbtech.util.Vector2;

/**
 * Represents a Bullet within the game world.
 * @author Brendan Jones
 *
 */
public class Bullet extends Entity {
	
	/**
	 * The magnitude of the velocity of a Bullet.
	 */
	private static final double VELOCITY_MAGNITUDE = 6.75;
	
	/**
	 * The maximum number of cycles that a Bullet can exist.
	 */
	private static final int MAX_LIFESPAN = 60;
	
	/**
	 * The number of cycles this Bullet has existed.
	 */
	private int lifespan;

	/**
	 * Creates a new Bullet instance.
	 * @param owner The object that fired the bullet.
	 * @param angle The direction of the Bullet.
	 */
	public Bullet(Entity owner, double angle) {
		super(new Vector2(owner.position), new Vector2(angle).scale(VELOCITY_MAGNITUDE), 2.0, 0);
		this.lifespan = MAX_LIFESPAN;
	}
	
	@Override
	public void update(Game game) {
		super.update(game);
		
		//Decrement the lifespan of the bullet, and remove it if needed.
		this.lifespan--;
		if(lifespan <= 0) {
			flagForRemoval();
		}
	}

	@Override
	public void handleCollision(Game game, Entity other) {
		if(other.getClass() != Player.class) {
			flagForRemoval();
		}
	}
	
	@Override
	public void draw(Graphics2D g, Game game) {
		g.drawOval(-1, -1, 2, 2);
	}

}
