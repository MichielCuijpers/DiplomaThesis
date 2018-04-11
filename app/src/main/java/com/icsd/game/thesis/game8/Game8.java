package com.icsd.game.thesis.game8;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Path;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import com.icsd.game.thesis.R;

import java.util.ArrayList;

public class Game8 extends AppCompatActivity {
    View ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8;
    ArrayList<View> balls;
    ConstraintLayout lo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game8);
        lo = (ConstraintLayout) findViewById(R.id.lo);
        init();


    }

    private void init() {
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
        for (int i = 1; i < balls.size(); i++) {
            //balls.get(i).setVisibility(View.INVISIBLE);
            balls.get(i).setX(balls.get(1).getX()+(i*200));
        }

       // ObjectAnimator animation = ObjectAnimator.ofFloat(ball8, "translationY", 900f);
       // animation.setDuration(8000);
       // animation.start();


    }

    private void round(int round) {

    }

    private void dropBalls(int round) {

    }

    private void check() {

    }


}
