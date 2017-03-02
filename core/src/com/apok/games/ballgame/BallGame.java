package com.apok.games.ballgame;

import com.apok.games.ballgame.screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;



public class BallGame extends Game{

	public static final int WIDTH = 432;
	public static final int HEIGHT = 768;
	public static final String TITLE = "Ball Game";

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

}
