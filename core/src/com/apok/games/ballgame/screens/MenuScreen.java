package com.apok.games.ballgame.screens;


import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.ui.IClickCallback;
import com.apok.games.ballgame.ui.PlayButton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;



public class MenuScreen extends AbstractScreen {

    public MenuScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        Image menuBackground = new Image(new Texture("menubackground.png"));
        PlayButton playButton = new PlayButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.setScreen(new GameplayScreen(game));
            }
        });
        stage.addActor(menuBackground);
        stage.addActor(playButton);
    }

    public void render(float delta)
    {
        super.render(delta);
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }
}