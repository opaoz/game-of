package ru.opa.pack.bonuses;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Bonusable;
import ru.opa.pack.entity.Actor;

public class Melon extends GameObject implements Bonusable{

	public Melon(int x, int y) {
		super(x, y);
	}

	@Override
	public void takeIt(Actor actor) {
		actor.heal(2.0);
		actor.speedDown(1);
	}

	@Override
	public String getIcon() {
		return "textures/bonuses/melon.png";
	}

}
