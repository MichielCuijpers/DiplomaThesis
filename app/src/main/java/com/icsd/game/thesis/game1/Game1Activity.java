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

import com.icsd.game.thesis.Menu;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game1Activity extends AppCompatActivity {


    private static Context myCont;
    private String currentCategorie;
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
    private ArrayList<String> a;
    private Session curSession;
    private DatabaseHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        view1 = getLayoutInflater().inflate(R.layout.game1_categories_activity, null);
        view2 = getLayoutInflater().inflate(R.layout.game1_prototype, null);
        setContentView(view1);
        pickCategoryView = findViewById(R.id.textView6);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        curSession = new Session(Menu.testUser.getUsername(), 1);
        curSession.setTimeStart(System.currentTimeMillis() / 1000);
        myCont = this.getApplicationContext();
        //Question.QuestionDBEntry.addTestQuestionToDB();


    }


    //onClickMethods
    public void category1OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategorie = CATEGORY1;
        question = new Question(currentCategorie);

        initTheQuestion();
    }

    public void category2OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategorie = CATEGORY2;
        question = new Question(currentCategorie);
        initTheQuestion();
    }

    public void category3OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategorie = CATEGORY3;
        question = new Question(currentCategorie);
        initTheQuestion();

    }

    public void category4OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategorie = CATEGORY4;
        question = new Question(currentCategorie);
        initTheQuestion();

    }

    public void category5OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategorie = CATEGORY5;
        question = new Question(currentCategorie);
        initTheQuestion();

    }

    public void category6OnClick(View view) {
        setContentView(view2);
        initGuiComps();
        this.currentCategorie = CATEGORY6;
        question = new Question(currentCategorie);
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

    //funcionality methods
    private void initGuiComps() {
        this.questionView = findViewById(R.id.questionView);
        this.answer1Button = findViewById(R.id.answer1Button);
        this.answer2Button = findViewById(R.id.answer2Button);
        this.answer3Button = findViewById(R.id.answer3Button);
        this.answer4Button = findViewById(R.id.answer4Button);
    }

    private void initTheQuestion() {

        correctAnswer = this.question.answers.get(0);
        Collections.shuffle(this.question.answers);
        this.questionView.setText(this.question.getQuestion());

        this.answer1Button.setText(this.question.answers.get(0));
        this.answer2Button.setText(this.question.answers.get(1));
        this.answer3Button.setText(this.question.answers.get(2));
        this.answer4Button.setText(this.question.answers.get(3));

    }

    private void checkAnswer(Button button) {
        if (button.getText().equals(correctAnswer)) {
            Toast.makeText(this, "Congratulations. Your answer is correct!! ", Toast.LENGTH_SHORT).show();
            curSession.setScore(curSession.getScore() + 1);
            curSession.setStage(curSession.getStage() + 1);
            curSession.setTimeEnd(System.currentTimeMillis() / 1000);
            setContentView(view1);
            pickCategoryView.setText("Please choose another category");


        } else {
            Toast.makeText(this, "Wrong aswer, try one more time !!  ", Toast.LENGTH_SHORT).show();
            curSession.setFails(curSession.getFails() + 1);
        }
        if (curSession.getStage() == 6) {
            dbHandler = new DatabaseHandler(this.getApplicationContext());
            Toast.makeText(this, "Congrats!! You found all answers!! Game End Play another game ", Toast.LENGTH_LONG).show();

            Intent c = new Intent(this, Menu.class);
            startActivity(c);
        }
    }

    public static Context getMyCont() {
        return myCont;
    }


}
