package ru.opa.pack.abstr;

import java.awt.Graphics;

import ru.opa.pack.entity.sprites.Sprite;

public abstract class SimpleTerrain {
	protected Sprite sprite;

	public SimpleTerrain() {
		sprite = new Sprite(getIcon());
	}

	public void draw(Graphics g, int x, int y) {
		sprite.draw(g, x, y);
	}

	public abstract String getIcon();
}
