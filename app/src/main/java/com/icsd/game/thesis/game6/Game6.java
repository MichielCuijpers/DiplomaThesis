package com.icsd.game.thesis.game6;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.icsd.game.thesis.activities.LoginActivity;
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.SoundHandler;
import com.icsd.game.thesis.activities.SurveyActivity;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.commons.Session;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.ArrayList;
import java.util.Random;

public class Game6 extends AppCompatActivity {
    private Button iimage1;
    private Button iimage2;
    private Button iimage3;
    private Button iimage4;
    private Button iimage5;
    private ArrayList<Button> images;
    private ArrayList<Button> fruits;
    private ArrayList<Button> vehicles;
    private ArrayList<Button> smart_devices;
    private ArrayList<Button> food;
    private ArrayList<Button> flowers;
    private TextView score;
    // private Categories category;
    private Random rand;
    private ArrayList<ArrayList> cat;
    private Button melon, avocado, strawberry, banana, cherries, kiwi, orange, bicycle, bike, car, jeep, truck, golf, suv, phone, phone2, tablet, tablet2,
            smartwatch, pc, laptop, flower1, flower2, flower3, flower4, flower5, flower6, flower7, shuffle;
    private int sc = 0;
    private int wrongs = 0;
    private Session currentSession;
    private DatabaseHandler dbHandler;
    private SoundHandler soundHandler;
    private PopUpWindow popUpWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game6_content_main);
        dbHandler = new DatabaseHandler(this.getApplicationContext());
        currentSession = new Session(LoginActivity.getUser().getUsername(), 6);
        currentSession.setTimeStart(System.currentTimeMillis() / 1000);
        soundHandler = new SoundHandler(getApplicationContext());
        initTest();
    }

    public void onStop() {
        super.onStop();
        if (currentSession != null) {
            currentSession.setTimeEnd(System.currentTimeMillis() / 1000);
            dbHandler = new DatabaseHandler(this);
            dbHandler.addSessionToDB(this.currentSession);
        }
    }

    private void initTest() {

        images = new ArrayList<>();
        fruits = new ArrayList<>();
        vehicles = new ArrayList<>();
        smart_devices = new ArrayList<>();
        food = new ArrayList<>();
        flowers = new ArrayList<>();
        cat = new ArrayList<>();


        initButtons();

        //category = new Categories();
        //flowers=category.getFlowers();
        //fruits=category.getFruits();
        // vehicles=category.getVehicles();
        //smart_devices=category.getSmart_devices();


        cat.add(flowers);
        cat.add(fruits);
        cat.add(vehicles);
        cat.add(smart_devices);
        initGameplay();
        shuffle();


    }

    private void initLists() {

        images = new ArrayList<>();
        fruits = new ArrayList<>();
        vehicles = new ArrayList<>();
        smart_devices = new ArrayList<>();
        food = new ArrayList<>();
        flowers = new ArrayList<>();
        cat = new ArrayList<>();
    }

    private void initButtons() {
        iimage1 = findViewById(R.id.image1);
        iimage2 = findViewById(R.id.image2);
        iimage3 = findViewById(R.id.image3);
        iimage4 = findViewById(R.id.image4);
        iimage5 = findViewById(R.id.image5);

        melon = findViewById(R.id.button46);
        shuffle = findViewById(R.id.button18);
        avocado = findViewById(R.id.button19);
        strawberry = findViewById(R.id.button20);
        banana = findViewById(R.id.button21);
        cherries = findViewById(R.id.button22);
        kiwi = findViewById(R.id.button23);
        orange = findViewById(R.id.button24);
        bicycle = findViewById(R.id.button25);
        bike = findViewById(R.id.button26);
        car = findViewById(R.id.button27);
        jeep = findViewById(R.id.button28);
        truck = findViewById(R.id.button29);
        golf = findViewById(R.id.button30);
        suv = findViewById(R.id.button31);
        phone = findViewById(R.id.button32);
        phone2 = findViewById(R.id.button33);
        tablet = findViewById(R.id.button34);
        tablet2 = findViewById(R.id.button35);
        smartwatch = findViewById(R.id.button36);
        pc = findViewById(R.id.button37);
        laptop = findViewById(R.id.button38);
        flower1 = findViewById(R.id.button39);
        flower2 = findViewById(R.id.button40);
        flower3 = findViewById(R.id.button41);
        flower4 = findViewById(R.id.button42);
        flower5 = findViewById(R.id.button43);
        flower6 = findViewById(R.id.button44);
        flower7 = findViewById(R.id.button45);

        melon.setBackground(getDrawable(R.drawable.melon));
        avocado.setBackground(getDrawable(R.drawable.avocado));
        strawberry.setBackground(getDrawable(R.drawable.strawberry));
        banana.setBackground(getDrawable(R.drawable.banana));
        cherries.setBackground(getDrawable(R.drawable.cherries));
        kiwi.setBackground(getDrawable(R.drawable.kiwi));
        orange.setBackground(getDrawable(R.drawable.orange));
        bicycle.setBackground(getDrawable(R.drawable.bicycle));
        bike.setBackground(getDrawable(R.drawable.bike));
        car.setBackground(getDrawable(R.drawable.car));
        jeep.setBackground(getDrawable(R.drawable.jeep));
        truck.setBackground(getDrawable(R.drawable.truck));
        golf.setBackground(getDrawable(R.drawable.golf_cart));
        suv.setBackground(getDrawable(R.drawable.suv));
        phone.setBackground(getDrawable(R.drawable.phone));
        phone2.setBackground(getDrawable(R.drawable.phone2));
        tablet.setBackground(getDrawable(R.drawable.tablet));
        tablet2.setBackground(getDrawable(R.drawable.tablet2));
        smartwatch.setBackground(getDrawable(R.drawable.smartwatch));

        pc.setBackground(getDrawable(R.drawable.pc));
        laptop.setBackground(getDrawable(R.drawable.laptop));
        flower1.setBackground(getDrawable(R.drawable.flower1));
        flower2.setBackground(getDrawable(R.drawable.flower2));
        flower3.setBackground(getDrawable(R.drawable.flower3));
        flower4.setBackground(getDrawable(R.drawable.flower4));
        flower5.setBackground(getDrawable(R.drawable.flower5));
        flower6.setBackground(getDrawable(R.drawable.flower6));
        flower7.setBackground(getDrawable(R.drawable.flower7));

        fruits.add(melon);
        fruits.add(avocado);
        fruits.add(strawberry);
        fruits.add(banana);
        fruits.add(cherries);
        fruits.add(kiwi);
        fruits.add(strawberry);

        vehicles.add(bicycle);
        vehicles.add(bike);
        vehicles.add(car);
        vehicles.add(jeep);
        vehicles.add(truck);
        vehicles.add(golf);
        vehicles.add(suv);

        smart_devices.add(phone);
        smart_devices.add(phone2);
        smart_devices.add(tablet);
        smart_devices.add(tablet2);
        smart_devices.add(smartwatch);
        smart_devices.add(pc);
        smart_devices.add(laptop);

        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);
        flowers.add(flower4);
        flowers.add(flower5);
        flowers.add(flower6);
        flowers.add(flower7);

        images.add(iimage1);
        images.add(iimage2);
        images.add(iimage3);
        images.add(iimage4);
        images.add(iimage5);
    }

    private void addButtonsToLists() {
        cat.add(flowers);
        cat.add(fruits);
        cat.add(vehicles);
        cat.add(smart_devices);
    }

    private void initGameplay() {
        rand = new Random();
        int which_cat = rand.nextInt(4);
        for (int i = 0; i < 4; i++) {
            int which_image = rand.nextInt(flowers.size()); //choose a random number from the list that was chosen
            if (which_cat == 0) {
                images.get(i).setBackground(fruits.get(which_image).getBackground());
                //cat.remove(which_cat);
                int doesnt_fit = rand.nextInt(cat.size());
                int which_image1 = rand.nextInt((vehicles.size()));
                if (doesnt_fit == 0) {
                    images.get(4).setBackground(vehicles.get(3).getBackground());

                } else if (doesnt_fit == 1) {
                    images.get(4).setBackground(flowers.get(which_image1).getBackground());
                } else if (doesnt_fit == 2) {
                    images.get(4).setBackground(smart_devices.get(which_image1).getBackground());
                }
                //Button wrong = (Button)cat.get(doesnt_fit).get(which_image); //keeps the wrong image

            } else if (which_cat == 1) {
                images.get(i).setBackground((Drawable) vehicles.get(which_image).getBackground());
                //cat.remove(which_cat);
                int doesnt_fit = rand.nextInt(3);
                int which_image1 = rand.nextInt(cat.size());
                if (doesnt_fit == 0) {
                    images.get(4).setBackground(flowers.get(which_image1).getBackground());
                } else if (doesnt_fit == 1) {
                    images.get(4).setBackground(fruits.get(which_image1).getBackground());
                } else if (doesnt_fit == 2) {
                    images.get(4).setBackground(smart_devices.get(which_image1).getBackground());
                }
                //images.get(4).setBackground((Drawable) cat.get(doesnt_fit).get(which_image));
                //Button wrong = (Button)cat.get(doesnt_fit).get(which_image); //keeps the wrong image
                //Collections.shuffle(images);
            } else if (which_cat == 2) {
                images.get(i).setBackground((Drawable) fruits.get(which_image).getBackground());
                //cat.remove(which_cat);
                int doesnt_fit = rand.nextInt(3);
                int which_image1 = rand.nextInt(cat.size());
                if (doesnt_fit == 0) {
                    images.get(4).setBackground(smart_devices.get(which_image1).getBackground());
                    //images.get(4)
                } else if (doesnt_fit == 1) {
                    images.get(4).setBackground(flowers.get(which_image1).getBackground());
                } else if (doesnt_fit == 2) {
                    images.get(4).setBackground(vehicles.get(which_image1).getBackground());
                }
                //images.get(4).setBackground((Drawable) cat.get(doesnt_fit).get(which_image));
                //Button wrong = (Button)cat.get(doesnt_fit).get(which_image); //keeps the wrong image
                // Collections.shuffle(images);
            } else if (which_cat == 3) {
                images.get(i).setBackground(smart_devices.get(which_image).getBackground());
                //cat.remove(which_cat);
                int doesnt_fit = rand.nextInt(3);
                int which_image1 = rand.nextInt(cat.size());
                if (doesnt_fit == 0) {
                    images.get(4).setBackground(fruits.get(which_image1).getBackground());
                } else if (doesnt_fit == 1) {
                    images.get(4).setBackground(flowers.get(which_image1).getBackground());
                } else if (doesnt_fit == 2) {
                    images.get(4).setBackground(vehicles.get(which_image1).getBackground());
                }
                //Collections.shuffle(images);
            }

        }

    }

    private void initGame() {
        initLists();
        initButtons();
        addButtonsToLists();
        initGameplay();
        //category = new Categories();
        //flowers=category.getFlowers();
        //fruits=category.getFruits();
        // vehicles=category.getVehicles();
        //smart_devices=category.getSmart_devices();
        shuffle1();
    }

    public void shuffle() {
        int which_image2 = rand.nextInt(images.size());

        shuffle.setBackground(images.get(4).getBackground());
        images.get(4).setBackground(images.get(which_image2).getBackground());
        images.get(which_image2).setBackground(shuffle.getBackground());
        images.get(which_image2).setText("WRONG");
        shuffle = images.get(which_image2);

    }

    public void shuffle1() {
        int which_image2 = rand.nextInt(images.size());

        shuffle.setBackground(images.get(4).getBackground());
        images.get(4).setBackground(images.get(which_image2).getBackground());
        images.get(which_image2).setBackground(shuffle.getBackground());
        shuffle = images.get(which_image2);

    }

    public void testOnClick(View View) {
        for (int i = 0; i < images.size(); i++) {
            images.get(i).setText("");
        }
        initTest();
    }

    public void playOnClick(View View) {

        this.setContentView(R.layout.activity_game6_playactivity);
        score = (TextView) findViewById(R.id.text1);
        popUpWindow = new PopUpWindow(Game6.this, Game6.this);
        initGame();

    }//i methodo checkwinner

    private void userWinsTheTurn() {
        sc++;
        score.setText(getResources().getString(R.string.scoreg6) + sc);
        currentSession.setScore(sc);
        currentSession.setStage(currentSession.getStage() + 1);
        soundHandler.playOkSound();
        popUpWindow.showPopUp(getResources().getString(R.string.correct_answer1));
        if (sc == 7 || wrongs == 6) {
            Intent surv = new Intent(this, SurveyActivity.class);
            SurveyActivity.setQuestionType(0);
            SurveyActivity.setGameID(6);
            startActivity(surv);
        } else {
            initGame();
        }

    }

    private void userLoosesTheTurn() {
        wrongs--;
        score.setText(getResources().getString(R.string.scoreg6) + wrongs);
        currentSession.setFails(currentSession.getFails() + 1);
        currentSession.setScore(currentSession.getScore() - 1);
        soundHandler.playWrongSound();
        popUpWindow.showPopUp(getResources().getString(R.string.wrong_answer1));
        initGame();
    }

    public void image1OnClick(View v) {
        if (iimage1.equals(shuffle)) {
            userWinsTheTurn();
        } else {
            userLoosesTheTurn();
        }


    }

    public void image5OnClick(View v) {

        if (iimage5 == shuffle) {
            userWinsTheTurn();
        } else {
            userLoosesTheTurn();
        }

    }

    public void image2OnClick(View v) {

        if (iimage2 == shuffle) {
            userWinsTheTurn();
        } else {
            userLoosesTheTurn();
        }
    }

    public void image3OnClick(View v) {

        if (iimage3 == shuffle) {
            userWinsTheTurn();
        } else {
            userLoosesTheTurn();
        }
    }

    public void image4OnClick(View v) {

        if (iimage4 == shuffle) {
            userWinsTheTurn();
        } else {
            userLoosesTheTurn();
        }
    }


}
