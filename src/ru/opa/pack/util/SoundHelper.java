package ru.opa.pack.util;

import ru.opa.pack.entity.Sound;

public class SoundHelper {
	
	public static void Play(String path) {
		new Thread(new Sound(path)).start();
	}
}
