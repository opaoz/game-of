package ru.opa.pack.monsters;

import ru.opa.pack.abstr.Walk;

public class Opossum extends Rat {

	public Opossum(int x, int y, Walk walk) {
		super(x, y, walk);
	}

	@Override
	public double getDamage() {
		return 2.0;
	}

	@Override
	public double getSpeed() {
		return 6.0;
	}
	
	@Override
	public String getIcon() {
		return "textures/monsters/opossum.png";
	}
}
