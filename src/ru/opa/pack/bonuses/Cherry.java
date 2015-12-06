package ru.opa.pack.bonuses;

import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.api.Bonusable;
import ru.opa.pack.entity.Actor;

public class Cherry extends GameObject implements Bonusable{

	public Cherry(int x, int y){
		super(x, y);
	}

	@Override
	public void takeIt(Actor actor) {
		actor.speedUp(0.5);
	}

	@Override
	public String getIcon() {
		return "textures/bonuses/cherry.png";
	}
}
