package com.icsd.game.thesis.game1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

public class Game1Activity extends AppCompatActivity {


    private static Context myCont;
    private String currentCategory;
    private View view1, view2;
    private TextView questionView;
    private TextView pickCategoryView;
    private Button answer1Button;
    private Button answer2Button;
    private Button answer3Button;
    private Button answer4Button;
    private static final String CATEGORY1 = "geography";
    private static final String CATEGORY2 = "history";
    private static final String CATEGORY3 = "art";
    private static final String CATEGORY4 = "food";
    private static final String CATEGORY5 = "directory";
    private static final String CATEGORY6 = "general";
    private Question question;
    private String correctAnswer;
    private int miniTurn;
    private Session curSession;
    private DatabaseHandler dbHandler;
    private ArrayList<String> questions;
    private SoundHandler soundHandler;
    private PopUpWindow popUpWindow;
    private ArrayList<Question> questionsFinal;
    int tempFails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        init();

    }

    public void onPause() {
        super.onPause();
        endGameKill();


    }

    public void onStop() {
        super.onStop();
        endGameKill();
    }

    private void init() {
        view1 = getLayoutInflater().inflate(R.layout.game1_categories_activity, null);
        view2 = getLayoutInflater().inflate(R.layout.game1_prototype, null);
        setContentView(view1);
        pickCategoryView = findViewById(R.id.textView6);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        curSession = new Session(LoginActivity.getUser().getUsername(), 1);
        curSession.setTimeStart(System.currentTimeMillis() / 1000);
        myCont = this.getApplicationContext();
        questions = new ArrayList<>();
        soundHandler = new SoundHandler(getApplicationContext());
        popUpWindow = new PopUpWindow(this, this);
        miniTurn = 0;
        questionsFinal = new ArrayList<>();


    }

    private void initGuiComps() {
        this.questionView = findViewById(R.id.questionView);
        this.answer1Button = findViewById(R.id.checkButton5);
        this.answer2Button = findViewById(R.id.answer2Button);
        this.answer3Button = findViewById(R.id.answer3Button);
        this.answer4Button = findViewById(R.id.answer4Button);
    }

    private void initTheQuestions() {

        for (int i = 0; i < 4; i++) {
            questionsFinal.add(question = new Question(questions));
            for (int j = 0; j < 5; j++) {
                questions.remove(0);
            }
        }
        Collections.shuffle(questionsFinal);

    }

    private void initTheQuestion() {
        tempFails = 1;
        this.questionView.setText(questionsFinal.get(0).getQuestion());
        correctAnswer = questionsFinal.get(0).getAnswers().get(0);
        Collections.shuffle(question.getAnswers());
        this.answer1Button.setText(questionsFinal.get(0).getAnswers().get(0));
        this.answer2Button.setText(questionsFinal.get(0).getAnswers().get(1));
        this.answer3Button.setText(questionsFinal.get(0).getAnswers().get(2));
        this.answer4Button.setText(questionsFinal.get(0).getAnswers().get(3));
        questionsFinal.remove(0);

    }

    private void checkAnswer(Button button) {

        if (button.getText().equals(correctAnswer)) {
            soundHandler.playOkSound();
            popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
            curSession.setScore(curSession.getScore() + 1);
            curSession.setStage(curSession.getStage() + 1);

            if (questionsFinal.isEmpty()) {
                setContentView(view1);
                pickCategoryView.setText(getResources().getString(R.string.choose_another_category));
                return;
            }
            initTheQuestion();


        } else {
            soundHandler.playWrongSound();
            if (tempFails == 2) {
                popUpWindow.showPopUp("You cant try again.\n Try the next Question");
                initTheQuestion();
                return;
            }
            popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
            curSession.setFails(curSession.getFails() + 1);
            tempFails++;


        }

        if (curSession.getStage() == 24) {
            endGameKill();
        }
    }

    private void endGameKill() {
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        curSession.setTimeEnd(System.currentTimeMillis() / 1000);
        dbHandler.addSessionToDB(this.curSession);
        soundHandler.stopSound();
        popUpWindow.showPopUp(getResources().getString(R.string.end_game_congrats1));
        Intent c = new Intent(this, Menu.class);
        startActivity(c);
    }

    public static Context getMyCont() {
        return myCont;
    }

    //onClickMethods
    public void category1OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategory = CATEGORY1;
        questions = Question.QuestionDBEntry.takeQuestionFromDB(currentCategory);

        initTheQuestions();
        initTheQuestion();
    }

    public void category2OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategory = CATEGORY2;
        questions = Question.QuestionDBEntry.takeQuestionFromDB(currentCategory);
        initTheQuestions();
        initTheQuestion();
    }

    public void category3OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategory = CATEGORY3;
        questions = Question.QuestionDBEntry.takeQuestionFromDB(currentCategory);
        initTheQuestions();
        initTheQuestion();

    }

    public void category4OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategory = CATEGORY4;
        questions = Question.QuestionDBEntry.takeQuestionFromDB(currentCategory);
        initTheQuestions();
        initTheQuestion();

    }

    public void category5OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategory = CATEGORY5;
        questions = Question.QuestionDBEntry.takeQuestionFromDB(currentCategory);
        initTheQuestions();
        initTheQuestion();

    }

    public void category6OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategory = CATEGORY6;
        questions = Question.QuestionDBEntry.takeQuestionFromDB(currentCategory);
        initTheQuestions();
        initTheQuestion();

    }


    public void answer1OnClick(View view) {
        checkAnswer((Button) view);
    }

    public void answer2OnClick(View view) {
        checkAnswer((Button) view);
    }

    public void answer3OnClick(View view) {
        checkAnswer((Button) view);
    }

    public void answer4OnClick(View view) {
        checkAnswer((Button) view);
    }


}
