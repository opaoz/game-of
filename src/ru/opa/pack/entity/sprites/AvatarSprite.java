package ru.opa.pack.entity.sprites;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Icon;

import ru.opa.pack.enums.Actors;

public class AvatarSprite extends Sprite implements Icon {
	private Actors actor;

	public AvatarSprite(Actors a) {
		super("textures/actors/actor_faces.png");
		actor = a;
		int x = 0, y = 0;

		switch (a) {
		case Arina:
			x = 1;
			y = 0;
			break;
		case Azazel:
			x = 2;
			y = 0;
			break;
		case Darkside:
			x = 0;
			y = 1;
			break;
		case DoomKnight:
			x = 3;
			y = 1;
			break;
		case Knight:
			x = 2;
			y = 1;
			break;
		case Naga:
			x = 1;
			y = 1;
			break;
		case Necropoth:
			x = 0;
			y = 0;
			break;
		case Pirat:
			x = 3;
			y = 0;
			break;
		}

		image = sourceImage.getSubimage(x * 96, y * 96, 96, 96);
	}

	public Actors getName() {
		return actor;
	}

	public Image getImage() {
		return image;
	}

	@Override
	public int getIconHeight() {
		return getHeight();
	}

	@Override
	public int getIconWidth() {
		return getWidth();
	}

	@Override
	public void paintIcon(Component arg0, Graphics g, int x, int y) {
		draw(g, x, y);
	}
}
