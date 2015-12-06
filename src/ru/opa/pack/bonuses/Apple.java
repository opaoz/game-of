package ru.opa.pack.bonuses;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Bonusable;
import ru.opa.pack.entity.Actor;

public class Apple extends GameObject implements Bonusable {

	public Apple(int x, int y) {
		super(x, y);
	}

	@Override
	public void takeIt(Actor actor) {
		actor.heal(2.0);
	}

	@Override
	public String getIcon() {
		return "textures/bonuses/apple.png";
	}

}
