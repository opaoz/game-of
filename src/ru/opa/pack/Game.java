package ru.opa.pack;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.opa.pack.abstr.Creature;
import ru.opa.pack.abstr.GameObject;
import ru.opa.pack.abstr.Walk;
import ru.opa.pack.api.Barrierable;
import ru.opa.pack.api.Bonusable;
import ru.opa.pack.api.Monsterable;
import ru.opa.pack.barriers.Tree;
import ru.opa.pack.bonuses.Apple;
import ru.opa.pack.bonuses.Banana;
import ru.opa.pack.bonuses.Berry;
import ru.opa.pack.bonuses.Cherry;
import ru.opa.pack.bonuses.Lemon;
import ru.opa.pack.bonuses.Melon;
import ru.opa.pack.bonuses.Peach;
import ru.opa.pack.bonuses.Pear;
import ru.opa.pack.bonuses.Pineapple;
import ru.opa.pack.entity.Actor;
import ru.opa.pack.keyboard.KeyInputHandler;
import ru.opa.pack.monsters.Bull;
import ru.opa.pack.monsters.Opossum;
import ru.opa.pack.monsters.Rat;
import ru.opa.pack.monsters.walks.Escape;
import ru.opa.pack.terrain.MainTerrain;
import ru.opa.pack.terrain.large.Alley;
import ru.opa.pack.terrain.large.Labyrinth;
import ru.opa.pack.terrain.medium.Cube;
import ru.opa.pack.terrain.medium.Helix;
import ru.opa.pack.terrain.small.CircleOfPits;
import ru.opa.pack.terrain.small.Stonehenge;
import ru.opa.pack.util.Randomize;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 636822335393900524L;
	private boolean running = false;
	public static int WIDTH = MainTerrain.HOR * MainTerrain.WIDTH - 20;
	public static int HEIGHT = MainTerrain.VER * MainTerrain.HEIGHT - 20;
	public static String NAME = "Game";
	public MainTerrain terrain = new MainTerrain();
	public KeyInputHandler keyHandler = new KeyInputHandler();
	public static List<Creature> creatures = new ArrayList<Creature>();
	public static List<Bonusable> bonuses = new ArrayList<Bonusable>();
	public static List<Barrierable> barriers = new ArrayList<Barrierable>();
	public static List<Barrierable> trees = new ArrayList<Barrierable>();
	public static List<Creature> toDie = new ArrayList<Creature>();
	public static Actor a = new Actor(Game.WIDTH / 2 - 15, Game.HEIGHT / 2 - 30);

	@Override
	public void run() {
		long lastTime = System.currentTimeMillis();
		long delta;

		init();

		while (running) {
			delta = System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();
			update(delta);
			render();
		}
	}

	public void start() {
		running = true;
		new Thread(this).start();
	}

	public void regenerateTerrain() {
		creatures.clear();
		barriers.clear();
		bonuses.clear();
		trees.clear();

		terrain.init();
		a.setY(Game.HEIGHT / 2 - 30);
		a.setX(Game.WIDTH / 2 - 15);

		spawnBarriers();
	}

	public void init() {
		addKeyListener(keyHandler);
		registerBonuses();
		registerMonsters();
		registerTerrains();
		terrain.init();

		spawnBarriers();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(2);
			requestFocus();
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
		terrain.draw(g);

		for (Bonusable bn : bonuses)
			((GameObject) bn).draw(g);

		for (Barrierable br : barriers)
			((GameObject) br).draw(g);

		for (Creature cr : creatures)
			cr.draw(g);

		for (Barrierable br : trees)
			((GameObject) br).draw(g);

		a.draw(g);
		g.dispose();
		bs.show();

	}

	public void update(long delta) {
		if (bonuses.isEmpty())
			regenerateTerrain();

		actorWalk();

		monsterFight();
		bonusTake();
		monsterRemove();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("Ошибка потока. Аварийное завершение");
		}
	}

	private void actorWalk() {
		switch (keyHandler.getPressed()) {
		case 0:
			if (Walk.canMoveDown(a))
				a.up();
			break;
		case 1:
			if (Walk.canMoveRight(a))
				a.right();
			break;
		case 2:
			if (Walk.canMoveUp(a))
				a.down();
			break;
		case 3:
			if (Walk.canMoveLeft(a))
				a.left();
			break;
		case -1:
			break;
		}
	}

	private void monsterRemove() {
		for (Iterator<Creature> creatureToDie = toDie.iterator(); creatureToDie
				.hasNext();) {
			Creature currentCreature = creatureToDie.next();
			currentCreature.die();
			creatures.remove(currentCreature);
			creatureToDie.remove();
		}
	}

	private void monsterFight() {

		for (Creature cr : creatures) {
			cr.move();
		}
		for (Iterator<Creature> creatureIter = creatures.iterator(); creatureIter
				.hasNext();) {
			Creature currentMonster = creatureIter.next();
			if (a.isCollision((GameObject) currentMonster)) {
				if (currentMonster instanceof Monsterable)
					((Monsterable) currentMonster).actorAttack(a);
				if (currentMonster.isDie()) {
					currentMonster.die();
					creatureIter.remove();
				}
				if (a.isDie())
					a.die();
				currentMonster.setWalk(new Escape(currentMonster.getWalk()));
			}
		}
	}

	private void bonusTake() {
		for (Iterator<Bonusable> bonusIter = bonuses.iterator(); bonusIter
				.hasNext();) {
			Bonusable currentBonus = bonusIter.next();
			if (a.isCollision((GameObject) currentBonus)) {
				currentBonus.takeIt(a);
				a.onBonusTake();
				bonusIter.remove();
			}
		}
	}

	private void registerBonuses() {
		Randomize.registerBonus(Apple.class);
		Randomize.registerBonus(Cherry.class);
		Randomize.registerBonus(Berry.class);
		Randomize.registerBonus(Melon.class);
		Randomize.registerBonus(Banana.class);
		Randomize.registerBonus(Lemon.class);
		Randomize.registerBonus(Peach.class);
		Randomize.registerBonus(Pear.class);
		Randomize.registerBonus(Pineapple.class);
	}

	private void registerMonsters() {
		Randomize.registerMonster(Bull.class);
		Randomize.registerMonster(Rat.class);
		Randomize.registerMonster(Opossum.class);
	}

	private void registerTerrains() {
		Randomize.registerTerrainClass(CircleOfPits.class, 0);
		Randomize.registerTerrainClass(Stonehenge.class, 0);

		Randomize.registerTerrainClass(Cube.class, 1);
		Randomize.registerTerrainClass(Helix.class, 1);

		Randomize.registerTerrainClass(Labyrinth.class, 2);
		Randomize.registerTerrainClass(Alley.class, 2);
	}

	private void spawnBarriers() {
		trees.add(new Tree(0, 98));
		trees.add(new Tree(211, 5));
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Game.WIDTH, Game.HEIGHT);
	}
}
