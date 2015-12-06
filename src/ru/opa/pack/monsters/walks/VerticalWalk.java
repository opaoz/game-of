package ru.opa.pack.monsters.walks;

import ru.opa.pack.abstr.Creature;
import ru.opa.pack.abstr.Walk;

public class VerticalWalk extends Walk {

	@Override
	public void move(Creature cr) {
		if (!canMoveDown(cr) || !canMoveUp(cr))
			upDown = !upDown;

		if (upDown)
			cr.up();
		else
			cr.down();
	}

}
