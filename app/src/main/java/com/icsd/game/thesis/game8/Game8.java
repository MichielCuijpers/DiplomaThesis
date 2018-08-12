package com.icsd.game.thesis.game8;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.icsd.game.thesis.common_activities.LoginActivity;
import com.icsd.game.thesis.common_activities.Menu;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.SoundHandler;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game8 extends AppCompatActivity {

    private BallView ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9;
    private TextView scoreView;
    private int delay;
    private Handler handler1, handler2;
    private int score;
    private ArrayList<Runnable> runs;
    private Session curSession;
    private DatabaseHandler dbHandler;
    private ObjectAnimator animation1, animation2, animation3, animation4, animation5, animation6, animation7, animation8, animation9;
    private PopUpWindow popUpWindow;
    private ArrayList<BallView> balls;
    private SoundHandler soundHandler;
    private int turn;
    private int miniTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game8);
        init();
        gameplay();

    }

    public void onPause() {
        super.onPause();

    }

    public void onStop() {
        super.onStop();
        endGame();

    }

    private void initGui() {
        ball1 = findViewById(R.id.ball1);
        ball2 = findViewById(R.id.ball2);
        ball3 = findViewById(R.id.ball3);
        ball4 = findViewById(R.id.ball4);
        ball5 = findViewById(R.id.ball5);
        ball6 = findViewById(R.id.ball6);
        ball7 = findViewById(R.id.ball7);
        ball8 = findViewById(R.id.ball8);
        ball9 = findViewById(R.id.ball9);

        scoreView = findViewById(R.id.scoreView);

        balls = new ArrayList<>();
        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
        balls.add(ball4);
        balls.add(ball5);
        balls.add(ball6);
        balls.add(ball7);
        balls.add(ball8);
        balls.add(ball9);

        hideBalls();


    }


    private void init() {
        initRunnables();
        initGui();
        initGameplay();
        initAnimations();

        dbHandler = new DatabaseHandler(this.getApplicationContext());
        curSession = new Session(LoginActivity.getUser().getUsername(), 8);
        curSession.setTimeStart(System.currentTimeMillis() / 1000);
        popUpWindow = new PopUpWindow(this, this);


    }

    private void initAnimations() {
        animation1 = ObjectAnimator.ofFloat(ball1, "translationY", 900f);
        animation2 = ObjectAnimator.ofFloat(ball2, "translationY", 900f);
        animation3 = ObjectAnimator.ofFloat(ball3, "translationY", 900f);
        animation4 = ObjectAnimator.ofFloat(ball4, "translationY", 900f);
        animation5 = ObjectAnimator.ofFloat(ball5, "translationY", 900f);
        animation6 = ObjectAnimator.ofFloat(ball6, "translationY", 900f);
        animation7 = ObjectAnimator.ofFloat(ball7, "translationY", 900f);
        animation8 = ObjectAnimator.ofFloat(ball8, "translationY", 900f);
        animation9 = ObjectAnimator.ofFloat(ball9, "translationY", 900f);
    }

    private void initGameplay() {
        score = 0;
        this.delay = 100;
        turn = 1;
        miniTurn = 0;
    }

    private void initRunnables() {
        Runnable run1 = new Runnable() {
            @Override
            public void run() {

                animation1.setDuration(4000);
                ball1.setVisibility(View.VISIBLE);
                animation1.start();


                animation4.setDuration(4000);
                ball4.setVisibility(View.VISIBLE);
                animation4.start();
                animation7.setDuration(4000);

                ball7.setVisibility(View.VISIBLE);
                animation7.start();
                delay = delay + 400;

                gameplay();


            }
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {

                animation3.setDuration(4000);
                ball3.setVisibility(View.VISIBLE);
                animation3.start();


                animation6.setDuration(4000);
                ball6.setVisibility(View.VISIBLE);
                animation6.start();


                animation9.setDuration(4000);
                ball9.setVisibility(View.VISIBLE);
                animation9.start();
                delay = delay + 500;

                gameplay();


            }
        };

        Runnable run3 = new Runnable() {
            @Override
            public void run() {

                animation5.setDuration(4000);
                ball5.setVisibility(View.VISIBLE);
                animation5.start();

                animation2.setDuration(4000);
                ball2.setVisibility(View.VISIBLE);
                animation2.start();

                animation8.setDuration(4000);
                ball8.setVisibility(View.VISIBLE);
                animation8.start();
                delay = delay + 600;

                gameplay();


            }
        };
        handler1 = new Handler();
        handler2 = new Handler();

        runs = new ArrayList<>();
        runs.add(run1);
        runs.add(run2);
        runs.add(run3);


    }

    private void gameplay() {
        Collections.shuffle(runs);
        changeTurn();
        switch (turn) {
            case 1:
                turn1();
                break;
            case 2:
                turn2and3();
                break;
            case 3:
                popUpWindow.getmPopupWindow().dismiss();
                turn2and3();
                break;
            case 4:
                endGame();
                break;
        }

    }

    private void turn1() {
        Random r = new Random();
        soundHandler = new SoundHandler(getApplicationContext());
        handler1.postDelayed(runs.get(r.nextInt(3)), delay);
    }

    private void turn2and3() {
        final Random r = new Random();
        soundHandler = new SoundHandler(getApplicationContext());
        makeBallsGreenAgain();
        someBallsToRed();
        if (miniTurn == 1) {
            hideBalls();
            if (turn == 2) {
                popUpWindow.showPopUp("Now,Dont touch the RED balls");
            } else {
                popUpWindow.showPopUp("Now,Dont touch the GREEN balls");
            }

            popUpWindow.getmPopupWindow().setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    delay = 100;
                    handler1.postDelayed(runs.get(r.nextInt(3)), delay);
                }
            });
        } else {
            handler1.postDelayed(runs.get(r.nextInt(3)), delay);
        }
    }

    private void changeTurn() {
        miniTurn++;

        if (miniTurn == 8) {
            turn++;
            miniTurn = 1;
        }
    }

    private void makeBallsGreenAgain() {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).setColor(Color.GREEN);
        }
    }

    private void someBallsToRed() {
        Random r = new Random();
        balls.get(r.nextInt(6)).setColor(Color.RED);
        balls.get(r.nextInt(6)).setColor(Color.RED);
        balls.get(r.nextInt(6)).setColor(Color.RED);
        balls.get(r.nextInt(6)).setColor(Color.RED);
        if (turn == 3) {
            balls.get(r.nextInt(6)).setColor(Color.RED);
            balls.get(r.nextInt(6)).setColor(Color.RED);
        }
    }

    private void hideBalls() {
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).setVisibility(View.INVISIBLE);
        }
    }

    private void endGame() {

        curSession.setTimeEnd(System.currentTimeMillis() / 1000);
        dbHandler.addSessionToDB(this.curSession);
        handler1.removeCallbacks(null);
        handler2.removeCallbacks(null);
        dbHandler.close();
        Intent c = new Intent(this, Menu.class);
        startActivity(c);


    }

    private void updateScore(BallView ball) {
        if (turn == 2 || turn == 1) {
            if (ball.getPaint().getColor() == Color.GREEN) {
                soundHandler.playOkSoundPool();
                score++;
                scoreView.setText("Score:" + score);
                this.curSession.setScore(this.score);

            } else {
                soundHandler.playWrongPool();
                score--;
                scoreView.setText("Score:" + score);
                this.curSession.setScore(this.score);

            }
        }
        if (turn == 3) {
            if (ball.getPaint().getColor() == Color.GREEN) {
                soundHandler.playWrongSound();
                score--;
                scoreView.setText("Score:" + score);
                this.curSession.setScore(this.score);

            } else {
                soundHandler.playOkSound();
                score++;
                scoreView.setText("Score:" + score);
                this.curSession.setScore(this.score);

            }
        }


    }


    //OnClick Methods
    public void ball8OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        scoreView.setText("Score:" + this.score);
        updateScore(((BallView) view));

    }

    public void ball3OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        scoreView.setText("Score:" + this.score);
        updateScore((BallView) view);
    }

    public void ball6OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        scoreView.setText("Score:" + this.score);
        updateScore((BallView) view);
    }

    public void ball5OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        updateScore((BallView) view);
    }

    public void ball1OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        updateScore((BallView) view);

    }

    public void ball2OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        updateScore((BallView) view);

    }

    public void ball7OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        updateScore((BallView) view);

    }

    public void ball4OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        updateScore((BallView) view);

    }

}
