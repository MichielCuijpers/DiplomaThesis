package com.icsd.game.thesis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.icsd.game.thesis.R.id.homeAsUp;
import static com.icsd.game.thesis.R.id.number1View;
import static com.icsd.game.thesis.R.id.textView;

public class LoginActivity extends AppCompatActivity {
    char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    TextView number1View;
    TextView number2View;
    TextView number3View;
    TextView number4View;
    TextView number5View;
    Integer[][] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initGui();
    }

    private void initGui() {
        number1View = findViewById(R.id.number1View);
        number2View = findViewById(R.id.number2View);
        number3View = findViewById(R.id.number3View);
        number4View = findViewById(R.id.number4View);
        number5View = findViewById(R.id.number5View);
        textViews = new Integer[5][2];
        textViews[0][0] = number1View.getId();
        textViews[1][0] = number2View.getId();
        textViews[2][0] = number3View.getId();
        textViews[3][0] = number4View.getId();
        textViews[4][0] = number5View.getId();
        for (int i = 0; i < 5; i++) {
            textViews[i][1] = 1;
        }


    }

    private void changeLetter(Integer i) {

        TextView view = findViewById(textViews[i][0]);
        view.setText(alphabet[textViews[i][1]] + "");
        textViews[i][1]++;

    }


    public void upButton1(View view) {
        changeLetter(0);
    }

    public void downButton1(View view) {
        changeLetter(1);

    }

    public void upButton2(View view) {
        changeLetter(1);

    }

    public void downButton2(View view) {
        changeLetter(1);

    }

    public void upButton3(View view) {
        changeLetter(2);

    }

    public void downButton3(View view) {
        changeLetter(2);

    }

    public void upButton4(View view) {
        changeLetter(3);

    }

    public void downButton4(View view) {
        changeLetter(3);

    }


    public void upButotn5(View view) {
        changeLetter(4);

    }


    public void downButton5(View view) {
        changeLetter(4);
    }
}
