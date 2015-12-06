package ru.opa.pack.keyboard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputHandler extends KeyAdapter {
	private boolean pressed[] = new boolean[4];// 0-top,1-right,2-bottom,3-left

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			pressed[3] = true;
			break;
		case KeyEvent.VK_RIGHT:
			pressed[1] = true;
			break;
		case KeyEvent.VK_UP:
			pressed[2] = true;
			break;
		case KeyEvent.VK_DOWN:
			pressed[0] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			pressed[3] = false;
			break;
		case KeyEvent.VK_RIGHT:
			pressed[1] = false;
			break;
		case KeyEvent.VK_UP:
			pressed[2] = false;
			break;
		case KeyEvent.VK_DOWN:
			pressed[0] = false;
			break;
		}
	}

	public int getPressed() {
		for (int i = 0; i < 4; i++)
			if (pressed[i])
				return i;
		return -1;
	}
}
