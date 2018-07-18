package com.icsd.game.thesis.Game12;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collections;
import com.icsd.game.thesis.R;
import java.util.ArrayList;


public class Game12 extends AppCompatActivity {
    private Button play;
    private Button tutorialButton;
    private Button tutorialButton2;
    private Button ObjectButton;
    private Button ObjectButton2;
    private Button ObjectButton3;
    private Button ObjectButton4;
    private Button gprock;
    private Button gpscissors;
    private Button gppaper;
    private Button gppencil;
    private Button tie;
    private TextView title;
    private ViewGroup.LayoutParams scale;
    private StringBuilder combinefile;
    private ArrayList<Button> gameplayimages;
    private int who;
    private int turn_tutorial = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game12);
        initGraphics();
        initScreen();
    }
    private void initGraphics()
    {
        tutorialButton = (Button)findViewById(R.id.tutorialbutton); //con button
        tutorialButton2 = (Button)findViewById(R.id.tutorialbutton2); //back button
        ObjectButton = (Button)findViewById(R.id.tutorialObjectIcon);
        ObjectButton2 = (Button)findViewById(R.id.tutorialObjectIcon2);
        ObjectButton.setOnClickListener(null);
        ObjectButton2.setOnClickListener(null);
        ObjectButton3 = (Button)findViewById(R.id.tutorialObjectIcon3);
        ObjectButton4 = (Button)findViewById(R.id.tutorialObjectIcon4);
        tie = (Button) findViewById(R.id.tieb);
        gameplayimages = new ArrayList<Button>();
        gprock = (Button) findViewById(R.id.gameplayrock);
        gppencil = (Button) findViewById(R.id.gameplaypencil);
        gpscissors = (Button) findViewById(R.id.gameplayscissors);
        gppaper = (Button) findViewById(R.id.gameplaypaper);
        gameplayimages.add(gprock);
        gameplayimages.add(gppencil);
        gameplayimages.add(gpscissors);
        gameplayimages.add(gppaper);
        combinefile = new StringBuilder();
        title = (TextView) findViewById(R.id.textView);
        scale = title.getLayoutParams();
    }
    public void continueonClick(View view) {
        initScreen();
    }
    public void backonClick(View view) {
        clearScreen();
        Log.e("MyDEbou", getTutorial()+"");
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
        else if(getTutorial()==4)
        {
            initGameplay();
            tutorialButton.setText("ROLL");
            tutorialButton2.setVisibility(View.INVISIBLE);
        }
    }
    private void clearScreen()
    {
        Log.e("MyDEbou", getTutorial()+"clear");
         if(getTutorial()==2)
        {
            minustutorial();
            Page1();
        }
        else if(getTutorial()==3)
        {
            minustutorial();
            Page2();
        }
    }
    private void plustutorial()
    {
        turn_tutorial++;
    }
    private void minustutorial()
    {
        turn_tutorial--;
    }
    private int getTutorial()
    {
        return turn_tutorial;
    }
    private void Page1()
    {
        tutorialButton2.setVisibility(View.INVISIBLE);
        ObjectButton.setBackground(getDrawable(R.drawable.pencil));
        ObjectButton2.setBackground(getDrawable(R.drawable.paper));
        ObjectButton3.setVisibility(View.INVISIBLE);
        ObjectButton4.setVisibility(View.INVISIBLE);
        plustutorial();
    }
    private void Page2()
    {
        ObjectButton.setBackground(getDrawable(R.drawable.paper));
        ObjectButton.setText("PAPER");
        ObjectButton2.setBackground(getDrawable(R.drawable.rock));
        ObjectButton2.setText("ROCK");
        tutorialButton2.setVisibility(View.VISIBLE);
        plustutorial();
    }
    private void Page3()
    {
        ObjectButton.setBackground(getDrawable(R.drawable.rock));
        ObjectButton.setText("ROCK");
        ObjectButton2.setVisibility(View.INVISIBLE);
        ObjectButton3.setVisibility(View.VISIBLE);
        ObjectButton4.setVisibility(View.VISIBLE);
        ObjectButton3.setBackground(getDrawable(R.drawable.scissors));
        ObjectButton4.setBackground(getDrawable(R.drawable.pencil));
        ObjectButton3.setText("SCISSORS");
        ObjectButton4.setText("PENCIL");
        tutorialButton2.setVisibility(View.VISIBLE);
        plustutorial();
    }
    private void Page4()
    {
        ObjectButton.setBackground(getDrawable(R.drawable.scissors));
        ObjectButton.setText("SCISSORS");
        ObjectButton2.setVisibility(View.INVISIBLE);
        ObjectButton3.setVisibility(View.VISIBLE);
        ObjectButton4.setVisibility(View.VISIBLE);
        ObjectButton3.setBackground(getDrawable(R.drawable.pencil));
        ObjectButton4.setBackground(getDrawable(R.drawable.paper));
        ObjectButton3.setText("PENCIL");
        ObjectButton4.setText("PAPER");
        tutorialButton2.setVisibility(View.VISIBLE);
        tutorialButton.setText("PLAY");
        plustutorial();
    }
    private void initGameplay()
    {
        ObjectButton.callOnClick();
        ObjectButton2.callOnClick();
        Log.e("MyDEbou", "Initgameplay called");
       ObjectButton3.setVisibility(View.INVISIBLE);
       ObjectButton4.setVisibility(View.INVISIBLE);
       ObjectButton.setVisibility(View.VISIBLE);
       ObjectButton2.setVisibility(View.VISIBLE);
       for(int i =0;i<gameplayimages.size();i++)
       {
           Collections.shuffle(gameplayimages);
           ObjectButton.setBackground(gameplayimages.get(i).getBackground());
           ObjectButton.setText(" ");
           Collections.shuffle(gameplayimages);
           ObjectButton2.setBackground(gameplayimages.get(i).getBackground());
           ObjectButton2.setText(" ");
           title.setText("Click on the Winner");
           title.setWidth(scale.width=500);
           tie.setVisibility(View.VISIBLE);
       }

    }

    public void CheckWinner(int Player1, int Player2, ImageView P1, ImageView P2)
    {
      //auto einai palio den isxuei to ftiaxnw to prwi
    }

    public void p2onClick(View view) {
        ObjectButton.getBackground();  //kwsta to sinexizw to prwi...den exw kapoio thema ola ok, den exo valei to TIE koumpi sto diko sou layout
    }

    public void p1onClick(View view) {
    }
}
