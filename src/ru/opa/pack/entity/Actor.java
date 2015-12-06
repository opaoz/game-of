package ru.opa.pack.entity;

import ru.opa.pack.abstr.Creature;
import ru.opa.pack.entity.sprites.CreatureSprite;
import ru.opa.pack.enums.Actors;
import ru.opa.pack.ui.MainPanel;
import ru.opa.pack.util.SoundHelper;

public class Actor extends Creature {
	private MainPanel mainPanel;

	public Actor(int x, int y) {
		super(x, y, null);
		damage = 7.0;
		speed = 4.0;
	}

	@Override
	public double getMaxHealth() {
		return 10.0;
	}

	@Override
	public double getDamage() {
		return damage;
	}

	@Override
	public double getSpeed() {
		return speed;
	}

	@Override
	public String getIcon() {
		return "textures/actor.png";
	}

	@Override
	public void damage(double hearts) {
		super.damage(hearts);
		mainPanel.repaint();
	}

	@Override
	public void heal(double hearts) {
		super.heal(hearts);
		mainPanel.repaint();
	}

	public void setPanel(MainPanel panel) {
		mainPanel = panel;
	}

	public void onBonusTake() {
		SoundHelper.Play("sounds/bonus.wav");
		mainPanel.repaint();
	}

	public void changeModel(Actors a) {
		spriteC = new CreatureSprite("textures/actors/" + a + ".png");
	}

	@Override
	public void die() {
		System.exit(-1);
	}
}
