package com.icsd.game.thesis.Game9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.icsd.game.thesis.R;

public class Game9 extends AppCompatActivity {
    private ImageView view1;
    private ImageView view2;
    private ImageView view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game9);
        view1=findViewById(R.id.imageView);
        view2=findViewById(R.id.imageView12);
        view3=findViewById(R.id.green);
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(view3.getResources().equals("green1"))
                {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}