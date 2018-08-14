package com.icsd.game.thesis.Game11;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.icsd.game.thesis.commons.LoginActivity;
import com.icsd.game.thesis.commons.Menu2;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.SoundHandler;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.ArrayList;
import java.util.Collections;
import static android.graphics.Color.parseColor;

public class Game11 extends AppCompatActivity {
    private ArrayList<String> shadows;
    private ArrayList<String> shadowsclicked;
    private ArrayList<Button> screenbuttons;
    private Button Buttonforpick1,Buttonforpick2,Buttonforpick3;
    private Button one,two,three,four,five,six,seven,eight,nine;
    private static int buttonpressed;
    private Runnable timer;
    private ColorDrawable buttoncolor;
    private int colorID;
    private final Handler defaultButtons = new Handler();
    private static int correct;
    private static int wrong;
    private Button test;
    private TextView correctans;
    private TextView wrongans;
    private TextView tip;
    private static int Pattern;
    private static int PatterCount;
    private Session currentSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;
    private PopUpWindow popUpWindow;
    private TextView tutorialText;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        tutorialText = findViewById(R.id.tutorialTextView);
        tutorialText.setText(getResources().getString(R.string.tutorialGame11));

    }
    private void initGui(){
        shadows = new ArrayList<String>();
        shadowsclicked = new ArrayList<String>();
        screenbuttons = new ArrayList<Button>();
        tip = (TextView) findViewById(R.id.Tip);
        one = (Button) findViewById(R.id.oneb);
        two = (Button) findViewById(R.id.twob);
        three = (Button) findViewById(R.id.threeb);
        four = (Button) findViewById(R.id.fourb);
        five = (Button) findViewById(R.id.fiveb);
        six = (Button) findViewById(R.id.sixb);
        seven = (Button) findViewById(R.id.sevenb);
        eight = (Button) findViewById(R.id.eightb);
        nine = (Button) findViewById(R.id.nineb);
        one.setBackgroundColor(parseColor("#FFFF8800"));
        two.setBackgroundColor(parseColor("#FFFF8800"));
        three.setBackgroundColor(parseColor("#FFFF8800"));
        four.setBackgroundColor(parseColor("#FFFF8800"));
        five.setBackgroundColor(parseColor("#FFFF8800"));
        six.setBackgroundColor(parseColor("#FFFF8800"));
        seven.setBackgroundColor(parseColor("#FFFF8800"));
        eight.setBackgroundColor(parseColor("#FFFF8800"));
        nine.setBackgroundColor(parseColor("#FFFF8800"));
        correctans = (TextView) findViewById(R.id.corrects);
        wrongans = (TextView) findViewById(R.id.wrongs);
        screenbuttons.add(one);
        screenbuttons.add(two);
        screenbuttons.add(three);
        screenbuttons.add(four);
        screenbuttons.add(five);
        screenbuttons.add(six);
        screenbuttons.add(seven);
        screenbuttons.add(eight);
        screenbuttons.add(nine);
        tip.setText("Try touching the patter after disappear");
        buttonpressed = 0;

        startGame();
    }
    private void startGame(){
        getPattern();
    }
    private void getPattern(){
        if(Pattern==1){
            PickRandomButtonForShadowing(screenbuttons);
        }
        else if(Pattern==2){
            PickRandomTwoButtonsForShadowing(screenbuttons);
        }
        else{
            PickRandomButtonsForShadowing(screenbuttons);
        }
    }
    private void PickRandomButtonForShadowing(ArrayList<Button> Buttons){
        Collections.shuffle(Buttons);
        for(int i = 0;i<Buttons.size();i++){
            Buttonforpick1 = (Button) Buttons.get(i);
            Buttons.remove(i);
        }
        if(Buttons.size()<8){
            ShadowoneButton(Buttonforpick1);
        }
    }
    private void PickRandomTwoButtonsForShadowing(ArrayList<Button> Buttons){
        Collections.shuffle(Buttons);
        for(int i = 0;i<Buttons.size();i++){
            Buttonforpick1 = (Button) Buttons.get(i);
            Buttons.remove(i);
        }
        Collections.shuffle(Buttons);
        for(int i = 0;i<Buttons.size();i++){
            Buttonforpick2 = (Button) Buttons.get(i);
            Buttons.remove(i);
        }
        if(Buttons.size()<8){
            ShadowingtwoButtons(Buttonforpick1,Buttonforpick2);
        }
    }
    private void PickRandomButtonsForShadowing(ArrayList<Button> Buttons){
        Collections.shuffle(Buttons);
        for(int i = 0;i<Buttons.size();i++){
            Buttonforpick1 = (Button) Buttons.get(i);
            Buttons.remove(i);
        }
        Collections.shuffle(Buttons);
        for(int i = 0;i<Buttons.size();i++){
            Buttonforpick2 = (Button) Buttons.get(i);
            Buttons.remove(i);
        }
        Collections.shuffle(Buttons);
        for(int i = 0;i<Buttons.size();i++){
            Buttonforpick3 = (Button) Buttons.get(i);
            Buttons.remove(i);
        }

        if(Buttons.size()<8){
            ShadowingButtons(Buttonforpick1,Buttonforpick2,Buttonforpick3);
        }

    }
    private void ShadowingButtons(Button onee,Button twoo,Button threee){
        onee.setBackgroundColor(parseColor("#778899"));
        twoo.setBackgroundColor(parseColor("#778899"));
        threee.setBackgroundColor(parseColor("#778899"));
        shadows.add(onee.getText().toString());
        shadows.add(twoo.getText().toString());
        shadows.add(threee.getText().toString());
        resetButtons(onee,twoo,threee);

    }
    private void ShadowoneButton(Button onee){
        onee.setBackgroundColor(parseColor("#778899"));
        shadows.add(onee.getText().toString());
        resetoneButton(onee);
    }
    private void ShadowingtwoButtons(Button onee,Button twoo){
        onee.setBackgroundColor(parseColor("#778899"));
        twoo.setBackgroundColor(parseColor("#778899"));
        shadows.add(onee.getText().toString());
        shadows.add(twoo.getText().toString());
        resettwoButtons(onee,twoo);

    }
    private void resetButtons(final Button a,final Button b,final Button c) {

        timer = new Runnable() {
            @Override
            public void run() {

                a.setBackgroundColor(parseColor("#FFFF8800"));
                b.setBackgroundColor(parseColor("#FFFF8800"));
                c.setBackgroundColor(parseColor("#FFFF8800"));


            }
        };
        defaultButtons.postDelayed(timer, 5000);
    }
    private void resetoneButton(final Button a){
        timer = new Runnable() {
            @Override
            public void run() {

                a.setBackgroundColor(parseColor("#FFFF8800"));
            }
        };
        defaultButtons.postDelayed(timer, 5000);
    }
    private void resettwoButtons(final Button a,final Button b){
        timer = new Runnable() {
            @Override
            public void run() {

                a.setBackgroundColor(parseColor("#FFFF8800"));
                b.setBackgroundColor(parseColor("#FFFF8800"));
            }
        };
        defaultButtons.postDelayed(timer, 5000);
    }
    private void isPressed(){
        buttonpressed+=1;
        CheckifMatch(shadowsclicked,shadows,buttonpressed);

    }
    private void unPress(){
        buttonpressed-=1;
    }
    private void checkEndGame(){
        if(correct==8){
            currentSession.setTimeEnd(System.currentTimeMillis()/1000);
            dbHandler.addSessionToDB(currentSession);
            soundHandler.stopSound();
            Toast.makeText(this, "GAME END", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this , Menu2.class);
            startActivity(intent);
        }
    }
    private void CheckifMatch(ArrayList<String> clicked,ArrayList<String> corrects,int pressedbuttons){
        if(Pattern==1){
            if(pressedbuttons==1){
                Collections.sort(clicked);
                Collections.sort(corrects);

                Log.e(getClass().getName(),"ArrayList clicked:"+clicked.toString());
                Log.e(getClass().getName(),"ArrayList corrects:"+corrects.toString());
                if (clicked.toString().contentEquals(corrects.toString())) {
                    tip.setText("Watch out for the next Pattern");
                    correct++;
                    currentSession.setScore(correct);
                    soundHandler.playOkSound();
                    correctans.setText("Corrects: "+correct);
                    popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
                    checkEndGame();
                    corrects.removeAll(corrects);
                    clicked.removeAll(clicked);
                    defaultButtons.removeCallbacks(timer);
                    Pattern++;
                    PatterCount++;
                    if(PatterCount==1){
                        Pattern=1;
                        initGui();
                    }else{
                        initGui();
                    }


                }else{
                    wrong++;
                    currentSession.setFails(currentSession.getFails()+1);
                    soundHandler.playWrongSound();
                    wrongans.setText("Wrongs: "+wrong);
                    popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
                    corrects.removeAll(corrects);
                    clicked.removeAll(clicked);
                    defaultButtons.removeCallbacks(timer);
                    initGui();

                }
            }
        }else if(Pattern==2){
            if(pressedbuttons==2) {
                Collections.sort(clicked);
                Collections.sort(corrects);

                Log.e(getClass().getName(),"ArrayList clicked:"+clicked.toString());
                Log.e(getClass().getName(),"ArrayList corrects:"+corrects.toString());
                if (clicked.toString().contentEquals(corrects.toString())) {
                    tip.setText("Watch out for the next Pattern");
                    correct++;
                    soundHandler.playOkSound();
                    correctans.setText("Corrects: "+correct);
                    correctans.setText("Corrects: "+correct);
                    checkEndGame();
                    popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
                    corrects.removeAll(corrects);
                    clicked.removeAll(clicked);
                    defaultButtons.removeCallbacks(timer);
                    PatterCount++;
                    if(PatterCount==2){
                        Pattern=2;
                        initGui();
                    }else{
                        Pattern=3;
                        initGui();
                    }
                }else{
                    wrong++;
                    currentSession.setFails(currentSession.getFails()+1);
                    soundHandler.playWrongSound();
                    wrongans.setText("Wrongs: "+wrong);
                    popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
                    corrects.removeAll(corrects);
                    clicked.removeAll(clicked);
                    defaultButtons.removeCallbacks(timer);
                    initGui();

                }




            }
        }else {

            if (pressedbuttons == 3) {
                Collections.sort(clicked);
                Collections.sort(corrects);

                Log.e(getClass().getName(), "ArrayList clicked:" + clicked.toString());
                Log.e(getClass().getName(), "ArrayList corrects:" + corrects.toString());
                if (clicked.toString().contentEquals(corrects.toString())) {
                    tip.setText("Watch out for the next Pattern");
                    correct++;
                    soundHandler.playOkSound();
                    correctans.setText("Corrects: "+correct);
                    correctans.setText("Corrects: " + correct);
                    checkEndGame();
                    popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
                    corrects.removeAll(corrects);
                    clicked.removeAll(clicked);
                    defaultButtons.removeCallbacks(timer);
                    Pattern++;
                    initGui();
                } else {
                    currentSession.setFails(currentSession.getFails()+1);
                    soundHandler.playWrongSound();
                    wrong++;
                    wrongans.setText("Wrongs: " + wrong);
                    popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
                    corrects.removeAll(corrects);
                    clicked.removeAll(clicked);
                    defaultButtons.removeCallbacks(timer);
                    initGui();

                }


            }
        }

    }

    public void oneonclick(View view) {
        buttoncolor = (ColorDrawable) one.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            one.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(one.getText().toString());
            isPressed();
        }else{
            one.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(one.getText().toString());
            unPress();
        }
    }

    public void sixonclick(View view) {
        buttoncolor = (ColorDrawable) six.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            six.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(six.getText().toString());
            isPressed();
        }else{
            six.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(six.getText().toString());
            unPress();
        }
    }
    public void tutorialOkOnClick(View view) {
     init();
    }
    private void init(){
        setContentView(R.layout.activity_game11);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        currentSession = new Session(LoginActivity.getUser().getUsername(),11);
        currentSession.setTimeStart(System.currentTimeMillis()/1000);
        soundHandler = new SoundHandler(getApplicationContext());
        popUpWindow = new PopUpWindow(this,this);
        correct = 0;
        wrong = 0;
        Pattern = 1;
        PatterCount = 0;
        initGui();

    }
    public void fiveonclick(View view) {
        buttoncolor = (ColorDrawable) five.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            five.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(five.getText().toString());
            isPressed();
        }else{
            five.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(five.getText().toString());
            unPress();
        }
    }

    public void sevenonclick(View view) {
        buttoncolor = (ColorDrawable) seven.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            seven.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(seven.getText().toString());
            isPressed();
        }else{
            seven.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(seven.getText().toString());
            unPress();
        }
    }

    public void fouronclick(View view) {
        buttoncolor = (ColorDrawable) four.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            four.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(four.getText().toString());
            isPressed();
        }else{
            four.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(four.getText().toString());
            unPress();
        }
    }

    public void eightonclick(View view) {
        buttoncolor = (ColorDrawable) eight.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            eight.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(eight.getText().toString());
            isPressed();
        }else{
            eight.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(eight.getText().toString());
            unPress();
        }
    }

    public void threeonclick(View view) {
        buttoncolor = (ColorDrawable) three.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            three.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(three.getText().toString());
            isPressed();
        }else{
            three.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(three.getText().toString());
            unPress();
        }
    }

    public void twoonclick(View view) {
        buttoncolor = (ColorDrawable) two.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            two.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(two.getText().toString());
            isPressed();
        }else{
            two.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(two.getText().toString());
            unPress();
        }
    }

    public void nineonclick(View view) {
        buttoncolor = (ColorDrawable) nine.getBackground();
        colorID = buttoncolor.getColor();
        if(colorID == parseColor("#FFFF8800")) {
            nine.setBackgroundColor(parseColor("#778899"));
            shadowsclicked.add(nine.getText().toString());
            isPressed();
        }else{
            nine.setBackgroundColor(parseColor("#FFFF8800"));
            shadowsclicked.remove(nine.getText().toString());
            unPress();
        }
    }
}
