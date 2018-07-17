package com.icsd.game.thesis.Game12;
import android.graphics.drawable.Drawable;
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
    private Button tutorialButton;
    private Button ObjectButton;
    private Button ObjectButton2;
    private Button ObjectButton3;
    private Button ObjectButton4;
    private Button rockb;
    private Button paperb;
    private Button scissorsb;
    private Button pencilb;
    private ImageView p1;
    private ImageView p2;
    private int who;
    private int turn_tutorial;
    private ArrayList<Integer> randimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game12);
        initGraphics();
        initScreen();
    }

    public ImageView getP1() {
        return p1;
    }

    public ImageView getP2() {
        return p2;
    }
    private void initGraphics()
    {
        play = (Button)findViewById(R.id.play);
        tutorialButton = (Button)findViewById(R.id.tutorialbutton);
        ObjectButton = (Button)findViewById(R.id.tutorialObjectIcon);
        ObjectButton2 = (Button)findViewById(R.id.tutorialObjectIcon2);
        ObjectButton3 = (Button)findViewById(R.id.tutorialObjectIcon3);
        ObjectButton4 = (Button)findViewById(R.id.tutorialObjectIcon4);
    }
    public void continueonClick(View view) {
        initScreen();
    }
    private void initScreen()
    {
        if(getTutorial()==0)
        {
            Page1();
        }
        else if(getTutorial()==1)
        {
            Page2();
        }
        else if(getTutorial()==2)
        {
            Page3();
        }
        else if(getTutorial()==3)
        {
            Page4();
        }
    }
    private int tutorial()
    {
        return turn_tutorial = turn_tutorial = +1;
    }
    private int getTutorial()
    {
        return turn_tutorial;
    }
    private void Page1()
    {
        tutorial();
        ObjectButton.setBackground(Drawable.createFromPath("pencil.png"));
        ObjectButton2.setBackground(Drawable.createFromPath("paper.png"));
    }
    private void Page2()
    {
        tutorial();
        ObjectButton.setBackground(Drawable.createFromPath("paper.png"));
        ObjectButton2.setBackground(Drawable.createFromPath("rock.png"));
    }
    private void Page3()
    {
        tutorial();
        ObjectButton.setBackground(Drawable.createFromPath("rock.png"));
        ObjectButton3.setBackground(Drawable.createFromPath("scissors.png"));
        ObjectButton4.setBackground(Drawable.createFromPath("pencil.png"));
        ObjectButton3.setVisibility(View.VISIBLE);
        ObjectButton4.setVisibility(View.VISIBLE);
    }
    private void Page4()
    {
        tutorial();
        ObjectButton.setBackground(Drawable.createFromPath("scissors.png"));
        ObjectButton3.setBackground(Drawable.createFromPath("pencil.png"));
        ObjectButton4.setBackground(Drawable.createFromPath("paper.png"));
        ObjectButton3.setVisibility(View.VISIBLE);
        ObjectButton4.setVisibility(View.VISIBLE);
    }
    private void initGameplay()
    {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.gameplay12);
                p1 = (ImageView) findViewById(R.id.p1);
                p2 = (ImageView) findViewById(R.id.p2);
                Random randId = new Random();
                int numforp1 = randimg.get(randId.nextInt(4));
                int numforp2 = randimg.get(randId.nextInt(4));
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
                            Toast.makeText(getApplicationContext(), "YOU WON,Player1 is the Winner", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "LOSE, Player2 is the Winner", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                p2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (p2.getId() == who) {
                            Toast.makeText(getApplicationContext(), "YOU WON,Player2 is the Winner", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "LOSE, Player1 is the Winner", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
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
