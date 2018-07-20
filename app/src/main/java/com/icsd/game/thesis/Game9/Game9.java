package com.icsd.game.thesis.Game9;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game9 extends AppCompatActivity {
    private ArrayList<Button> colorObjects;   /* list with all color objects */
    private ArrayList<String> allColor;      /* list with all color name */
    private ArrayList<Button> correctAnswers; /* list with all correct answers PER turn */ /*Initialize in every turn*/
    private ArrayList<String> clickedAnswers; /* list with all all answers user answered PER turn */ /*Initialize in every turn*/
    private ArrayList<Button> correctColorButtons; /* list with all buttons initialized in tutorial and gameplay */
    /* $$$$$$ */

    private Button randomcolor1;      /*     BUTTONS   */
    private Button randomcolor2;        /* FOR */
    private Button randomcolor3;        /*   GAMEPLAY */
    private Button randomcolor4;
    private Button randomcolor5;
    private Button randomcolor6;
    private Button removeTest;
    private Button answergp1;
    private Button answergp2;
    private Button answergp3;
    private Button answergp4;
    private Button answergp5;
    private Button answergp6;
    private Button controlgp;
    private Button controltuto;
    private TextView cmd;
    private TextView feedback;
    private TextView title;
    /* $$$$$$ */
    private Button green1, green2, green3, green4, green5;
    private Button red1, red2, red3, red4, red5;
    private Button blue1, blue2, blue3, blue4, blue5;                 /*     BUTTONS   */
    private Button purple1, purple2, purple3, purple4, purple5;        /* FOR */
    private Button black1, black2, black3, black4, black5;            /*   ImageBackground */
    private Button yel1, yel2, yel3, yel4, yel5;
    /* $$$$$$ */
    private int turn; /* keeps the round */
    private static  int countCorrectAnswers = 0;
    private static  int  countWrongAnswers = 0;
    private int positionofrandomcolor;
    private int positionofshuffledarraylist;/* for the random method in PickRandColor */
    private Random randC;
    private Random randP;
    private String getColor;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game9);
        initTutorialGui();
    }
    private void initVariables()
    {
        turn = 0;
    }
    private void initGeneralGraphics() {
        colorObjects = new ArrayList<Button>();
        allColor = new ArrayList<String>();
        correctAnswers = new ArrayList<Button>();
        clickedAnswers = new ArrayList<String>();
        correctColorButtons = new ArrayList<Button>();
        randC = new Random();
        randP = new Random();
        cmd = (TextView) findViewById(R.id.command);
        controlgp = (Button) findViewById(R.id.goplay);
        controltuto = (Button) findViewById(R.id.tutorial_test);
        feedback = (TextView) findViewById(R.id.found);
        title = (TextView) findViewById(R.id.textView12);
    } /* Initialize all General Items */
    private void initAllColor() /* Init all Colors ArrayList */
    {
        allColor.add("green");
        allColor.add("red");
        allColor.add("black");
        allColor.add("blue");
        allColor.add("purple");
        allColor.add("yellow");
    }
    private void initColorObjects() {

        green1 = (Button) findViewById(R.id.green1);
        green2 = (Button) findViewById(R.id.green2);
        green3 = (Button) findViewById(R.id.green3);
        green4 = (Button) findViewById(R.id.green4);
        green5 = (Button) findViewById(R.id.green5);

        green1.setBackground(getDrawable(R.drawable.gr1));
        green2.setBackground(getDrawable(R.drawable.gr2));
        green3.setBackground(getDrawable(R.drawable.gr3));
        green4.setBackground(getDrawable(R.drawable.gr4));
        green5.setBackground(getDrawable(R.drawable.gr5));

        red1 = (Button) findViewById(R.id.red1);
        red2 = (Button) findViewById(R.id.red2);
        red3 = (Button) findViewById(R.id.red3);
        red4 = (Button) findViewById(R.id.red4);
        red5 = (Button) findViewById(R.id.red5);

        red1.setBackground(getDrawable(R.drawable.r1));
        red2.setBackground(getDrawable(R.drawable.r2));
        red3.setBackground(getDrawable(R.drawable.r3));
        red4.setBackground(getDrawable(R.drawable.r4)); //problima auti i eikona i r4
        red5.setBackground(getDrawable(R.drawable.r5));

        blue1 = (Button) findViewById(R.id.blue1);
        blue2 = (Button) findViewById(R.id.blue2);
        blue3 = (Button) findViewById(R.id.blue3);
        blue4 = (Button) findViewById(R.id.blue4);
        blue5 = (Button) findViewById(R.id.blue5);

        blue1.setBackground(getDrawable(R.drawable.bl1));
        blue2.setBackground(getDrawable(R.drawable.bl2));
        blue3.setBackground(getDrawable(R.drawable.bl3));
        blue4.setBackground(getDrawable(R.drawable.bl4));
        blue5.setBackground(getDrawable(R.drawable.bl5));

        purple1 = (Button) findViewById(R.id.purple1);
        purple2 = (Button) findViewById(R.id.purple2);
        purple3 = (Button) findViewById(R.id.purple3);
        purple4 = (Button) findViewById(R.id.purple4);
        purple5 = (Button) findViewById(R.id.purple5);

        purple1.setBackground(getDrawable(R.drawable.pr1));
        purple2.setBackground(getDrawable(R.drawable.pr2));
        purple3.setBackground(getDrawable(R.drawable.pr3));
        purple4.setBackground(getDrawable(R.drawable.pr4));
        purple5.setBackground(getDrawable(R.drawable.pr5));

        black1 = (Button) findViewById(R.id.black1);
        black2 = (Button) findViewById(R.id.black2);
        black3 = (Button) findViewById(R.id.black3);
        black4 = (Button) findViewById(R.id.black4);
        black5 = (Button) findViewById(R.id.black5);

        black1.setBackground(getDrawable(R.drawable.blc1));
        black2.setBackground(getDrawable(R.drawable.blc2));
        black3.setBackground(getDrawable(R.drawable.blc3));
        black4.setBackground(getDrawable(R.drawable.blc4));
        black5.setBackground(getDrawable(R.drawable.blc5));


        yel1 = (Button) findViewById(R.id.yellow1);
        yel2 = (Button) findViewById(R.id.yellow2);
        yel3 = (Button) findViewById(R.id.yellow3);
        yel4 = (Button) findViewById(R.id.yellow4);
        yel5 = (Button) findViewById(R.id.yellow5);

        yel1.setBackground(getDrawable(R.drawable.yl1));
        yel2.setBackground(getDrawable(R.drawable.yl2));
        yel3.setBackground(getDrawable(R.drawable.yl3));
        yel4.setBackground(getDrawable(R.drawable.yl4));
        yel5.setBackground(getDrawable(R.drawable.yl5));

        colorObjects.add(green1);
        colorObjects.add(green2);
        colorObjects.add(green3);
        colorObjects.add(green4);
        colorObjects.add(green5);
        colorObjects.add(red1);
        colorObjects.add(red2);
        colorObjects.add(red3);
        colorObjects.add(red4);
        colorObjects.add(red5);
        colorObjects.add(blue1);
        colorObjects.add(blue2);
        colorObjects.add(blue3);
        colorObjects.add(blue4);
        colorObjects.add(blue5);
        colorObjects.add(black1);
        colorObjects.add(black2);
        colorObjects.add(black3);
        colorObjects.add(black4);
        colorObjects.add(black5);
        colorObjects.add(yel1);
        colorObjects.add(yel2);
        colorObjects.add(yel3);
        colorObjects.add(yel4);
        colorObjects.add(yel5);
        colorObjects.add(purple1);
        colorObjects.add(purple2);
        colorObjects.add(purple3);
        colorObjects.add(purple4);
        colorObjects.add(purple5);

    } /* Init all buttons with images */
    private void initTutorialGui(){
        initVariables();
        initGeneralGraphics();
        initAllColor();
        initColorObjects();
        initGamePlayButtons();
        checkColor(returnColor());
        feedback.setVisibility(View.INVISIBLE);
    }
    private void GamePlay(){
        initVariables();
        initGeneralGraphics();
        initAllColor();
        initColorObjects();
        initGamePlayButtons();
        checkColor(returnColor());
        initAnswerButtons();
        removeTest.setVisibility(View.INVISIBLE);
        randomcolor1.setTextSize(0);
        randomcolor2.setTextSize(0);
        randomcolor3.setTextSize(0);
        randomcolor4.setTextSize(0);
        randomcolor5.setTextSize(0);
        randomcolor6.setTextSize(0);
        controlgp.setVisibility(View.INVISIBLE);
        controltuto.setVisibility(View.INVISIBLE);
        title.setText("PLAYTIME");
        initFeedback();
        feedback.setVisibility(View.VISIBLE);
    }
    private String PickRandColor(ArrayList<String> turn) /* Shuffle colors arraylist and return a random color */
    {
        Collections.shuffle(turn);
        positionofrandomcolor = randC.nextInt(turn.size()-1)+1;
        return (String) turn.get(positionofrandomcolor);
    }
    private void plusRound() /* counter for rounds */
    {
        turn++;
    }
    private void initGamePlayButtons(){
        randomcolor1 = (Button) findViewById(R.id.gpbutton1);
        randomcolor2 = (Button) findViewById(R.id.gpbutton4);
        randomcolor3 = (Button) findViewById(R.id.gpbutton3);
        randomcolor4 = (Button) findViewById(R.id.gpbutton2);
        randomcolor5 = (Button) findViewById(R.id.gpbutton5);
        randomcolor6 = (Button) findViewById(R.id.gpbutton6);
        removeTest = (Button) findViewById(R.id.tutorial_test);
        correctColorButtons.add(randomcolor1);
        correctColorButtons.add(randomcolor2);
        correctColorButtons.add(randomcolor3);
        correctColorButtons.add(randomcolor4);
        correctColorButtons.add(randomcolor5);
        correctColorButtons.add(randomcolor6);
    }
    private void initAnswerButtons(){
        answergp1 = (Button) findViewById(R.id.gpbutton1);
        answergp2 = (Button) findViewById(R.id.gpbutton4);
        answergp3 = (Button) findViewById(R.id.gpbutton3);
        answergp4 = (Button) findViewById(R.id.gpbutton2);
        answergp5 = (Button) findViewById(R.id.gpbutton5);
        answergp6 = (Button) findViewById(R.id.gpbutton6);
    }
    private void checkColor(String color){
        if(color.equals("green")) {
            CheckGreens();
        }
        else if(color.equals("blue")){
            CheckBlue();
        }
        else if(color.equals("black")){
            CheckBlack();
        }
        else if(color.equals("purple")){
            CheckPurple();
        }
        else if(color.equals("yellow")){
            CheckYellow();
        }
        else if(color.equals("red")){
            CheckRed();
        }
    }
    private void CheckGreens()
    {
            for(int correct1=0;correct1<correctColorButtons.size();correct1++){
                Collections.shuffle(colorObjects);
                for(int list = 0;list<colorObjects.size();list++)
                {
                    if(colorObjects.get(list).getText().equals("green")) {
                        cmd.setText("CLICK THE GREEN ITEMS");
                        randomcolor1.setBackground(colorObjects.get(list).getBackground());
                        randomcolor1.setText(colorObjects.get(list).getText());
                        correctColorButtons.remove(randomcolor1);
                    }
                }
            }
            for(int correct2=0;correct2<correctColorButtons.size();correct2++){
                Collections.shuffle(colorObjects);
                for(int list2 = 0;list2<colorObjects.size();list2++)
                {
                    if(colorObjects.get(list2).getText().equals("green")) {
                        randomcolor5.setBackground(colorObjects.get(list2).getBackground());
                        randomcolor5.setText(colorObjects.get(list2).getText());
                        correctColorButtons.remove(randomcolor5);
                    }
                }
            }
            for(int removable = 0;removable<colorObjects.size();removable++){
                if(colorObjects.get(removable).getText().equals("green")){
                    colorObjects.remove(colorObjects.get(removable));
                }
            }

            Collections.shuffle(colorObjects);
            for(int i=0;i<colorObjects.size();i++){
            {
                randomcolor2.setBackground(colorObjects.get(i).getBackground());
                randomcolor2.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor3.setBackground(colorObjects.get(i).getBackground());
                randomcolor3.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor4.setBackground(colorObjects.get(i).getBackground());
                randomcolor4.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor6.setBackground(colorObjects.get(i).getBackground());
                randomcolor6.setText(colorObjects.get(i).getText());
            }
            correctAnswers.add(randomcolor1);
            correctAnswers.add(randomcolor2);
            correctAnswers.add(randomcolor3);
            correctAnswers.add(randomcolor4);
            correctAnswers.add(randomcolor5);
            correctAnswers.add(randomcolor6);
        }
    }
    private void CheckBlue()
    {
        for(int correct1=0;correct1<correctColorButtons.size();correct1++){
            Collections.shuffle(colorObjects);
            for(int list = 0;list<colorObjects.size();list++)
            {
                if(colorObjects.get(list).getText().equals("blue")) {
                    cmd.setText("CLICK THE BLUE ITEMS");
                    randomcolor1.setBackground(colorObjects.get(list).getBackground());
                    randomcolor1.setText(colorObjects.get(list).getText());
                    correctColorButtons.remove(randomcolor1);
                }
            }
        }
        for(int correct2=0;correct2<correctColorButtons.size();correct2++){
            Collections.shuffle(colorObjects);
            for(int list2 = 0;list2<colorObjects.size();list2++)
            {
                if(colorObjects.get(list2).getText().equals("blue")) {
                    randomcolor5.setBackground(colorObjects.get(list2).getBackground());
                    randomcolor5.setText(colorObjects.get(list2).getText());
                    correctColorButtons.remove(randomcolor5);
                }
            }
        }
        for(int removable = 0;removable<colorObjects.size();removable++){
            if(colorObjects.get(removable).getText().equals("blue")){
                colorObjects.remove(colorObjects.get(removable));
            }
        }
        Collections.shuffle(colorObjects);
        for(int i=0;i<colorObjects.size();i++){
            {
                randomcolor2.setBackground(colorObjects.get(i).getBackground());
                randomcolor2.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor3.setBackground(colorObjects.get(i).getBackground());
                randomcolor3.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor4.setBackground(colorObjects.get(i).getBackground());
                randomcolor4.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor6.setBackground(colorObjects.get(i).getBackground());
                randomcolor6.setText(colorObjects.get(i).getText());
            }
        }
        correctAnswers.add(randomcolor1);
        correctAnswers.add(randomcolor2);
        correctAnswers.add(randomcolor3);
        correctAnswers.add(randomcolor4);
        correctAnswers.add(randomcolor5);
        correctAnswers.add(randomcolor6);
    }
    private void CheckBlack()
    {
        for(int correct1=0;correct1<correctColorButtons.size();correct1++){
            Collections.shuffle(colorObjects);
            for(int list = 0;list<colorObjects.size();list++)
            {
                if(colorObjects.get(list).getText().equals("black")) {
                    cmd.setText("CLICK THE BLACK ITEMS");
                    randomcolor1.setBackground(colorObjects.get(list).getBackground());
                    randomcolor1.setText(colorObjects.get(list).getText());
                    correctColorButtons.remove(randomcolor1);
                }
            }
        }
        for(int correct2=0;correct2<correctColorButtons.size();correct2++){
            Collections.shuffle(colorObjects);
            for(int list2 = 0;list2<colorObjects.size();list2++)
            {
                if(colorObjects.get(list2).getText().equals("black")) {
                    randomcolor5.setBackground(colorObjects.get(list2).getBackground());
                    randomcolor5.setText(colorObjects.get(list2).getText());
                    correctColorButtons.remove(randomcolor5);
                }
            }
        }
        for(int removable = 0;removable<colorObjects.size();removable++){
            if(colorObjects.get(removable).getText().equals("black")){
                colorObjects.remove(colorObjects.get(removable));
            }
        }
        Collections.shuffle(colorObjects);
        for(int i=0;i<colorObjects.size();i++){
            {
                randomcolor2.setBackground(colorObjects.get(i).getBackground());
                randomcolor2.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor3.setBackground(colorObjects.get(i).getBackground());
                randomcolor3.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor4.setBackground(colorObjects.get(i).getBackground());
                randomcolor4.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor6.setBackground(colorObjects.get(i).getBackground());
                randomcolor6.setText(colorObjects.get(i).getText());
            }
        }
        correctAnswers.add(randomcolor1);
        correctAnswers.add(randomcolor2);
        correctAnswers.add(randomcolor3);
        correctAnswers.add(randomcolor4);
        correctAnswers.add(randomcolor5);
        correctAnswers.add(randomcolor6);
    }
    private void CheckPurple()
    {
        for(int correct1=0;correct1<correctColorButtons.size();correct1++){
            Collections.shuffle(colorObjects);
            for(int list = 0;list<colorObjects.size();list++)
            {
                if(colorObjects.get(list).getText().equals("purple")) {
                    cmd.setText("CLICK THE PURPLE ITEMS");
                    randomcolor1.setBackground(colorObjects.get(list).getBackground());
                    randomcolor1.setText(colorObjects.get(list).getText());
                    correctColorButtons.remove(randomcolor1);
                }
            }
        }
        for(int correct2=0;correct2<correctColorButtons.size();correct2++){
            Collections.shuffle(colorObjects);
            for(int list2 = 0;list2<colorObjects.size();list2++)
            {
                if(colorObjects.get(list2).getText().equals("purple")) {
                    randomcolor5.setBackground(colorObjects.get(list2).getBackground());
                    randomcolor5.setText(colorObjects.get(list2).getText());
                    correctColorButtons.remove(randomcolor5);
                }
            }
        }
        for(int removable = 0;removable<colorObjects.size();removable++){
            if(colorObjects.get(removable).getText().equals("purple")){
                colorObjects.remove(colorObjects.get(removable));
            }
        }
        Collections.shuffle(colorObjects);
        for(int i=0;i<colorObjects.size();i++){
            {
                randomcolor2.setBackground(colorObjects.get(i).getBackground());
                randomcolor2.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor3.setBackground(colorObjects.get(i).getBackground());
                randomcolor3.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor4.setBackground(colorObjects.get(i).getBackground());
                randomcolor4.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor6.setBackground(colorObjects.get(i).getBackground());
                randomcolor6.setText(colorObjects.get(i).getText());
            }
        }
        correctAnswers.add(randomcolor1);
        correctAnswers.add(randomcolor2);
        correctAnswers.add(randomcolor3);
        correctAnswers.add(randomcolor4);
        correctAnswers.add(randomcolor5);
        correctAnswers.add(randomcolor6);
    }
    private void CheckYellow()
    {
        for(int correct1=0;correct1<correctColorButtons.size();correct1++){
            Collections.shuffle(colorObjects);
            for(int list = 0;list<colorObjects.size();list++)
            {
                if(colorObjects.get(list).getText().equals("yellow")) {
                    cmd.setText("CLICK THE YELLOW ITEMS");
                    randomcolor1.setBackground(colorObjects.get(list).getBackground());
                    randomcolor1.setText(colorObjects.get(list).getText());
                    correctColorButtons.remove(randomcolor1);
                }
            }
        }
        for(int correct2=0;correct2<correctColorButtons.size();correct2++){
            Collections.shuffle(colorObjects);
            for(int list2 = 0;list2<colorObjects.size();list2++)
            {
                if(colorObjects.get(list2).getText().equals("yellow")) {
                    randomcolor5.setBackground(colorObjects.get(list2).getBackground());
                    randomcolor5.setText(colorObjects.get(list2).getText());
                    correctColorButtons.remove(randomcolor5);
                }
            }
        }
        for(int removable = 0;removable<colorObjects.size();removable++){
            if(colorObjects.get(removable).getText().equals("yellow")){
                colorObjects.remove(colorObjects.get(removable));
            }
        }
        Collections.shuffle(colorObjects);
        for(int i=0;i<colorObjects.size();i++){
            {
                randomcolor2.setBackground(colorObjects.get(i).getBackground());
                randomcolor2.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor3.setBackground(colorObjects.get(i).getBackground());
                randomcolor3.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor4.setBackground(colorObjects.get(i).getBackground());
                randomcolor4.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor6.setBackground(colorObjects.get(i).getBackground());
                randomcolor6.setText(colorObjects.get(i).getText());
            }
        }
        correctAnswers.add(randomcolor1);
        correctAnswers.add(randomcolor2);
        correctAnswers.add(randomcolor3);
        correctAnswers.add(randomcolor4);
        correctAnswers.add(randomcolor5);
        correctAnswers.add(randomcolor6);
    }
    private void CheckRed()
    {
        for(int correct1=0;correct1<correctColorButtons.size();correct1++){
            Collections.shuffle(colorObjects);
            for(int list = 0;list<colorObjects.size();list++)
            {
                if(colorObjects.get(list).getText().equals("red")) {
                    cmd.setText("CLICK THE RED ITEMS");
                    randomcolor1.setBackground(colorObjects.get(list).getBackground());
                    randomcolor1.setText(colorObjects.get(list).getText());
                    correctColorButtons.remove(randomcolor1);
                }
            }
        }
        for(int correct2=0;correct2<correctColorButtons.size();correct2++){
            Collections.shuffle(colorObjects);
            for(int list2 = 0;list2<colorObjects.size();list2++)
            {
                if(colorObjects.get(list2).getText().equals("red")) {
                    randomcolor5.setBackground(colorObjects.get(list2).getBackground());
                    randomcolor5.setText(colorObjects.get(list2).getText());
                    correctColorButtons.remove(randomcolor5);
                }
            }
        }
        for(int removable = 0;removable<colorObjects.size();removable++){
            if(colorObjects.get(removable).getText().equals("red")){
                colorObjects.remove(colorObjects.get(removable));
            }
        }
        Collections.shuffle(colorObjects);
        for(int i=0;i<colorObjects.size();i++){
            {
                randomcolor2.setBackground(colorObjects.get(i).getBackground());
                randomcolor2.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor3.setBackground(colorObjects.get(i).getBackground());
                randomcolor3.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor4.setBackground(colorObjects.get(i).getBackground());
                randomcolor4.setText(colorObjects.get(i).getText());
                Collections.shuffle(colorObjects);
                randomcolor6.setBackground(colorObjects.get(i).getBackground());
                randomcolor6.setText(colorObjects.get(i).getText());
            }
        }
        correctAnswers.add(randomcolor1);
        correctAnswers.add(randomcolor2);
        correctAnswers.add(randomcolor3);
        correctAnswers.add(randomcolor4);
        correctAnswers.add(randomcolor5);
        correctAnswers.add(randomcolor6);
    }
    private  String returnColor()
    {
        getColor = PickRandColor(allColor);
        return getColor;
    }
    private int randPositionofList()
    {
        return positionofshuffledarraylist = randP.nextInt(colorObjects.size()-1)+1;
    }
    private void CheckWinner(ArrayList<String> answers, ArrayList<Button> correct){
        for(int i = 0;i<correctAnswers.size();i++)
        {
            for(int j = 0;j<answers.size();j++)
            {
                if(answers.get(j).equals(correctAnswers.get(i).getText())){
                    countCorrectAnswers+=1;
                    initFeedback();
                    Toast.makeText(this, "WON  ", Toast.LENGTH_SHORT).show();
                    GamePlay();
                }
                else if(!answers.get(j).equals(correctAnswers.get(i).getText())){
                    countWrongAnswers+=1;
                    initFeedback();
                    Toast.makeText(this, "LOSE  ", Toast.LENGTH_SHORT).show();
                    GamePlay();
                }
            }
        }
    }
    public void initFeedback()
    {
        feedback.setText("Corrects: "+returnCorrectAnswers());
    }
    public int returnCorrectAnswers(){
        return countCorrectAnswers;
    }
    public int returnWrongAnswers(){
        return countWrongAnswers;
    }
    public void goplayonClick(View view) {
        GamePlay();
    }

    public void gpbutton1onClick(View view) {
        answer1 = randomcolor1.getText().toString();
        clickedAnswers.add(answer1);
        CheckWinner(clickedAnswers,correctAnswers);
    }

    public void gpbutton2onClick(View view) {
        Log.e("ANSWER2", answer2 + "");
        answer2 = randomcolor2.getText().toString();
        clickedAnswers.add(answer2);
        CheckWinner(clickedAnswers,correctAnswers);
    }

    public void gpbutton3onClick(View view) {
        Log.e("ANSWER3", answer3 + "");
        answer3 = randomcolor3.getText().toString();
        clickedAnswers.add(answer3);
        CheckWinner(clickedAnswers,correctAnswers);
    }

    public void gpbutton4onClick(View view) {
        Log.e("ANSWER4", answer4 + "");
        answer4 = randomcolor4.getText().toString();
        clickedAnswers.add(answer4);
        CheckWinner(clickedAnswers,correctAnswers);
    }


    public void gpbutton5onClick(View view) {
        Log.e("ANSWER5", answer5 + "");
        answer5 = randomcolor5.getText().toString();
        clickedAnswers.add(answer5);
        CheckWinner(clickedAnswers,correctAnswers);
    }

    public void gpbutton6onClick(View view) {
        Log.e("ANSWER6", answer6 + "");
        answer6 = randomcolor6.getText().toString();
        clickedAnswers.add(answer6);
        CheckWinner(clickedAnswers,correctAnswers);
    }
    public void testonClick(View view) {
        initTutorialGui();
    }
}
