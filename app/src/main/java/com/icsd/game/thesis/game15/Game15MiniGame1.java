package com.icsd.game.thesis.game15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.R;

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
    private Random r;
    private int number1;
    private int number2;
    private int kindOfTurn;
    private int correctAnswer;
    private String correctAnswerStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game15_mini_game1);
        initGui();
        initGameplay();
        initTurn();
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
    }

    private void initTurn() {
        r = new Random();
        number1 = r.nextInt(399) + 1;
        r = new Random();
        number2 = r.nextInt(399) + 1;
        r = new Random();
        kindOfTurn = r.nextInt(3) + 1;

        number1View.setText(number1 + "");
        number2View.setText(number2 + "");

        if (kindOfTurn == 4) {
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            correctAnswer = number1 + number2;
            button1.setText(correctAnswer);
            button2.setText(correctAnswer);
            button3.setText(correctAnswer);
            button4.setText(correctAnswer);
            textView1.setText("*");

        } else if (kindOfTurn == 1) {
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            correctAnswer = number1 + number2;
            button1.setText(correctAnswer + "");
            button2.setText(correctAnswer + "");
            button3.setText(correctAnswer + "");
            button4.setText(correctAnswer + "");
            textView1.setText("+");

        } else if (kindOfTurn == 2) {
            button3.setVisibility(View.VISIBLE);
            button4.setVisibility(View.VISIBLE);
            correctAnswer = number1 - number2;
            textView1.setText("-");
            button1.setText(correctAnswer + "");
            button2.setText(correctAnswer + "");
            button3.setText(correctAnswer + "");
            button4.setText(correctAnswer + "");

        } else if (kindOfTurn == 3) {
            button1.setText("<");
            button2.setText(">");
            
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            if (number1 > number2) {
                correctAnswerStr = ">";

            } else {
                correctAnswerStr = "<";
            }

        }


    }

    private void check() {


    }

    public void button1OnClick(View view) {
        if (kindOfTurn == 3 && correctAnswerStr.equals(button1.getText())) {
            Toast.makeText(this, "gj ", Toast.LENGTH_SHORT).show();
        } else if ((kindOfTurn == 1 || kindOfTurn == 2) && correctAnswer == (Integer.parseInt((String) button1.getText()))) {
            Toast.makeText(this, "gj ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fail, please try again ", Toast.LENGTH_SHORT).show();
        }


    }

    public void button2OnClick(View view) {
        if (kindOfTurn == 3 && correctAnswerStr.equals(button2.getText())) {
            Toast.makeText(this, "gj ", Toast.LENGTH_SHORT).show();
        } else if ((kindOfTurn == 1 || kindOfTurn == 2) && correctAnswer == (Integer.parseInt((String) button1.getText()))) {
            Toast.makeText(this, "gj ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fail, please try again ", Toast.LENGTH_SHORT).show();
        }
    }

    public void button3OnClick(View view) {
        if (correctAnswer == (Integer.parseInt((String) button3.getText()))) {
            Toast.makeText(this, "gj ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fail, please try again ", Toast.LENGTH_SHORT).show();
        }
    }

    public void button4OnClick(View view) {
        if (correctAnswer == (Integer.parseInt((String) button4.getText()))) {
            Toast.makeText(this, "gj ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fail, please try again ", Toast.LENGTH_SHORT).show();
        }
    }
}
