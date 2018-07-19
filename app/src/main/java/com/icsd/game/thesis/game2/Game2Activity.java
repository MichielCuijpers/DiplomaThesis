package com.icsd.game.thesis.game2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.icsd.game.thesis.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

public class Game2Activity extends AppCompatActivity {

    private ImageView mapImageView;
    private ImageView mapPin;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ArrayList cities;
    private ArrayList<String> countriesEurope;
    private ArrayList<String> countriesAfrica;
    private ArrayList countriesAsia;
    private int turn;
    private String currectCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        initGameplay();

        initGui();
        initTurn();


    }

    private void initGameplay() {
        cities = new ArrayList();
        countriesEurope = new ArrayList();
        countriesAfrica = new ArrayList();
        countriesAsia = new ArrayList();

        countriesEurope.add("Italy");
        countriesEurope.add("Greece");
        countriesEurope.add("France");
        countriesEurope.add("Finland");

        countriesAfrica.add("Nigeria");
        countriesAfrica.add("Egypt");
        countriesAfrica.add("Morocco");
        countriesAfrica.add("Algeria");
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
            currectCorrect = countriesEurope.get(0);
            addPinOnMap();
            Collections.shuffle(countriesEurope);
            button1.setText(countriesEurope.get(0) + "");
            button2.setText(countriesEurope.get(1) + "");
            button3.setText(countriesEurope.get(2) + "");
            button4.setText(countriesEurope.get(3) + "");

        }
        if (turn == 3 || turn == 4) {
            //Africa Turn
            mapImageView.setImageResource(R.drawable.africa_map);

            // Collections.shuffle(countriesAfrica);
            currectCorrect = countriesAfrica.get(3);
            addPinOnMap();
            Collections.shuffle(countriesAfrica);
            button1.setText(countriesAfrica.get(0) + "");
            button2.setText(countriesAfrica.get(1) + "");
            button3.setText(countriesAfrica.get(2) + "");
            button4.setText(countriesAfrica.get(3) + "");

        }
        if (turn == 4 || turn == 5) {

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
        }


    }


    private void check(String answer) {
        if (answer.equals(currectCorrect)) {
            Toast.makeText(this, "Congrats!!  ", Toast.LENGTH_LONG).show();
            turn++;
            initTurn();
        } else {
            Toast.makeText(this, "Fail ", Toast.LENGTH_LONG).show();

            initTurn();

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
