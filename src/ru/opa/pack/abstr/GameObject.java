package ru.opa.pack.abstr;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import ru.opa.pack.Game;
import ru.opa.pack.api.Barrierable;
import ru.opa.pack.barriers.Tree;
import ru.opa.pack.entity.sprites.Sprite;
import ru.opa.pack.enums.Sides;

public abstract class GameObject {
	private int x, y;
	private Sprite sprite;

	public GameObject(int x, int y) {
		sprite = new Sprite(getIcon());

		setX(x);
		setY(y);
	}

	public void setX(int x) {
		if (x > Game.WIDTH - 30 || x < 0)
			return;
		this.x = x;
	}

	public void setY(int y) {
		if (y > Game.HEIGHT - 22 || y < 0)
			return;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void draw(Graphics g) {
		getSprite().draw(g, x, y);
	}

	public boolean isCollision(GameObject go) {
		if (go instanceof Tree)
			return isTreeCollision(go);
		int t = 6;
		Rectangle a = new Rectangle(getX() + t, getY() + t, 32 - t, 32 - t);
		Rectangle b = new Rectangle(go.getX() + t, go.getY() + t, 32 - t,
				32 - t);

		return b.intersects(a);
	}

	private boolean isTreeCollision(GameObject go) {
		return Point2D.distance(x + getSprite().getWidth() / 2, y
				+ getSprite().getHeight() / 2, go.getX()
				+ getSprite().getWidth() / 2, go.getY()
				+ getSprite().getHeight() / 2) <= (go.getSprite().getRaduis()
				/ 2 * (go instanceof Tree ? 2 : 1) + getSprite().getRaduis() / 2);
	}

	public boolean isBarrierCollision(Sides side) {
		for (Barrierable br : Game.barriers) {
			if (isCollision((GameObject) br)) {
				if (!br.underStep((GameObject) this)) {
					if (((GameObject) br).getY() > this.getY()) {
						if (side == Sides.down)
							return true;
					} else {
						if (side == Sides.up)
							return true;
					}

					if (((GameObject) br).getX() > this.getX()) {
						if (side == Sides.right)
							return true;
					} else if (side == Sides.left)
						return true;

				}
			}
		}

		for (Barrierable br : Game.trees) {
			if (isCollision((GameObject) br)) {
				if (!br.underStep((GameObject) this))
					if (((GameObject) br).getY() > this.getY()) {
						if (side == Sides.down)
							return true;
					} else {
						if (side == Sides.up)
							return true;
					}

				if (((GameObject) br).getX() > this.getX()) {
					if (side == Sides.right)
						return true;
				} else if (side == Sides.left)
					return true;

			}
		}

		return false;
	}

	public abstract String getIcon();
}
