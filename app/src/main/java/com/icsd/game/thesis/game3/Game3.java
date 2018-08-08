package com.icsd.game.thesis.game3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.pet.Tooltips.PopUpWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game3 extends AppCompatActivity {

    private ArrayList<Button> buttonsList;
    private ArrayList<Integer> randomsList;
    private ArrayList<Integer> correctsList;
    private int turn;
    private Boolean isSecondButton;
    private String previewsButtonText;
    private Button previewsButton;
    private PopUpWindow p;
    private ArrayList<Integer> tempArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);
        initGui();
        initGameplay();
        p = new PopUpWindow(this, this);
        gameplay(turn);
    }

    private void initGui() {
        buttonsList = new ArrayList<>();

        for (int i = 1; i < 16; i++) {

            String btn = "number" + i + "Button";
            int resID = getResources().getIdentifier(btn, "id", getPackageName());
            buttonsList.add(this.<Button>findViewById(resID));


        }
        clearGui();

    }

    private void initGameplay() {
        turn = 1;
        isSecondButton = false;
        tempArrayList = new ArrayList<>();
        correctsList = new ArrayList<>();
        randomsList = new ArrayList<>();
    }

    private void generateRandoms(int turn) {

        randomsList.clear();
        Random r;
        switch (turn) {
            case 1:
                for (int i = 0; i < 5; i++) {
                    r = new Random();
                    randomsList.add(r.nextInt(300));
                }
                break;
            case 2:

                for (int i = 0; i < 7; i++) {
                    r = new Random();
                    randomsList.add(r.nextInt(300));
                }
                break;
            case 3:
                for (int i = 0; i < 9; i++) {
                    r = new Random();
                    randomsList.add(r.nextInt(300));
                }
                break;
            case 4:
                for (int i = 0; i < 12; i++) {
                    r = new Random();
                    randomsList.add(r.nextInt(300));
                }
                break;
            case 5:
                for (int i = 0; i < 15; i++) {
                    r = new Random();
                    randomsList.add(r.nextInt(300));
                }
                break;

        }

    }

    private void clearGui() {
        for (int i = 0; i < buttonsList.size(); i++) {
            buttonsList.get(i).setVisibility(View.INVISIBLE);
        }
    }

    private void initTurn(int turn) {
        generateRandoms(turn);
        correctsList = randomsList;
        Collections.shuffle(randomsList);

        switch (turn) {
            case 1:
                for (int i = 0; i < 5; i++) {
                    buttonsList.get(i).setVisibility(View.VISIBLE);
                    buttonsList.get(i).setText(String.valueOf(randomsList.get(i)));
                }
                break;
            case 2:
                for (int i = 0; i < 7; i++) {
                    buttonsList.get(i).setVisibility(View.VISIBLE);
                    buttonsList.get(i).setText(String.valueOf(randomsList.get(i)));
                }
                break;
            case 3:
                for (int i = 0; i < 9; i++) {
                    buttonsList.get(i).setVisibility(View.VISIBLE);
                    buttonsList.get(i).setText(String.valueOf(randomsList.get(i)));
                }
                break;
            case 4:
                for (int i = 0; i < 12; i++) {
                    buttonsList.get(i).setVisibility(View.VISIBLE);
                    buttonsList.get(i).setText(String.valueOf(randomsList.get(i)));
                }
                break;
            case 5:
                for (int i = 0; i < 15; i++) {
                    buttonsList.get(i).setVisibility(View.VISIBLE);
                    buttonsList.get(i).setText(String.valueOf(randomsList.get(i)));
                }
                break;


        }

    }

    private void gameplay(int turn) {
        switch (turn) {
            case 1:
                initTurn(1);
                break;
            case 2:
                initTurn(2);
                break;
            case 3:
                initTurn(3);
                break;
            case 4:
                initTurn(4);
                break;
            case 5:
                initTurn(4);
                break;


        }
    }

    private void buttonIsClick(View view) {
        Button b = (Button) view;

        if (!isSecondButton) {
            b.setBackgroundColor(Color.parseColor("#FFC56C07"));
            previewsButtonText = b.getText().toString();
            previewsButton = b;
            isSecondButton = true;
        } else {
            previewsButton.setBackgroundColor(Color.parseColor("#FFFF8800"));
            previewsButton.setText(b.getText().toString());
            b.setText(previewsButtonText);
            isSecondButton = false;

        }


    }

    private void check() {
        tempArrayList.clear();
        Collections.sort(correctsList);
        int j = 0;
        for (int i = 0; i < 15; i++) {
            if (buttonsList.get(i).getVisibility() == View.INVISIBLE) {

            } else {

                tempArrayList.add(Integer.parseInt((String) buttonsList.get(j).getText()));
                Log.e("MYDEBUG",tempArrayList.get(i)+"/"+correctsList.get(i));
                j++;
            }
        }
        if (tempArrayList.equals(correctsList)) {
            p.showPopUp(getResources().getString(R.string.correct_answer2));
            turn++;
            gameplay(turn);
        } else {
            p.showPopUp(getResources().getString(R.string.wrong_answer2));
        }

    }

    private void endGame() {

    }

    // OnCLicks
    public void number1OnClick(View view) {
        buttonIsClick(view);
    }

    public void number2OnClick(View view) {
        buttonIsClick(view);
    }

    public void number3OnClick(View view) {
        buttonIsClick(view);
    }

    public void number4OnClick(View view) {
        buttonIsClick(view);
    }

    public void number5OnClick(View view) {
        buttonIsClick(view);
    }

    public void number6OnClick(View view) {
        buttonIsClick(view);
    }

    public void number7OnClick(View view) {
        buttonIsClick(view);
    }

    public void number8OnClick(View view) {
        buttonIsClick(view);
    }

    public void number9OnClick(View view) {
        buttonIsClick(view);
    }

    public void number10OnClick(View view) {
        buttonIsClick(view);
    }

    public void number11OnClick(View view) {
        buttonIsClick(view);
    }

    public void number12OnClick(View view) {
        buttonIsClick(view);
    }

    public void number13OnClick(View view) {
        buttonIsClick(view);
    }

    public void number14OnClick(View view) {
        buttonIsClick(view);
    }

    public void number15OnClick(View view) {
        buttonIsClick(view);
    }

    public void checkOnClick(View view) {
        check();
    }
}
