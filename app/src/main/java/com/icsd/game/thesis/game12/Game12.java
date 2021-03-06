package com.icsd.game.thesis.game12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;

import com.icsd.game.thesis.activities.LoginActivity;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.SoundHandler;
import com.icsd.game.thesis.activities.SurveyActivity;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.commons.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.ArrayList;


public class Game12 extends AppCompatActivity {
    private Button play;
    private Button tutorialButton;
    private Button tutorialButton2;
    private Button ObjectButton;
    private Button ObjectButton2;
    private Button ObjectButton3;
    private Button ObjectButton4;
    private Button gprock;
    private Button gpscissors;
    private Button gppaper;
    private Button gppencil;
    private Button tie;
    private Button gameplayb1;
    private Button gameplayb2;
    private TextView title;
    private ViewGroup.LayoutParams scale;
    private StringBuilder combinefile;
    private ArrayList<Button> gameplayimages;
    private ArrayList<String> knownwinner;
    private static int corrects;
    private static int wrongs;
    private int turn_tutorial = 0;
    private String takeTextFrom1;
    private String takeTextFrom2;
    private String kwinner;
    private String chosenwinner;
    private TextView corans;
    private Session currentSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;
    private PopUpWindow popUpWindow;
    private TextView winnertext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game12);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        currentSession = new Session(LoginActivity.getUser().getUsername(), 12);
        currentSession.setTimeStart(System.currentTimeMillis() / 1000);
        soundHandler = new SoundHandler(getApplicationContext());
        popUpWindow = new PopUpWindow(this, this);
        initGraphics();
        initScreen();
    }

    public void onStop() {
        super.onStop();
        currentSession.setTimeEnd(System.currentTimeMillis() / 1000);
        dbHandler.addSessionToDB(currentSession);
        dbHandler.close();
    }

    private void initGraphics() {
        takeTextFrom1 = " ";
        takeTextFrom2 = " ";
        kwinner = " ";
        chosenwinner = " ";
        tutorialButton = findViewById(R.id.tutorialbutton); //con button
        tutorialButton2 = findViewById(R.id.tutorialbutton2); //back button
        ObjectButton = findViewById(R.id.tutorialObjectIcon);
        ObjectButton2 = findViewById(R.id.tutorialObjectIcon2);
        ObjectButton.setOnClickListener(null);
        ObjectButton2.setOnClickListener(null);
        ObjectButton3 = findViewById(R.id.tutorialObjectIcon3);
        ObjectButton4 = findViewById(R.id.tutorialObjectIcon4);
        tie = findViewById(R.id.tieb);
        gameplayimages = new ArrayList<>();
        gprock = findViewById(R.id.gameplayrock);
        gppencil = findViewById(R.id.gameplaypencil);
        gpscissors = findViewById(R.id.gameplayscissors);
        gppaper = findViewById(R.id.gameplaypaper);
        gprock.setText("rock");
        gppencil.setText("pencil");
        gpscissors.setText("scissors");
        gppaper.setText("paper");
        gameplayimages.add(gprock);
        gameplayimages.add(gppencil);
        gameplayimages.add(gpscissors);
        gameplayimages.add(gppaper);
        gameplayb1 = findViewById(R.id.gp1);
        gameplayb2 = findViewById(R.id.gp2);
        gameplayb1.setVisibility(View.INVISIBLE);
        gameplayb2.setVisibility(View.INVISIBLE);
        winnertext = findViewById(R.id.textView13);
        combinefile = new StringBuilder();
        title = findViewById(R.id.textView);
        scale = title.getLayoutParams();
        wrongs = 0;
        corrects = 0;
        knownwinner = new ArrayList<>();
        corans = findViewById(R.id.correctans);
        corans.setVisibility(View.INVISIBLE);


    }

    public void continueonClick(View view) {
        initScreen();
    }

    public void backonClick(View view) {
        clearScreen();
        Log.e("MyDEbou", getTutorial() + "");
    }

    private void initScreen() {
        if (getTutorial() == 0) {
            page1();
        } else if (getTutorial() == 1) {
            page2();
        } else if (getTutorial() == 2) {
            page3();
        } else if (getTutorial() == 3) {
            page4();
        } else if (getTutorial() == 4) {
            initGameplay();
            tutorialButton.setVisibility(View.INVISIBLE);
            tutorialButton2.setVisibility(View.INVISIBLE);
        }
    }

    private void clearScreen() {
        Log.e("MyDEbou", getTutorial() + "clear");
        if (getTutorial() == 2) {
            minustutorial();
            page1();
        } else if (getTutorial() == 3) {
            minustutorial();
            page2();
        }
    }

    private void plustutorial() {
        turn_tutorial++;
    }

    private void minustutorial() {
        turn_tutorial--;
    }

    private int getTutorial() {
        return turn_tutorial;
    }

    private void page1() {
        tutorialButton2.setVisibility(View.INVISIBLE);
        ObjectButton.setBackground(getDrawable(R.drawable.pencil));
        ObjectButton2.setBackground(getDrawable(R.drawable.paper));
        ObjectButton3.setVisibility(View.INVISIBLE);
        ObjectButton4.setVisibility(View.INVISIBLE);
        plustutorial();
    }

    private void page2() {
        ObjectButton.setBackground(getDrawable(R.drawable.paper));
        ObjectButton.setText("PAPER");
        ObjectButton2.setBackground(getDrawable(R.drawable.rock));
        ObjectButton2.setText("ROCK");
        tutorialButton2.setVisibility(View.VISIBLE);
        plustutorial();
    }

    private void page3() {
        ObjectButton.setBackground(getDrawable(R.drawable.rock));
        ObjectButton.setText("ROCK");
        ObjectButton2.setVisibility(View.INVISIBLE);
        ObjectButton3.setVisibility(View.VISIBLE);
        ObjectButton4.setVisibility(View.VISIBLE);
        ObjectButton3.setBackground(getDrawable(R.drawable.scissors));
        ObjectButton4.setBackground(getDrawable(R.drawable.pencil));
        ObjectButton3.setText("SCISSORS");
        ObjectButton4.setText("PENCIL");
        tutorialButton2.setVisibility(View.VISIBLE);
        plustutorial();
    }

    private void page4() {
        ObjectButton.setBackground(getDrawable(R.drawable.scissors));
        ObjectButton.setText("SCISSORS");
        ObjectButton2.setVisibility(View.INVISIBLE);
        ObjectButton3.setVisibility(View.VISIBLE);
        ObjectButton4.setVisibility(View.VISIBLE);
        ObjectButton3.setBackground(getDrawable(R.drawable.pencil));
        ObjectButton4.setBackground(getDrawable(R.drawable.paper));
        ObjectButton3.setText("PENCIL");
        ObjectButton4.setText("PAPER");
        tutorialButton2.setVisibility(View.VISIBLE);
        tutorialButton.setText("PLAY");
        plustutorial();
    }

    private void initGameplay() {
        Log.e("MyDEbou", "Initgameplay called");
        winnertext.setVisibility(View.INVISIBLE);
        ObjectButton3.setVisibility(View.INVISIBLE);
        ObjectButton4.setVisibility(View.INVISIBLE);
        ObjectButton.setVisibility(View.INVISIBLE);
        ObjectButton2.setVisibility(View.INVISIBLE);
        gameplayb1.setVisibility(View.VISIBLE);
        gameplayb2.setVisibility(View.VISIBLE);

        Collections.shuffle(gameplayimages);
        // do {
        for (int i = 0; i < gameplayimages.size(); i++) { //na thumithw dowhile
            if (gameplayimages.get(i).getText().equals("scissors")) {
                gameplayb1.setBackground(getDrawable(R.drawable.scissors));
                gameplayb1.setText("scissors");
                gameplayb1.setTextSize(0);
                //gpscissors.setVisibility(View.VISIBLE);
                knownwinner.add("scissors");


            } else if (gameplayimages.get(i).getText().equals("paper")) {
                gameplayb1.setBackground(getDrawable(R.drawable.paper));
                gameplayb1.setText("paper");
                gameplayb1.setTextSize(0);
                knownwinner.add("paper");

            } else if (gameplayimages.get(i).getText().equals("rock")) {
                gameplayb1.setBackground(getDrawable(R.drawable.rock));
                gameplayb1.setText("rock");
                gameplayb1.setTextSize(0);
                knownwinner.add("rock");

            } else if (gameplayimages.get(i).getText().equals("pencil")) {
                gameplayb1.setBackground(getDrawable(R.drawable.pencil));
                gameplayb1.setText("pencil");
                gameplayb1.setTextSize(0);
                knownwinner.add("pencil");

            }

        }
        Collections.shuffle(gameplayimages);
        for (int i = 0; i < gameplayimages.size(); i++) { //na thumithw dowhile
            if (gameplayimages.get(i).getText().equals("scissors")) {
                gameplayb2.setBackground(getDrawable(R.drawable.scissors));
                gameplayb2.setText("scissors");
                gameplayb2.setTextSize(0);
                //gpscissors.setVisibility(View.VISIBLE);
                knownwinner.add("scissors");


            } else if (gameplayimages.get(i).getText().equals("paper")) {
                gameplayb2.setBackground(getDrawable(R.drawable.paper));
                gameplayb2.setText("paper");
                gameplayb2.setTextSize(0);
                knownwinner.add("paper");

            } else if (gameplayimages.get(i).getText().equals("rock")) {
                gameplayb2.setBackground(getDrawable(R.drawable.rock));
                gameplayb2.setText("rock");
                gameplayb2.setTextSize(0);
                knownwinner.add("rock");

            } else if (gameplayimages.get(i).getText().equals("pencil")) {
                gameplayb2.setBackground(getDrawable(R.drawable.pencil));
                gameplayb2.setText("pencil");
                gameplayb2.setTextSize(0);
                knownwinner.add("pencil");

            }

        }
        // }while (pos<2);
        //CheckKnownWinner();
        title.setText(getResources().getString(R.string.winnerg12));
        title.setWidth(scale.width = 500);
        tie.setVisibility(View.VISIBLE);
        corans.setText("Corrects : " + corrects);


    }

    public String CheckKnownWinner(String one, String two) {
        if ((one.equals("rock")) && (two.equals("pencil"))) {
            return "rock";
        } else if ((one.equals("rock")) && (two.equals("scissors"))) {
            return "rock";
        } else if ((one.equals("rock")) && (two.equals("paper"))) {
            return "paper";
        } else if ((one.equals("pencil")) && (two.equals("paper"))) {
            return "pencil";
        } else if ((one.equals("pencil")) && (two.equals("scissors"))) {
            return "scissors";
        } else if ((one.equals("pencil")) && (two.equals("rock"))) {
            return "rock";
        } else if ((one.equals("scissors")) && (two.equals("rock"))) {
            return "rock";
        } else if ((one.equals("scissors")) && (two.equals("pencil"))) {
            return "scissors";
        } else if ((one.equals("scissors")) && (two.equals("paper"))) {
            return "scissors";
        } else if ((one.equals("paper")) && (two.equals("scissors"))) {
            return "scissors";
        } else if ((one.equals("paper")) && (two.equals("pencil"))) {
            return "pencil";
        } else if ((one.equals("paper")) && (two.equals("rock"))) {
            return "paper";
        } else {
            return "tie";
        }
    }

    public void checkWins(Button one, Button two) {
        if ((gameplayb1.getText().equals("rock")) && (gameplayb2.getText().equals("scissors"))) {

        }
    }

    public void checkEndGame() {
        if (corrects == 8 || wrongs == 6) {

            soundHandler.stopSound();
            Toast.makeText(this, "GAME END", Toast.LENGTH_SHORT).show();

            Intent surv = new Intent(this, SurveyActivity.class);
            SurveyActivity.setQuestionType(0);
            SurveyActivity.setGameID(12);
            startActivity(surv);

        }
    }

    public void p1onClick(View view) {

        kwinner = CheckKnownWinner((String) gameplayb1.getText(), (String) gameplayb2.getText());
        Log.e("MyDEbou", "To 1 exei " + gameplayb1.getText() + "kai to kwiner :" + kwinner);
        if (gameplayb1.getText().equals(kwinner)) {
            popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
            corrects++;
            currentSession.setScore(corrects);
            currentSession.setStage(corrects);
            soundHandler.playOkSound();
            checkEndGame();
            initGameplay();
        } else {
            popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
            wrongs++;
            currentSession.setFails(currentSession.getFails() + 1);
            currentSession.setScore(currentSession.getScore() - 1);
            soundHandler.playWrongSound();
            initGameplay();
        }
    }

    public void p2onClick(View view) {
        kwinner = CheckKnownWinner((String) gameplayb1.getText(), (String) gameplayb2.getText());
        Log.e("MyDEbou", "To 2 exei " + gameplayb2.getText() + "kai to kwiner :" + kwinner);
        if (gameplayb2.getText().equals(kwinner)) {
            popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
            corrects++;
            currentSession.setScore(corrects);
            currentSession.setStage(corrects);
            soundHandler.playOkSound();
            checkEndGame();
            initGameplay();
        } else {
            popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
            wrongs++;
            currentSession.setFails(currentSession.getFails() + 1);
            currentSession.setScore(currentSession.getScore() - 1);
            soundHandler.playWrongSound();
            initGameplay();
        }
    }

    public void tieonClick(View view) {
        kwinner = CheckKnownWinner((String) gameplayb1.getText(), (String) gameplayb2.getText());
        Log.e("MyDEbou", "To 2 exei " + gameplayb2.getText() + "kai to kwiner :" + kwinner);
        if (kwinner.equals("tie")) {
            popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
            corrects++;
            currentSession.setStage(corrects);
            currentSession.setScore(corrects);
            soundHandler.playOkSound();
            checkEndGame();
            initGameplay();
        } else {
            popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
            wrongs++;
            currentSession.setFails(currentSession.getFails() + 1);
            currentSession.setScore(currentSession.getScore() - 1);
            soundHandler.playWrongSound();
            initGameplay();

        }
    }


}
