package com.icsd.game.thesis.game5;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.icsd.game.thesis.R;

import java.util.ArrayList;

import static com.icsd.game.thesis.R.drawable.hummer;

public class Game5 extends AppCompatActivity {
    private Object object;
    private ArrayList<String> objectList;
    private Button answer1Button;
    private Button answer2Button;
    private Button answer3Button;
    private Button answer4Button;
    private ImageView image;
    private static Context myCont;
    public static Context getMyCont() {
        return myCont;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game5_prototype);
        myCont = this.getApplicationContext();
        Object.ObjectDBEntry.addTestQuestionToDB();
        init();


    }

    public void init() {
        this.answer1Button = findViewById(R.id.answer1Button);
        this.answer2Button = findViewById(R.id.answer2Button);
        this.answer3Button = findViewById(R.id.answer3Button);
        this.answer4Button = findViewById(R.id.answer4Button);
        image = findViewById(R.id.imageViewObject);
        object = new Object();
        this.answer1Button.setText(object.getAnswers().get(0));
        this.answer2Button.setText(object.getAnswers().get(1));
        this.answer3Button.setText(object.getAnswers().get(2));
        this.answer4Button.setText(object.getAnswers().get(3));
        image.setImageResource(R.drawable.hummer);
    }

    public void choice1OnClick(View view) {
    }

    public void choice2OnClick(View view) {
    }

    public void choice3OnClick(View view) {
    }

    public void choice4OnClick(View view) {
    }
}
