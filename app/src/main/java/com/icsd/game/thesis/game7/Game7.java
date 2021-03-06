package com.icsd.game.thesis.game7;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.commons.AppLan;
import com.icsd.game.thesis.activities.LoginActivity;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.SoundHandler;
import com.icsd.game.thesis.activities.SurveyActivity;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.commons.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.ArrayList;
import java.util.Collections;

public class Game7 extends AppCompatActivity {
    private ImageView backgroundimg;
    private ArrayList<String> backshuffle;
    private Button fridge;
    private Button kit_lamp;
    private Button wash_dish;
    private Button cooker;
    private Button smoker;
    private Button sand;
    private Button soap;
    private Button bubble;
    private Button hands;
    private Button mirror;
    private Button lamp_bath;
    private Button sofa;
    private Button dinlamp;
    private Button soundleft;
    private Button soundright;
    private Button tv;
    private ConstraintLayout main;
    private TextView quest_text; //textview pou tha emfanizei tin erwtisi
    private static int kitchen_played; //counter an paixtike plirws i kouzina
    private static int bathroom_played;
    private static int dinroom_played;
    private static int correct_answers;
    private static int wrong_answers;
    private String chosen_background;
    private String correct_answer;
    private String answer_chosen;
    private Session currentSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;
    private PopUpWindow popUpWindow;
    Questions new_question;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        TextView tutorialText;
        tutorialText = findViewById(R.id.tutorialTextView);
        tutorialText.setText(getResources().getString(R.string.tutorialGame7));

    }

    public void onStop() {
        super.onStop();
        currentSession.setTimeEnd(System.currentTimeMillis() / 1000);
        dbHandler.addSessionToDB(currentSession);
        dbHandler.close();
    }

    public void initGui() {
        new_question = new Questions();
        initQuestions();
        backgroundimg = (ImageView) findViewById(R.id.background_g7);
        quest_text = (TextView) findViewById(R.id.question_text);
        backshuffle = new ArrayList<String>();
        backshuffle.add("kitchen");
        backshuffle.add("bathroom");
        backshuffle.add("din");
        main = (ConstraintLayout) findViewById(R.id.activity_game7);
        kitchen_played = 0;
        bathroom_played = 0;
        dinroom_played = 0;
        correct_answers = 0;
        wrong_answers = 0;

        fridge = findViewById(R.id.fridge);
        kit_lamp = findViewById(R.id.kit_lamp);
        wash_dish = findViewById(R.id.wash_dish);
        cooker = findViewById(R.id.cooker);
        smoker = findViewById(R.id.smoker);
        sand = findViewById(R.id.sand);

        soap = findViewById(R.id.soap);
        bubble = findViewById(R.id.bubble);
        hands = findViewById(R.id.hands);
        mirror = findViewById(R.id.mirror);
        lamp_bath = findViewById(R.id.lamp_bath);

        tv = findViewById(R.id.tv);
        sofa = findViewById(R.id.sofa);
        dinlamp = findViewById(R.id.din_lamp);
        soundleft = findViewById(R.id.sound_left);
        soundright = findViewById(R.id.sound_right);

        fridge.setVisibility(View.INVISIBLE);
        kit_lamp.setVisibility(View.INVISIBLE);
        wash_dish.setVisibility(View.INVISIBLE);
        cooker.setVisibility(View.INVISIBLE);
        smoker.setVisibility(View.INVISIBLE);
        sand.setVisibility(View.INVISIBLE);

        soap.setVisibility(View.INVISIBLE);
        bubble.setVisibility(View.INVISIBLE);
        hands.setVisibility(View.INVISIBLE);
        mirror.setVisibility(View.INVISIBLE);
        lamp_bath.setVisibility(View.INVISIBLE);

        tv.setVisibility(View.INVISIBLE);
        sofa.setVisibility(View.INVISIBLE);
        dinlamp.setVisibility(View.INVISIBLE);
        soundleft.setVisibility(View.INVISIBLE);
        soundright.setVisibility(View.INVISIBLE);

    }

    public void pickBackground() { //elengxei an exei paixtei mia othoni kai arxikopoiei antistoixa to background
        Collections.shuffle(backshuffle);
        for (int i = 0; i < backshuffle.size(); i++) {
            chosen_background = backshuffle.get(i);
        }
        if (chosen_background.equals("kitchen")) {
            if (kitchen_played == 0) {
                initKitchen();
            } else {
                backshuffle.remove("kitchen");
                pickBackground();
            }
        } else if (chosen_background.equals("bathroom")) {
            if (bathroom_played == 0) {
                initBathroom();
            } else {
                backshuffle.remove("bathroom");
                pickBackground();
            }
        } else if (chosen_background.equals("din")) {
            if (dinroom_played == 0) {
                initDinroom();
            } else {
                backshuffle.remove("din");
                pickBackground();
                ;
            }
        }
    }

    public void initKitchen() {
        //arxikopoisi koumpiwn kouzinas
        if (new_question.check_empty_list(new_question.getKitchen()) == true) {
            kitchen_played = 1;
            fridge.setVisibility(View.INVISIBLE);
            kit_lamp.setVisibility(View.INVISIBLE);
            wash_dish.setVisibility(View.INVISIBLE);
            cooker.setVisibility(View.INVISIBLE);
            smoker.setVisibility(View.INVISIBLE);
            sand.setVisibility(View.INVISIBLE);
            pickBackground();
        } else {
            fridge.setVisibility(View.VISIBLE);
            kit_lamp.setVisibility(View.VISIBLE);
            wash_dish.setVisibility(View.VISIBLE);
            cooker.setVisibility(View.VISIBLE);
            smoker.setVisibility(View.VISIBLE);
            sand.setVisibility(View.VISIBLE);


            backgroundimg.setBackground((getDrawable(R.drawable.kitchen)));
            if (new_question.return_Questions("kitchen").equals(AppLan.getAppContext().getResources().getString(R.string.ice))) {
                quest_text.setText(getResources().getString(R.string.ice));
            } else if (new_question.return_Questions("kitchen").equals(AppLan.getAppContext().getResources().getString(R.string.bread))) {
                quest_text.setText(getResources().getString(R.string.bread));
            } else if (new_question.return_Questions("kitchen").equals(AppLan.getAppContext().getResources().getString(R.string.kitchen_lights))) {
                quest_text.setText(getResources().getString(R.string.kitchen_lights));
            } else if (new_question.return_Questions("kitchen").equals(AppLan.getAppContext().getResources().getString(R.string.bottle))) {
                quest_text.setText(getResources().getString(R.string.bottle));
            } else if (new_question.return_Questions("kitchen").equals(AppLan.getAppContext().getResources().getString(R.string.cook))) {
                quest_text.setText(getResources().getString(R.string.cook));
            } else if (new_question.return_Questions("kitchen").equals(AppLan.getAppContext().getResources().getString(R.string.smoke))) {
                quest_text.setText(getResources().getString(R.string.smoke));
            }
            new_question.deleteQuestionUsed("kitchen", quest_text.getText().toString());
            correct_answer = new_question.setCorrectAnswer(quest_text.getText().toString());

            fridge.setBackground(null);
            fridge.setTextSize(0);

            kit_lamp.setBackground(null);
            kit_lamp.setTextSize(0);

            wash_dish.setBackground(null);
            wash_dish.setTextSize(0);

            cooker.setBackground(null);
            cooker.setTextSize(0);

            smoker.setBackground(null);
            smoker.setTextSize(0);

            sand.setBackground(null);
            sand.setTextSize(0);
            //koumpia kouzinas
        }
    }

    public void initBathroom() {
        if (new_question.check_empty_list(new_question.getBathroom()) == true) {
            bathroom_played = 1;
            pickBackground();
        } else {
            soap.setVisibility(View.VISIBLE);
            bubble.setVisibility(View.VISIBLE);
            hands.setVisibility(View.VISIBLE);
            mirror.setVisibility(View.VISIBLE);
            lamp_bath.setVisibility(View.VISIBLE);
            backgroundimg.setBackground(getDrawable(R.drawable.bathroom));
            if (new_question.return_Questions("bathroom").equals(AppLan.getAppContext().getResources().getString(R.string.take_bath))) {
                quest_text.setText(getResources().getString(R.string.take_bath));
            } else if (new_question.return_Questions("bathroom").equals(AppLan.getAppContext().getResources().getString(R.string.hair))) {
                quest_text.setText(getResources().getString(R.string.hair));
            } else if (new_question.return_Questions("bathroom").equals(AppLan.getAppContext().getResources().getString(R.string.soap))) {
                quest_text.setText(getResources().getString(R.string.soap));
            } else if (new_question.return_Questions("bathroom").equals(AppLan.getAppContext().getResources().getString(R.string.bathroom_lights))) {
                quest_text.setText(getResources().getString(R.string.bathroom_lights));
            } else if (new_question.return_Questions("bathroom").equals(AppLan.getAppContext().getResources().getString(R.string.wash))) {
                quest_text.setText(getResources().getString(R.string.wash));
            }
            new_question.deleteQuestionUsed("bathroom", quest_text.getText().toString());
            correct_answer = new_question.setCorrectAnswer(quest_text.getText().toString());

            soap.setBackground(null);
            soap.setTextSize(0);

            bubble.setBackground(null);
            bubble.setTextSize(0);

            hands.setBackground(null);
            hands.setTextSize(0);

            mirror.setBackground(null);
            mirror.setTextSize(0);

            lamp_bath.setBackground(null);
            lamp_bath.setTextSize(0);

        }
    }

    public void tutorialOkOnClick(View view) {
        setContentView(R.layout.activity_game7);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        currentSession = new Session(LoginActivity.getUser().getUsername(), 7);
        currentSession.setTimeStart(System.currentTimeMillis() / 1000);
        soundHandler = new SoundHandler(getApplicationContext());
        popUpWindow = new PopUpWindow(this, this);
        initGui();
        pickBackground();
    }

    public void initDinroom() {
        if (new_question.check_empty_list(new_question.getDinroom()) == true) {
            dinroom_played = 1;
            sofa.setVisibility(View.INVISIBLE);
            tv.setVisibility(View.INVISIBLE);
            dinlamp.setVisibility(View.INVISIBLE);
            soundright.setVisibility(View.INVISIBLE);
            soundleft.setVisibility(View.INVISIBLE);
            pickBackground();
        } else {
            sofa.setVisibility(View.VISIBLE);
            tv.setVisibility(View.VISIBLE);
            dinlamp.setVisibility(View.VISIBLE);
            soundright.setVisibility(View.VISIBLE);
            soundleft.setVisibility(View.VISIBLE);
            backgroundimg.setBackground(getDrawable(R.drawable.din_room));

            if (new_question.return_Questions("din").equals(AppLan.getAppContext().getResources().getString(R.string.sit))) {
                quest_text.setText(getResources().getString(R.string.sit));
            } else if (new_question.return_Questions("din").equals(AppLan.getAppContext().getResources().getString(R.string.din_lights))) {
                quest_text.setText(getResources().getString(R.string.din_lights));
            } else if (new_question.return_Questions("din").equals(AppLan.getAppContext().getResources().getString(R.string.tv_din))) {
                quest_text.setText(getResources().getString(R.string.tv_din));
            } else if (new_question.return_Questions("din").equals(AppLan.getAppContext().getResources().getString(R.string.music))) {
                quest_text.setText(getResources().getString(R.string.music));
            }
            new_question.deleteQuestionUsed("din", quest_text.getText().toString());
            correct_answer = new_question.setCorrectAnswer(quest_text.getText().toString());

            sofa.setBackground(null);
            sofa.setTextSize(0);

            tv.setBackground(null);
            tv.setTextSize(0);

            dinlamp.setBackground(null);
            dinlamp.setTextSize(0);

            soundleft.setBackground(null);
            soundleft.setTextSize(0);

            soundright.setBackground(null);
            soundright.setTextSize(0);

        }
    }

    public void initQuestions() {
        new_question.setQuestions();
    }

    public void fridgeonClick(View view) {
        answer_chosen = fridge.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void kitLamponClick(View view) {
        answer_chosen = kit_lamp.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void washDishonClick(View view) {
        answer_chosen = wash_dish.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void cookeronclick(View view) {
        answer_chosen = cooker.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void smokeronClick(View view) {
        answer_chosen = smoker.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void sandonClick(View view) {
        answer_chosen = sand.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void handsonclick(View view) {
        answer_chosen = hands.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void mirroronclick(View view) {
        answer_chosen = mirror.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void bubbleonclick(View view) {
        answer_chosen = bubble.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void lampbathonclick(View view) {
        answer_chosen = lamp_bath.getText().toString();
        checkifWon(answer_chosen, correct_answer);

    }

    public void soaponclick(View view) {
        answer_chosen = soap.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void soundonclick(View view) {
        answer_chosen = soundright.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void tvonclick(View view) {
        answer_chosen = tv.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void sofaonclick(View view) {
        answer_chosen = sofa.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    public void dinlamponclick(View view) {
        answer_chosen = dinlamp.getText().toString();
        checkifWon(answer_chosen, correct_answer);
    }

    private void checkifWon(String answered, String chosed) {

        if (chosen_background.equals("kitchen")) {
            if (answered.equals(chosed)) {
                correct_answers++;
                currentSession.setScore(correct_answers);
                currentSession.setStage(currentSession.getStage() + 1);
                soundHandler.playOkSound();
                checkEndGame();
                popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
                initKitchen();
            } else {
                wrong_answers++;
                currentSession.setFails(currentSession.getFails() + 1);
                soundHandler.playWrongSound();
                checkEndGame();
                popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
                initKitchen();
            }

        } else if (chosen_background.equals("bathroom")) {
            if (answered.equals(chosed)) {
                correct_answers++;
                currentSession.setScore(correct_answers);
                currentSession.setStage(currentSession.getStage() + 1);
                soundHandler.playOkSound();
                checkEndGame();
                popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
                initBathroom();
            } else {
                wrong_answers++;
                currentSession.setFails(currentSession.getFails() + 1);
                soundHandler.playWrongSound();
                checkEndGame();
                popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
                initBathroom();
            }
        } else if (chosen_background.equals("din")) {
            if (answered.equals(chosed)) {
                correct_answers++;
                currentSession.setScore(correct_answers);
                currentSession.setStage(currentSession.getStage() + 1);
                soundHandler.playOkSound();
                checkEndGame();
                popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
                initDinroom();
            } else {
                wrong_answers++;
                currentSession.setFails(currentSession.getFails() + 1);
                soundHandler.playWrongSound();
                checkEndGame();
                popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
                initDinroom();
            }
        }
    }

    public void checkEndGame() {
        if (correct_answers == 8 || wrong_answers == 6) {

            soundHandler.stopSound();
            Toast.makeText(this, "GAME END", Toast.LENGTH_SHORT).show();
            Intent surv = new Intent(this, SurveyActivity.class);
            SurveyActivity.setQuestionType(0);
            SurveyActivity.setGameID(7);
            startActivity(surv);
        }
    }

    public void test(View view) {
        pickBackground();
    }


}
