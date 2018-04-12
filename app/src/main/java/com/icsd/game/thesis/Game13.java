package com.icsd.game.thesis;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
    ArrayList<String> checkList;
    ArrayList<String> patternList;
    Button buttonD;
    Button buttonR;
    Button buttonM;
    Button buttonL;
    Random r;
    int noteNumnber;
    int delay;


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

    protected void onPause(Bundle savedInstanceState) {
        super.onPause();
        la.pause();
        re.pause();
        mi.pause();
        dof.pause();
        Game13.this.finish();

    }

    protected void onStop(Bundle savedInstanceState) {
        super.onStop();
        la.pause();
        re.pause();
        mi.pause();
        dof.pause();
        Game13.this.finish();
    }


    protected void init() {
        buttonD = (Button) findViewById(id.dof);
        buttonR = (Button) findViewById(R.id.re);
        buttonM = (Button) findViewById(id.mi);
        buttonL = (Button) findViewById(R.id.la);
        mContext = this;
        this.turn = 0;
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
        checkList = new ArrayList<>();
        patternList = new ArrayList<>();
        r = new Random();
        delay = 800;
    }


    protected void playPattern() throws IOException {
        checkList.clear();
        patternList.clear();
        Log.e("Debug", "start playpattern");
        switch (turn) {
            case 0:
                Log.e("Debug", " playpattern case 0");
                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);
                    }
                }, 800);
                change.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        changeColor(noteNumnber);
                        checkPattern();
                    }
                }, 1400);
                break;
            case 1:
                Log.e("Debug", " playpattern case 1");
                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("Debug", " playpattern case 1 prwti nota");
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        Log.e("Debug", " playpattern case 1 prwti nota" + " >>" + noteNumnber);
                        playNote(noteNumnber);

                    }
                }, 800);
                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ;
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        Log.e("Debug", " playpattern case 1 deferi nota" + " >>" + noteNumnber);
                        playNote(noteNumnber);


                    }
                }, 1200);
                change.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        checkPattern();
                    }
                }, 1400);
                break;
            case 2:
                Log.e("Debug", " playpattern case 2");
                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 800);

                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 1200);

                handlerMi.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);
                    }
                }, 1600);
                change.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        checkPattern();
                    }
                }, 1800);
                break;
            case 3:
                Log.e("Debug", " playpattern case 3");
                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 800);

                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 1200);

                handlerMi.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 1600);
                handlerDof.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 2000);
                change.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        checkPattern();
                    }
                }, 2200);
                break;
            case 4:
                Log.e("Debug", " playpattern case 3");
                handlerLa.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 800);

                handlerRe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 1200);

                handlerMi.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 1600);
                handlerDof.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        noteNumnber = 10;
                        noteNumnber = r.nextInt(4);
                        playNote(noteNumnber);

                    }
                }, 2000);
                change.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        changeColor(noteNumnber);
                        checkPattern();
                    }
                }, 2200);
                break;


        }


    }

    protected void playNote(int noteNumber) {
        switch (noteNumber) {
            case 0:
                dof.start();
                patternList.add("do");
                buttonD.setBackgroundColor(Color.DKGRAY);
                break;
            case 1:
                re.start();
                patternList.add("re");
                buttonR.setBackgroundColor(Color.DKGRAY);
                break;
            case 2:
                mi.start();
                patternList.add("mi");
                buttonM.setBackgroundColor(Color.DKGRAY);
                break;
            case 3:
                la.start();
                patternList.add("la");
                buttonL.setBackgroundColor(Color.DKGRAY);
                break;
            case 10:
                break;
        }
    }

    protected void changeColor(int noteNumber) {
        switch (noteNumber) {
            case 0:
                buttonD.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_green_light));
                break;
            case 1:
                buttonR.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
                break;
            case 2:
                buttonM.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_orange_dark));
                break;
            case 3:
                buttonL.setBackgroundColor(mContext.getResources().getColor(android.R.color.holo_purple));
                break;
            case 10:
                break;
        }
    }

    protected void checkPattern() {


        waitPlayer.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (checkList.equals(patternList)) {

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
        }, 6000);

    }


    public void playDo(View view) {
        dof.start();
        checkList.add("do");

    }

    public void palyRe(View view) {
        re.start();
        checkList.add("re");
    }

    public void playMi(View view) {
        mi.start();
        checkList.add("mi");
    }

    public void playla(View view) {
        la.start();
        checkList.add("la");
    }

    public void onPrepared(MediaPlayer player) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
