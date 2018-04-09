package com.icsd.game.thesis;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static com.icsd.game.thesis.R.*;

public class Game13 extends AppCompatActivity implements MediaPlayer.OnPreparedListener {
    private static Context mContext;
    private Integer turn;
    private MediaPlayer la;
    private MediaPlayer mi;
    private MediaPlayer re;
    private MediaPlayer dof;
    public Handler handlerMi;
    public Handler handlerLa;
    public Handler handlerRe;
    public Handler handlerDof;
    public Handler change;
    public Handler waitPlayer;
    public Boolean check = true;
    public Boolean check2 = false;
    Boolean[] array;
    Button buttonD;
    Button buttonR;
    Button buttonM;
    Button buttonL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_game13);
        init();

        try {
            gamePlay();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    protected void init() {
        buttonD = (Button) findViewById(id.dof);
        buttonR = (Button) findViewById(R.id.re);
        buttonM = (Button) findViewById(id.mi);
        buttonL = (Button) findViewById(R.id.la);
        mContext = this;
        this.turn = 1;
        la = MediaPlayer.create(this, raw.la);
        re = MediaPlayer.create(this, raw.re);
        mi = MediaPlayer.create(this, raw.mi);
        dof = MediaPlayer.create(this, raw.dof);
        handlerLa = new Handler();
        handlerRe = new Handler();
        handlerMi = new Handler();
        handlerDof = new Handler();
        change = new Handler();
        waitPlayer = new Handler();

        array = new Boolean[4];
        array[0] = false;
        array[1] = false;
        array[2] = false;
        array[3] = false;

        //  list = (ArrayList<Boolean>) Arrays.asList(false, false, false, false);
    }

    protected void gamePlay() throws IOException {

        Log.e("Debug", "pre-playpattern ");

        playPattern();


    }

    protected void playPattern() throws IOException {
        Log.e("Debug", "start playpattern");
        switch (turn) {
            case 1:
                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dof.start();
                        buttonD.setBackgroundColor(Color.DKGRAY);
                    }
                }, 800);
                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonD.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_green_light));
                        re.start();
                        buttonR.setBackgroundColor(Color.DKGRAY);

                    }
                }, 1200);
                change.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonR.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                        checkPattern();
                    }
                }, 1400);
                break;
            case 2:

                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        re.start();
                        buttonR.setBackgroundColor(Color.DKGRAY);
                    }
                }, 800);

                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonR.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                        mi.start();
                        buttonM.setBackgroundColor(Color.DKGRAY);
                    }
                }, 1200);

                handlerMi.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonM.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_orange_dark));
                        la.start();
                        buttonL.setBackgroundColor(Color.DKGRAY);
                    }
                }, 1600);
                change.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonL.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_purple));
                        checkPattern();
                    }
                }, 1800);
                break;
            case 3:
                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        re.start();
                        buttonR.setBackgroundColor(Color.DKGRAY);
                    }
                }, 800);

                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonR.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                        mi.start();
                        buttonM.setBackgroundColor(Color.DKGRAY);
                    }
                }, 1200);

                handlerMi.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonM.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_orange_dark));
                        la.start();
                        buttonL.setBackgroundColor(Color.DKGRAY);
                    }
                }, 1600);
                handlerDof.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonL.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_purple));
                        dof.start();
                        buttonD.setBackgroundColor(Color.DKGRAY);
                    }
                }, 2000);
                change.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        buttonD.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_green_light));
                        checkPattern();
                    }
                }, 2200);
                break;

        }

    }

    protected void checkPattern() {

        Log.e("Debug", "check inside");
        waitPlayer.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (turn == 1) {
                    if (array[0] && array[1] && !array[2] && !array[3]) {
                        Log.e("Debug", "Correct");
                        turn++;
                        try {
                            playPattern();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e("Debug", "InCorrect");
                        try {
                            playPattern();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (turn == 2) {
                    if (!array[0] && array[1] && array[2] && array[3]) {
                        Log.e("Debug", "Correct");
                        turn++;
                        try {
                            playPattern();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e("Debug", "InCorrect");
                        try {
                            playPattern();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                } else if (turn == 3) {
                    if (array[0] && array[1] && array[2] && array[3]) {
                        Log.e("Debug", "Correct");
                        turn++;
                        try {
                            playPattern();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e("Debug", "InCorrect");
                        try {
                            playPattern();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        }, 6000);

    }


    public void playDo(View view) {
        dof.start();
        this.array[0] = true;

    }

    public void palyRe(View view) {
        re.start();
        this.array[1] = true;
    }

    public void playMi(View view) {
        mi.start();
        this.array[2] = true;
    }

    public void playla(View view) {
        la.start();
        this.array[3] = true;
    }

    public void onPrepared(MediaPlayer player) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
