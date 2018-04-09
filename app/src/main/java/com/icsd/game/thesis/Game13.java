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
    ArrayList<String> list;
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
            playPattern();
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
        list = new ArrayList<>();
    }


    protected void playPattern() throws IOException {
        list.clear();
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


        waitPlayer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("Debug", "check inside" + list.get(0) +" "+list.get(1));
                if (turn == 1) {
                    if (list.get(0).equals("do") && list.get(1).equals("re") && list.size() == 2) {
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
                    if (list.get(0).equals("re") && list.get(1).equals("mi") && list.get(2).equals("la") && list.size() == 3) {
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
                    if (list.get(0).equals("re") && list.get(1).equals("mi") && list.get(2).equals("la") && list.get(3).equals("do") && list.size() == 4) {
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
        list.add("do");

    }

    public void palyRe(View view) {
        re.start();
        list.add("re");
    }

    public void playMi(View view) {
        mi.start();
        list.add("mi");
    }

    public void playla(View view) {
        la.start();
        list.add("la");
    }

    public void onPrepared(MediaPlayer player) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
