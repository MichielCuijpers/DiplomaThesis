package com.icsd.game.thesis.game5;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.Menu2;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;

import java.util.ArrayList;
import java.util.Collections;

import static com.icsd.game.thesis.R.drawable.hummer;

public class Game5 extends AppCompatActivity {
    private Object object;
    private ArrayList<Object> objectList;
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

    public static Context getMyCont() {
        return myCont;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game5_prototype);
        myCont = this.getApplicationContext();
        // Object.ObjectDBEntry.addTestQuestionToDB();
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        curSession = new Session(Menu.testUser.getUsername(), 5);
        curSession.setTimeStart(System.currentTimeMillis() );

        init();
        play(turn);


    }

    public void init() {
        this.answer1Button = findViewById(R.id.choise1Button);
        this.answer2Button = findViewById(R.id.choise2Button);
        this.answer3Button = findViewById(R.id.choise3Button);
        this.answer4Button = findViewById(R.id.choise4Button);
        image = findViewById(R.id.imageViewObject);
        objectList = Object.ObjectDBEntry.takeObjectsFromDB();


    }

    public void play(int turn) {
        if (endGame()) {

            Toast.makeText(this, "Congrats!! You found all answers!! Game End Play another game ", Toast.LENGTH_LONG).show();
            curSession.setTimeEnd(System.currentTimeMillis() );
            dbHandler.addSessionToDB(this.curSession);
            Intent c = new Intent(this, Menu.class);
            startActivity(c);
        }
        correct = objectList.get(turn).getAnswers().get(0);
        Collections.shuffle(objectList.get(turn).getAnswers());

        this.answer1Button.setText(objectList.get(turn).getAnswers().get(0));
        this.answer2Button.setText(objectList.get(turn).getAnswers().get(1));
        this.answer3Button.setText(objectList.get(turn).getAnswers().get(2));
        this.answer4Button.setText(objectList.get(turn).getAnswers().get(3));
        String img = objectList.get(turn).getName();
        int resID = getResources().getIdentifier(img, "drawable", getPackageName());
        Log.e("IMAGID", resID + "");

        image.setImageResource(resID);
    }

    public void check(Button button) {
        if (button.getText().equals(correct)) {
            Toast.makeText(this, "Congratulations. Your answer is correct!! ", Toast.LENGTH_SHORT).show();
            turn++;

            play(turn);
            curSession.setScore(curSession.getScore() + 1);
            curSession.setStage(curSession.getStage() + 1);


        } else {
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
        if (turn == 3) {
            return true;

        }
        return false;
    }

}
