package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Apok on 02.03.2017.
 */

public class GameplayScreen extends AbstractScreen{

    private Image background;
    private Player player;

    public GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        background = new Image(new Texture("menubackground.png"));
        player = new Player();
        stage.addActor(background);
        stage.addActor(player);
    }

    public void render(float delta)
    {
        super.render(delta);
        updatePlayer();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void updatePlayer() {
        if(Gdx.input.isTouched() && Gdx.input.getY()>600 &&
                Gdx.input.getX()>player.getWidth()/2 &&
                Gdx.input.getX() < BallGame.WIDTH - player.getWidth()/2)
            player.setPosition(Gdx.input.getX()-player.getWidth()/2, player.getY());
        if(Gdx.input.getY() < 600)
        {
            Vector3 input = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(input);
            player.setRotation(player.countAngleToInput(input) + 270);
        }

    }
}
