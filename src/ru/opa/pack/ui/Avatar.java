package ru.opa.pack.ui;

import java.awt.Image;

import ru.opa.pack.entity.sprites.AvatarSprite;
import ru.opa.pack.enums.Actors;

public class Avatar {
	private AvatarSprite avatar;
	
	public Avatar(Actors a){
		avatar = new AvatarSprite(a);
	}

	public Image getImage(){
		return avatar.getImage();
	}
	
}
