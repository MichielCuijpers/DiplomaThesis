package com.icsd.game.thesis;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game13 extends AppCompatActivity {
    Context context = this;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game13);
        mp = MediaPlayer.create(context, R.raw.la);
        mp.setVolume(10,600);
        final Button b = (Button) findViewById(R.id.button21);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.reset();
                        mp.release();
                        mp = MediaPlayer.create(context, R.raw.la);
                    } mp.start();
                } catch(Exception e) { e.printStackTrace(); }
            }
        });
    }
}
