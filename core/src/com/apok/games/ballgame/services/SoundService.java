package com.apok.games.ballgame.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Apok on 05.03.2017.
 */

public class SoundService {
    private Sound chrumSound;
    private Music backgroundMusic;

    public SoundService()
    {
        init();
    }

    private void init() {
        chrumSound = Gdx.audio.newSound(Gdx.files.internal("chrum.mp3"));
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundmusic.mp3"));
        backgroundMusic.setVolume(0.5f);
    }

    public void playChrum()
    {
        chrumSound.play();
    }

    public void playBackgroundMusic()
    {
        backgroundMusic.play();
        backgroundMusic.setLooping(true);
    }
}
