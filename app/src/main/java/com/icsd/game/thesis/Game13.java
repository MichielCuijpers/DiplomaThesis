package com.icsd.game.thesis;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

import java.io.IOException;

public class Game13 extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game13);
        mp = MediaPlayer.create(this, R.raw.re);

    }

    public void playSound(View view) {


        mp.start();
    }
}
