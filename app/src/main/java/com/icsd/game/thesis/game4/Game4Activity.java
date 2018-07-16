package com.icsd.game.thesis.game4;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.icsd.game.thesis.R;

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
    private Button buttonCheck;

    public static Context getMyCont() {
        return myCont;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.game4protype);

        myCont = this.getApplicationContext();
        buttonsList = new ArrayList<>();
        takeWordsFromDB();
        initGui();
        gameplay();
        //Word.WordDBEntry.addTestWordsToDB();


    }

    private void gameplay() {
        Collections.shuffle(this.wordsList);
        initWordInGui();

    }

    private void initWordInGui() {
//
        List<String> templist = new LinkedList<String>( Arrays.asList(wordsList.get(0)));
        wordsList.set(0,shuffle(wordsList.get(0)));

            for (int i = 0; i < wordsList.get(0).length(); i++) {
                Log.e("MyDEbou", this.buttonsList.size() + "//" + wordsList.size());

                buttonsList.get(i).setText(wordsList.get(0).charAt(i)+"");
                buttonsList.get(i).setVisibility(View.VISIBLE);
            }



    }
    public String shuffle(String input){
        List<Character> characters = new ArrayList<Character>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
       return output.toString();
    }


    private void initGui() {

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
        buttonCheck = findViewById(R.id.checkButton5);
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
        for (int i = 0; i < 12; i++) {
            buttonsList.get(i).setVisibility(View.INVISIBLE);

        }
    }


    private void takeWordsFromDB() {
        wordsList = Word.WordDBEntry.takeWorldsFromDB();

    }
}
