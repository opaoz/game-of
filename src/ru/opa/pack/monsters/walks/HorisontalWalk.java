package ru.opa.pack.monsters.walks;

import ru.opa.pack.abstr.Creature;
import ru.opa.pack.abstr.Walk;

public class HorisontalWalk extends Walk {

	@Override
	public void move(Creature creature) {
		if (!canMoveX(creature))
			leftRight = !leftRight;
		
		if (leftRight)
			creature.left();
		else
			creature.right();
	}

}
