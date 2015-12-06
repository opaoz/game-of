package ru.opa.pack.monsters;

import ru.opa.pack.abstr.Creature;
import ru.opa.pack.abstr.Walk;
import ru.opa.pack.api.Monsterable;
import ru.opa.pack.entity.Actor;
import ru.opa.pack.util.SoundHelper;

public class Rat extends Creature implements Monsterable {

	public Rat(int x, int y, Walk walk) {
		super(x, y, walk);
	}

	@Override
	public void actorAttack(Actor actor) {
		actor.damage(getDamage());
		damage(actor.getDamage());
	}

	@Override
	public double getMaxHealth() {
		return 3.0;
	}

	@Override
	public double getDamage() {
		return 3.0;
	}

	@Override
	public double getSpeed() {
		return 4.0;
	}

	@Override
	public String getIcon() {
		return "textures/monsters/rat.png";
	}

	@Override
	public void die() {
		SoundHelper.Play("sounds/mouseDie.wav");
	}

}
