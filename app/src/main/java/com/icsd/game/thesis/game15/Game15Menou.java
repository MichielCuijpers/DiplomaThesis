package com.icsd.game.thesis.game15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.Menu2;
import com.icsd.game.thesis.R;

public class Game15Menou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game15_menou);
    }

    public void miniGame1OnClick(View view) {
        Intent c = new Intent(this, Game15MiniGame1.class);
        startActivity(c);
    }

    public void miniGame2OnClick(View view) {
        Intent c = new Intent(this, Game15MiniGame2.class);
        startActivity(c);
    }


}
