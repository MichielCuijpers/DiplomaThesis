package com.icsd.game.thesis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import static com.icsd.game.thesis.R.id.homeAsUp;
import static com.icsd.game.thesis.R.id.number1View;

public class LoginActivity extends AppCompatActivity {
    char[] alphabet = "bcdefghijklmnopqrstuvwxyz".toCharArray();
    TextView number1View;
    TextView number2View;
    TextView number3View;
    TextView number4View;
    TextView number5View;
    HashMap<Integer, Integer> textViews;

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
        textViews=new HashMap<>();
        textViews.put(number1View.getId(), 0);
        textViews.put(number2View.getId(), 0);
        textViews.put(number3View.getId(), 0);
        textViews.put(number4View.getId(), 0);
        textViews.put(number5View.getId(), 0);
    }

    private void changeLetter(TextView view) {
        view.setText(alphabet[textViews.get(view.getId())]);
        textViews.put(view.getId(), textViews.get(view.getId()) + 1);
    }

    public void upButton1(View view) {
        changeLetter((TextView) view);
    }

    public void downButton1(View view) {
        changeLetter((TextView) view);

    }

    public void upButton2(View view) {
        changeLetter((TextView) view);

    }

    public void downButton2(View view) {
        changeLetter((TextView) view);

    }

    public void upButton3(View view) {
        changeLetter((TextView) view);

    }

    public void downButton3(View view) {
        changeLetter((TextView) view);

    }

    public void upButton4(View view) {
        changeLetter((TextView) view);

    }

    public void downButton4(View view) {
        changeLetter((TextView) view);

    }


    public void upButotn5(View view) {
        changeLetter((TextView) view);

    }


    public void downButton5(View view) {
    }
}
