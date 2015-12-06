package ru.opa.pack.bonuses;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Bonusable;
import ru.opa.pack.entity.Actor;

public class Berry extends GameObject implements Bonusable {

	public Berry(int x, int y) {
		super(x, y);
	}

	@Override
	public void takeIt(Actor actor) {
		actor.damageUp(0.75);
	}

	@Override
	public String getIcon() {
		return "textures/bonuses/berry.png";
	}

}
