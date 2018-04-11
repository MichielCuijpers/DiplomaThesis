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
import android.widget.Button;

import com.icsd.game.thesis.R;

import java.util.ArrayList;

public class Game8 extends AppCompatActivity {
    private View ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8;
    private ArrayList<View> balls;
    private ConstraintLayout lo;
    int round;
    public Handler handler1;
    public Handler handler2;
    public Handler handler3;
    public Handler handler4;
    public Handler handler5;
    public Handler handler6;
    public Handler handler7;
    public Handler handler8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game8);
        lo = (ConstraintLayout) findViewById(R.id.lo);
        init();
        gameplay(1);

    }

    private void init() {

        this.round = 1;

        handler1 = new Handler();
        handler2 = new Handler();
        handler3 = new Handler();
        handler4 = new Handler();
        handler5 = new Handler();
        handler6 = new Handler();
        handler7 = new Handler();
        handler8 = new Handler();


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


    }

    private void gameplay(int r) {


        switch (r) {
            case 1:
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball1, "translationY", 900f);
                        animation.setDuration(8000);
                        ball1.setVisibility(View.VISIBLE);
                        animation.start();
                    }
                }, 800);
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball7, "translationY", 900f);
                        animation.setDuration(8000);
                        ball7.setVisibility(View.VISIBLE);
                        animation.start();
                    }
                }, 1600);
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball4, "translationY", 900f);
                        animation.setDuration(8000);
                        ball4.setVisibility(View.VISIBLE);
                        animation.start();
                        round++;
                        gameplay(round);
                    }
                }, 2200);
                break;
            case 2:
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball3, "translationY", 900f);
                        animation.setDuration(8000);
                        animation.setRepeatMode(ValueAnimator.RESTART);
                        ball4.setVisibility(View.VISIBLE);
                        animation.start();
                    }
                }, 800);
                handler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball7, "translationY", 900f);
                        animation.setDuration(8000);
                        ball7.setVisibility(View.VISIBLE);
                        animation.start();

                    }
                }, 1600);
                handler5.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball2, "translationY", 900f);
                        animation.setDuration(8000);
                        ball2.setVisibility(View.VISIBLE);
                        animation.start();
                        round++;
                        gameplay(round);
                    }
                }, 2200);
                break;
            case 3:
                handler6.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball8, "translationY", 900f);
                        animation.setDuration(8000);
                        ball8.setVisibility(View.VISIBLE);
                        animation.start();
                    }
                }, 800);
                handler7.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball4, "translationY", 900f);
                        animation.setDuration(8000);
                        ball4.setVisibility(View.VISIBLE);
                        animation.start();
                    }
                }, 1600);
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball1, "translationY", 900f);
                        animation.setDuration(8000);
                        ball1.setVisibility(View.VISIBLE);
                        animation.start();
                        round++;
                        gameplay(round);
                    }
                }, 2200);
                break;
            case 4:
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball1, "translationY", 900f);
                        animation.setDuration(8000);
                        ball1.setVisibility(View.VISIBLE);
                        animation.start();
                    }
                }, 800);
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball3, "translationY", 900f);
                        animation.setDuration(8000);
                        ball3.setVisibility(View.VISIBLE);
                        animation.start();
                    }
                }, 1600);
                handler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ObjectAnimator animation = ObjectAnimator.ofFloat(ball7, "translationY", 900f);
                        animation.setDuration(8000);
                        ball7.setVisibility(View.VISIBLE);
                        animation.start();
                        
                    }
                }, 2200);
                break;

        }

    }

    private void initRound() {

    }

    private void check() {

    }


}
