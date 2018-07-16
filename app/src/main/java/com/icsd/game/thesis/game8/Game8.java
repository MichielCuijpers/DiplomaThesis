package com.icsd.game.thesis.game8;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.Menu2;
import com.icsd.game.thesis.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game8 extends AppCompatActivity {

    private View ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9;
    private TextView scoreView;
    private ArrayList<View> balls;
    private ConstraintLayout lo;
    private int delay;
    private Handler handler1, handler2;
    private Runnable run1;
    private Runnable run2;
    private Runnable run3;
    private int crt;
    private int score;
    private MediaPlayer sound;
    private ArrayList<Runnable> runs;

    ObjectAnimator animation1, animation2, animation3, animation4, animation5, animation6, animation7, animation8, animation9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game8);
        initRunnables();
        init();
        gameplay(crt);

    }

    private void initGui() {
        ball1 = (View) findViewById(R.id.ball1);
        ball2 = (View) findViewById(R.id.ball2);
        ball3 = (View) findViewById(R.id.ball3);
        ball4 = (View) findViewById(R.id.ball4);
        ball5 = (View) findViewById(R.id.ball5);
        ball6 = (View) findViewById(R.id.ball6);
        ball7 = (View) findViewById(R.id.ball7);
        ball8 = (View) findViewById(R.id.ball8);
        ball9 = (View) findViewById(R.id.ball9);
        scoreView = (TextView) findViewById(R.id.scoreView);

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

//        ball1.setVisibility(View.INVISIBLE);
//        for (int i = 1; i < balls.size(); i++) {
//            Log.e("DEBUGMY",balls.get(i).toString()+"");
//            balls.get(i).setVisibility(View.INVISIBLE);
//}
//
    }

    private void init() {
        initGui();
        initRunnables();
        initGameplay();
        initAnimations();


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
        sound = MediaPlayer.create(this, R.raw.ballsound1);
        crt = 0;
        score = 0;
        this.delay = 100;
    }

    private void initRunnables() {
        run1 = new Runnable() {
            @Override
            public void run() {
                Log.e("YODEBUG", "run1");


                animation1.setDuration(4000);
                ball1.setVisibility(View.VISIBLE);
                animation1.start();


                animation4.setDuration(4000);
                ball4.setVisibility(View.VISIBLE);
                animation4.start();
                animation7.setDuration(4000);

                ball7.setVisibility(View.VISIBLE);
                animation7.start();
                delay = delay + 3000;
                gameplay(crt++);


            }
        };

        run2 = new Runnable() {
            @Override
            public void run() {
                Log.e("YODEBUG", "run2");


                animation3.setDuration(4000);
                ball3.setVisibility(View.VISIBLE);
                animation3.start();


                animation6.setDuration(4000);
                ball6.setVisibility(View.VISIBLE);
                animation6.start();


                animation9.setDuration(4000);
                ball9.setVisibility(View.VISIBLE);
                animation9.start();
                delay = delay + 3000;
                gameplay(crt++);
            }
        };

        run3 = new Runnable() {
            @Override
            public void run() {
                Log.e("YODEBUG", "run3");

                animation5.setDuration(4000);
                ball5.setVisibility(View.VISIBLE);
                animation5.start();
                delay = delay + 3000;

                animation2.setDuration(4000);
                ball2.setVisibility(View.VISIBLE);
                animation2.start();

                animation8.setDuration(4000);
                ball8.setVisibility(View.VISIBLE);
                animation8.start();

                gameplay(crt++);


            }
        };
        handler1 = new Handler();
        handler2 = new Handler();

        runs = new ArrayList<>();
        runs.add(run1);
        runs.add(run2);
        runs.add(run3);


    }

    private void gameplay(int turn) {
        startTurn(turn);

    }

    private void startTurn(int turn) {


        Collections.shuffle(runs);
        Random r = new Random();
        handler1.postDelayed(runs.get(r.nextInt(3)), delay);
        delay = delay - 2000;

    }

    private void checkForEndGame() {
        if (this.score == 20) {
            killAll();
            Toast.makeText(this, "Congratulations. You WON ! ", Toast.LENGTH_LONG).show();
            Intent c = new Intent(this, Menu.class);
            startActivity(c);
        }

    }

    private void updateScore() {
        score++;
        scoreView.setText("Score:" + score);

        checkForEndGame();
    }

    private void killAll() {
        handler1.removeCallbacks(null);
        handler2.removeCallbacks(null);
        sound.stop();
    }

    //Tough Events Methods
    public void ball8OnClick(View view) {
        view.setVisibility(View.INVISIBLE);
        sound.start();

        scoreView.setText("Score:" + this.score);
        updateScore();

    }

    public void ball3OnClick(View view) {
        view.setVisibility(View.INVISIBLE);

        sound.start();
        scoreView.setText("Score:" + this.score);
        updateScore();
    }

    public void ball6OnClick(View view) {
        view.setVisibility(View.INVISIBLE);

        sound.start();
        scoreView.setText("Score:" + this.score);
        updateScore();
    }

    public void ball5OnClick(View view) {
        view.setVisibility(View.INVISIBLE);

        sound.start();


        updateScore();
    }

    public void ball1OnClick(View view) {
        view.setVisibility(View.INVISIBLE);

        sound.start();
        updateScore();

    }

    public void ball2OnClick(View view) {
        view.setVisibility(View.INVISIBLE);

        sound.start();
        updateScore();

    }

    public void ball7OnClick(View view) {
        view.setVisibility(View.INVISIBLE);

        sound.start();
        updateScore();

    }

    public void ball4OnClick(View view) {
        view.setVisibility(View.INVISIBLE);

        sound.start();
        updateScore();

    }


}
