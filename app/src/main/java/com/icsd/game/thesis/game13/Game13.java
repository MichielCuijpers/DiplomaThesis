package com.icsd.game.thesis.game13;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.icsd.game.thesis.common_activities.LoginActivity;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.ArrayList;

import java.util.Random;

import static com.icsd.game.thesis.R.id;
import static com.icsd.game.thesis.R.layout;
import static com.icsd.game.thesis.R.raw;

public class
Game13 extends AppCompatActivity implements MediaPlayer.OnPreparedListener {


    private Integer turn;
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
    private int checkRand;
    private Button buttonD;
    private Button buttonR;
    private Button buttonM;
    private Button buttonL;
    private Random r;
    private int noteNumnber;
    private int delay;
    private Runnable run1;
    private Runnable run2;
    private Runnable run3;
    private Runnable run4;
    private Runnable runChange1;
    private Runnable runChange2;
    private Runnable runCheck;
    private Session curSession;
    private DatabaseHandler dbHandler;
    private PopUpWindow popUpWindow;
    private int tempTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(layout.game13_prototype);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        init();
        curSession = new Session(LoginActivity.getUser().getUsername(), 13);
        curSession.setTimeStart(System.currentTimeMillis() / 1000);
        playPattern();


    }

    public void onPause() {
        super.onPause();


    }

    public void onStop() {
        super.onStop();
        killAll();
    }

    public void onPrepared(MediaPlayer player) {

    }

    private void initRunnables() {
        final Context mContext;
        runCheck = new Runnable() {
            @Override
            public void run() {
                if (checkList.equals(patternList)) {
                    popUpWindow.showPopUp(getResources().getString(R.string.correct_answer2));

                    popUpWindow.getmPopupWindow().setOnDismissListener(new PopupWindow.OnDismissListener() {

                        @Override
                        public void onDismiss() {
                            playPattern();
                        }
                    });
                    curSession.setScore(turn);
                    curSession.setStage(turn);
                    turn++;
                    if (turn == 10) {
                        popUpWindow.showPopUp(getResources().getString(R.string.end_game_congrats2));
                        saveSessionToDB();
                        killAll();
                    } else {

                    }

                } else {
                    popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer2));

                    popUpWindow.getmPopupWindow().setOnDismissListener(new PopupWindow.OnDismissListener() {

                        @Override
                        public void onDismiss() {

                            playPattern();
                        }
                    });
                    curSession.setFails(curSession.getFails() + 1);


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

    private void init() {
        buttonD = findViewById(id.dof);
        buttonR = findViewById(id.re);
        buttonM = findViewById(id.mi);
        buttonL = findViewById(id.la);

        this.turn = 0;
        la = MediaPlayer.create(this, raw.la);
        re = MediaPlayer.create(this, raw.re);
        mi = MediaPlayer.create(this, raw.mi);
        dof = MediaPlayer.create(this, raw.dof);
        popUpWindow = new PopUpWindow(this, this);
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

    private void playPattern() {
        checkList.clear();
        patternList.clear();
        switch (turn) {
            case 0:
                handlerLa.postDelayed(run1, 1100);
                change.postDelayed(runChange1, 1500);
                break;
            case 1:
                handlerLa.postDelayed(run1, 1100);
                change.postDelayed(runChange1, 1500);
                break;
            case 2:
                handlerLa.postDelayed(run1, 1100);
                change.postDelayed(runChange1, 1500);
                break;
            case 3:
                handlerDof.postDelayed(run3, 1100);
                handlerRe.postDelayed(run2, 1700);
                change2.postDelayed(runChange2, 1700);
                break;
            case 4:
                handlerDof.postDelayed(run3, 1100);
                handlerDof.postDelayed(run3, 1700);
                change2.postDelayed(runChange2, 1900);
                break;
            case 5:
                handlerDof.postDelayed(run3, 1100);
                handlerRe.postDelayed(run4, 1700);
                handlerLa.postDelayed(run1, 1900);
                change2.postDelayed(runChange2, 2100);

                break;
            case 6:
                handlerDof.postDelayed(run3, 1100);
                handlerRe.postDelayed(run4, 1700);
                handlerLa.postDelayed(run1, 1900);
                change2.postDelayed(runChange2, 2100);
                break;
            case 7:
                handlerDof.postDelayed(run3, 1100);
                handlerRe.postDelayed(run4, 1700);
                handlerLa.postDelayed(run1, 1900);
                handlerMi.postDelayed(run2, 2100);
                change2.postDelayed(runChange2, 2300);
                break;
            case 8:
                handlerDof.postDelayed(run3, 1100);
                handlerRe.postDelayed(run4, 1700);
                handlerLa.postDelayed(run1, 1900);
                handlerMi.postDelayed(run2, 2100);
                change2.postDelayed(runChange2, 2300);
                break;

        }


    }

    private void playNote(int noteNumber) {
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

    private void changeColor(int noteNumber) {
        final Context mContext;
        mContext = this;
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

    private void checkPattern() {

        waitPlayer.postDelayed(runCheck, 3000);

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

    private void killAll() {

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
        dbHandler.addSessionToDB(this.curSession);
        curSession.setTimeEnd(System.currentTimeMillis() / 1000);
    }

    private void saveSessionToDB() {
        curSession.setTimeEnd(System.currentTimeMillis() / 1000);
        dbHandler.addSessionToDB(this.curSession);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
