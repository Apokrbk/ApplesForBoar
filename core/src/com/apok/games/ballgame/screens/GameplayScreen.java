package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Boar;
import com.apok.games.ballgame.entities.Player;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.apok.games.ballgame.entities.levels.Level1;
import com.apok.games.ballgame.entities.levels.Level2;
import com.apok.games.ballgame.services.SoundService;
import com.apok.games.ballgame.ui.Animation;
import com.apok.games.ballgame.ui.MyFont;
import com.apok.games.ballgame.ui.ScoreLabel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.Stack;


public class GameplayScreen extends AbstractScreen{

    private Player player;
    private Ball ball;
    private Vector3 input;
    private Boar boar;
    private SetOfObstacles activeLevel;
    private SoundService soundService;
    private Animation countDown;
    private MyFont myFont;
    private int balls;

    GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        input = new Vector3(0,0,0);
        ball = new Ball();
        initBackground();
        initPlayer();
        initBoar();
        initScoreLabelBackground();
        initLevels();
        soundService = new SoundService();
        soundService.playBackgroundMusic();
        countDown = new Animation(new TextureRegion(new Texture("countdown.png")), 3, 3.4f);
        myFont = new MyFont();
        balls = 3;

    }

    private void initLevels() {
        activeLevel = new Level1();
        activeLevel.addObstaclesToStage(stage);
    }


    private void initScoreLabelBackground() {
        Image scoreLabelBackground = new Image(new Texture("scorelabel.png"));
        scoreLabelBackground.setPosition(10, 10);
        stage.addActor(scoreLabelBackground);
    }

    private void initBoar() {
        boar = new Boar();
        stage.addActor(boar);
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    private void initBackground() {
        Image background = new Image(new Texture("menubackground.png"));
        stage.addActor(background);
    }

    public void render(float delta)
    {
        super.render(delta);
        setInput();
        addBall();
        activeLevel.updateObstacles(ball);
        boar.update();
        player.update(input);
        if(isBallOnStage())
            ball.update(boar, this);
        stage.act();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
        spriteBatch.begin();
        if(!game.isPlaying())
        {
            countDown.update(delta);
            spriteBatch.draw(countDown.getFrame(),72,240);
        }
        myFont.drawScore(game.getScoreService().getPoints(), 105, 22, spriteBatch);
        spriteBatch.end();
        if(isGameover())
        {
            game.setScreen(new GameoverScreen(game, game.getScoreService().getPoints()));
            game.getScoreService().resetGameScore();
            game.setPlaying(false);
            soundService.stopBackgroundMusic();
        }
        System.out.println("LICZBA JABLEK: " + balls);

    }

    private void setInput() {
        input.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(input);
    }

    private void addBall() {
        if(isShootingAllowed())
        {
            balls--;
            ball = new Ball((int)(player.getX()),
                    (int)(player.getY()),
                    input);
            stage.addActor(ball);
        }
    }

    private boolean isGameover()
    {
        return (!isBallOnStage() && balls ==0);
    }

    private boolean isShootingAllowed()
    {
        return Gdx.input.isTouched() && input.y > 140 && !isBallOnStage() && game.isPlaying();
    }

    private boolean isBallOnStage()
    {
        return !(ball.getStage() == null);
    }

    public BallGame getGame() {
        return game;
    }

    public void changeToNextLevel() {
        balls = 3;
        soundService.playChrum();
        activeLevel.removeFromStage();
        activeLevel = activeLevel.nextLevel();
        activeLevel.addObstaclesToStage(stage);
    }

}
