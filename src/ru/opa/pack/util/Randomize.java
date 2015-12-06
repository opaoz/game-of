package ru.opa.pack.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.opa.pack.abstr.Creature;
import ru.opa.pack.abstr.Terrain;
import ru.opa.pack.abstr.Walk;
import ru.opa.pack.api.Bonusable;

public class Randomize {
	protected static List<Class<? extends Terrain>> SmallTerrains = new ArrayList<Class<? extends Terrain>>(); // a=0
	protected static List<Class<? extends Terrain>> MediumTerrains = new ArrayList<Class<? extends Terrain>>(); // a=1
	protected static List<Class<? extends Terrain>> LargeTerrains = new ArrayList<Class<? extends Terrain>>(); // a=2
	protected static List<Class<? extends Bonusable>> Bonuses = new ArrayList<Class<? extends Bonusable>>();
	protected static List<Class<? extends Creature>> Monsters = new ArrayList<Class<? extends Creature>>();

	private static Random r = new Random();

	public static void registerTerrainClass(Class<? extends Terrain> terrain,
			int a) {
		switch (a) {
		case 0:
			SmallTerrains.add(terrain);
			break;
		case 1:
			MediumTerrains.add(terrain);
			break;
		case 2:
			LargeTerrains.add(terrain);
			break;
		}

	}

	public static void registerBonus(Class<? extends Bonusable> bonus) {
		Bonuses.add(bonus);
	}

	public static void registerMonster(Class<? extends Creature> monster) {
		Monsters.add(monster);
	}

	public static Terrain randomizeTerrain(int a) {
		try {
			switch (a) {
			case 0:
				return SmallTerrains.get(r.nextInt(SmallTerrains.size()))
						.newInstance();
			case 1:
				return MediumTerrains.get(r.nextInt(MediumTerrains.size()))
						.newInstance();
			case 2:
				return LargeTerrains.get(r.nextInt(LargeTerrains.size()))
						.newInstance();
			}
		} catch (InstantiationException e) {
			System.out.println("Ошибка создания объекта класса");
		} catch (IllegalAccessException e) {
			System.out.println("Ошибка доступа к классу");
		}

		return null;
	}

	public static Bonusable randomizeBonus(int x, int y) {
		try {
			return Bonuses.get(r.nextInt(Bonuses.size()))
					.getConstructor(int.class, int.class).newInstance(x, y);
		} catch (InstantiationException e) {
			System.out.println("Ошибка создания объекта класса");
		} catch (Exception e) {
			System.out.println("Ошибка доступа к классу");
		}
		return null;
	}

	public static Creature randomizeMonster(int x, int y, Walk walk) {
		try {
			return Monsters.get(r.nextInt(Monsters.size()))
					.getConstructor(int.class, int.class, Walk.class)
					.newInstance(x, y, walk);
		} catch (InstantiationException e) {
			System.out.println("Ошибка создания объекта класса");
		} catch (Exception e) {
			System.out.println("Ошибка доступа к классу");
		}
		return null;
	}
}
