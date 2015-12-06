package ru.opa.pack.barriers;

import java.util.Random;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Barrierable;

public class Stone extends GameObject implements Barrierable {

	public Stone(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean underStep(GameObject gameObject) {
		return false;
	}

	@Override
	public String getIcon() {
		Random r = new Random();
		return "textures/terrain/stone" + r.nextInt(2) + ".png";
	}

}
