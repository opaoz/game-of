package ru.opa.pack.monsters;

import ru.opa.pack.abstr.Creature;
import ru.opa.pack.abstr.Walk;
import ru.opa.pack.api.Monsterable;
import ru.opa.pack.entity.Actor;
import ru.opa.pack.util.SoundHelper;

public class Bull extends Creature implements Monsterable {

	public Bull(int x, int y, Walk walk) {
		super(x, y, walk);
	}

	@Override
	public double getMaxHealth() {
		return 15.0;
	}

	@Override
	public double getDamage() {
		return 5.0;
	}

	@Override
	public double getSpeed() {
		return 2;
	}

	@Override
	public void actorAttack(Actor actor) {
		actor.damage(getDamage());
		damage(actor.getDamage() * .5);
	}

	@Override
	public String getIcon() {
		return "textures\\monsters\\bull.png";
	}

	@Override
	public void die() {
		SoundHelper.Play("sounds/bullDie.wav");
	}
}
