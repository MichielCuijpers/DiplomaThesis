package com.icsd.game.thesis;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.GameDBEntry;
import com.icsd.game.thesis.database.User;
import com.icsd.game.thesis.pet.PopUpWindow;

public class LoginActivity extends AppCompatActivity {
    private final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private TextView number1View;
    private TextView number2View;
    private TextView number3View;
    private TextView number4View;
    private TextView number5View;
    private Integer[][] textViews;
    private static User user;
    private DatabaseHandler dh;
    private static SQLiteDatabase db;
    private PopUpWindow popUpWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        dh = new DatabaseHandler(this);
        db = dh.getWritableDatabase();
       // dh.onCreate(db);
      //  GameDBEntry.addGamesToDB(db, this);
        setContentView(R.layout.splash_screen_layout);
        popUpWindow = new PopUpWindow(this, this);
        android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                setContentView(R.layout.activity_login);
                initGui();
            }
        }, 1000);

    }

    private void initGui() {
        number1View = findViewById(R.id.number1View);
        number2View = findViewById(R.id.number2View);
        number3View = findViewById(R.id.number3View);
        number4View = findViewById(R.id.number4View);
        number5View = findViewById(R.id.number5View);
        textViews = new Integer[5][2];
        textViews[0][0] = number1View.getId();
        textViews[1][0] = number2View.getId();
        textViews[2][0] = number3View.getId();
        textViews[3][0] = number4View.getId();
        textViews[4][0] = number5View.getId();
        for (int i = 0; i < 5; i++) {
            textViews[i][1] = 0;
        }


    }

    private void changeLetterUp(Integer i) {

        TextView view = findViewById(textViews[i][0]);

        view.setText(alphabet[textViews[i][1]] + "");
        if (textViews[i][1] != 25) {
            textViews[i][1]++;
            view.setText(alphabet[textViews[i][1]] + "");
        } else {
            textViews[i][1] = 0;
            view.setText(alphabet[textViews[i][1]] + "");
        }


    }

    private void changeLetterDown(Integer i) {

        TextView view = findViewById(textViews[i][0]);
        if (textViews[i][1] != 0) {
            textViews[i][1]--;
            view.setText(alphabet[textViews[i][1]] + "");
        } else {
            textViews[i][1] = 25;
            view.setText(alphabet[textViews[i][1]] + "");
        }


    }


    public void upButton1(View view) {
        changeLetterUp(0);
    }

    public void downButton1(View view) {
        changeLetterDown(0);

    }

    public void upButton2(View view) {
        changeLetterUp(1);

    }

    public void downButton2(View view) {
        changeLetterDown(1);

    }

    public void upButton3(View view) {
        changeLetterUp(2);

    }

    public void downButton3(View view) {
        changeLetterDown(2);

    }

    public void upButton4(View view) {
        changeLetterUp(3);

    }

    public void downButton4(View view) {
        changeLetterDown(3);

    }


    public void upButotn5(View view) {
        changeLetterUp(4);

    }


    public void downButton5(View view) {
        changeLetterDown(4);
    }

    public void doneOnClick(View view) {
        user = new User(number1View.getText().toString() + number2View.getText() + number3View.getText() + number4View.getText() + number5View.getText());
        if (dh.addUserToDB(user, db)) {
            Log.e("MYDEBUG","WELCOME ");
           // popUpWindow.showPopUp("Welcome Back");
        } else {
            Log.e("MYDEBUG","WELCOME back");
           // popUpWindow.showPopUp("Have Fun in The Games ");
        }
        Intent c = new Intent(LoginActivity.this, Menu.class);
        startActivity(c);
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    public static User getUser() {
        return user;
    }

}
