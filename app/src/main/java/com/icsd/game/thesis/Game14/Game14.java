package com.icsd.game.thesis.Game14;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.icsd.game.thesis.R;

import java.util.ArrayList;

public class Game14 extends AppCompatActivity {
    private Button test_again;
    private Button start_game;
    private TextView titletext;
    private Button object1;
    private Button object2;
    private ArrayList<Button> heavy;
    private ArrayList<Button> light;
    private Button heavy1,heavy2,heavy3,heavy4,heavy5,heavy6,heavy7,heavy8;
    private Button light1,light2,light3,light4,light5,light6,light7,light8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game14);
    }
    private void initGraphics()
    {
        test_again = (Button) findViewById(R.id.tuto_test);
        start_game = (Button) findViewById(R.id.start_gp);
        object1 = (Button) findViewById(R.id.tutorialbutton_g14);
        object2 = (Button) findViewById(R.id.tutorialbutton_g15);
        titletext = (TextView) findViewById(R.id.title_14);

    }
    private void initGamePlayImages() {
        heavy1 = (Button) findViewById(R.id.heavy);
        heavy2 = (Button) findViewById(R.id.heavy2);
        heavy3 = (Button) findViewById(R.id.heavy3);
        heavy4 = (Button) findViewById(R.id.heavy4);
        heavy5 = (Button) findViewById(R.id.heavy5);
        heavy6 = (Button) findViewById(R.id.heavy6);
        heavy7 = (Button) findViewById(R.id.heavy7);
        heavy8 = (Button) findViewById(R.id.heavy8);

        heavy1.setBackground(getDrawable(R.drawable.heavy1));
        heavy2.setBackground(getDrawable(R.drawable.heavy2));
        heavy3.setBackground(getDrawable(R.drawable.heavy3));
        heavy4.setBackground(getDrawable(R.drawable.heavy4));
        heavy5.setBackground(getDrawable(R.drawable.heavy5));
        heavy6.setBackground(getDrawable(R.drawable.heavy6));
        heavy7.setBackground(getDrawable(R.drawable.heavy7));
        heavy8.setBackground(getDrawable(R.drawable.heavy8));

        heavy.add(heavy1);
        heavy.add(heavy2);
        heavy.add(heavy3);
        heavy.add(heavy4);
        heavy.add(heavy5);
        heavy.add(heavy6);
        heavy.add(heavy7);
        heavy.add(heavy8);

         light1 = (Button) findViewById(R.id.light);
         light2 = (Button) findViewById(R.id.light2);
         light3 = (Button) findViewById(R.id.light3);
         light4 = (Button) findViewById(R.id.light4);
         light5 = (Button) findViewById(R.id.light5);
         light6 = (Button) findViewById(R.id.light6);
         light7 = (Button) findViewById(R.id.light7);
         light8 = (Button) findViewById(R.id.light8);

         light1.setBackground(getDrawable(R.drawable.light1));
         light2.setBackground(getDrawable(R.drawable.light2));
         light3.setBackground(getDrawable(R.drawable.light3));
         light4.setBackground(getDrawable(R.drawable.light4));
         light5.setBackground(getDrawable(R.drawable.light5));
         light6.setBackground(getDrawable(R.drawable.light6));
         light7.setBackground(getDrawable(R.drawable.light7));
         light8.setBackground(getDrawable(R.drawable.light8));

        light.add(light1);
        light.add(light2);
        light.add(light3);
        light.add(light4);
        light.add(light5);
        light.add(light6);
        light.add(light7);
        light.add(light8);

    }
    public void tutoonClick(View view) {
    }

    public void startgponClick(View view) {
    }
}
