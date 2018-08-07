package com.icsd.game.thesis.game2;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.icsd.game.thesis.LoginActivity;
import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.SoundHandler;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.Tooltips.PopUpWindow;

import java.util.ArrayList;
import java.util.Collections;


public class Game2Activity extends AppCompatActivity {

    private ImageView mapImageView;
    private ImageView mapPin;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ArrayList<String> countriesEurope;
    private ArrayList<String> countriesAfrica;
    private ArrayList<String> countriesDone;
    private ArrayList<String> countriesAsia;
    private int turn;
    private String currectCorrect;
    private Session curSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;
    private PopUpWindow popUpWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        init();


    }

    private void init() {

        curSession = new Session(LoginActivity.getUser().getUsername(), 2);
        curSession.setTimeStart(System.currentTimeMillis() / 1000);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        soundHandler = new SoundHandler(getApplicationContext());
        popUpWindow = new PopUpWindow(this, this);

        initGameplay();
        initGui();
        initTurn();

    }

    private void initGameplay() {

        countriesEurope = new ArrayList();
        countriesAfrica = new ArrayList();
        countriesAsia = new ArrayList();
        countriesDone = new ArrayList();

        countriesEurope.add("Italy");
        countriesEurope.add("Greece");
        countriesEurope.add("France");
        countriesEurope.add("Finland");

        countriesAfrica.add("Nigeria");
        countriesAfrica.add("Egypt");
        countriesAfrica.add("Morocco");
        countriesAfrica.add("Algeria");

        countriesAsia.add("China");
        countriesAsia.add("India");
        countriesAsia.add("Iran");
        countriesAsia.add("Kazakhstan");
        turn = 1;


    }

    private void initGui() {
        mapImageView = findViewById(R.id.mapImageView);
        button1 = findViewById(R.id.button1_game12);
        button2 = findViewById(R.id.button2_game12);
        button3 = findViewById(R.id.button3_game12);
        button4 = findViewById(R.id.button4_game12);


    }

    private void initTurn() {
        if (turn == 1 || turn == 2) {
            //Europe Turn
            mapImageView.setImageResource(R.drawable.europe_map);

            Collections.shuffle(countriesEurope);
            if (countriesDone.contains(countriesEurope.get(0))) {
                currectCorrect = countriesEurope.get(1);
            } else {
                currectCorrect = countriesEurope.get(0);
            }

            addPinOnMap();
            Collections.shuffle(countriesEurope);
            button1.setText(countriesEurope.get(0) + "");
            button2.setText(countriesEurope.get(1) + "");
            button3.setText(countriesEurope.get(2) + "");
            button4.setText(countriesEurope.get(3) + "");

        }
        if (turn == 3 || turn == 4) {
            popUpWindow.getmPopupWindow().dismiss();
            popUpWindow.showPopUp(getResources().getString(R.string.new_turn));
            cleanBackgroundForPopUp();


            //Africa Turn
            mapImageView.setImageResource(R.drawable.africa_map);

            Collections.shuffle(countriesAfrica);
            if (countriesDone.contains(countriesEurope.get(0))) {
                currectCorrect = countriesAfrica.get(1);
            } else {
                currectCorrect = countriesAfrica.get(0);
            }

            addPinOnMap();
            Collections.shuffle(countriesAfrica);
            button1.setText(countriesAfrica.get(0) + "");
            button2.setText(countriesAfrica.get(1) + "");
            button3.setText(countriesAfrica.get(2) + "");
            button4.setText(countriesAfrica.get(3) + "");

        }
        if (turn == 5 || turn == 6) {
            popUpWindow.getmPopupWindow().dismiss();
            popUpWindow.showPopUp(getResources().getString(R.string.new_turn));
            cleanBackgroundForPopUp();
            mapImageView.setImageResource(R.drawable.asia_map);
            Collections.shuffle(countriesAsia);
            if (countriesDone.contains(countriesAsia.get(0))) {
                currectCorrect = countriesAsia.get(1);
            } else {
                currectCorrect = countriesAsia.get(0);
            }

            addPinOnMap();
            Collections.shuffle(countriesAsia);
            button1.setText(countriesAsia.get(0) + "");
            button2.setText(countriesAsia.get(1) + "");
            button3.setText(countriesAsia.get(2) + "");
            button4.setText(countriesAsia.get(3) + "");

        }

    }

    private void drawPinOnMap(int x, int y, int imageRes) {
        BitmapFactory.Options myOptions = new BitmapFactory.Options();
        myOptions.inDither = true;
        myOptions.inScaled = false;
        myOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;// important
        myOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageRes, myOptions);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);

        Bitmap workingBitmap = Bitmap.createBitmap(bitmap);
        Bitmap mutableBitmap = workingBitmap.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(mutableBitmap);
        canvas.drawCircle(x, y, 30, paint);
        mapImageView.setImageBitmap(mutableBitmap);

    }

    private void addPinOnMap() {
        if (currectCorrect.equals("Italy")) {
            drawPinOnMap(529, 790, R.drawable.europe_map);


        } else if (currectCorrect.equals("Greece")) {
            drawPinOnMap(800, 900, R.drawable.europe_map);

        } else if (currectCorrect.equals("France")) {
            drawPinOnMap(300, 700, R.drawable.europe_map);

        } else if (currectCorrect.equals("Finland")) {
            drawPinOnMap(700, 200, R.drawable.europe_map);
        } else if (currectCorrect.equals("Nigeria")) {
            drawPinOnMap(600, 680, R.drawable.africa_map);
        } else if (currectCorrect.equals("Egypt")) {
            drawPinOnMap(1050, 300, R.drawable.africa_map);
        } else if (currectCorrect.equals("Morocco")) {
            drawPinOnMap(500, 200, R.drawable.africa_map);
        } else if (currectCorrect.equals("Algeria")) {
            drawPinOnMap(300, 150, R.drawable.africa_map);
        } else if (currectCorrect.equals("China")) {
            drawPinOnMap(500, 500, R.drawable.asia_map);

        } else if (currectCorrect.equals("India")) {
            drawPinOnMap(450, 650, R.drawable.asia_map);

        } else if (currectCorrect.equals("Iran")) {
            drawPinOnMap(230, 520, R.drawable.asia_map);

        } else if (currectCorrect.equals("Kazakhstan")) {
            drawPinOnMap(400, 380, R.drawable.asia_map);

        }


    }

    private void cleanBackgroundForPopUp() {

        mapImageView.setVisibility(View.INVISIBLE);

        if (popUpWindow.getmPopupWindow().isShowing()) {

            mapImageView.setVisibility(View.INVISIBLE);

        }
        popUpWindow.getmPopupWindow().setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {

                mapImageView.setVisibility(View.VISIBLE);

            }
        });

    }

    private void check(String answer) {
        if (answer.equals(currectCorrect)) {
            soundHandler.playOkSound();

            popUpWindow.showPopUp(getResources().getString(R.string.correct_answer2));
            cleanBackgroundForPopUp();

            turn++;
            if (this.turn == 7) {
                soundHandler.stopSound();
                curSession.setTimeEnd(System.currentTimeMillis() / 1000);
                dbHandler.addSessionToDB(this.curSession);
                popUpWindow.showPopUp(getResources().getString(R.string.end_game_congrats_countries));
                Intent c = new Intent(this, Menu.class);
                startActivity(c);
            }
            countriesDone.add(currectCorrect);
            curSession.setScore(turn);

            initTurn();
        } else {
            soundHandler.playWrongSound();

            popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
            cleanBackgroundForPopUp();
            curSession.setFails(curSession.getFails() + 1);
            //initTurn();

        }

    }

    public void choise1OnClick(View view) {
        check((String) button1.getText());
    }


    public void choise2OnClick(View view) {
        check((String) button2.getText());
    }

    public void choise3OnClick(View view) {
        check((String) button3.getText());
    }

    public void choise4OnClick(View view) {
        check((String) button4.getText());
    }


}
