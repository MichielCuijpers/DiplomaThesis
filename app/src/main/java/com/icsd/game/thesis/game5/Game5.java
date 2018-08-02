package com.icsd.game.thesis.game5;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.SoundHandler;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;

import java.util.ArrayList;
import java.util.Collections;

public class Game5 extends AppCompatActivity {
    private ObjectT objectT;
    private ArrayList<ObjectT> objectTList;
    private Button answer1Button;
    private Button answer2Button;
    private Button answer3Button;
    private Button answer4Button;
    private ImageView image;
    private static Context myCont;
    private int turn = 0;
    private String correct;
    private Session curSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;

    public static Context getMyCont() {
        return myCont;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game5_prototype);


        init();
        play(turn);


    }

    public void init() {
        myCont = this.getApplicationContext();

        dbHandler = new DatabaseHandler(this.getApplicationContext());
        curSession = new Session(Menu.testUser.getUsername(), 5);
        curSession.setTimeStart(System.currentTimeMillis());
        soundHandler = new SoundHandler(getApplicationContext());

        this.answer1Button = findViewById(R.id.choise1Button);
        this.answer2Button = findViewById(R.id.choise2Button);
        this.answer3Button = findViewById(R.id.choise3Button);
        this.answer4Button = findViewById(R.id.choise4Button);
        image = findViewById(R.id.imageViewObject);
        objectTList = ObjectT.ObjectDBEntry.takeObjectsFromDB();
        Collections.shuffle(objectTList);


    }

    public void play(int turn) {
        if (endGame()) {

            Toast.makeText(this, "Congrats!! You found all answers!! Game End Play another game ", Toast.LENGTH_LONG).show();
            curSession.setTimeEnd(System.currentTimeMillis());
            curSession.setScore(this.turn);
            dbHandler.addSessionToDB(this.curSession);
            Intent c = new Intent(this, Menu.class);
            startActivity(c);
        }
        correct = objectTList.get(turn).getAnswers().get(0);
        Collections.shuffle(objectTList.get(turn).getAnswers());

        this.answer1Button.setText(objectTList.get(turn).getAnswers().get(0));
        this.answer2Button.setText(objectTList.get(turn).getAnswers().get(1));
        this.answer3Button.setText(objectTList.get(turn).getAnswers().get(2));
        this.answer4Button.setText(objectTList.get(turn).getAnswers().get(3));
        String img = objectTList.get(turn).getName();
        int resID = getResources().getIdentifier(img, "drawable", getPackageName());
        Log.e("IMAGID", resID + "");

        image.setImageResource(resID);
    }

    public void check(Button button) {
        if (button.getText().equals(correct)) {
            soundHandler.playOkSound();
            Toast.makeText(this, "Congratulations. Your answer is correct!! ", Toast.LENGTH_SHORT).show();
            turn++;

            play(turn);
            curSession.setScore(curSession.getScore() + 1);
            curSession.setStage(curSession.getStage() + 1);


        } else {
            soundHandler.playWrongSound();
            Toast.makeText(this, "Wrong aswer, try one more time !!  ", Toast.LENGTH_SHORT).show();
            curSession.setFails(curSession.getFails() + 1);

        }

    }


    public void choice1OnClick(View view) {
        check((Button) view);

    }

    public void choice2OnClick(View view) {
        check((Button) view);
    }

    public void choice3OnClick(View view) {
        check((Button) view);
    }

    public void choice4OnClick(View view) {
        check((Button) view);
    }

    public Boolean endGame() {
        if (turn == 5) {
            return true;

        }
        return false;
    }

}
