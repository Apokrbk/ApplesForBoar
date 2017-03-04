package com.apok.games.ballgame;

import com.apok.games.ballgame.screens.MenuScreen;
import com.badlogic.gdx.Game;


public class BallGame extends Game{

	public static final int WIDTH = 432;
	public static final int HEIGHT = 768;
	public static final String TITLE = "Ball Game";

	public int getScore() {
		return score;
	}

	private int score;

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

	public void addPoint()
	{
		score++;
	}

}
