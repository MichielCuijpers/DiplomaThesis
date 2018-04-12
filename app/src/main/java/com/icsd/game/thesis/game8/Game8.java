package com.icsd.game.thesis.game8;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import com.icsd.game.thesis.R;

import java.util.ArrayList;

public class Game8 extends AppCompatActivity {
    private View ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8;
    private ArrayList<View> balls;
    private ConstraintLayout lo;
    int delay;
    public Handler handler1;
    public Handler handler2;


    ObjectAnimator animation1, animation2, animation3, animation4, animation5, animation8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game8);
        lo = (ConstraintLayout) findViewById(R.id.lo);

        init();
        gameplay(1);

    }

    private void init() {

        this.delay = 800;

        handler1 = new Handler();
        handler2 = new Handler();

        ball1 = (View) findViewById(R.id.ball1);
        ball2 = (View) findViewById(R.id.ball2);
        ball3 = (View) findViewById(R.id.ball3);
        ball4 = (View) findViewById(R.id.ball4);
        ball5 = (View) findViewById(R.id.ball5);
        ball6 = (View) findViewById(R.id.ball6);
        ball7 = (View) findViewById(R.id.ball7);
        ball8 = (View) findViewById(R.id.ball8);

        balls = new ArrayList<>();
        balls.add(ball1);
        balls.add(ball2);
        balls.add(ball3);
        balls.add(ball4);
        balls.add(ball5);
        balls.add(ball6);
        balls.add(ball7);
        balls.add(ball8);

        ball1.setVisibility(View.INVISIBLE);
        for (int i = 1; i < balls.size(); i++) {
            balls.get(i).setVisibility(View.INVISIBLE);
            balls.get(i).setX(balls.get(1).getX() + (i * 200));
        }
        animation5 = ObjectAnimator.ofFloat(ball3, "translationY", 900f);
        animation4 = ObjectAnimator.ofFloat(ball2, "translationY", 900f);
        animation8 = ObjectAnimator.ofFloat(ball8, "translationY", 900f);
        animation1 = ObjectAnimator.ofFloat(ball1, "translationY", 900f);
        animation2 = ObjectAnimator.ofFloat(ball4, "translationY", 900f);
        animation3 = ObjectAnimator.ofFloat(ball7, "translationY", 900f);

    }

    private void gameplay(int r) {


        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                animation4.pause();
                animation5.pause();
                animation8.pause();
                animation1.setDuration(4000);
                ball1.setVisibility(View.VISIBLE);
                animation1.start();


                animation2.setDuration(4000);
                ball4.setVisibility(View.VISIBLE);
                animation2.start();


                animation3.setDuration(4000);
                ball7.setVisibility(View.VISIBLE);
                animation3.start();

            }
        }, delay);
        delay = delay + 2500;
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {

                animation1.pause();
                animation2.pause();
                animation3.pause();


                animation5.setDuration(4000);
                ball3.setVisibility(View.VISIBLE);
                animation5.start();


                animation4.setDuration(4000);
                ball2.setVisibility(View.VISIBLE);
                animation4.start();

                animation8.setDuration(4000);
                ball8.setVisibility(View.VISIBLE);
                animation8.start();
                gameplay(3);
            }
        }, delay);
        delay = delay + 2000;


    }

    private void initRound() {

    }

    private void check() {

    }


}
