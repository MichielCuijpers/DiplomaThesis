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
    private ArrayList<String> keepweight;
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
        keepweight = new ArrayList<String>();
    }
    public void tutoonClick(View view) {
    }

    public void startgponClick(View view) {
    }
}
