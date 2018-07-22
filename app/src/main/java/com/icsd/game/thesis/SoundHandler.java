package com.icsd.game.thesis;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

public class SoundHandler {
    private MediaPlayer sound;
    private int okSoundId;
    private int wrongSoundId;

    Context cont;


    public SoundHandler(Context cont) {
        sound = new MediaPlayer();
        this.cont = cont;
        okSoundId = cont.getResources().getIdentifier("correct_sound", "raw", cont.getPackageName());
        wrongSoundId = cont.getResources().getIdentifier("wrong_sound", "raw", cont.getPackageName());
    }

    public void playOkSound() {

        sound = MediaPlayer.create(cont, okSoundId);
        sound.start();
    }

    public void playWrongSound() {
        sound = MediaPlayer.create(cont, wrongSoundId);
        sound.start();
    }

    public void stopSound() {
        sound.stop();
    }

    public void prepareSound() {
        try {

            sound.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
