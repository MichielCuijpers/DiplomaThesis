package com.icsd.game.thesis.game1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Game1Activity extends AppCompatActivity {


    private static Context myCont;
    private String currentCategorie;
    private View view1, view2;
    private TextView questionView;
    private Button answer1Button;
    private Button answer2Button;
    private Button answer3Button;
    private Button answer4Button;
    private static final String CATEGORY1 = "planet";
    private static final String CATEGORY2 = "history";
    private static final String CATEGORY3 = "geography";
    private static final String CATEGORY4 = "food";
    private static final String CATEGORY5 = "sports";
    private static final String CATEGORY6 = "animals";
    private Question question;
    private String correctAnswer;
    private ArrayList<String> a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view1 = getLayoutInflater().inflate(R.layout.game1_categories_activity, null);
        view2 = getLayoutInflater().inflate(R.layout.game1_prototype, null);
        setContentView(view1);
        myCont = this.getApplicationContext();
        Question.QuestionDBEntry.addTestQuestionToDB();
        initGuiComps();


    }

    public static Context getMyCont() {
        return myCont;
    }

    public void category1OnClick(View view) {
        setContentView(view2);
        this.currentCategorie = CATEGORY1;
        question = new Question(CATEGORY1);
        initTheQuestion();
    }

    public void category2OnClick(View view) {
        setContentView(view2);
        this.currentCategorie = CATEGORY2;
        question = new Question(CATEGORY2);
        initTheQuestion();
    }

    public void category3OnClick(View view) {
        setContentView(view2);
        this.currentCategorie = CATEGORY3;
        question = new Question(CATEGORY3);
        initTheQuestion();

    }

    public void category4OnClick(View view) {
        setContentView(view2);

        this.currentCategorie = CATEGORY4;
        question = new Question(CATEGORY4);
        initTheQuestion();

    }

    public void category5OnClick(View view) {
        setContentView(view2);
        this.currentCategorie = CATEGORY5;
    }

    public void category6OnClick(View view) {
        setContentView(view2);
        this.currentCategorie = CATEGORY6;
    }

    private void initGuiComps() {
        this.questionView = (TextView) findViewById(R.id.questionView);
        this.answer1Button = (Button) findViewById(R.id.answer1Button);
        this.answer2Button = (Button) findViewById(R.id.answer2Button);
        this.answer3Button = (Button) findViewById(R.id.answer3Button);
        this.answer4Button = (Button) findViewById(R.id.answer4Button);
    }

    private void initTheQuestion() {
        correctAnswer = this.question.answers.get(0);
        this.questionView.setText(this.question.getQuestion());
        Random r = new Random();
        this.answer1Button.setText(this.question.answers.get(0));
        this.answer2Button.setText(this.question.answers.get(1));
        this.answer3Button.setText(this.question.answers.get(2));
        this.answer4Button.setText(this.question.answers.get(3));

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

    private void checkAnswer(Button button) {
        if (button.getText().equals(correctAnswer)) {
            Toast.makeText(this, "Congradulations. Your answer is correct!! ", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Wrong aswer, try one more time !!  ", Toast.LENGTH_LONG).show();
        }
    }
}
