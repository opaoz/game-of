package ru.opa.pack.ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import ru.opa.pack.Game;
import ru.opa.pack.entity.sprites.Sprite;
import ru.opa.pack.enums.Actors;

public class MainPanel extends Canvas {
	private static final long serialVersionUID = -504416643381241841L;
	private Avatar avatar;
	private Sprite border, bg;
	private StateBar health, speed, damage;

	public MainPanel(Actors a) {
		avatar = new Avatar(a);
		Game.a.changeModel(a);
		
		border = new Sprite("textures/border.png");
		bg = new Sprite("textures/background.png");

		health = new StateBar(new Sprite("textures/stats/health0.png"),
				Color.green, Game.a.getMaxHealth(), 230, false);
		speed = new StateBar(new Sprite("textures/stats/speed.png"),
				Color.yellow, Game.a.getSpeed(), 0, true);
		damage = new StateBar(new Sprite("textures/stats/damage.png"),
				Color.red, Game.a.getDamage(), 0, true);

		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		int panelX = (getWidth() - border.getWidth()) / 2;

		bg.draw(g, 0, 0);
		g.drawImage(avatar.getImage(), panelX, 5, this);
		border.draw(g, panelX, 5);

		health.setCurrent(Game.a.getHealth());
		int delta = (int) (Game.a.getMaxHealth() / Game.a.getHealth());
		if (delta >= 3)
			health.setIcon(new Sprite("textures/stats/health2.png"));
		else if (delta >= 2)
			health.setIcon(new Sprite("textures/stats/health1.png"));
		else
			health.setIcon(new Sprite("textures/stats/health0.png"));
		
		health.draw(g, panelX + 110, 60);

		damage.setCurrent(Game.a.getDamage());
		damage.draw(g, panelX + 110, 20);

		speed.setCurrent(Game.a.getSpeed());
		speed.draw(g, panelX + 240, 20);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(480, 110);
	}
}
