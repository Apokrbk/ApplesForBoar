package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class GameplayScreen extends AbstractScreen{

    private Image background;
    private Player player;
    private Ball ball;
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
        addBall();
        player.update(input);
        ball.update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void addBall() {
        if(Gdx.input.isTouched() && input.y > 150)
        {
            ball = new Ball((int)(player.getX()+player.getWidth()/2), (int)(player.getY()),input);
            stage.addActor(ball);
        }
    }

}
