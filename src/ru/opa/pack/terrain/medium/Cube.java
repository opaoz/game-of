package ru.opa.pack.terrain.medium;

import java.awt.Graphics;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.Terrain;
import ru.opa.pack.enums.Terrains;
import ru.opa.pack.monsters.walks.HorisontalWalk;
import ru.opa.pack.monsters.walks.VerticalWalk;
import ru.opa.pack.terrain.simple.Sand64;
import ru.opa.pack.terrain.simple.StepedEarth;
import ru.opa.pack.util.Randomize;

public class Cube extends Terrain {
	private StepedEarth sE = new StepedEarth();
	private Sand64 sand = new Sand64();
	private Terrains array[][] = {
			{ Terrains.pit, Terrains.pit, Terrains.none, Terrains.stone,
					Terrains.stone },
			{ Terrains.none, Terrains.none, Terrains.none, Terrains.none,
					Terrains.stone },
			{ Terrains.none, Terrains.none, Terrains.none, Terrains.none,
					Terrains.none },
			{ Terrains.none, Terrains.none, Terrains.none, Terrains.none,
					Terrains.pit },
			{ Terrains.none, Terrains.none, Terrains.none, Terrains.none,
					Terrains.bushes }, };

	@Override
	public void add(int x, int y) {
		spawn(x, y, array);
	}

	@Override
	public void draw(Graphics g) {
		sE.draw(g, x + 50, y + 75);
		sand.draw(g, x, y + 32);
		sand.draw(g, x + 64, y + 32);
		sand.draw(g, x, y + 96);
		sand.draw(g, x + 64, y + 96);
	}

	@Override
	public void append() {
		Game.creatures.add(Randomize.randomizeMonster(x + 96, y + 32,
				new HorisontalWalk()));
		Game.creatures.add(Randomize.randomizeMonster(x + 96, y + 96,
				new VerticalWalk()));

		Game.bonuses.add(Randomize.randomizeBonus(x + 55, y + 80));
	}

}
