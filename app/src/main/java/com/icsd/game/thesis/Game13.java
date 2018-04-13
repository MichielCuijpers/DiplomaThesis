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
    protected Integer turn;
    private MediaPlayer la;
    private MediaPlayer mi;
    private MediaPlayer re;
    private MediaPlayer dof;
    private Handler handlerMi;
    private Handler handlerLa;
    private Handler handlerRe;
    private Handler handlerDof;
    private Handler change;
    private Handler change2;
    private Handler waitPlayer;
    private ArrayList<String> checkList;
    private ArrayList<String> patternList;
    protected int checkRand;
    private Button buttonD;
    private Button buttonR;
    private Button buttonM;
    private Button buttonL;
    private Random r;
    private int noteNumnber;
    protected int delay;
    private Runnable run1;
    private Runnable run2;
    private Runnable run3;
    private Runnable run4;
    private Runnable runChange1;
    private Runnable runChange2;
    private Runnable runCheck;


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

    public void onPause() {
        super.onPause();
        la.pause();
        re.pause();
        mi.pause();
        dof.pause();
        handlerLa.removeCallbacks(run1);
        handlerDof.removeCallbacks(run3);
        handlerRe.removeCallbacks(run4);
        change.removeCallbacks(runChange1);
        change2.removeCallbacks(runChange2);
        waitPlayer.removeCallbacks(runCheck);


    }

    public void onStop() {
        super.onStop();
        la.pause();
        re.pause();
        mi.pause();
        dof.pause();
        this.turn = 10;
        handlerLa.removeCallbacks(run1);
        handlerDof.removeCallbacks(run3);
        handlerRe.removeCallbacks(run4);
        change.removeCallbacks(runChange1);
        change2.removeCallbacks(runChange2);
        waitPlayer.removeCallbacks(runCheck);

    }


    
    protected void initRunnables() {
        runCheck = new Runnable() {
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
        };
        run1 = new Runnable() {
            @Override
            public void run() {

                changeColor(noteNumnber);
                do {
                    noteNumnber = r.nextInt(4);
                } while (noteNumnber == checkRand);
                checkRand = noteNumnber;
                playNote(noteNumnber);
            }
        };
        run2 = new Runnable() {
            @Override
            public void run() {

                changeColor(noteNumnber);
                do {
                    noteNumnber = r.nextInt(4);
                } while (noteNumnber == checkRand);
                checkRand = noteNumnber;
                playNote(noteNumnber);
            }
        };
        run3 = new Runnable() {
            @Override
            public void run() {

                changeColor(noteNumnber);
                do {
                    noteNumnber = r.nextInt(4);
                } while (noteNumnber == checkRand);
                checkRand = noteNumnber;
                playNote(noteNumnber);
            }
        };
        run4 = new Runnable() {
            @Override
            public void run() {

                changeColor(noteNumnber);
                do {
                    noteNumnber = r.nextInt(4);
                } while (noteNumnber == checkRand);
                checkRand = noteNumnber;
                playNote(noteNumnber);
            }
        };
        runChange1 = new Runnable() {
            @Override
            public void run() {
                changeColor(noteNumnber);
                checkPattern();
            }
        };
        runChange2 = new Runnable() {
            @Override
            public void run() {
                changeColor(noteNumnber);
                checkPattern();
            }
        };


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
        change2 = new Handler();
        change = new Handler();
        waitPlayer = new Handler();
        checkList = new ArrayList<>();
        patternList = new ArrayList<>();
        r = new Random();
        delay = 800;
        initRunnables();

    }


    protected void playPattern() throws IOException {
        checkList.clear();
        patternList.clear();
        Log.e("Debug", "start playpattern");
        switch (turn) {
            case 0:
                Log.e("Debug", " playpattern case 0");
                handlerLa.postDelayed(run1, 800);
                change.postDelayed(runChange1, 1200);
                break;
            case 1:
                handlerDof.postDelayed(run3, 800);
                handlerRe.postDelayed(run2, 1200);
                change2.postDelayed(runChange2, 1400);
                break;
            case 2:
                handlerDof.postDelayed(run3, 800);
                handlerRe.postDelayed(run4, 1200);
                handlerLa.postDelayed(run1, 1400);
                change2.postDelayed(runChange2, 1600);
                break;
            case 3:
                handlerDof.postDelayed(run3, 800);
                handlerRe.postDelayed(run4, 1200);
                handlerLa.postDelayed(run1, 1400);
                handlerMi.postDelayed(run2, 1600);
                change2.postDelayed(runChange2, 1800);

                break;
            case 4:
                handlerDof.postDelayed(run3, 800);
                handlerRe.postDelayed(run4, 1200);
                handlerLa.postDelayed(run1, 1400);
                handlerMi.postDelayed(run2, 1600);
                change2.postDelayed(runChange2, 1800);

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

        waitPlayer.postDelayed(runCheck, 4000);

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
