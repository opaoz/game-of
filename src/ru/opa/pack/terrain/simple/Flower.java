package ru.opa.pack.terrain.simple;

import java.util.Random;

import ru.opa.pack.abstr.SimpleTerrain;

public class Flower extends SimpleTerrain {

	@Override
	public String getIcon() {
		Random r = new Random();
		return "textures/terrain/flower" + r.nextInt(4) + ".png";
	}

}
