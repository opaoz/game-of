package ru.opa.pack.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ru.opa.pack.entity.sprites.Sprite;

public class StateBar {
	private Sprite icon;
	private Color color;
	private double max, current;
	private static BasicStroke stroke = new BasicStroke(8f);
	private int width = 100, height = 32;
	private boolean isMaxOrCurrent;// false - current, true - max

	public StateBar(Sprite icon, Color color, double max, int width,
			boolean flag) {
		if (width == 0)
			this.width = 100;
		else
			this.width = width;
		this.isMaxOrCurrent = flag;
		this.icon = icon;
		this.color = color;
		this.max = current = max;
	}

	public void setCurrent(double current) {
		if (isMaxOrCurrent)
			max = current;
		this.current = current;
	}

	public void setIcon(Sprite icon) {
		this.icon = icon;
	}

	public void draw(Graphics g, int x, int y) {
		Graphics2D g2D = (Graphics2D) g;

		g2D.setStroke(stroke);

		g2D.setColor(new Color(0, 0, 0, 0.5f));
		g2D.drawLine(x + height, y + 13, x + width, y + 13);

		g2D.setColor(color);
		g2D.drawLine(x + height, y + 13, x + (int) ((width / max) * current),
				y + 13);

		g2D.setColor(Color.white);
		String state = isMaxOrCurrent ? max + "" : (current + "/" + max);
		g2D.drawString(state, x + (width / 3) + state.length() * 2
				+ (isMaxOrCurrent ? 15 : 0), y + 27);
		icon.draw(g, x, y);
	}

}
