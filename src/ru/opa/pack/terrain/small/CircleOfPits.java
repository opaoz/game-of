package ru.opa.pack.terrain.small;

import java.awt.Graphics;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.Terrain;
import ru.opa.pack.enums.Terrains;
import ru.opa.pack.monsters.walks.HorisontalWalk;
import ru.opa.pack.terrain.simple.StepedEarth;
import ru.opa.pack.util.Randomize;

public class CircleOfPits extends Terrain {
	private StepedEarth sE = new StepedEarth();
	private Terrains array[][] = {
			{ Terrains.none, Terrains.none, Terrains.stone },
			{ Terrains.none, Terrains.none, Terrains.none },
			{ Terrains.pit, Terrains.pit, Terrains.pit } };

	@Override
	public void draw(Graphics g) {
		sE.draw(g, x + 0, y + 0);
	}

	@Override
	public void append() {
		Game.bonuses.add(Randomize.randomizeBonus(x + 5, y + 5));
		Game.creatures.add(Randomize.randomizeMonster(x, y,
				new HorisontalWalk()));
	}

	@Override
	public void add(int x, int y) {
		spawn(x, y, array);
	}

}
