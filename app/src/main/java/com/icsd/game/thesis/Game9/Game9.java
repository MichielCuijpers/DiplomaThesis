package com.icsd.game.thesis.Game9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.icsd.game.thesis.R;

import java.util.ArrayList;

public class Game9 extends AppCompatActivity {
    private ArrayList<Button> colorObjects;   /* list with all color objects */
    private ArrayList<String> randColor;      /* list with all color name */
    private ArrayList<String> correctAnswers; /* list with all correct answers PER turn */ /*Initialize in every turn*/
    private ArrayList<String> clickedAnswers; /* list with all all answers user answered PER turn */ /*Initialize in every turn*/
    /* $$$$$$ */
    private Button correctcolor1;
    private Button correctcolor2;
    private Button randomcolor1;      /*     BUTTONS   */
    private Button randomcolor2;        /* FOR */
    private Button randomcolor3;        /*   GAMEPLAY */
    private Button randomcolor4;
    /* $$$$$$ */
    private Button green1,green2,green3,green4,green5;
    private Button red1,red2,red3,red4,red5;
    private Button blue1,blue2,blue3,blue4,blue5;                 /*     BUTTONS   */
    private Button purple1,purple2,purple3,purple4,purple5;        /* FOR */
    private Button black1,black2,black3,black4,black5;            /*   ImageBackground */
    private Button yel1,yel2,yel3,yel4,yel5;
    /* $$$$$$ */
    private int turn = 0;
    private int countCorrectAnswers = 0;
    private int countWrongAnswers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game9);


    }

    private void initGraphics() {

    }
    private void initGeneralGraphics()
    {
        colorObjects = new ArrayList<Button>();
    }
    private void initColorObjects()
    {

        green1 = (Button) findViewById(R.id.green1);
        green2 = (Button) findViewById(R.id.green2);
        green3 = (Button) findViewById(R.id.green3);
        green4 = (Button) findViewById(R.id.green4);
        green5 = (Button) findViewById(R.id.green5);

        //green1.setBackground(getDrawable(R.drawable.scissors));

        red1 = (Button) findViewById(R.id.red1);
        red2 = (Button) findViewById(R.id.red2);
        red3 = (Button) findViewById(R.id.red3);
        red5 = (Button) findViewById(R.id.red4);
        red5 = (Button) findViewById(R.id.red5);

        blue1 = (Button) findViewById(R.id.blue1);
        blue2 = (Button) findViewById(R.id.blue2);
        blue3 = (Button) findViewById(R.id.blue3);
        blue4 = (Button) findViewById(R.id.blue4);
        blue5 = (Button) findViewById(R.id.blue5);

        purple1 = (Button) findViewById(R.id.purple1);
        purple2 = (Button) findViewById(R.id.purple2);
        purple3 = (Button) findViewById(R.id.purple3);
        purple4 = (Button) findViewById(R.id.purple4);
        purple5 = (Button) findViewById(R.id.purple5);

        black1 = (Button) findViewById(R.id.black1);
        black2 = (Button) findViewById(R.id.black2);
        black3 = (Button) findViewById(R.id.black3);
        black4 = (Button) findViewById(R.id.black4);
        black5 = (Button) findViewById(R.id.black5);

        yel1 = (Button) findViewById(R.id.yellow1);
        yel2 = (Button) findViewById(R.id.yellow2);
        yel3 = (Button) findViewById(R.id.yellow3);
        yel4 = (Button) findViewById(R.id.yellow4);
        yel5 = (Button) findViewById(R.id.yellow5);

    }
}