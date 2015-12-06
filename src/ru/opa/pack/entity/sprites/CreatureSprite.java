package ru.opa.pack.entity.sprites;

import java.awt.Image;

public class CreatureSprite extends Sprite {
	private Image stations[][] = new Image[4][3];
	private int margins[] = new int[4]; // 0-top,1-right,2-bottom,3-left

	public CreatureSprite(String path) {
		super(path);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++)
				stations[i][j] = sourceImage
						.getSubimage(j * 32, i * 32, 32, 32);

			margins[i] = 0;
		}
		image = stations[0][0];
	}

	public void right() {
		if (margins[1] == 2)
			margins[1] = 0;
		image = stations[2][margins[1]++];
	}

	public void left() {
		if (margins[3] == 2)
			margins[3] = 0;
		image = stations[1][margins[3]++];
	}

	public void top() {
		if (margins[0] == 2)
			margins[0] = 0;
		image = stations[0][margins[0]++];
	}

	public void bottom() {
		if (margins[2] == 2)
			margins[2] = 0;
		image = stations[3][margins[2]++];
	}
}
