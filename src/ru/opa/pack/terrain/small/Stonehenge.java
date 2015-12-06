package ru.opa.pack.terrain.small;

import java.awt.Graphics;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.Terrain;
import ru.opa.pack.enums.Terrains;
import ru.opa.pack.monsters.walks.Hold;
import ru.opa.pack.terrain.simple.Grout;
import ru.opa.pack.util.Randomize;

public class Stonehenge extends Terrain {
	private Grout grout = new Grout();
	private Terrains array[][] = {
			{ Terrains.stone, Terrains.none, Terrains.none, Terrains.none,
					Terrains.stone, Terrains.none, Terrains.none },
			{ Terrains.none, Terrains.none, Terrains.none, Terrains.none,
					Terrains.none, Terrains.none, Terrains.stone },
			{ Terrains.stone, Terrains.none, Terrains.none, Terrains.none,
					Terrains.stone, Terrains.none, Terrains.none },
			{ Terrains.none, Terrains.none, Terrains.stone, Terrains.none,
					Terrains.none, Terrains.none, Terrains.stone } };

	@Override
	public void draw(Graphics g) {
		grout.draw(g, x, y + 32);
		grout.draw(g, x + 32, y + 32);
		grout.draw(g, x + 64, y + 64);
		grout.draw(g, x + 96, y + 64);

		grout.draw(g, x + 160, y);
	}

	@Override
	public void add(int x, int y) {
		spawn(x, y, array);
	}

	@Override
	public void append() {
		Game.bonuses.add(Randomize.randomizeBonus(x + 37, y + 5));
		Game.creatures.add(Randomize.randomizeMonster(x + 32, y + 32,
				new Hold()));
	}

}
