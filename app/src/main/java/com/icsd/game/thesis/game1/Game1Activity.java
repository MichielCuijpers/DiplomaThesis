package com.icsd.game.thesis.game1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.icsd.game.thesis.R;

public class Game1Activity extends AppCompatActivity {


    private static Context myCont;

    private View view1, view2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view1 = getLayoutInflater().inflate(R.layout.game1_categories_activity, null);
        view2 = getLayoutInflater().inflate(R.layout.game1_prototype, null);
        setContentView(view1);
        myCont = this.getApplicationContext();
        Question.addTestQuestionToDB();
    }

    public static Context getMyCont() {
        return myCont;
    }

    public void category2(View view) {
        setContentView(view2);
    }

    public void category1(View view) {
       setContentView(view2);
    }
}
