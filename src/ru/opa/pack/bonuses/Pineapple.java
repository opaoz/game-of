package ru.opa.pack.bonuses;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Bonusable;
import ru.opa.pack.entity.Actor;

public class Pineapple extends GameObject implements Bonusable {

	public Pineapple(int x, int y) {
		super(x, y);
	}

	@Override
	public void takeIt(Actor actor) {
		actor.damageDown(2);
		actor.heal(2);
	}

	@Override
	public String getIcon() {
		return "textures/bonuses/pineapple.png";
	}

}
