package ru.opa.pack.monsters.walks;

import ru.opa.pack.abstr.Creature;
import ru.opa.pack.abstr.Walk;
import ru.opa.pack.enums.Sides;


public class Around extends Walk {
	
	protected Sides direction = Sides.left;

	@Override
	public void move(Creature creature) {
		moveLogic(creature);
	}

	protected void moveLogic(Creature creature) {
		if (!canMoveLeft(creature) && direction == Sides.left)
			direction = Sides.down;
		if (!canMoveRight(creature) && direction == Sides.right)
			direction = Sides.up;
		if (!canMoveUp(creature) && direction == Sides.down)
			direction = Sides.right;
		if (!canMoveDown(creature) && direction == Sides.up)
			direction = Sides.left;

		switch (direction) {
		case left:
			creature.left();
			break;
		case right:
			creature.right();
			break;
		case up:
			creature.up();
			break;
		case down:
			creature.down();
			break;
		}
	}
}
