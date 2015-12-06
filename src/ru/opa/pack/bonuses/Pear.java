package ru.opa.pack.bonuses;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Bonusable;
import ru.opa.pack.entity.Actor;

public class Pear extends GameObject implements Bonusable {

	public Pear(int x, int y) {
		super(x, y);
	}

	@Override
	public void takeIt(Actor actor) {
		actor.speedUp(1);
		actor.heal(1);
	}

	@Override
	public String getIcon() {
		return "textures/bonuses/pear.png";
	}

}
