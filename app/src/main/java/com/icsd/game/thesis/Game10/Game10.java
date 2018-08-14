package com.icsd.game.thesis.Game10;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.R;

import java.util.ArrayList;
import java.util.Collections;

import static android.graphics.Color.parseColor;

public class Game10  extends AppCompatActivity{

    private Button objl,obj2,obj3,obj4,obj5,obj6,obj7,obj8,obj9,obj10,obj11,obj12;
    private Button level_1_button;
    private static int which_level;
    private ArrayList<Button> level_1_buttons;
    private ArrayList<String> objects_for_game;
    private Runnable timer;
    private final Handler defaultButtons = new Handler();
    private String correct_answer;
    private ArrayList<String> correct_answers;
    private ArrayList<String> clicked_answers;
    private static int pressedButtons;
    private TextView text;
    private TextView standard;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game10);
        which_level = 0;
        pressedButtons = 0;
        initGui();
    }
    private void initGui(){
      objl= (Button) findViewById(R.id.obj1);
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
      standard = (TextView)findViewById(R.id.textView10);
      standard.setText("Touch the");
      text.setVisibility(View.INVISIBLE);
      standard.setVisibility(View.INVISIBLE);
      objects_for_game = new ArrayList<String>();
      objects_for_game.add("banana");
      objects_for_game.add("avocado");
      objects_for_game.add("kiwi");
      objects_for_game.add("melon");
      objects_for_game.add("orange");
      objects_for_game.add("strawberry");
      level_1_buttons = new ArrayList<Button>();

      startGame();
    }
    private void Check_Level(){
        correct_answers = new ArrayList<String>();
        clicked_answers = new ArrayList<String>();
        if(which_level==0){
            obj12.setVisibility(View.INVISIBLE);
            obj11.setVisibility(View.INVISIBLE);
            obj10.setVisibility(View.INVISIBLE);
            obj9.setVisibility(View.INVISIBLE);
            obj8.setVisibility(View.INVISIBLE);
            obj7.setVisibility(View.INVISIBLE);
            obj3.setVisibility(View.INVISIBLE);
            obj2.setVisibility(View.INVISIBLE);
            objl.setVisibility(View.INVISIBLE);
            level_1_buttons.add(obj4);
            level_1_buttons.add(obj5);
            level_1_buttons.add(obj6);
            Collections.shuffle(objects_for_game);
            for(int i = 0;i<objects_for_game.size();i++){
                if(objects_for_game.get(i).equals("banana")){
                    correct_answers.add("banana");
                    text.setText("Banana");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(0).setText("banana");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(1).setText("avocado");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(2).setText("kiwi");
                    resetButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2));
                    break;
                }else if(objects_for_game.get(i).equals("avocado")){
                    correct_answers.add("avocado");
                    text.setText("Avocado");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(0).setText("avocado");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(1).setText("banana");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(2).setText("kiwi");
                    resetButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2));
                    break;
                }
                else if(objects_for_game.get(i).equals("kiwi")){
                    correct_answers.add("kiwi");
                    text.setText("Kiwi");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(0).setText("kiwi");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.melon));
                    level_1_buttons.get(1).setText("melon");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(2).setText("strawberry");
                    resetButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2));
                    break;
                }
                else if(objects_for_game.get(i).equals("melon")){
                    correct_answers.add("melon");
                    text.setText("Melon");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.melon));
                    level_1_buttons.get(0).setText("melon");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.orange));
                    level_1_buttons.get(1).setText("orange");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(2).setText("banana");
                    resetButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2));
                    break;
                }
                else if(objects_for_game.get(i).equals("orange")){
                    correct_answers.add("orange");
                    text.setText("Orange");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.orange));
                    level_1_buttons.get(0).setText("orange");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(1).setText("avocado");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(2).setText("strawberry");
                    resetButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2));
                    break;
                }
                else if(objects_for_game.get(i).equals("strawberry")){
                    correct_answers.add("strawberry");
                    text.setText("Strawberry");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(0).setText("strawberry");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.orange));
                    level_1_buttons.get(1).setText("orange");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.melon));
                    level_1_buttons.get(2).setText("melon");
                    resetButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2));
                    break;
                }
            }

        }
        else if(which_level==2){
            obj12.setVisibility(View.INVISIBLE);
            obj11.setVisibility(View.INVISIBLE);
            obj10.setVisibility(View.INVISIBLE);
            obj3.setVisibility(View.INVISIBLE);
            obj2.setVisibility(View.INVISIBLE);
            objl.setVisibility(View.INVISIBLE);
            obj9.setVisibility(View.VISIBLE);
            obj8.setVisibility(View.VISIBLE);
            obj7.setVisibility(View.VISIBLE);
            level_1_buttons.add(obj4);
            level_1_buttons.add(obj5);
            level_1_buttons.add(obj6);
            level_1_buttons.add(obj7);
            level_1_buttons.add(obj8);
            level_1_buttons.add(obj9);
            Collections.shuffle(objects_for_game);
            for(int i = 0;i<objects_for_game.size();i++){
                if(objects_for_game.get(i).equals("banana")){
                    correct_answers.add("banana");
                    correct_answers.add("banana");
                    text.setText("Banana");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(0).setText("banana");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(1).setText("avocado");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(2).setText("banana");
                    level_1_buttons.get(3).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(3).setText("kiwi");
                    level_1_buttons.get(4).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(4).setText("strawberry");
                    level_1_buttons.get(5).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(5).setText("kiwi");
                    resetsixButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2),level_1_buttons.get(3),level_1_buttons.get(4),level_1_buttons.get(5));
                    break;
                }else if(objects_for_game.get(i).equals("avocado")){
                    correct_answers.add("avocado");
                    correct_answers.add("avocado");
                    text.setText("Avocado");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(0).setText("avocado");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(1).setText("banana");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(2).setText("kiwi");
                    level_1_buttons.get(3).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(3).setText("avocado");
                    level_1_buttons.get(4).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(4).setText("strawberry");
                    level_1_buttons.get(5).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(5).setText("banana");
                    resetsixButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2),level_1_buttons.get(3),level_1_buttons.get(4),level_1_buttons.get(5));
                    break;
                }
                else if(objects_for_game.get(i).equals("kiwi")){
                    correct_answers.add("kiwi");
                    correct_answers.add("kiwi");
                    text.setText("Kiwi");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(0).setText("kiwi");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(1).setText("avocado");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(2).setText("banana");
                    level_1_buttons.get(3).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(3).setText("kiwi");
                    level_1_buttons.get(4).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(4).setText("strawberry");
                    level_1_buttons.get(5).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(5).setText("banana");
                    resetsixButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2),level_1_buttons.get(3),level_1_buttons.get(4),level_1_buttons.get(5));
                    break;
                }
                else if(objects_for_game.get(i).equals("melon")){
                    correct_answers.add("melon");
                    correct_answers.add("melon");
                    text.setText("Melon");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.melon));
                    level_1_buttons.get(0).setText("melon");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(1).setText("avocado");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(2).setText("banana");
                    level_1_buttons.get(3).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(3).setText("kiwi");
                    level_1_buttons.get(4).setBackground(getDrawable(R.drawable.melon));
                    level_1_buttons.get(4).setText("melon");
                    level_1_buttons.get(5).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(5).setText("strawberry");
                    resetsixButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2),level_1_buttons.get(3),level_1_buttons.get(4),level_1_buttons.get(5));
                    break;
                }
                else if(objects_for_game.get(i).equals("orange")){
                    correct_answers.add("orange");
                    correct_answers.add("orange");
                    text.setText("Orange");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.orange));
                    level_1_buttons.get(0).setText("orange");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(1).setText("avocado");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(2).setText("banana");
                    level_1_buttons.get(3).setBackground(getDrawable(R.drawable.orange));
                    level_1_buttons.get(3).setText("orange");
                    level_1_buttons.get(4).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(4).setText("strawberry");
                    level_1_buttons.get(5).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(5).setText("kiwi");
                    resetsixButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2),level_1_buttons.get(3),level_1_buttons.get(4),level_1_buttons.get(5));
                    break;
                }
                else if(objects_for_game.get(i).equals("strawberry")){
                    correct_answers.add("strawberry");
                    correct_answers.add("strawberry");
                    text.setText("Strawberry");
                    Collections.shuffle(level_1_buttons);
                    level_1_buttons.get(0).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(0).setText("banana");
                    level_1_buttons.get(1).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(1).setText("strawberry");
                    level_1_buttons.get(2).setBackground(getDrawable(R.drawable.banana));
                    level_1_buttons.get(2).setText("banana");
                    level_1_buttons.get(3).setBackground(getDrawable(R.drawable.kiwi));
                    level_1_buttons.get(3).setText("kiwi");
                    level_1_buttons.get(4).setBackground(getDrawable(R.drawable.strawberry));
                    level_1_buttons.get(4).setText("strawberry");
                    level_1_buttons.get(5).setBackground(getDrawable(R.drawable.avocado));
                    level_1_buttons.get(5).setText("avocado");
                    resetsixButtons(level_1_buttons.get(0),level_1_buttons.get(1),level_1_buttons.get(2),level_1_buttons.get(3),level_1_buttons.get(4),level_1_buttons.get(5));
                    break;
                }
            }
        }
        else if(which_level==3){

        }
    }
    private void resetButtons(final Button a,final Button b,final Button c) {

        timer = new Runnable() {
            @Override
            public void run() {

                a.setBackgroundColor(parseColor("#FFFF8800"));
                b.setBackgroundColor(parseColor("#FFFF8800"));
                c.setBackgroundColor(parseColor("#FFFF8800"));
                standard.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);


            }
        };
        defaultButtons.postDelayed(timer, 5000);
    }
    private void resetsixButtons(final Button a,final Button b,final Button c,final Button d,final Button e,final Button s) {

        timer = new Runnable() {
            @Override
            public void run() {

                a.setBackgroundColor(parseColor("#FFFF8800"));
                b.setBackgroundColor(parseColor("#FFFF8800"));
                c.setBackgroundColor(parseColor("#FFFF8800"));
                d.setBackgroundColor(parseColor("#FFFF8800"));
                e.setBackgroundColor(parseColor("#FFFF8800"));
                s.setBackgroundColor(parseColor("#FFFF8800"));
                standard.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);


            }
        };
        defaultButtons.postDelayed(timer, 5000);
    }
    private void startGame(){
        Check_Level();
    }
    private void CheckIfMatch(ArrayList<String> clicked,ArrayList<String> corrects,int pressedButtons){
        if(which_level == 0 && pressedButtons==1){
            Log.e(getClass().getName(),"Clicked : "+clicked.toString()+" corrects : "+corrects.toString());
            Collections.sort(clicked);
            Collections.sort(corrects);
            if(clicked.toString().contentEquals(corrects.toString())){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                corrects.removeAll(corrects);
                clicked.removeAll(clicked);
                defaultButtons.removeCallbacks(timer);
                which_level++;
                initGui();

            }
            else{
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
                corrects.removeAll(corrects);
                clicked.removeAll(clicked);
                defaultButtons.removeCallbacks(timer);
                which_level++;
                initGui();
            }

        }else if(which_level==1 && pressedButtons==2){
            Log.e(getClass().getName(),"Clicked : "+clicked.toString()+" corrects : "+corrects.toString());
            Collections.sort(clicked);
            Collections.sort(corrects);
            if(clicked.toString().contentEquals(corrects.toString())){
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
                corrects.removeAll(corrects);
                clicked.removeAll(clicked);
                defaultButtons.removeCallbacks(timer);
                which_level++;
                initGui();
            }
            else{
                Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
                corrects.removeAll(corrects);
                clicked.removeAll(clicked);
                defaultButtons.removeCallbacks(timer);
                which_level++;
                initGui();
            }
            which_level++;
        }

    }
    private void isPressed(){
        pressedButtons+=1;
        CheckIfMatch(clicked_answers,correct_answers,pressedButtons);

    }
    private void unPress(){
        pressedButtons-=1;
    }
    public void obj5onclick(View view) {
        clicked_answers.add(obj5.getText().toString());
        isPressed();
    }

    public void obj6onclick(View view) {
        clicked_answers.add(obj6.getText().toString());
        isPressed();
    }

    public void obj4onclick(View view) {
        clicked_answers.add(obj4.getText().toString());
        isPressed();
    }

    public void obj7onclick(View view) {
        clicked_answers.add(obj7.getText().toString());
        isPressed();
    }

    public void obj8onclick(View view) {
        clicked_answers.add(obj8.getText().toString());
        isPressed();
    }

    public void obj9onclick(View view) {
        clicked_answers.add(obj9.getText().toString());
        isPressed();
    }
}
