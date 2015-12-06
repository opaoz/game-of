package ru.opa.pack.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import ru.opa.pack.Game;
import ru.opa.pack.enums.Actors;

public class MainScreen extends JFrame {
	private static final long serialVersionUID = 7818182669741279585L;
	private Game game;
	private MainPanel mainPanel;

	public MainScreen(Actors a) {
		game = new Game();
		mainPanel = new MainPanel(a);
		Game.a.setPanel(mainPanel);
		setTitle(Game.NAME + " of " + a.toString());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(game, BorderLayout.CENTER);
		add(mainPanel, BorderLayout.PAGE_END);

		pack();
		setResizable(false);
		setVisible(true);
		game.start();
	}
}
