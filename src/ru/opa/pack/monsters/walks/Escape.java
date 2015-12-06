package ru.opa.pack.monsters.walks;

import java.awt.geom.Point2D;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.Creature;
import ru.opa.pack.abstr.Walk;
import ru.opa.pack.enums.Sides;

public class Escape extends Around {
	private long ms = 3000, current;
	private Walk old;
	private double oldSpeed = 0;

	public Escape(Walk old) {
		current = System.currentTimeMillis();
		this.old = old;
	}

	@Override
	public void move(Creature creature) {
		if (oldSpeed == 0) {
			oldSpeed = creature.getSpeed();
			creature.speedUp(oldSpeed);
		}

		if ((System.currentTimeMillis() - current) >= ms) {
			creature.setWalk(old);
			creature.speedDown(oldSpeed);
			return;
		}

		// if (Game.a.getX() > creature.getX()) {
		if (Game.a.getX() <= creature.getX() + creature.getSprite().getWidth()
				&& dist(creature)
				&& Math.abs(Game.a.getY() - creature.getY()) < 10) {
			direction = Sides.left;

		}

		// if (Game.a.getX() < creature.getX()) {
		else if (Game.a.getX() + Game.a.getSprite().getWidth() >= creature
				.getX()
				&& dist(creature)
				&& Math.abs(Game.a.getY() - creature.getY()) < 10) {
			direction = Sides.right;
		}

		// if (Game.a.getY() > creature.getY()) {
		else if (Game.a.getY() <= creature.getY()
				+ creature.getSprite().getHeight()
				&& dist(creature)
				&& Math.abs(Game.a.getX() - creature.getX()) < 10) {
			direction = Sides.down;
		}

		// if (Game.a.getY() < creature.getY()) {
		else if (Game.a.getY() + Game.a.getSprite().getWidth() >= creature
				.getY()
				&& dist(creature)
				&& Math.abs(Game.a.getX() - creature.getX()) < 10) {
			direction = Sides.up;
		}

		moveLogic(creature);
	}

	private boolean dist(Creature creature) {
		return Point2D.distance(Game.a.getX(), Game.a.getY(), creature.getX(),
				creature.getY()) <= 40;
	}
}
