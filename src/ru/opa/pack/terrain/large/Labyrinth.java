package ru.opa.pack.terrain.large;

import java.awt.Graphics;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.Terrain;
import ru.opa.pack.enums.Terrains;
import ru.opa.pack.monsters.walks.HorisontalWalk;
import ru.opa.pack.monsters.walks.VerticalWalk;
import ru.opa.pack.terrain.simple.Flower;
import ru.opa.pack.terrain.simple.Grout;
import ru.opa.pack.terrain.simple.Sand64;
import ru.opa.pack.terrain.simple.StepedEarth;
import ru.opa.pack.util.Randomize;

public class Labyrinth extends Terrain {
	private StepedEarth sE = new StepedEarth();
	private Sand64 sand = new Sand64();
	private Grout grout = new Grout();
	private Flower flower = new Flower();

	private Terrains array[][] = {
			{ Terrains.bushes, Terrains.none, Terrains.none, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.bushes, Terrains.bushes, Terrains.none,
					Terrains.bushes, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.none, Terrains.none,
					Terrains.none, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.stone, Terrains.stone,
					Terrains.stone, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.none, Terrains.none,
					Terrains.stone, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.none, Terrains.none,
					Terrains.none, Terrains.none },
			{ Terrains.bushes, Terrains.none, Terrains.bushes, Terrains.bushes,
					Terrains.none, Terrains.bushes },
			{ Terrains.bushes, Terrains.none, Terrains.none, Terrains.pit,
					Terrains.none, Terrains.none },
			{ Terrains.bushes, Terrains.bushes, Terrains.bushes,
					Terrains.bushes, Terrains.bushes, Terrains.none },
			{ Terrains.none, Terrains.none, Terrains.none, Terrains.none,
					Terrains.none, Terrains.none } };

	@Override
	public void add(int x, int y) {
		spawn(x, y, array);
	}

	@Override
	public void append() {
		Game.bonuses.add(Randomize.randomizeBonus(x + 37, y + 5));
		Game.bonuses.add(Randomize.randomizeBonus(x + 70, y + 230));

		Game.creatures.add(Randomize.randomizeMonster(x + 160, y + 5,
				new VerticalWalk()));
		Game.creatures.add(Randomize.randomizeMonster(x + 32, y + 64,
				new HorisontalWalk()));
		Game.creatures.add(Randomize.randomizeMonster(x + 32, y + 224,
				new VerticalWalk()));
	}

	@Override
	public void draw(Graphics g) {
		sand.draw(g, x + 64, y + 128);

		sE.draw(g, x + 32, y + 5);
		sE.draw(g, x + 64, y + 224);

		grout.draw(g, x + 160, y);
		grout.draw(g, x + 160, y + 32);
		grout.draw(g, x + 160, y + 64);
		grout.draw(g, x + 160, y + 96);
		grout.draw(g, x + 160, y + 128);
		grout.draw(g, x + 160, y + 160);

		grout.draw(g, x + 32, y + 224);

		flower.draw(g, x + 80, y + 135);
	}
}
