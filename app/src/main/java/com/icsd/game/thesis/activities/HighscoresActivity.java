package com.icsd.game.thesis.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class HighscoresActivity extends AppCompatActivity {
    private TextView h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14, h15;
    private ArrayList<TextView> texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);
        texts = new ArrayList<>();
        initGui();
        setHighscores();
    }

    private void initGui() {
        h1 = findViewById(R.id.h1);
        h2 = findViewById(R.id.h2);
        h3 = findViewById(R.id.h3);
        h4 = findViewById(R.id.h4);
        h5 = findViewById(R.id.h5);
        h6 = findViewById(R.id.h6);
        h7 = findViewById(R.id.h7);
        h8 = findViewById(R.id.h8);
        h9 = findViewById(R.id.h9);
        h10 = findViewById(R.id.h10);
        h11 = findViewById(R.id.h11);
        h12 = findViewById(R.id.h12);
        h13 = findViewById(R.id.h13);
        h14 = findViewById(R.id.h14);
        h15 = findViewById(R.id.h15);
        texts.add(h1);
        texts.add(h2);
        texts.add(h3);
        texts.add(h4);
        texts.add(h5);
        texts.add(h6);
        texts.add(h7);
        texts.add(h8);
        texts.add(h9);
        texts.add(h10);
        texts.add(h11);
        texts.add(h12);
        texts.add(h13);
        texts.add(h14);
        texts.add(h15);
    }

    private void setHighscores() {
        HashMap<Integer, Integer> map = DatabaseHandler.getHighscoresFromDB();
        for (int i = 0; i < texts.size(); i++) {
            if(map.get(i)!=null){

                texts.get(i).append(map.get(i) + "");
            }

        }

    }
}
