package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Boar;
import com.apok.games.ballgame.entities.Player;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.apok.games.ballgame.entities.levels.Level1;
import com.apok.games.ballgame.services.SoundService;
import com.apok.games.ballgame.ui.Animation;
import com.apok.games.ballgame.ui.MyFont;
import com.apok.games.ballgame.ui.QuantityOfBalls;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;



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
    private QuantityOfBalls quantityOfBalls;

    GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        initInput();
        initBall();
        initBackground();
        initPlayer();
        initBoar();
        initScoreLabelBackground();
        initLevels();
        initSoundService();
        initCountDown();
        initMyFont();
        initQuantityOfBalls();

    }

    private void initQuantityOfBalls() {
        balls = 3;
        quantityOfBalls = new QuantityOfBalls();
    }

    private void initMyFont() {
        myFont = new MyFont();
    }

    private void initCountDown() {
        countDown = new Animation(new TextureRegion(new Texture("countdown.png")), 3, 3.4f);
    }

    private void initInput() {
        input = new Vector3(0,0,0);
    }

    private void initBall() {
        ball = new Ball();
    }

    private void initSoundService() {
        soundService = new SoundService();
        soundService.playBackgroundMusic();
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
        addBallWhenPlayerClicksTheScreen();
        updateEntities();
        drawWorld(delta);
        if(isGameOver())
            gameOver();
    }

    private void drawWorld(float delta) {
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
        spriteBatch.begin();
        drawCountdown(delta);
        myFont.drawScore(game.getScoreService().getPoints(), 105, 22, spriteBatch);
        quantityOfBalls.drawBalls(spriteBatch, balls);
        spriteBatch.end();
    }

    private void drawCountdown(float delta) {
        if(!game.isPlaying())
        {
            countDown.update(delta);
            spriteBatch.draw(countDown.getFrame(),72,240);
        }
    }

    private void updateEntities() {
        activeLevel.updateObstacles(ball);
        boar.update();
        player.update(input);
        if(isBallOnStage())
            ball.update(boar, this);
        stage.act();
    }

    private void gameOver() {
        game.getScoreService().setHighscore();
        game.setScreen(new GameoverScreen(game, game.getScoreService().getPoints()));
        game.getScoreService().resetGameScore();
        game.setPlaying(false);
        soundService.stopBackgroundMusic();
        soundService.playGameoverSound();
    }

    private void setInput() {
        input.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(input);
    }

    private void addBallWhenPlayerClicksTheScreen() {
        if(isShootingAllowed())
        {
            balls--;
            ball = new Ball((int)(player.getX()),
                    (int)(player.getY()),
                    input);
            stage.addActor(ball);
        }
    }

    private boolean isGameOver()
    {
        return (!isBallOnStage() && balls ==0);
    }

    private boolean isShootingAllowed()
    {
        return Gdx.input.isTouched() && input.y > 160 && !isBallOnStage() && game.isPlaying();
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
