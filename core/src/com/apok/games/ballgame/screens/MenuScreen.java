package com.apok.games.ballgame.screens;


import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;



public class MenuScreen extends AbstractScreen {

    private Image menuBackground;

    public MenuScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        menuBackground = new Image(new Texture("menubackground.png"));
        stage.addActor(menuBackground);
    }

    public void render(float delta)
    {
        super.render(delta);
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }
}