package ru.opa.pack.abstr;

import ru.opa.pack.Game;
import ru.opa.pack.api.Barrierable;
import ru.opa.pack.enums.Sides;

public abstract class Walk {
	protected boolean upDown = true; // up = true, down = false
	protected boolean leftRight = true; // left = true, right = false

	public abstract void move(Creature creature);

	public static boolean canMoveX(Creature creature) {
		if (creature.getX() >= Game.WIDTH - 32 || creature.getX() <= 0)
			return false;

		for (Barrierable br : Game.barriers) {
			if (creature.isCollision((GameObject) br)) {
				if (!br.underStep((GameObject) creature))
					return false;
			}
		}

		return true;
	}

	public static boolean canMoveY(Creature creature) {
		if (creature.getY() >= Game.HEIGHT - 32 || creature.getY() <= 0)
			return false;

		return true;
	}

	public static boolean canMoveRight(Creature creature) {
		if (((GameObject) creature).isBarrierCollision(Sides.right))
			return false;
		return !(creature.getX() >= Game.WIDTH - 32);
	}

	public static boolean canMoveLeft(Creature creature) {
		if (((GameObject) creature).isBarrierCollision(Sides.left))
			return false;
		return !(creature.getX() <= 0);
	}

	public static boolean canMoveUp(Creature creature) {
		if (((GameObject) creature).isBarrierCollision(Sides.up))
			return false;
		return !(creature.getY() <= 8);
	}

	public static boolean canMoveDown(Creature creature) {
		if (((GameObject) creature).isBarrierCollision(Sides.down))
			return false;
		return !(creature.getY() >= Game.HEIGHT - 32);
	}

}
