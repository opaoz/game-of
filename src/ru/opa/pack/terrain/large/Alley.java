package ru.opa.pack.terrain.large;

import java.awt.Graphics;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.Terrain;
import ru.opa.pack.enums.Terrains;
import ru.opa.pack.monsters.walks.HorisontalWalk;
import ru.opa.pack.monsters.walks.VerticalWalk;
import ru.opa.pack.util.Randomize;

public class Alley extends Terrain {
	private Terrains array[][] = {
			{ Terrains.bushes, Terrains.none, Terrains.none, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.bushes, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.bushes, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.bushes, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.none, Terrains.none,
					Terrains.none, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.bushes, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.bushes, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.bushes, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.bushes, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.none, Terrains.none, Terrains.bushes, Terrains.none,
					Terrains.none, Terrains.none } };

	@Override
	public void draw(Graphics g) {

	}

	@Override
	public void add(int x, int y) {
		spawn(x, y, array);
	}

	@Override
	public void append() {
		Game.creatures.add(Randomize.randomizeMonster(x + 32, y + 128,
				new HorisontalWalk()));
		Game.creatures.add(Randomize.randomizeMonster(x + 96, y + 32,
				new VerticalWalk()));

		Game.bonuses.add(Randomize.randomizeBonus(x + 37, y + 5));
		Game.bonuses.add(Randomize.randomizeBonus(x + 165, y + 5));
	}
}
