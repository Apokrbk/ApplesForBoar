package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
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
    private Vector3 input;

    public GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        background = new Image(new Texture("menubackground.png"));
        player = new Player();
        stage.addActor(background);
        stage.addActor(player);
        input = new Vector3(0,0,0);
    }

    public void render(float delta)
    {
        super.render(delta);
        input.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(input);
        updatePlayer();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void updatePlayer() {
        Rectangle playerMovement = new Rectangle(0+player.getWidth()/2,0, BallGame.WIDTH - player.getWidth()/2, 200);
        if(Gdx.input.isTouched() && playerMovement.contains(input.x, input.y))
            player.setPosition(input.x-player.getWidth()/2, player.getY());
        if(input.y > 200)
        {
            player.setRotation(player.countAngleToInput(input) + 270);
        }

    }
}
