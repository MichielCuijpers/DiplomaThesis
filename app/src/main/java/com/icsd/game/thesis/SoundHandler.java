package com.icsd.game.thesis;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.io.IOException;

public class SoundHandler {
    private MediaPlayer sound;
    private final int okSoundId;
    private final int wrongSoundId;
    private SoundPool soundPool;
    int coreSound;
    int falsSound;

    public MediaPlayer getSound() {
        return sound;
    }

    private final Context cont;


    public SoundHandler(Context cont) {
        sound = new MediaPlayer();
        this.cont = cont;
        okSoundId = cont.getResources().getIdentifier("correct_sound", "raw", cont.getPackageName());
        wrongSoundId = cont.getResources().getIdentifier("wrong_sound", "raw", cont.getPackageName());
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        coreSound = soundPool.load(cont, okSoundId, 1);
        falsSound = soundPool.load(cont, wrongSoundId, 1);

    }

    public void playOkSound() {

        sound = MediaPlayer.create(cont, okSoundId);
        sound.start();

    }

    public void playWrongSound() {
        sound = MediaPlayer.create(cont, wrongSoundId);
        sound.start();

    }

    public void playOkSoundPool() {
        //noinspection deprecation

        soundPool.play(coreSound, 1, 1, 0, 0, 1);
    }

    public void playWrongPool() {
        //noinspection deprecation

        soundPool.play(falsSound, 1, 1, 0, 0, 1);
    }

    public void stopSound() {
        sound.stop();
    }

}
