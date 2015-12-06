package ru.opa.pack.bonuses;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Bonusable;
import ru.opa.pack.entity.Actor;

public class Lemon extends GameObject implements Bonusable {

	public Lemon(int x, int y) {
		super(x, y);
	}

	@Override
	public void takeIt(Actor actor) {
		actor.damage(0.5);
		actor.speedUp(1);
	}

	@Override
	public String getIcon() {
		return "textures/bonuses/lemon.png";
	}

}
