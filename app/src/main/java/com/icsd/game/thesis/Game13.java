package com.icsd.game.thesis;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import static com.icsd.game.thesis.R.*;

public class Game13 extends AppCompatActivity implements MediaPlayer.OnPreparedListener {
    private Integer turn;
    private MediaPlayer la ;
    private MediaPlayer mi ;
    private MediaPlayer re ;
    public Handler handlerMi;
    public Handler handlerLa;
    public Handler handlerRe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_game13);
        this.turn=1;
        la = MediaPlayer.create(this, raw.la);
        re = MediaPlayer.create(this, raw.re);
        mi = MediaPlayer.create(this, raw.mi);
        handlerLa = new Handler();
        handlerRe = new Handler();
        handlerMi = new Handler();
        try {
            playPattern();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    protected  void playPattern() throws IOException {

        switch(turn){
            case 1:

                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        la.start();
                    }
                }, 800);

                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        re.start();
                    }
                }, 1000);

                handlerMi.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mi.start();
                    }
                }, 1200);
                this.turn ++;
                break;
            case 2:

                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        re.start();
                    }
                }, 800);

                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mi.start();
                    }
                }, 1000);

                handlerMi.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        la.start();
                    }
                }, 1200);

            break;
        }

    }
    public  void onPrepared(MediaPlayer player){

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
