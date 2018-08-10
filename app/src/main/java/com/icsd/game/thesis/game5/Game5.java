package com.icsd.game.thesis.game5;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.icsd.game.thesis.LoginActivity;
import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.SoundHandler;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Game5 extends AppCompatActivity {
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
    private PopUpWindow popUpWindow;

    public static Context getMyCont() {
        return myCont;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game5_prototype);


        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        play(turn);


    }

    public void onPause() {
        super.onPause();
        endGameKill();


    }

    public void onStop() {
        super.onStop();
        endGameKill();

    }


    private void init() throws IOException {
        myCont = this.getApplicationContext();

        dbHandler = new DatabaseHandler(this.getApplicationContext());
        curSession = new Session(LoginActivity.getUser().getUsername(), 5);
        curSession.setTimeStart(System.currentTimeMillis());
        soundHandler = new SoundHandler(getApplicationContext());

        this.answer1Button = findViewById(R.id.choise1Button);
        this.answer2Button = findViewById(R.id.choise2Button);
        this.answer3Button = findViewById(R.id.choise3Button);
        this.answer4Button = findViewById(R.id.choise4Button);
        image = findViewById(R.id.imageViewObject);
        objectTList = ObjectT.ObjectDBEntry.takeObjectsFromDB();
        Collections.shuffle(objectTList);
        popUpWindow = new PopUpWindow(myCont, this);


    }

    private void cleanBackgroundForPopUp() {


        if (popUpWindow.getmPopupWindow().isShowing()) {

            image.setVisibility(View.INVISIBLE);

        }
        popUpWindow.getmPopupWindow().setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {

                image.setVisibility(View.VISIBLE);

            }
        });

    }

    private void endGameKill() {
        curSession.setTimeEnd(System.currentTimeMillis());
        curSession.setScore(this.turn);
        dbHandler.addSessionToDB(this.curSession);
        Intent c = new Intent(this, Menu.class);
        startActivity(c);
    }

    private void play(int turn) {
        if (endGame()) {
            endGameKill();

        }
        correct = objectTList.get(turn).getAnswers().get(0);
        Collections.shuffle(objectTList.get(turn).getAnswers());

        this.answer1Button.setText(objectTList.get(turn).getAnswers().get(0));
        this.answer2Button.setText(objectTList.get(turn).getAnswers().get(1));
        this.answer3Button.setText(objectTList.get(turn).getAnswers().get(2));
        this.answer4Button.setText(objectTList.get(turn).getAnswers().get(3));
        String img = objectTList.get(turn).getName();
        int resID = getResources().getIdentifier(img, "drawable", getPackageName());
        image.setImageResource(resID);
    }

    private void check(Button button) {
        if (button.getText().equals(correct)) {
            soundHandler.playOkSound();
            popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
            cleanBackgroundForPopUp();
            turn++;

            play(turn);
            curSession.setScore(curSession.getScore() + 1);
            curSession.setStage(curSession.getStage() + 1);


        } else {
            soundHandler.playWrongSound();
            popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer2));
            cleanBackgroundForPopUp();
            curSession.setFails(curSession.getFails() + 1);

        }

    }

    private Boolean endGame() {
        return turn == 5;
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


}
