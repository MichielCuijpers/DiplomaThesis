package com.icsd.game.thesis.Game10;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.LoginActivity;
import com.icsd.game.thesis.commons.SoundHandler;
import com.icsd.game.thesis.commons.SurveyActivity;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import static android.graphics.Color.parseColor;

public class Game10 extends AppCompatActivity {

    private Button objl, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12;
    private static int which_level;
    private Runnable timer;
    private final Handler defaultButtons = new Handler();
    private int correct_answer;
    private TextView text;
    private TextView standard;
    private ArrayList<Integer> images;
    private ArrayList<Integer> tempImages;
    private ArrayList<Button> buttons;
    private String[] corArray;
    private String[] corArray2;
    private SoundHandler soundHandler;
    private PopUpWindow popUpWindow;
    private Session currentSession;
    private int tempFails;
    private TextView tutorialText;
    private DatabaseHandler dbHandler;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        tutorialText = findViewById(R.id.tutorialTextView);
        tutorialText.setText(getResources().getString(R.string.tutorialGame10));


    }


    public void onStop() {
        super.onStop();
        if (currentSession != null) {
            currentSession.setTimeEnd(System.currentTimeMillis() / 1000);
            dbHandler = new DatabaseHandler(this);
            dbHandler.addSessionToDB(this.currentSession);
        }
    }

    private void init() {
        tempImages = new ArrayList<>();
        images = new ArrayList<>();
        corArray = new String[20];
        corArray2 = new String[20];
        tempFails = 0;
        which_level = 1;
        soundHandler = new SoundHandler(this);
        currentSession = new Session(LoginActivity.getUser().getUsername(), 10);
        currentSession.setTimeStart(System.currentTimeMillis() / 1000);
        initImages();
        initGui();
        popUpWindow = new PopUpWindow(this, this);

    }

    private void initImages() {
        images = new ArrayList<>();
        images.add(R.drawable.banana);
        images.add(R.drawable.avocado);
        images.add(R.drawable.kiwi);
        images.add(R.drawable.melon);
        images.add(R.drawable.strawberry);
        images.add(R.drawable.orange);
        images.add(R.drawable.apple);
        images.add(R.drawable.grapefruit);
        images.add(R.drawable.flower1);
        images.add(R.drawable.cherries);
        images.add(R.drawable.bike);
        images.add(R.drawable.car);
    }

    private void initGui() {
        objl = (Button) findViewById(R.id.obj1);
        obj2 = (Button) findViewById(R.id.obj2);
        obj3 = (Button) findViewById(R.id.obj3);
        obj4 = (Button) findViewById(R.id.obj4);
        obj5 = (Button) findViewById(R.id.obj5);
        obj6 = (Button) findViewById(R.id.obj6);
        obj7 = (Button) findViewById(R.id.obj7);
        obj8 = (Button) findViewById(R.id.obj8);
        obj9 = (Button) findViewById(R.id.obj9);
        obj10 = (Button) findViewById(R.id.obj10);
        obj11 = (Button) findViewById(R.id.obj11);
        obj12 = (Button) findViewById(R.id.obj12);
        text = (TextView) findViewById(R.id.textView11);
        standard = (TextView) findViewById(R.id.textView10);
        standard.setText(getResources().getString(R.string.touch));
        text.setVisibility(View.INVISIBLE);
        standard.setVisibility(View.INVISIBLE);
        buttons = new ArrayList<>();
        buttons.add(objl);
        buttons.add(obj2);
        buttons.add(obj3);
        buttons.add(obj4);
        buttons.add(obj5);
        buttons.add(obj6);
        buttons.add(obj7);
        buttons.add(obj8);
        buttons.add(obj9);
        buttons.add(obj10);
        buttons.add(obj11);
        buttons.add(obj12);
        startGame();
    }

    private void gameplay(int turn) {
        Collections.shuffle(images);
        tempImages.clear();
        setAllInvisible();

        correct_answer = images.get(0);
        text.setText(correct_answer);
        corArray = text.getText().toString().split("/");
        corArray2 = corArray[2].split("\\.");
        switch (turn) {
            case 1:
                addToTemp(turn);
                Collections.shuffle(tempImages);
                text.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 3; i++) {
                    buttons.get(i).setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        buttons.get(i).setBackground(getDrawable(tempImages.get(i)));
                    } else {
                        buttons.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), tempImages.get(i), null));
                    }
                    if (correct_answer == tempImages.get(i)) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            buttons.get(i).setTag(getDrawable(tempImages.get(i)));
                        } else {
                            buttons.get(i).setTag(ResourcesCompat.getDrawable(getResources(), tempImages.get(i), null));
                        }
                    }
                }
                resetButtons(turn, 4000);
                break;
            case 2:
                addToTemp(turn);
                Collections.shuffle(tempImages);
                text.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 6; i++) {
                    buttons.get(i).setVisibility(View.VISIBLE);
                   // buttons.get(i).setBackground(getDrawable(tempImages.get(i)));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        buttons.get(i).setBackground(getDrawable(tempImages.get(i)));
                    } else {
                        buttons.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), tempImages.get(i), null));
                    }
                    if (correct_answer == tempImages.get(i)) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            buttons.get(i).setTag(getDrawable(tempImages.get(i)));
                        } else {
                            buttons.get(i).setTag(ResourcesCompat.getDrawable(getResources(), tempImages.get(i), null));
                        }
                    }
                }
                resetButtons(turn, 4000);

                break;
            case 3:
                addToTemp(turn);
                Collections.shuffle(tempImages);
                text.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 9; i++) {
                    buttons.get(i).setVisibility(View.VISIBLE);
                   // buttons.get(i).setBackground(getDrawable(tempImages.get(i)));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        buttons.get(i).setBackground(getDrawable(tempImages.get(i)));
                    } else {
                        buttons.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), tempImages.get(i), null));
                    }
                    if (correct_answer == tempImages.get(i)) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            buttons.get(i).setTag(getDrawable(tempImages.get(i)));
                        } else {
                            buttons.get(i).setTag(ResourcesCompat.getDrawable(getResources(), tempImages.get(i), null));
                        }
                    }
                }
                resetButtons(turn, 4000);
                break;
            case 4:
                addToTemp(turn);
                Collections.shuffle(tempImages);
                text.setVisibility(View.INVISIBLE);
                for (int i = 0; i < 12; i++) {
                    buttons.get(i).setVisibility(View.VISIBLE);
                  //  buttons.get(i).setBackground(getDrawable(tempImages.get(i)));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        buttons.get(i).setBackground(getDrawable(tempImages.get(i)));
                    } else {
                        buttons.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), tempImages.get(i), null));
                    }
                    if (correct_answer == tempImages.get(i)) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            buttons.get(i).setTag(getDrawable(tempImages.get(i)));
                        } else {
                            buttons.get(i).setTag(ResourcesCompat.getDrawable(getResources(), tempImages.get(i), null));
                        }
                    }
                }
                resetButtons(turn, 4000);
                break;
            case 5: {
                endGame();
                break;
            }
        }
    }

    public void endGame() {
        if (soundHandler != null) {
            soundHandler.stopSound();
        }

        Intent surv = new Intent(this, SurveyActivity.class);
        SurveyActivity.setQuestionType(0);
        SurveyActivity.setGameID(10);
        startActivity(surv);
    }

    private void addToTemp(int turn) {
        for (int i = 0; i < turn * 3; i++) {
            tempImages.add(images.get(i));
        }
    }

    private void setAllInvisible() {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setVisibility(View.INVISIBLE);
            buttons.get(i).setTag(null);
        }
    }


    private void toStrings(String string) {
        if (string.equals("banana")) {
            text.setText(getResources().getString(R.string.banana));

        } else if (string.equals("avocado")) {
            text.setText(getResources().getString(R.string.avocado));

        } else if (string.equals("kiwi")) {
            text.setText(getResources().getString(R.string.kiwi));

        } else if (string.equals("melon")) {
            text.setText(getResources().getString(R.string.melon));

        } else if (string.equals("strawberry")) {
            text.setText(getResources().getString(R.string.strawberry));

        } else if (string.equals("orange")) {
            text.setText(getResources().getString(R.string.orange));

        } else if (string.equals("apple")) {
            text.setText(getResources().getString(R.string.apple));

        } else if (string.equals("grapfruit")) {
            text.setText(getResources().getString(R.string.grapfruit));

        } else if (string.equals("flower1")) {
            text.setText(getResources().getString(R.string.flower1));

        } else if (string.equals("cherries")) {
            text.setText(getResources().getString(R.string.cherries));

        } else if (string.equals("bike")) {
            text.setText(getResources().getString(R.string.bike));

        } else if (string.equals("car")) {
            text.setText(getResources().getString(R.string.car));

        }
    }

    private void resetButtons(final int i, int delay) {

        timer = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < i * 3; j++) {
                    buttons.get(j).setBackgroundColor(parseColor("#FFFF8800"));
                }
                standard.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                toStrings(corArray2[0]);

            }
        };
        defaultButtons.postDelayed(timer, delay);
    }

    private void startGame() {
        gameplay(which_level);
    }

    private void check(Button button) {

        if (this.currentSession.getFails() == 6) {
            endGame();
            return;
        }
        if (button.getTag() != null) {

            soundHandler.playOkSound();
            //popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
            currentSession.setStage(currentSession.getStage() + 1);
            currentSession.setScore(currentSession.getScore() + 1);
            which_level++;
            gameplay(which_level);

        } else {
            currentSession.setScore(currentSession.getScore() - 1);
            currentSession.setFails(currentSession.getFails() + 1);
            tempFails++;
            soundHandler.playWrongSound();
            // popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer2));
            if (tempFails == 4) {
                tempFails = 0;
                which_level++;
                gameplay(which_level);
            }
            for (int i = 0; i < which_level * 3; i++) {
                buttons.get(i).setBackground(getDrawable(tempImages.get(i)));
            }
            resetButtons(which_level, 600);

        }
    }

    public void obj5onclick(View view) {
        check((Button) view);

    }

    public void obj6onclick(View view) {
        check((Button) view);

    }

    public void obj4onclick(View view) {
        check((Button) view);

    }

    public void obj3onclick(View view) {
        check((Button) view);
    }

    public void obj2onclick(View view) {
        check((Button) view);
    }

    public void obj1onclick(View view) {
        check((Button) view);
    }

    public void obj7onclick(View view) {
        check((Button) view);
    }

    public void obj8onclick(View view) {
        check((Button) view);
    }

    public void obj9onclick(View view) {
        check((Button) view);
    }

    public void obj11onclick(View view) {
        check((Button) view);
    }

    public void obj12onclick(View view) {
        check((Button) view);
    }

    public void tutorialOkOnClick(View view) {

        setContentView(R.layout.activity_game10);
        init();
    }
}
