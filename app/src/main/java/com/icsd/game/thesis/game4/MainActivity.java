package com.icsd.game.thesis.game4;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.icsd.game.thesis.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
        private ArrayList<Button> letters;
        private Button s;
        private Button one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;
        private ArrayList<Button> buttonkeep ;
        private Button dynamic;
        private ConstraintLayout lay;
        private TextView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        letters = new ArrayList<Button>();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.game4protype);
        s = (Button) findViewById(R.id.button24);
        buttonkeep = new ArrayList<Button>();


        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable buttoncolor = (ColorDrawable) s.getBackground();
                int colorId = buttoncolor.getColor();
                if(colorId == (Color.argb(255,176,102,18)))
                {
                    s.setPressed(false);
                    s.setBackgroundColor(Color.argb(255,255,136,0));


                }
                else{
                    s.setPressed(true);
                    s.setBackgroundColor(Color.argb(255,176,102,18));


                }
            }
        });

        ArrayList<String> phrases = new ArrayList<String>();


        phrases.add("SMART");



        Occurs c = new Occurs();
        try {
            String tobeshuffled = c.PickPhrases(phrases);

            Character[] something = c.shuffleCharArray(tobeshuffled);

            for(int i = 0; i<something.length;i++)
            {
                String m = Character.toString(something[i]);

                dynamic = findViewById(R.id.button23);
                dynamic.setVisibility(View.INVISIBLE);
                dynamic.setText(m);
                v.findViewById(R.id.textView7);
                v.setText(m);
            }

            System.out.println("I swsti leksi : " + tobeshuffled);
            StringBuilder anakatemeni = new StringBuilder();
            for(int i = 0;i<something.length;i++)
            {
                anakatemeni.append(Character.toString(something[i]));
            }
            System.out.println("I anakatemeni : " + anakatemeni);

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

}
