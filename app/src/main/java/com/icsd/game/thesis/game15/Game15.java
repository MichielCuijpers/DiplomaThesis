package com.icsd.game.thesis.game15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.icsd.game.thesis.commons.LoginActivity;
import com.icsd.game.thesis.commons.Menu2;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.SoundHandler;
import com.icsd.game.thesis.commons.SurveyActivity;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game15 extends AppCompatActivity {
    private TextView number1View;
    private TextView number2View;
    private TextView textView1;
    private TextView textView2;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private int turn;
    private int tempTurn;
    private Random r;
    private int number1;
    private int number2;
    private int correctAnswer;
    private String correctAnswerStr;
    private ArrayList<Integer> randomsList;
    private PopUpWindow p;
    private Session currentSession;
    private SoundHandler soundHandler;
    private ArrayList<Integer> tempForRNG;
    private int correctsInTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game15_mini_game1);

        soundHandler = new SoundHandler(getApplicationContext());

        currentSession = new Session(LoginActivity.getUser().getUsername(), 15);
        currentSession.setTimeStart(System.currentTimeMillis() / 1000);
        initGui();
        initGameplay();
        p = new PopUpWindow(this, this);
        gameplay(this.turn);
    }

    public void onPause() {
        super.onPause();

    }

    public void onStop() {
        super.onStop();
        if (currentSession != null) {
            currentSession.setTimeEnd(System.currentTimeMillis() / 1000);
            DatabaseHandler dbHandler = new DatabaseHandler(this.getApplicationContext());
            dbHandler.addSessionToDB(this.currentSession);
        }
    }

    private void initGui() {
        number1View = findViewById(R.id.number1view);
        number2View = findViewById(R.id.number2view);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button1_game15);
        button2 = findViewById(R.id.button2_game15);
        button3 = findViewById(R.id.button3_game15);
        button4 = findViewById(R.id.button4_game15);
    }

    private void initGameplay() {
        this.turn = 1;
        this.tempTurn = 0;
        randomsList = new ArrayList<>();
    }

    private void generateRandoms() {
        randomsList.clear();
        r = new Random();
        randomsList.add(number1 = r.nextInt(140) + 1);
        r = new Random();
        randomsList.add(number2 = r.nextInt(140) + 1);

    }

    private void randomInAnswers() {
        tempForRNG = new ArrayList<>();
        Integer rngSeed;
        tempForRNG.add(correctAnswer);
        for (int i = 1; i < 4; i++) {

            r = new Random();
            rngSeed = r.nextInt(35);

            rngSeed = rngSeed + (Collections.max(randomsList));

            tempForRNG.add(rngSeed);
        }
        Collections.shuffle(tempForRNG);

    }

    private void setAnswersInTexts() {
        randomInAnswers();
        button1.setText(tempForRNG.get(0) + "");
        button2.setText(tempForRNG.get(1) + "");
        button3.setText(tempForRNG.get(2) + "");
        button4.setText(tempForRNG.get(3) + "");
    }

    private void initTurn(int kindOfTurn) {
        generateRandoms();

        number1View.setText(randomsList.get(0) + "");
        number2View.setText(randomsList.get(1) + "");

        switch (kindOfTurn) {
            case 4:
                correctsInTurn = 0;
                button3.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
                correctAnswer = number1 * number2;
                setAnswersInTexts();
                textView1.setText("*");
                tempTurn++;

                break;
            case 1:
                correctsInTurn = 0;
                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                correctAnswer = number1 + number2;
                setAnswersInTexts();
                textView1.setText("+");
                tempTurn++;

                break;
            case 2:
                correctsInTurn = 0;
                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                correctAnswer = number1 - number2;
                textView1.setText("-");
                setAnswersInTexts();
                tempTurn++;

                break;
            case 3:
                correctsInTurn = 0;
                button1.setText("<");
                button2.setText(">");


                button3.setVisibility(View.INVISIBLE);
                button4.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                textView1.setText("?");
                if (number1 > number2) {
                    correctAnswerStr = ">";

                } else {
                    correctAnswerStr = "<";
                }
                tempTurn++;

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


        }
    }

    private void endGame() {
        if (soundHandler != null) {
            soundHandler.stopSound();
        }
        if (currentSession != null) {
            currentSession.setTimeEnd(System.currentTimeMillis() / 1000);
            DatabaseHandler dbHandler = new DatabaseHandler(this.getApplicationContext());
            dbHandler.addSessionToDB(this.currentSession);
        }

        Intent surv = new Intent(this, SurveyActivity.class);
        SurveyActivity.setQuestionType(0);
        SurveyActivity.setGameID(15);
        startActivity(surv);
    }


    private void check2(Button button) {
        if (button.getText().toString().equals(correctAnswerStr)) {
            soundHandler.playOkSound();
            currentSession.setScore(currentSession.getScore() + 1);
            currentSession.setStage(currentSession.getStage() + 1);
            correctsInTurn++;
            p.showPopUp(getResources().getString(R.string.correct_answer2));
            if (tempTurn < 4) {
                currentSession.setScore(currentSession.getScore() + 2);
                gameplay(this.turn);
            } else {
                endGame();
            }
        } else {

            if (tempTurn < 4) {
                soundHandler.playWrongSound();
                currentSession.setScore(currentSession.getScore() - 1);
                p.showPopUp(getResources().getString(R.string.wrong_answer2));
                gameplay(this.turn);
            } else {
                endGame();
            }

        }

    }

    private void check(Button button) {

        if (correctAnswer == Integer.parseInt((String) button.getText())) {
            soundHandler.playOkSound();
            currentSession.setScore(currentSession.getScore() + 1);
            correctsInTurn++;
            p.showPopUp(getResources().getString(R.string.correct_answer2));
            if (tempTurn < 4) {
                if (correctsInTurn == 4) {
                    currentSession.setScore(currentSession.getScore() + 2);
                }
                gameplay(this.turn);
            } else {
                this.turn++;
                tempTurn = 0;
                gameplay(this.turn);
            }


        } else {
            soundHandler.playWrongSound();
            currentSession.setScore(currentSession.getScore() - 1);
            p.showPopUp(getResources().getString(R.string.wrong_answer2));
            if (tempTurn < 4) {
                gameplay(this.turn);
            } else {
                this.turn++;
                gameplay(this.turn);
            }


        }

    }

    //onClicks()
    public void button1OnClick(View view) {
        if (this.turn < 3) {
            check((Button) view);
        } else {
            check2((Button) view);
        }


    }

    public void button2OnClick(View view) {
        if (this.turn != 4) {
            check((Button) view);
        }
    }

    public void button3OnClick(View view) {

        if (this.turn < 3) {
            check((Button) view);
        } else {
            check2((Button) view);
        }

    }

    public void button4OnClick(View view) {

        check((Button) view);

    }

}
