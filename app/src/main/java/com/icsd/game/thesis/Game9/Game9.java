package com.icsd.game.thesis.Game9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.icsd.game.thesis.commons.LoginActivity;
import com.icsd.game.thesis.commons.Menu2;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.SoundHandler;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.ArrayList;
import java.util.Random;

public class Game9 extends AppCompatActivity {
    private Button iimage1;
    private Button iimage2;
    private Button iimage3;
    private Button iimage4;
    private Button iimage5;
    private ArrayList<Button> images;
    private ArrayList<Button> blue;
    private ArrayList<Button> black;
    private ArrayList<Button> green;
    private ArrayList<Button> purple;
    private ArrayList<Button> red;
    private ArrayList<Button> yellow;
    private TextView score;
    private int which_color;
    private TextView what_to_click;
    // private Categories category;
    private Random rand;
    private ArrayList<ArrayList> cat;
    private Button b1, b2, b3, b4, b5, bl1, bl2, bl3, bl4, bl5, g1, g2, g3, g4, g5, p1, p2, p3, p4, p5, r1, r2, r3, r4, r5, y1, y2, y3, y4, y5, shuffle;
    private int sc = 0;
    private ArrayList<Button> win;
    private ArrayList<Button> lose;
    private ArrayList<Button> right_color;
    //private boolean clicked1=false,clicked2=false,clicked3=false,clicked4=false,clicked5=false;
    private ArrayList<Boolean> clicked;
    private int position = 0, position1 = 0;
    private Session currentSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;
    private PopUpWindow popUpWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game9);

        dbHandler = new DatabaseHandler(this.getApplicationContext());
        currentSession = new Session(LoginActivity.getUser().getUsername(), 9);
        currentSession.setTimeStart(System.currentTimeMillis() / 1000);
        soundHandler = new SoundHandler(getApplicationContext());
        initTest();
    }

    private void initTest() {

        images = new ArrayList<Button>();
        blue = new ArrayList<Button>();
        black = new ArrayList<Button>();
        green = new ArrayList<Button>();
        purple = new ArrayList<Button>();
        red = new ArrayList<Button>();
        yellow = new ArrayList<Button>();
        cat = new ArrayList<ArrayList>();


        iimage1 = (Button) findViewById(R.id.button);
        iimage2 = (Button) findViewById(R.id.button2);
        iimage3 = (Button) findViewById(R.id.button3);
        iimage4 = (Button) findViewById(R.id.button4);
        iimage5 = (Button) findViewById(R.id.button5);

        what_to_click = (TextView) findViewById(R.id.textView);


        b1 = (Button) findViewById(R.id.button46);
        b2 = findViewById(R.id.button8);
        b3 = (Button) findViewById(R.id.button19);
        b4 = (Button) findViewById(R.id.button20);
        b5 = (Button) findViewById(R.id.button21);
        bl1 = (Button) findViewById(R.id.button22);
        bl2 = (Button) findViewById(R.id.button23);
        bl3 = (Button) findViewById(R.id.button24);
        bl4 = (Button) findViewById(R.id.button25);
        bl5 = (Button) findViewById(R.id.button26);
        g1 = (Button) findViewById(R.id.button27);
        g2 = (Button) findViewById(R.id.button28);
        g3 = (Button) findViewById(R.id.button29);
        g4 = (Button) findViewById(R.id.button30);
        g5 = (Button) findViewById(R.id.button31);
        p1 = (Button) findViewById(R.id.button32);
        p2 = (Button) findViewById(R.id.button33);
        p3 = (Button) findViewById(R.id.button34);
        p4 = (Button) findViewById(R.id.button35);
        p5 = (Button) findViewById(R.id.button36);
        r1 = (Button) findViewById(R.id.button37);
        r2 = (Button) findViewById(R.id.button38);
        r3 = (Button) findViewById(R.id.button39);
        r4 = (Button) findViewById(R.id.button40);
        r5 = (Button) findViewById(R.id.button41);
        y1 = (Button) findViewById(R.id.button42);
        y2 = (Button) findViewById(R.id.button43);
        y3 = (Button) findViewById(R.id.button44);
        y4 = (Button) findViewById(R.id.button45);
        y5 = findViewById(R.id.button9);
        shuffle = findViewById(R.id.button10);


        b1.setBackground(getDrawable(R.drawable.bl1));
        b2.setBackground(getDrawable(R.drawable.bl2));
        b3.setBackground(getDrawable(R.drawable.bl3));
        b4.setBackground(getDrawable(R.drawable.bl4));
        b5.setBackground(getDrawable(R.drawable.bl5));
        bl1.setBackground(getDrawable(R.drawable.blc1));
        bl2.setBackground(getDrawable(R.drawable.blc2));
        bl3.setBackground(getDrawable(R.drawable.blc3));
        bl4.setBackground(getDrawable(R.drawable.blc4));
        bl5.setBackground(getDrawable(R.drawable.blc5));
        g1.setBackground(getDrawable(R.drawable.gr1));
        g2.setBackground(getDrawable(R.drawable.gr2));
        g3.setBackground(getDrawable(R.drawable.gr3));
        g4.setBackground(getDrawable(R.drawable.gr4));
        g5.setBackground(getDrawable(R.drawable.gr5));
        p1.setBackground(getDrawable(R.drawable.pr1));
        p2.setBackground(getDrawable(R.drawable.pr2));
        p3.setBackground(getDrawable(R.drawable.pr3));
        p4.setBackground(getDrawable(R.drawable.pr4));
        p5.setBackground(getDrawable(R.drawable.pr5));
        r1.setBackground(getDrawable(R.drawable.r1));
        r2.setBackground(getDrawable(R.drawable.r2));
        r3.setBackground(getDrawable(R.drawable.r3));
        r4.setBackground(getDrawable(R.drawable.r4));
        r5.setBackground(getDrawable(R.drawable.r5));
        y1.setBackground(getDrawable(R.drawable.yl1));
        y2.setBackground(getDrawable(R.drawable.yl2));
        y3.setBackground(getDrawable(R.drawable.yl3));
        y4.setBackground(getDrawable(R.drawable.yl4));
        y5.setBackground(getDrawable(R.drawable.yl5));


        blue.add(b1);
        blue.add(b2);
        blue.add(b3);
        blue.add(b4);
        blue.add(b5);

        black.add(bl1);
        black.add(bl2);
        black.add(bl3);
        black.add(bl4);
        black.add(bl5);

        green.add(g1);
        green.add(g2);
        green.add(g3);
        green.add(g4);
        green.add(g5);

        purple.add(p1);
        purple.add(p2);
        purple.add(p3);
        purple.add(p4);
        purple.add(p5);

        red.add(r1);
        red.add(r2);
        red.add(r3);
        red.add(r4);
        red.add(r5);

        yellow.add(y1);
        yellow.add(y2);
        yellow.add(y3);
        yellow.add(y4);
        yellow.add(y5);

        images.add(iimage1);
        images.add(iimage2);
        images.add(iimage3);
        images.add(iimage4);
        images.add(iimage5);

        //category = new Categories();
        //flowers=category.getFlowers();
        //fruits=category.getFruits();
        // vehicles=category.getVehicles();
        //smart_devices=category.getSmart_devices();


        cat.add(blue);
        cat.add(black);
        cat.add(green);
        cat.add(purple);
        cat.add(red);
        cat.add(yellow);

        for (Button b : blue) {
            b.setText("");
        }
        for (Button b : black) {
            b.setText("");
        }
        for (Button b : green) {
            b.setText("");
        }
        for (Button b : purple) {
            b.setText("");
        }
        for (Button b : red) {
            b.setText("");
        }
        for (Button b : yellow) {
            b.setText("");
        }

        rand = new Random();
        which_color = rand.nextInt(cat.size()); //choose random color
        if (which_color == 0) {
            what_to_click.setText("Click on the blue images");
            for (Button b : blue) {
                b.setText("BLUE");
            }
        } else if (which_color == 1) {
            what_to_click.setText("Click on the black images");
            for (Button b : black) {
                b.setText("BLACK");
            }
        } else if (which_color == 2) {
            what_to_click.setText("Click on the green images");
            for (Button b : green) {
                b.setText("GREEN");
            }
        } else if (which_color == 3) {
            what_to_click.setText("Click on the purple images");
            for (Button b : purple) {
                b.setText("PURPLE");
            }
        } else if (which_color == 4) {
            what_to_click.setText("Click on the red images");
            for (Button b : red) {
                b.setText("RED");
            }
        } else if (which_color == 5) {
            what_to_click.setText("Click on the yellow images");
            for (Button b : yellow) {
                b.setText("YELLOW");
            }
        }

        for (int i = 0; i <= 4; i++) {
            int which_image = rand.nextInt(blue.size()); //choose a random number from the list that was chosen
            //which_color = rand.nextInt(cat.size()); //choose random color
            if (which_color == 0) {
                images.get(i).setBackground(blue.get(which_image).getBackground());
                images.get(i).setText(blue.get(which_image).getText());
            } else if (which_color == 1) {
                images.get(i).setBackground(black.get(which_image).getBackground());
                images.get(i).setText(black.get(which_image).getText());
            } else if (which_color == 2) {
                images.get(i).setBackground(green.get(which_image).getBackground());
                images.get(i).setText(green.get(which_image).getText());
            } else if (which_color == 3) {
                images.get(i).setBackground(purple.get(which_image).getBackground());
                images.get(i).setText(purple.get(which_image).getText());
            } else if (which_color == 4) {
                images.get(i).setBackground(red.get(which_image).getBackground());
                images.get(i).setText(red.get(which_image).getText());
            } else if (which_color == 5) {
                images.get(i).setBackground(yellow.get(which_image).getBackground());
                images.get(i).setText(yellow.get(which_image).getText());
            }
            which_color = rand.nextInt(cat.size()); //choose random color
        }
        shuffle();
    }

    private void initGame() {

        images = new ArrayList<Button>();
        blue = new ArrayList<Button>();
        black = new ArrayList<Button>();
        green = new ArrayList<Button>();
        purple = new ArrayList<Button>();
        red = new ArrayList<Button>();
        yellow = new ArrayList<Button>();
        cat = new ArrayList<ArrayList>();
        right_color = new ArrayList<Button>();
        clicked = new ArrayList<Boolean>();
        lose = new ArrayList<>();


        score = (TextView) findViewById(R.id.text1);


        iimage1 = (Button) findViewById(R.id.button);
        iimage2 = (Button) findViewById(R.id.button2);
        iimage3 = (Button) findViewById(R.id.button3);
        iimage4 = (Button) findViewById(R.id.button4);
        iimage5 = (Button) findViewById(R.id.button5);

        what_to_click = (TextView) findViewById(R.id.textView);


        b1 = (Button) findViewById(R.id.button46);
        b2 = findViewById(R.id.button8);
        b3 = (Button) findViewById(R.id.button19);
        b4 = (Button) findViewById(R.id.button20);
        b5 = (Button) findViewById(R.id.button21);
        bl1 = (Button) findViewById(R.id.button22);
        bl2 = (Button) findViewById(R.id.button23);
        bl3 = (Button) findViewById(R.id.button24);
        bl4 = (Button) findViewById(R.id.button25);
        bl5 = (Button) findViewById(R.id.button26);
        g1 = (Button) findViewById(R.id.button27);
        g2 = (Button) findViewById(R.id.button28);
        g3 = (Button) findViewById(R.id.button29);
        g4 = (Button) findViewById(R.id.button30);
        g5 = (Button) findViewById(R.id.button31);
        p1 = (Button) findViewById(R.id.button32);
        p2 = (Button) findViewById(R.id.button33);
        p3 = (Button) findViewById(R.id.button34);
        p4 = (Button) findViewById(R.id.button35);
        p5 = (Button) findViewById(R.id.button36);
        r1 = (Button) findViewById(R.id.button37);
        r2 = (Button) findViewById(R.id.button38);
        r3 = (Button) findViewById(R.id.button39);
        r4 = (Button) findViewById(R.id.button40);
        r5 = (Button) findViewById(R.id.button41);
        y1 = (Button) findViewById(R.id.button42);
        y2 = (Button) findViewById(R.id.button43);
        y3 = (Button) findViewById(R.id.button44);
        y4 = (Button) findViewById(R.id.button45);
        y5 = findViewById(R.id.button9);


        b1.setBackground(getDrawable(R.drawable.bl1));
        b2.setBackground(getDrawable(R.drawable.bl2));
        b3.setBackground(getDrawable(R.drawable.bl3));
        b4.setBackground(getDrawable(R.drawable.bl4));
        b5.setBackground(getDrawable(R.drawable.bl5));
        bl1.setBackground(getDrawable(R.drawable.blc1));
        bl2.setBackground(getDrawable(R.drawable.blc2));
        bl3.setBackground(getDrawable(R.drawable.blc3));
        bl4.setBackground(getDrawable(R.drawable.blc4));
        bl5.setBackground(getDrawable(R.drawable.blc5));
        g1.setBackground(getDrawable(R.drawable.gr1));
        g2.setBackground(getDrawable(R.drawable.gr2));
        g3.setBackground(getDrawable(R.drawable.gr3));
        g4.setBackground(getDrawable(R.drawable.gr4));
        g5.setBackground(getDrawable(R.drawable.gr5));
        p1.setBackground(getDrawable(R.drawable.pr1));
        p2.setBackground(getDrawable(R.drawable.pr2));
        p3.setBackground(getDrawable(R.drawable.pr3));
        p4.setBackground(getDrawable(R.drawable.pr4));
        p5.setBackground(getDrawable(R.drawable.pr5));
        r1.setBackground(getDrawable(R.drawable.r1));
        r2.setBackground(getDrawable(R.drawable.r2));
        r3.setBackground(getDrawable(R.drawable.r3));
        r4.setBackground(getDrawable(R.drawable.r4));
        r5.setBackground(getDrawable(R.drawable.r5));
        y1.setBackground(getDrawable(R.drawable.yl1));
        y2.setBackground(getDrawable(R.drawable.yl2));
        y3.setBackground(getDrawable(R.drawable.yl3));
        y4.setBackground(getDrawable(R.drawable.yl4));
        y5.setBackground(getDrawable(R.drawable.yl5));


        blue.add(b1);
        blue.add(b2);
        blue.add(b3);
        blue.add(b4);
        blue.add(b5);

        black.add(bl1);
        black.add(bl2);
        black.add(bl3);
        black.add(bl4);
        black.add(bl5);

        green.add(g1);
        green.add(g2);
        green.add(g3);
        green.add(g4);
        green.add(g5);

        purple.add(p1);
        purple.add(p2);
        purple.add(p3);
        purple.add(p4);
        purple.add(p5);

        red.add(r1);
        red.add(r2);
        red.add(r3);
        red.add(r4);
        red.add(r5);

        yellow.add(y1);
        yellow.add(y2);
        yellow.add(y3);
        yellow.add(y4);
        yellow.add(y5);

        images.add(iimage1);
        images.add(iimage2);
        images.add(iimage3);
        images.add(iimage4);
        images.add(iimage5);

        //category = new Categories();
        //flowers=category.getFlowers();
        //fruits=category.getFruits();
        // vehicles=category.getVehicles();
        //smart_devices=category.getSmart_devices();


        cat.add(blue);
        cat.add(black);
        cat.add(green);
        cat.add(purple);
        cat.add(red);
        cat.add(yellow);
        for (Button b : blue) {
            b.setText("");
        }
        for (Button b : black) {
            b.setText("");
        }
        for (Button b : green) {
            b.setText("");
        }
        for (Button b : purple) {
            b.setText("");
        }
        for (Button b : red) {
            b.setText("");
        }
        for (Button b : yellow) {
            b.setText("");
        }

        iimage1.setTextSize(0);
        iimage2.setTextSize(0);
        iimage3.setTextSize(0);
        iimage4.setTextSize(0);
        iimage5.setTextSize(0);

        rand = new Random();
        //int which_cat = rand.nextInt(cat.size());
        which_color = rand.nextInt(cat.size()); //choose random color
        if (which_color == 0) {
            what_to_click.setText("Click on the blue images");
            for (Button b : blue) {
                b.setText("BLUE");
                b.setTextSize(0);
            }
        } else if (which_color == 1) {
            what_to_click.setText("Click on the black images");
            for (Button b : black) {
                b.setText("BLACK");
                b.setTextSize(0);
            }
        } else if (which_color == 2) {
            what_to_click.setText("Click on the green images");
            for (Button b : green) {
                b.setText("GREEN");
                b.setTextSize(0);
            }
        } else if (which_color == 3) {
            what_to_click.setText("Click on the purple images");
            for (Button b : purple) {
                b.setText("PURPLE");
                b.setTextSize(0);
            }
        } else if (which_color == 4) {
            what_to_click.setText("Click on the red images");
            for (Button b : red) {
                b.setText("RED");
                b.setTextSize(0);
            }
        } else if (which_color == 5) {
            what_to_click.setText("Click on the yellow images");
            for (Button b : yellow) {
                b.setText("YELLOW");
                b.setTextSize(0);
            }
        }

        for (int i = 0; i <= 4; i++) {
            int which_image = rand.nextInt(blue.size()); //choose a random number from the list that was chosen
            //which_color = rand.nextInt(cat.size()); //choose random color
            if (which_color == 0) {
                images.get(i).setBackground(blue.get(which_image).getBackground());
                images.get(i).setText(blue.get(which_image).getText());
            } else if (which_color == 1) {
                images.get(i).setBackground(black.get(which_image).getBackground());
                images.get(i).setText(black.get(which_image).getText());
            } else if (which_color == 2) {
                images.get(i).setBackground(green.get(which_image).getBackground());
                images.get(i).setText(green.get(which_image).getText());
            } else if (which_color == 3) {
                images.get(i).setBackground(purple.get(which_image).getBackground());
                images.get(i).setText(purple.get(which_image).getText());
            } else if (which_color == 4) {
                images.get(i).setBackground(red.get(which_image).getBackground());
                images.get(i).setText(red.get(which_image).getText());
            } else if (which_color == 5) {
                images.get(i).setBackground(yellow.get(which_image).getBackground());
                images.get(i).setText(yellow.get(which_image).getText());
            }
            which_color = rand.nextInt(cat.size()); //choose random color
        }
        //shuffle();

    }

    public void shuffle() {
        int which_image2 = rand.nextInt(images.size());

        shuffle.setBackground(images.get(0).getBackground());
        shuffle.setText(images.get(0).getText());
        images.get(0).setBackground(images.get(which_image2).getBackground());
        images.get(0).setText(images.get(which_image2).getText());
        images.get(which_image2).setBackground(shuffle.getBackground());
        images.get(which_image2).setText(shuffle.getText());
        shuffle = images.get(which_image2);

    }

    public void testOnClick(View v) {
        for (Button b : blue) {
            b.setText("");
        }
        for (Button b : black) {
            b.setText("");
        }
        for (Button b : green) {
            b.setText("");
        }
        for (Button b : purple) {
            b.setText("");
        }
        for (Button b : red) {
            b.setText("");
        }
        for (Button b : yellow) {
            b.setText("");
        }
        initTest();
    }

    public void playOnClick(View v) {
        this.setContentView(R.layout.activity_game9_play);
        popUpWindow = new PopUpWindow(this,this);
        initGame();

    }

    public void checkWin() {
        for (Button b : images) {
            if (!b.getText().equals("")) {
                right_color.add(b);
            }
        }
    }

    public void checkEndGame() {
        if (sc == 15) {
            currentSession.setTimeEnd(System.currentTimeMillis() / 1000);
            dbHandler.addSessionToDB(currentSession);
            soundHandler.stopSound();
            Toast.makeText(this, "GAME END", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Menu2.class);
            startActivity(intent);
        }
    }
    private void cleanBackgroundForPopUp() {

        if (popUpWindow.getmPopupWindow().isShowing()) {

            iimage1.setVisibility(View.INVISIBLE);
            iimage2.setVisibility(View.INVISIBLE);
            iimage3.setVisibility(View.INVISIBLE);
            iimage4.setVisibility(View.INVISIBLE);
            iimage5.setVisibility(View.INVISIBLE);
            what_to_click.setVisibility(View.INVISIBLE);
            popUpWindow.getmPopupWindow().setOnDismissListener(new PopupWindow.OnDismissListener() {

                @Override
                public void onDismiss() {

                    iimage1.setVisibility(View.VISIBLE);
                    iimage2.setVisibility(View.VISIBLE);
                    iimage3.setVisibility(View.VISIBLE);
                    iimage4.setVisibility(View.VISIBLE);
                    iimage5.setVisibility(View.VISIBLE);
                    what_to_click.setVisibility(View.VISIBLE);

                }
            });
        }


    }
    public void checkOnClick(View v) {
        checkWin();
        checkEndGame();
        if (right_color.size() == clicked.size() && lose.size() == 0) {

            popUpWindow.showPopUp(getResources().getString(R.string.found_all));
            cleanBackgroundForPopUp();
            //right_color.remove(b);
            sc++;
            score.setText("Score: " + sc);
            position = 0;
            right_color.removeAll(clicked);
            for (int i = 0; i < clicked.size(); i++) {
                clicked.remove(i);
            }
            currentSession.setScore(sc);
            soundHandler.playOkSound();
            initGame();
        } else if (lose.size() != 0) {
            currentSession.setFails(currentSession.getFails() + 1);
            soundHandler.playWrongSound();
            for (int i = 0; i < lose.size(); i++) {
                lose.remove(i);
            }
            position1 = 0;
            position = 0;
            popUpWindow.showPopUp(getResources().getString(R.string.clicked_more));
            cleanBackgroundForPopUp();
        } else if (clicked.size() < right_color.size()) {
            currentSession.setFails(currentSession.getFails() + 1);
            soundHandler.playWrongSound();
            //Toast.makeText(this, String.valueOf(clicked.size()), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, String.valueOf(right_color.size()), Toast.LENGTH_SHORT).show();

            for (int i = 0; i < clicked.size(); i++) {
                clicked.remove(i);
            }
            position1 = 0;
            position = 0;
            popUpWindow.showPopUp(getResources().getString(R.string.missed_something));
            cleanBackgroundForPopUp();
        } else if (clicked.size() > right_color.size()) {
            for (int i = 0; i < clicked.size(); i++) {
                clicked.remove(i);
            }
            position1 = 0;
            position = 0;
            popUpWindow.showPopUp(getResources().getString(R.string.try_again));
            cleanBackgroundForPopUp();
            //Toast.makeText(this, String.valueOf(clicked.size()), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, String.valueOf(right_color.size()), Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < right_color.size(); i++) {
            right_color.remove(i);
        }
        position1 = 0;
        position = 0;
        for (int i = 0; i < clicked.size(); i++) {
            clicked.remove(i);
        }
        for (int i = 0; i < clicked.size(); i++) {
            clicked.remove(i);
        }
        for (int i = 0; i < right_color.size(); i++) {
            right_color.remove(i);
        }
        for (int i = 0; i < lose.size(); i++) {
            lose.remove(i);
        }
    }

    public void button1OnClick(View v) {
        if (!iimage1.getText().equals("")) {
            //clicked.add(position, true);
            clicked.add(position, true);
            position++;
        } else {
            lose.add(position1, iimage1);
            position1++;
            //Toast.makeText(this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
        }
    }

    public void button2OnClick(View v) {
        if (!iimage2.getText().equals("")) {
            clicked.add(position, true);
            position++;
        } else {
            lose.add(position1, iimage2);
            position1++;
            //Toast.makeText(this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
        }
    }

    public void button3OnClick(View v) {
        if (!iimage3.getText().equals("")) {
            //clicked.add(2, true);
            clicked.add(position, true);
            position++;
        } else {
            lose.add(position1, iimage3);
            position1++;
            //Toast.makeText(this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
        }
    }

    public void button4OnClick(View v) {
        if (!iimage4.getText().equals("")) {
            clicked.add(position, true);
            position++;
        } else {
            lose.add(position1, iimage4);
            position1++;
            //Toast.makeText(this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
        }
    }

    public void button5OnClick(View v) {
        if (!iimage5.getText().equals("")) {
            clicked.add(position, true);
            position++;
        } else {
            lose.add(position1, iimage5);
            position1++;
            //Toast.makeText(this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
        }
    }


}