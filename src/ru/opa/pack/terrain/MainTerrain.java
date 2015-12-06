package ru.opa.pack.terrain;

import java.awt.Graphics;
import java.util.Random;

import ru.opa.pack.Game;
import ru.opa.pack.abstr.SimpleTerrain;
import ru.opa.pack.abstr.Terrain;
import ru.opa.pack.terrain.simple.Earth;
import ru.opa.pack.terrain.simple.FlowerTerrain;
import ru.opa.pack.terrain.simple.Grout;
import ru.opa.pack.terrain.simple.Start;
import ru.opa.pack.terrain.simple.StepedEarth;
import ru.opa.pack.util.Randomize;

public class MainTerrain {
	public static final int WIDTH = 70, HEIGHT = 70;
	public static final int HOR = 7, VER = 5;
	private int field[][] = new int[VER][HOR];
	private Terrain small, medium, large;
	private SimpleTerrain terrain = new Earth();
	private Grout grout = new Grout();
	private FlowerTerrain flower = new FlowerTerrain();
	private StepedEarth steped = new StepedEarth();

	private void randomize() {
		small = Randomize.randomizeTerrain(0);
		medium = Randomize.randomizeTerrain(1);
		large = Randomize.randomizeTerrain(2);

	}

	public void init() {
		Random r = new Random();
		for (int i = 0; i < VER; i++) {
			for (int j = 0; j < HOR; j++)
				field[i][j] = r.nextInt(10);
		}
		randomize();

		small.add(0, 0);
		medium.add(0, 170);
		large.add(275, 5);
	}

	public void draw(Graphics g) {
		for (int i = 0; i < VER; i++)
			for (int j = 0; j < HOR; j++) {
				terrain.draw(g, j * WIDTH, i * HEIGHT);

				switch (field[i][j]) {
				case 1:
					grout.draw(g, j * WIDTH, i * HEIGHT);
					break;
				case 3:
				case 4:
					steped.draw(g, j * WIDTH, i * HEIGHT);
					break;
				case 5:
					flower.draw(g, j * WIDTH, i * HEIGHT);
					break;
				}
			}

		new Start().draw(g, Game.WIDTH / 2 - 15, Game.HEIGHT / 2 - 15);

		small.draw(g);
		medium.draw(g);
		large.draw(g);
	}
}
