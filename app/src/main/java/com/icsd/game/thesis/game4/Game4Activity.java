package com.icsd.game.thesis.game4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.SoundHandler;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.Tooltips.PopUpWindow;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Game4Activity extends AppCompatActivity {
    private static Context myCont;
    private ArrayList<String> wordsListTurn1;
    private ArrayList<String> wordsListTurn2;
    private ArrayList<String> wordsListTurn3;

    private ArrayList<Button> buttonsList;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Boolean isSecondButton;
    private String previewsButtonText;
    private Button previewsButton;
    private String currentWord;
    private int globalTurn;
    private int secondaryTurn;

    private Session curSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;
    PopUpWindow p;

    public static Context getMyCont() {
        return myCont;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game4protype);
        myCont = this.getApplicationContext();
        soundHandler = new SoundHandler(getApplicationContext());
        initGameplay();
        initGui();
        p = new PopUpWindow(myCont, this);
        gameplay(globalTurn);


    }

    private void initGameplay() {

        isSecondButton = false;
        globalTurn = 1;
        secondaryTurn = 0;
        wordsListTurn1 = new ArrayList<>();
        wordsListTurn2 = new ArrayList<>();
        wordsListTurn3 = new ArrayList<>();
        takeWordsFromDB();

        Collections.shuffle(this.wordsListTurn1);
        Collections.shuffle(this.wordsListTurn2);
        Collections.shuffle(this.wordsListTurn3);

        curSession = new Session(Menu.testUser.getUsername(), 4);
        curSession.setTimeStart(System.currentTimeMillis() / 1000);
    }

    private void gameplay(int turn) {


        switch (turn) {
            case 1:
                Log.e("MYDEBUG", "inn:" + globalTurn);
                currentWord = wordsListTurn1.get(secondaryTurn);
                setWordInGui(shuffleWord(currentWord));
                secondaryTurn++;

                break;
            case 2:
                p.getmPopupWindow().dismiss();
                p.showPopUp("TURN  "+globalTurn+" BEGINS");
                currentWord = wordsListTurn2.get(secondaryTurn);
                setWordInGui(shuffleWord(currentWord));
                secondaryTurn++;

                break;
            case 3:
                p.getmPopupWindow().dismiss();
                p.showPopUp("TURN  "+globalTurn+" BEGINS");
                currentWord = wordsListTurn3.get(secondaryTurn);
                setWordInGui(shuffleWord(currentWord));
                secondaryTurn++;

                break;

        }


    }

    private void setWordInGui(String word) {


        for (int i = 0; i < word.length(); i++) {
            buttonsList.get(i).setText(word.charAt(i) + "");
            buttonsList.get(i).setVisibility(View.VISIBLE);
        }


    }

    public String shuffleWord(String input) {
        List<Character> characters = new ArrayList<Character>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while (characters.size() != 0) {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    private void initGui() {
        buttonsList = new ArrayList<>();
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        buttonsList.add(button1);
        buttonsList.add(button2);
        buttonsList.add(button3);
        buttonsList.add(button4);
        buttonsList.add(button5);
        buttonsList.add(button6);
        buttonsList.add(button7);
        buttonsList.add(button8);
        buttonsList.add(button9);
        buttonsList.add(button10);
        buttonsList.add(button11);
        buttonsList.add(button12);
        clearGui();

    }

    private void clearGui() {
        for (int i = 0; i < 12; i++) {
            buttonsList.get(i).setVisibility(View.INVISIBLE);
        }
    }

    private void takeWordsFromDB() {

        ArrayList<String> tempWordsList;
        tempWordsList = Word.WordDBEntry.takeWorldsFromDB();
        for (int i = 0; i < tempWordsList.size(); i++) {
            if (tempWordsList.get(i).length() <= 4) {
                wordsListTurn1.add(tempWordsList.get(i));
            } else if (tempWordsList.get(i).length() > 4 && tempWordsList.get(i).length() <= 6) {
                wordsListTurn2.add(tempWordsList.get(i));
                Log.e("MYDEBUG", "list2size" + wordsListTurn2.size());
            } else {
                wordsListTurn3.add(tempWordsList.get(i));

            }
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

    public void checkOnClick(View view) {
        String world = "";
        for (int i = 0; i < currentWord.length(); i++) {
            world = world + buttonsList.get(i).getText();
        }
        if (currentWord.equals(world)) {
            soundHandler.playOkSound();
            this.curSession.setScore(this.globalTurn);

            // Toast.makeText(this, "CORRECT  ", Toast.LENGTH_SHORT).show();

            p.showPopUp("Correct. Congrats!");
            clearGui();
            if (secondaryTurn > 2) {
                changeTurn();
            }

            if (secondaryTurn == 0 || secondaryTurn == 1 || secondaryTurn == 2) {

                Log.e("MYDEBUG", "change tsecondaryurn" + secondaryTurn);
                gameplay(globalTurn);

            }

        } else {

            soundHandler.playWrongSound();
            p.showPopUp("False, try again!!");
            // Toast.makeText(this, "TRY AGAIN  ", Toast.LENGTH_SHORT).show();
            this.curSession.setFails(curSession.getFails() + 1);

        }
    }

    private void endGame() {
        soundHandler.stopSound();
        p.getmPopupWindow().dismiss();
        p.showPopUp("END GAME !! ");
        curSession.setTimeEnd(System.currentTimeMillis() / 1000);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        dbHandler.addSessionToDB(this.curSession);
        Intent c = new Intent(this, Menu.class);
        startActivity(c);
    }

    private void changeTurn() {

        secondaryTurn = 0;
        globalTurn++;
        if (this.globalTurn == 4) {
            endGame();
        }
        gameplay(globalTurn);
    }

    //OnCLicks
    public void button1OnClick(View view) {
        buttonIsClick(view);
    }

    public void button3OnClick(View view) {
        buttonIsClick(view);
    }

    public void button2OnClick(View view) {
        buttonIsClick(view);
    }

    public void button4OnClick(View view) {
        buttonIsClick(view);
    }

    public void button5OnClick(View view) {
        buttonIsClick(view);
    }

    public void button6OnClick(View view) {
        buttonIsClick(view);
    }

    public void button7OnClick(View view) {
        buttonIsClick(view);
    }

    public void button8OnClick(View view) {
        buttonIsClick(view);
    }

    public void button9OnClick(View view) {
        buttonIsClick(view);
    }

    public void button10OnClick(View view) {
        buttonIsClick(view);
    }

    public void button11nClick(View view) {
        buttonIsClick(view);
    }

    public void button12OnClick(View view) {
        buttonIsClick(view);
    }


}
