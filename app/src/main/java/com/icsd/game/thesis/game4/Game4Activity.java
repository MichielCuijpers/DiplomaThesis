package com.icsd.game.thesis.game4;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.icsd.game.thesis.activities.LoginActivity;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.SoundHandler;
import com.icsd.game.thesis.activities.SurveyActivity;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.commons.Session;
import com.icsd.game.thesis.pet.PopUpWindow;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Game4Activity extends AppCompatActivity {

    private ArrayList<String> wordsListTurn1;
    private ArrayList<String> wordsListTurn2;
    private ArrayList<String> wordsListTurn3;
    private ArrayList<Button> buttonsList;
    private Boolean isSecondButton;
    private String previewsButtonText;
    private Button previewsButton;
    private String currentWord;
    private int globalTurn;
    private int secondaryTurn;
    private static Context context;
    private Session curSession;
    private SoundHandler soundHandler;
    private PopUpWindow p;
    private int moves;
    private TextView tutorialText;
    private int tempFails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        context = getApplicationContext();

        tutorialText = findViewById(R.id.tutorialTextView);
        tutorialText.setText(getResources().getString(R.string.tutorialGame4));
        soundHandler = new SoundHandler(getApplicationContext());


    }

    public void onPause() {
        super.onPause();

    }

    public void onStop() {
        super.onStop();
        if (curSession != null) {
            curSession.setTimeEnd(System.currentTimeMillis() / 1000);
            if (moves != 0) {
                curSession.setScore(curSession.getScore() / moves);

            }

            DatabaseHandler dbHandler = new DatabaseHandler(this.getApplicationContext());
            dbHandler.addSessionToDB(this.curSession);
        }
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

        curSession = new Session(LoginActivity.getUser().getUsername(), 4);
        curSession.setTimeStart(System.currentTimeMillis() / 1000);
    }

    private void gameplay(int turn) {
        tempFails = 0;

        switch (turn) {
            case 1:
                Log.e("MYDEBUG", "turn1");
                currentWord = wordsListTurn1.get(secondaryTurn);
                Log.e("MYDEBUG", "current word is : " + currentWord);
                setWordInGui(shuffleWord(currentWord));
                secondaryTurn++;

                break;
            case 2:
                Log.e("MYDEBUG", "turn2");
                p.getmPopupWindow().dismiss();
                p.showPopUp(getResources().getString(R.string.new_turn));
                currentWord = wordsListTurn2.get(secondaryTurn);
                Log.e("MYDEBUG", "current word is : " + currentWord);
                setWordInGui(shuffleWord(currentWord));
                secondaryTurn++;

                break;
            case 3:
                Log.e("MYDEBUG", "turn3");
                p.getmPopupWindow().dismiss();
                p.showPopUp(getResources().getString(R.string.new_turn));
                currentWord = wordsListTurn3.get(secondaryTurn);
                Log.e("MYDEBUG", "current word is : " + currentWord);
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

    private String shuffleWord(String input) {
        List<Character> characters = new ArrayList<>();
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
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        Button button12 = findViewById(R.id.button12);
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
            if (tempWordsList.get(i).length() == 4) {

                wordsListTurn1.add(tempWordsList.get(i));
                Collections.shuffle(wordsListTurn1);
            } else if (tempWordsList.get(i).length() == 5) {
                wordsListTurn2.add(tempWordsList.get(i));
                Collections.shuffle(wordsListTurn2);
            } else if (tempWordsList.get(i).length() == 6) {
                wordsListTurn3.add(tempWordsList.get(i));
                Collections.shuffle(wordsListTurn3);

            }

        }
        Log.e("MYDEBUG", "4 letters list: " + wordsListTurn1.size());
        Log.e("MYDEBUG", "5 letters list: " + wordsListTurn2.size());
        Log.e("MYDEBUG", "6 letters list: " + wordsListTurn3.size());
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
            moves++;
        }


    }

    private void endGame() {
        if (soundHandler != null) {
            soundHandler.stopSound();
        }
        Intent surv = new Intent(this, SurveyActivity.class);
        SurveyActivity.setQuestionType(0);
        SurveyActivity.setGameID(4);
        startActivity(surv);
    }

    private StringBuilder takeWordFromGui() {
        StringBuilder world = new StringBuilder();
        for (int i = 0; i < currentWord.length(); i++) {
            world.append(buttonsList.get(i).getText());
        }
        Log.e("MYDEBUG", "Word user made: " + world.toString());
        return world;
    }

    private void changeTurn() {
        Log.e("MYDEBUG", "in change turn");
        if (secondaryTurn > 4) {
            secondaryTurn = 0;
            globalTurn++;
            if (this.globalTurn == 4) {
                endGame();
            }
            gameplay(globalTurn);
        }

        if (secondaryTurn == 0 || secondaryTurn == 1 || secondaryTurn == 2 || secondaryTurn == 3 || secondaryTurn == 4 ) {

            gameplay(globalTurn);

        }

    }

    private void correctTurn() {
        soundHandler.playOkSound();
        this.curSession.setScore(this.globalTurn);
        p.showPopUp(getResources().getString(R.string.correct_answer2));
    }

    private void wrongTurn() {
        this.tempFails++;
        soundHandler.playWrongSound();
        p.showPopUp(getResources().getString(R.string.wrong_answer2));
        this.curSession.setFails(curSession.getFails() + 1);
    }

    public static Context getContext() {
        return context;
    }

    //OnCLicks
    public void checkOnClick(View view) {
        String word = takeWordFromGui().toString();
        if (currentWord.equals(word)) {
            correctTurn();
            clearGui();
            changeTurn();

        } else {
            wrongTurn();
            if (tempFails == 5) {
                changeTurn();
            }
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

    public void tutorialOkOnClick(View view) {
        setContentView(R.layout.game4protype);
        initGameplay();
        initGui();
        p = new PopUpWindow(this, this);
        gameplay(globalTurn);

    }


}
