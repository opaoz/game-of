package ru.opa.pack.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import ru.opa.pack.entity.sprites.AvatarSprite;
import ru.opa.pack.enums.Actors;

public class ChoiseHero extends JFrame implements ActionListener {
	private static final long serialVersionUID = 5965666138363832825L;
	private JButton[] buttons = new JButton[8];

	public ChoiseHero() {
		setLayout(new FlowLayout());

		for (int i = 0; i < buttons.length; i++)
			buttons[i] = new JButton();

		buttons[0].setIcon(new AvatarSprite(Actors.Necropoth));
		buttons[1].setIcon(new AvatarSprite(Actors.Arina));
		buttons[2].setIcon(new AvatarSprite(Actors.Azazel));
		buttons[3].setIcon(new AvatarSprite(Actors.Pirat));
		buttons[4].setIcon(new AvatarSprite(Actors.Darkside));
		buttons[5].setIcon(new AvatarSprite(Actors.Naga));
		buttons[6].setIcon(new AvatarSprite(Actors.Knight));
		buttons[7].setIcon(new AvatarSprite(Actors.DoomKnight));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setPreferredSize(new Dimension(96, 96));
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
		
		setTitle("Choise your hero");
		pack();
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		new MainScreen(
				((AvatarSprite) ((JButton) event.getSource()).getIcon())
						.getName());
		this.dispose();
	}
}
