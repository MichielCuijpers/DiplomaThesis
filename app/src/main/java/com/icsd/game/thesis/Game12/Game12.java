package com.icsd.game.thesis.Game12;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import com.icsd.game.thesis.R;

import java.util.ArrayList;


public class Game12 extends AppCompatActivity {
    private Button play;
    private ImageView p1;
    private ImageView p2;
    private int who;
    private ArrayList<Integer> randimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game12);
        randimg = new ArrayList<Integer>();
        randimg.add(R.drawable.rock);
        randimg.add(R.drawable.pencil);
        randimg.add(R.drawable.scissors);
        randimg.add(R.drawable.paper);
        play = (Button) findViewById(R.id.play);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.gameplay12);
                p1 = (ImageView) findViewById(R.id.p1);
                p2 = (ImageView) findViewById(R.id.p2);
                Random randId = new Random();
                int numforp1 = randimg.get(randId.nextInt(4));
                int numforp2 = randimg.get(randId.nextInt(4));
                Log.e("DEBGMY",numforp1+"!!");
                p1.setImageResource(numforp1);
                p1.setId(numforp1);
                p2.setId(numforp2);
                p2.setImageResource(numforp2);
                Log.e("DEBGMY",p1.getId()+")))"+p1.getResources());
                Log.e("DEBGMY",p2.getId()+")))"+p1.getResources());

                who = CheckWinner(p1.getId(), p2.getId(), p1, p2); //PAIRNW STIN WHO TO ID TOU NIKITI
                if (p1.getId() == p2.getId()) {
                    Toast.makeText(getApplicationContext(), "That is a Tie!!", Toast.LENGTH_LONG).show();
                }
                p1.setOnClickListener(new View.OnClickListener() { //DES KAI EDW TA LISTENER MIPOS ERXETAI APO EDW ALLA DEN NOMIZW
                    @Override
                    public void onClick(View v) {

                        if (p1.getId() == who) {
                            Toast.makeText(getApplicationContext(), "GG YOU WON,Player1 is the Winner", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "EZ LOSE, Player2 is the Winner", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (p2.getId() == who) {
                            Toast.makeText(getApplicationContext(), "GG YOU WON,Player2 is the Winner", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "EZ LOSE, Player1 is the Winner", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    public ImageView getP1() {
        return p1;
    }

    public ImageView getP2() {
        return p2;
    }

    public Integer CheckWinner(int Player1, int Player2, ImageView P1, ImageView P2) //PAIRNEI TO ID APO TA IMAGEVIEW KAI TA IMAGEVIEW KAI BGAZEI EXPORT TO TEXT KAI ELENGXEI.(EDW PREPEI NA EXW ERROR) -- TREKSTO PRWTA!!!!
    {
        Log.e("DEBGMY",p2.getId()+")))"+p1.getResources());
        int winner = p1.getId();
        if ((P1.getResources().equals("rock")) && (P2.getResources().equals("pencil"))) {
            winner = P1.getId();
        }
        if ((P1.getResources().equals("rock")) && (P2.getResources().equals("scissors"))) {
            winner = P1.getId();
        }
        if ((P1.getResources().equals("rock")) && (P2.getResources().equals("paper"))) {
            winner = P2.getId();
        }

        if ((P1.getResources().equals("pencil")) && (P2.getResources().equals("paper"))) {
            winner = P1.getId();
        }
        if ((P1.getResources().equals("pencil")) && (P2.getResources().equals("rock"))) {
            winner = P2.getId();
        }
        if ((P1.getResources().equals("pencil")) && (P2.getResources().equals("scissors"))) {
            winner = P2.getId();
        }
        if ((P1.getResources().equals("paper")) && (P2.getResources().equals("rock"))) {
            winner = P1.getId();
        }
        if ((P1.getResources().equals("paper")) && (P2.getResources().equals("pencil"))) {
            winner = P2.getId();
        }
        if ((P1.getResources().equals("paper")) && (P2.getResources().equals("scissors"))) {
            winner = P2.getId();
        }
        if ((P1.getResources().equals("scissors")) && (P2.getResources().equals("paper"))) {
            winner = P1.getId();
        }
        if ((P1.getResources().equals("scissors")) && (P2.getResources().equals("pencil"))) {
            winner = P1.getId();
        }
        if ((P1.getResources().equals("scissors")) && (P2.getResources().equals("rock"))) {
            winner = P2.getId();
        }
        return winner;
    }
}
