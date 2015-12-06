package ru.opa.pack.barriers;

import java.util.Random;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Barrierable;
import ru.opa.pack.monsters.Rat;

public class Tree extends GameObject implements Barrierable {
	public Tree(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean underStep(GameObject gameObject) {
		if (gameObject instanceof Rat)
			return true;
		return false;
	}

	@Override
	public String getIcon() {
		Random r = new Random();
		return "textures/terrain/tree"+r.nextInt(3)+".png";
	}

}
