package com.icsd.game.thesis.Game14;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
public class Game14 extends AppCompatActivity {
    private Button test_again;
    private Button start_game;
    private TextView titletext;
    private Button object1;
    private Button object2;
    private Button objgameplay;
    private Button objgameplay2;
    private ArrayList<Button> heavy;
    private ArrayList<Button> light;
    private Button heavy1,heavy2,heavy3,heavy4,heavy5,heavy6,heavy7,heavy8;
    private Button light1,light2,light3,light4,light5,light6,light7,light8;
    private TextView fdb;
    private TextView instructions;
    private static int corrects;
    private static int incorrects;
    private Session currentSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;
    private PopUpWindow  popUpWindow;
    private ArrayList<String> status;
    private String statusstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game14);
        popUpWindow = new PopUpWindow(this,this);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        currentSession = new Session(LoginActivity.getUser().getUsername(),14);
        currentSession.setTimeStart(System.currentTimeMillis()/1000);
        soundHandler = new SoundHandler(getApplicationContext());
        initTutorial();
    }
    public void onStop(){
        super.onStop();
        currentSession.setTimeEnd(System.currentTimeMillis()/1000);
        dbHandler.addSessionToDB(currentSession);
    }
    private void initGraphics()
    {
        test_again = (Button) findViewById(R.id.tuto_test);
        start_game = (Button) findViewById(R.id.start_gp);
        object1 = (Button) findViewById(R.id.tutorialbutton_g14);
        object2 = (Button) findViewById(R.id.tutorialbutton_g15);
        objgameplay = (Button) findViewById(R.id.gameplaybutton_g14);
        objgameplay2 = (Button) findViewById(R.id.gameplaybutton_g15);
        titletext = (TextView) findViewById(R.id.title_14);
        fdb = (TextView) findViewById(R.id.feedback);
        instructions = (TextView) findViewById(R.id.instructions);
        instructions.setText(getResources().getString(R.string.game14_text));
        instructions.setVisibility(View.INVISIBLE);
        heavy = new ArrayList<Button>();
        light = new ArrayList<Button>();
        status = new ArrayList<String>();
        status.add("heavy");
        status.add("light");
        corrects = 0;
        incorrects = 0;
    }
    private void initTutorial(){
        initGraphics();
        initGamePlayImages();
        initTutorialScreen();
    }
    private void initGamePlay(){
        initGraphics();
        initGamePlayImages();
        initGamePlayScreen();
    }
    private void initTutorialScreen(){
        Collections.shuffle(heavy);
        fdb.setVisibility(View.INVISIBLE);
        for(int i = 0; i<heavy.size();i++)
        {
            object1.setBackground(heavy.get(i).getBackground());
            object1.setText("heavy");
        }
        Collections.shuffle(light);
        for(int i = 0; i <light.size();i++)
        {
            object2.setBackground(light.get(i).getBackground());
            object2.setText("light");
        }
    }
    private void initGamePlayScreen(){
        test_again.setVisibility(View.INVISIBLE);
        start_game.setVisibility(View.INVISIBLE);
        object1.setVisibility(View.INVISIBLE);
        object2.setVisibility(View.INVISIBLE);
        instructions.setVisibility(View.VISIBLE);
        Collections.shuffle(heavy);
        fdb.setText("Corrects : "+corrects);
        fdb.setVisibility(View.VISIBLE);
        titletext.setText("GamePlay");
        if(getStatus().equals("heavy")){
            for(int i = 0; i<heavy.size();i++)
            {
                objgameplay.setBackground(heavy.get(i).getBackground());
                objgameplay.setText("heavy");
                objgameplay.setTextSize(0);
            }
            Collections.shuffle(light);
            for(int i = 0; i <light.size();i++)
            {
                objgameplay2.setBackground(light.get(i).getBackground());
                objgameplay2.setText("light");
                objgameplay2.setTextSize(0);
            }
        }else{
            for(int i = 0; i<light.size();i++)
            {
                objgameplay.setBackground(light.get(i).getBackground());
                objgameplay.setText("light");
                objgameplay.setTextSize(0);
            }
            Collections.shuffle(heavy);
            for(int i = 0; i <heavy.size();i++)
            {
                objgameplay2.setBackground(heavy.get(i).getBackground());
                objgameplay2.setText("heavy");
                objgameplay2.setTextSize(0);
            }

        }


    }
    private String getStatus(){

        Collections.shuffle(status);
        for(int i = 0;i<status.size();i++){
            statusstring = status.get(i);
        }
        return statusstring;
    }
    private void initGamePlayImages() {
        heavy1 = (Button) findViewById(R.id.heavy);
        heavy2 = (Button) findViewById(R.id.heavy2);
        heavy3 = (Button) findViewById(R.id.heavy3);
        heavy4 = (Button) findViewById(R.id.heavy4);
        heavy5 = (Button) findViewById(R.id.heavy5);
        heavy6 = (Button) findViewById(R.id.heavy6);
        heavy7 = (Button) findViewById(R.id.heavy7);
        heavy8 = (Button) findViewById(R.id.heavy8);

        heavy1.setBackground(getDrawable(R.drawable.heavy1));
        heavy2.setBackground(getDrawable(R.drawable.heavy2));
        heavy3.setBackground(getDrawable(R.drawable.heavy3));
        heavy4.setBackground(getDrawable(R.drawable.heavy4));
        heavy5.setBackground(getDrawable(R.drawable.heavy5));
        heavy6.setBackground(getDrawable(R.drawable.heavy6));
        heavy7.setBackground(getDrawable(R.drawable.heavy7));
        heavy8.setBackground(getDrawable(R.drawable.heavy8));

        heavy.add(heavy1);
        heavy.add(heavy2);
        heavy.add(heavy3);
        heavy.add(heavy4);
        heavy.add(heavy5);
        heavy.add(heavy6);
        heavy.add(heavy7);
        heavy.add(heavy8);

        light1 = (Button) findViewById(R.id.light);
        light2 = (Button) findViewById(R.id.light2);
        light3 = (Button) findViewById(R.id.light3);
        light4 = (Button) findViewById(R.id.light4);
        light5 = (Button) findViewById(R.id.light5);
        light6 = (Button) findViewById(R.id.light6);
        light7 = (Button) findViewById(R.id.light7);
        light8 = (Button) findViewById(R.id.light8);

        light1.setBackground(getDrawable(R.drawable.light1));
        light2.setBackground(getDrawable(R.drawable.light2));
        light3.setBackground(getDrawable(R.drawable.light3));
        light4.setBackground(getDrawable(R.drawable.light4));
        light5.setBackground(getDrawable(R.drawable.light5));
        light6.setBackground(getDrawable(R.drawable.light6));
        light7.setBackground(getDrawable(R.drawable.light7));
        light8.setBackground(getDrawable(R.drawable.light8));

        light.add(light1);
        light.add(light2);
        light.add(light3);
        light.add(light4);
        light.add(light5);
        light.add(light6);
        light.add(light7);
        light.add(light8);

    }
    public void tutoonClick(View view) {
        initTutorial();
    }

    public void startgponClick(View view) {
        initGamePlay();
    }

    public void checkEndGame(){
        if(corrects==10 || incorrects==6){

            soundHandler.stopSound();
            Toast.makeText(this, "GAME END", Toast.LENGTH_SHORT).show();
            Intent surv = new Intent(this, SurveyActivity.class);
            SurveyActivity.setQuestionType(0);
            SurveyActivity.setGameID(14);
            startActivity(surv);
        }
    }

    public void gameplayonClick2(View view) {
        if(objgameplay2.getText().equals("heavy")){
            popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
            corrects++;
            fdb.setText("Corrects : "+corrects);
            currentSession.setScore(corrects);
            soundHandler.playOkSound();
            checkEndGame();
            initGamePlayScreen();
        }
        else{
            popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
            incorrects++;
            fdb.setText("Corrects : "+corrects);
            currentSession.setFails(currentSession.getFails()+1);
            soundHandler.playWrongSound();
            initGamePlayScreen();
        }
    }

    public void gameplayonClick1(View view) {
        if(objgameplay.getText().equals("heavy")){
            popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
            corrects++;
            fdb.setText("Corrects : "+corrects);
            currentSession.setScore(corrects);
            soundHandler.playOkSound();
            checkEndGame();
            initGamePlayScreen();
        }
        else{
            popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
            incorrects++;
            fdb.setText("Corrects : "+corrects);
            currentSession.setFails(currentSession.getFails()+1);
            soundHandler.playWrongSound();
            initGamePlayScreen();
        }
    }
}