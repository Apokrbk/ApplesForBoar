package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Apok on 02.03.2017.
 */

public class GameplayScreen extends AbstractScreen{

    private Image background;

    public GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        background = new Image(new Texture("menubackground.png"));
        stage.addActor(background);
    }

    public void render(float delta)
    {
        super.render(delta);
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }
}
