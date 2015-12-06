package ru.opa.pack.terrain.medium;

import java.awt.Graphics;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.Terrain;
import ru.opa.pack.enums.Terrains;
import ru.opa.pack.terrain.simple.Sand32;
import ru.opa.pack.util.Randomize;

public class Helix extends Terrain {
	private Sand32 sand = new Sand32();
	private Terrains array[][] = {
			{ Terrains.stone, Terrains.stone, Terrains.stone, Terrains.stone,
					Terrains.stone },
			{ Terrains.stone, Terrains.none, Terrains.none, Terrains.none,
					Terrains.none },
			{ Terrains.stone, Terrains.none, Terrains.stone, Terrains.stone,
					Terrains.stone },
			{ Terrains.stone, Terrains.none, Terrains.none, Terrains.none,
					Terrains.stone },
			{ Terrains.stone, Terrains.stone, Terrains.stone, Terrains.stone,
					Terrains.stone } };

	@Override
	public void draw(Graphics g) {
		sand.draw(g, x + 32, y + 32);
		sand.draw(g, x + 64, y + 32);
		sand.draw(g, x + 96, y + 32);
		sand.draw(g, x + 128, y + 32);

		sand.draw(g, x + 32, y + 64);
		sand.draw(g, x + 32, y + 96);

		sand.draw(g, x + 64, y + 96);
		sand.draw(g, x + 96, y + 96);
	}

	@Override
	public void add(int x, int y) {
		spawn(x, y, array);
	}

	@Override
	public void append() {
		Game.bonuses.add(Randomize.randomizeBonus(x + 100, y + 102));
	}

}
