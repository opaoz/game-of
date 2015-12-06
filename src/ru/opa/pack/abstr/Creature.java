package ru.opa.pack.abstr;

import ru.opa.pack.entity.sprites.CreatureSprite;
import ru.opa.pack.monsters.walks.Hold;

public abstract class Creature extends GameObject {
	protected double health, damage, speed;
	protected CreatureSprite spriteC;
	private boolean die = false;
	private Walk walkPath;

	public Creature(int x, int y, Walk walk) {
		super(x, y);
		spriteC = new CreatureSprite(getIcon());

		setX(x);
		setY(y);

		health = getMaxHealth();
		damage = getDamage();
		speed = getSpeed();

		if (walk != null)
			walkPath = walk;
		else
			walkPath = new Hold();
	}

	public void right() {
		setX((int) (getX() + speed));
		spriteC.right();
	}

	public void left() {
		setX((int) (getX() - speed));
		spriteC.left();
	}

	public void up() {
		setY((int) (getY() + speed));
		spriteC.top();
	}

	public void down() {
		setY((int) (getY() - speed));
		spriteC.bottom();
	}

	@Override
	public void draw(java.awt.Graphics g) {
		spriteC.draw(g, getX(), getY());
	};

	public abstract double getMaxHealth();

	public abstract double getDamage();

	public abstract double getSpeed();

	public void damage(double hearts) {
		heal(-hearts);
		if (health <= 0)
			die = true;
	}

	public void heal(double hearts) {
		if (health + hearts < getMaxHealth())
			health += hearts;
		else
			health = getMaxHealth();
	}

	public void speedDown(double count) {
		speed -= count;
	}

	public void damageDown(double count) {
		damage -= count;
	}

	public void speedUp(double count) {
		speed += count;
	}

	public void damageUp(double count) {
		damage += count;
	}

	public double getHealth() {
		return health;
	}

	public boolean isDie() {
		return die;
	}

	public void move() {
		walkPath.move(this);
	}

	public void setWalk(Walk walk) {
		walkPath = walk;
	}

	public Walk getWalk() {
		return walkPath;
	}

	public abstract void die();
}
