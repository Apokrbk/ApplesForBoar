package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public abstract class AbstractScreen implements Screen {
    protected BallGame game;
    protected Stage stage;
    protected OrthographicCamera camera;
    protected SpriteBatch spriteBatch;

    public AbstractScreen(BallGame game)
    {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(BallGame.WIDTH, BallGame.HEIGHT, camera));
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        init();
    }

    protected abstract void init();

    @Override
    public void resize(int width, int height) {

    }

    private void createCamera()
    {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, BallGame.WIDTH, BallGame.HEIGHT);
        camera.update();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }
}
