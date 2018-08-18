package com.icsd.game.thesis.commons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.icsd.game.thesis.Game10.Game10;
import com.icsd.game.thesis.Game11.Game11;
import com.icsd.game.thesis.Game12.Game12;
import com.icsd.game.thesis.Game14.Game14;
import com.icsd.game.thesis.Game6.Game6;
import com.icsd.game.thesis.Game7.Game7;
import com.icsd.game.thesis.Game9.Game9;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.AndroidDatabaseManager;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.game1.Game1Activity;
import com.icsd.game.thesis.game13.Game13;
import com.icsd.game.thesis.game15.Game15;
import com.icsd.game.thesis.game2.Game2Activity;
import com.icsd.game.thesis.game3.Game3;
import com.icsd.game.thesis.game4.Game4Activity;
import com.icsd.game.thesis.game5.Game5;
import com.icsd.game.thesis.game8.Game8;

import java.util.ArrayList;

public class Μenu3 extends AppCompatActivity {
    public static void setWichCate(int wichCate) {
        Μenu3.wichCate = wichCate;
    }

    private static int wichCate;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private ArrayList<Button> buttons;
    private View.OnClickListener game1;
    private View.OnClickListener game2;
    private View.OnClickListener game3;
    private View.OnClickListener game4;
    private View.OnClickListener game5;
    private View.OnClickListener game6;
    private View.OnClickListener game7;
    private View.OnClickListener game8;
    private View.OnClickListener game9;
    private View.OnClickListener game10;
    private View.OnClickListener game11;
    private View.OnClickListener game12;
    private View.OnClickListener game13;
    private View.OnClickListener game14;
    private View.OnClickListener game15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_categories_layout);
        buttons = new ArrayList<>();
        initGui();
        setOnclickListeners();
        setGui(wichCate);
    }


    private void initGui() {
        b1 = findViewById(R.id.menu3_b1);
        b2 = findViewById(R.id.menu3_b2);
        b3 = findViewById(R.id.menu3_b3);
        b4 = findViewById(R.id.menu3_b4);


        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        hideButtons();


    }

    private void showButtons(int howMuchButtons) {
        for (int i = 0; i < howMuchButtons; i++) {
            buttons.get(i).setVisibility(View.VISIBLE);

        }
    }

    private void hideButtons() {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setVisibility(View.INVISIBLE);

        }
    }

    private void setGui(int cat) {
        switch (cat) {
            case 1:
                b1.setText(getResources().getString(R.string.game1name));
                b2.setText(getResources().getString(R.string.game11name));
                b3.setText(getResources().getString(R.string.game10name));
                b4.setText(getResources().getString(R.string.game14name));
                hideButtons();
                showButtons(4);
                b1.setOnClickListener(game1);
                b2.setOnClickListener(game11);
                b3.setOnClickListener(game10);
                b4.setOnClickListener(game14);
                break;
            case 2:
                hideButtons();
                showButtons(3);
                b1.setText(getResources().getString(R.string.game6name));
                b2.setText(getResources().getString(R.string.game7name));
                b3.setText(getResources().getString(R.string.game12name));
                b1.setOnClickListener(game6);
                b2.setOnClickListener(game7);
                b3.setOnClickListener(game12);
                break;
            case 3:
                hideButtons();
                showButtons(3);
                b1.setText(getResources().getString(R.string.game13name));
                b2.setText(getResources().getString(R.string.game9name));
                b3.setText(getResources().getString(R.string.game8name));
                b4.setText(getResources().getString(R.string.game2name));

                b1.setOnClickListener(game13);
                b2.setOnClickListener(game9);
                b4.setOnClickListener(game2);
                b3.setOnClickListener(game8);
                break;
            case 4:
                hideButtons();
                showButtons(4);
                b1.setText(getResources().getString(R.string.game3name));
                b2.setText(getResources().getString(R.string.game4name));
                b3.setText(getResources().getString(R.string.game5name));
                b4.setText(getResources().getString(R.string.game15name));
                b1.setOnClickListener(game3);
                b2.setOnClickListener(game4);
                b3.setOnClickListener(game5);
                b4.setOnClickListener(game15);

                break;
        }
    }

    private void setOnclickListeners() {
        game1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game1Activity.class);
                startActivity(c);
            }
        };
        game2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game2Activity.class);
                startActivity(c);
            }
        };
        game3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game3.class);
                startActivity(c);
            }
        };
        game4 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game4Activity.class);
                startActivity(c);
            }
        };
        game5 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game5.class);
                startActivity(c);
            }
        };
        game6 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game6.class);
                startActivity(c);
            }
        };
        game7 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game7.class);
                startActivity(c);
            }
        };
        game8 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game8.class);
                startActivity(c);
            }
        };
        game9 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game9.class);
                startActivity(c);
            }
        };
        game10 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game10.class);
                startActivity(c);
            }
        };
        game11 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game11.class);
                startActivity(c);
            }
        };
        game12 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game12.class);
                startActivity(c);
            }
        };
        game13 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game13.class);
                startActivity(c);
            }
        };
        game14 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game14.class);
                startActivity(c);
            }
        };
        game15 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(getApplicationContext(), Game15.class);
                startActivity(c);
            }
        };


    }


}
