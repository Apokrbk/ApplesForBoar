package com.apok.games.ballgame;

import com.apok.games.ballgame.screens.MenuScreen;
import com.apok.games.ballgame.services.ScoreService;
import com.badlogic.gdx.Game;


public class BallGame extends Game{

	public static final int WIDTH = 432;
	public static final int HEIGHT = 768;
	public static final String TITLE = "Ball Game";
	private boolean playing = false;
	private ScoreService scoreService;

	public ScoreService getScoreService() {
		return scoreService;
	}

	@Override
	public void create () {
		scoreService = new ScoreService();
		setScreen(new MenuScreen(this));
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
}
