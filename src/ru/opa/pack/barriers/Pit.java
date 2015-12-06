package ru.opa.pack.barriers;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Barrierable;
import ru.opa.pack.monsters.Rat;

public class Pit extends GameObject implements Barrierable {

	public Pit(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean underStep(GameObject gameObject) {
		if (gameObject instanceof Rat) {
			Game.toDie.add((Rat) gameObject);
			return true;
		}
		return false;
	}

	@Override
	public String getIcon() {
		return "textures/terrain/pit.png";
	}

}
