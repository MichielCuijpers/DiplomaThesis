package com.icsd.game.thesis.game15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.pet.Tooltips.PopUpWindow;

import java.util.ArrayList;
import java.util.Random;

public class Game15MiniGame1 extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game15_mini_game1);
        initGui();
        initGameplay();
        gameplay(this.turn);
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
        r = new Random();
        randomsList.add(number1 = r.nextInt(200) + 1);
        r = new Random();
        randomsList.add(number2 = r.nextInt(200) + 1);

    }

    private void setAnswersInTexts() {

        button1.setText(correctAnswer + "");
        button2.setText(correctAnswer + 120 + "");
        button3.setText(correctAnswer - 15 + "");
        button4.setText(correctAnswer / 2 + "");
    }

    private void initTurn(int kindOfTurn) {


        number1View.setText(randomsList.get(0) + "");
        number2View.setText(randomsList.get(1) + "");

        if (kindOfTurn == 4) {
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            correctAnswer = number1 * number2;
            setAnswersInTexts();
            textView1.setText("*");
            tempTurn++;

        } else if (kindOfTurn == 1) {
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            correctAnswer = number1 + number2;
            setAnswersInTexts();
            textView1.setText("+");
            tempTurn++;

        } else if (kindOfTurn == 2) {
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            correctAnswer = number1 - number2;
            textView1.setText("-");
            setAnswersInTexts();
            tempTurn++;

        } else if (kindOfTurn == 3) {
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

        }


    }

    private void clean() {

    }

    private void gameplay(int turn) {
        switch (turn) {
            case 1:
                generateRandoms();
                initTurn(1);
                break;
            case 2:
                generateRandoms();
                initTurn(2);
                break;
            case 3:
                generateRandoms();
                initTurn(3);
                break;


        }
    }

    private void check2(Button button) {
        if (button.getText().toString().equals(correctAnswerStr)) {
            Toast.makeText(this, "gj ", Toast.LENGTH_SHORT).show();
            if (tempTurn < 4) {
                gameplay(this.turn);
            } else {
                //endGame
            }
        } else {
            Toast.makeText(this, "Fail, please try again ", Toast.LENGTH_SHORT).show();
            if (tempTurn < 4) {
                gameplay(this.turn);
            } else {
                //endGame
            }

        }

    }

    private void check(Button button) {
        if (correctAnswer == Integer.parseInt((String) button.getText())) {
            Toast.makeText(this, "gj ", Toast.LENGTH_SHORT).show();

            if (tempTurn < 4) {
                gameplay(this.turn);
            } else {
                this.turn++;
                gameplay(this.turn);
            }


        } else {
            Toast.makeText(this, "Fail, please try again ", Toast.LENGTH_SHORT).show();
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
        if (this.turn != 4) {
            check((Button) view);
        } else {
            check2((Button) view);
        }


    }

    public void button2OnClick(View view) {
        if (this.turn != 4) {
            check((Button) view);
        } else {
            check2((Button) view);
        }
    }

    public void button3OnClick(View view) {

        check((Button) view);

    }

    public void button4OnClick(View view) {

        check((Button) view);

    }

}
