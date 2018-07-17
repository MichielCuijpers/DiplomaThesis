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
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Game4Activity extends AppCompatActivity {
    private static Context myCont;
    private ArrayList<String> wordsList;
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
    private int turn;
    private Session curSession;
    private DatabaseHandler dbHandler;

    public static Context getMyCont() {
        return myCont;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game4protype);

        initGameplay();
        initGui();
        gameplay(turn);
        Word.WordDBEntry.addTestWordsToDB();


    }

    private void initGameplay() {
        myCont = this.getApplicationContext();
        isSecondButton = false;
        turn = 0;
        takeWordsFromDB();
        Collections.shuffle(this.wordsList);
        curSession = new Session(Menu.testUser.getUsername(), 4);
        curSession.setTimeStart(System.currentTimeMillis() / 1000);
    }

    private void gameplay(int turn) {

        setWordInGui(turn);

    }

    private void setWordInGui(int turn) {

        currentWord = wordsList.get(turn);
        wordsList.set(turn, shuffleWord(wordsList.get(turn)));

        for (int i = 0; i < wordsList.get(turn).length(); i++) {
            Log.e("MyDEbou", this.buttonsList.size() + "//" + wordsList.size());

            buttonsList.get(i).setText(wordsList.get(turn).charAt(i) + "");
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
        wordsList = Word.WordDBEntry.takeWorldsFromDB();

    }

    private void buttonIsClick(View view) {
        Button b = (Button) view;
        Log.e("MyDebug", isSecondButton + "");
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

    public void checkOnClick(View view) {
        String world = "";
        for (int i = 0; i < currentWord.length(); i++) {
            world = world + buttonsList.get(i).getText();
        }
        if (currentWord.equals(world)) {
            turn++;
            this.curSession.setScore(this.turn);
            if (this.turn == 8) {
                Toast.makeText(this, "END GAME ! PLAY ANOTHER GAME  ", Toast.LENGTH_SHORT).show();
                curSession.setTimeEnd(System.currentTimeMillis() / 1000);
                dbHandler = new DatabaseHandler(this.getApplicationContext());
                dbHandler.addSessionToDB(this.curSession);
                Intent c = new Intent(this, Menu.class);
                startActivity(c);
            }
            Toast.makeText(this, "CORRECT  ", Toast.LENGTH_SHORT).show();
            clearGui();
            gameplay(turn);
        } else {
            Toast.makeText(this, "TRY AGAIN  ", Toast.LENGTH_SHORT).show();
            this.curSession.setFails(curSession.getFails() + 1);

        }
    }

}
