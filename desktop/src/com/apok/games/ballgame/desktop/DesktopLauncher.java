package com.apok.games.ballgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.apok.games.ballgame.BallGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = BallGame.HEIGHT;
		config.width = BallGame.WIDTH;
		config.title = BallGame.TITLE;
		config.resizable = false;
		new LwjglApplication(new BallGame(), config);
	}
}
