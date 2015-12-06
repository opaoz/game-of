package ru.opa.pack.abstr;

import java.awt.Graphics;

import ru.opa.pack.Game;
import ru.opa.pack.barriers.Bushes;
import ru.opa.pack.barriers.Pit;
import ru.opa.pack.barriers.Stone;
import ru.opa.pack.enums.Terrains;

public abstract class Terrain {
	protected int x, y;

	public void spawn(int x, int y, Terrains array[][]) {
		this.x = x;
		this.y = y;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				switch (array[i][j]) {
				case stone:
					Game.barriers.add(new Stone(x + (j * 32), y + (i * 32)));
					break;
				case bushes:
					Game.barriers.add(new Bushes(x + (j * 32), y + (i * 32)));
					break;
				case pit:
					Game.barriers.add(new Pit(x + (j * 32), y + (i * 32)));
					break;
				default:
					break;
				}
			}
		}

		append();
	}

	public abstract void draw(Graphics g);

	public abstract void add(int x, int y);

	public abstract void append();
}
