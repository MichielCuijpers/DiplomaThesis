package com.icsd.game.thesis.commons;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.icsd.game.thesis.R;
import com.icsd.game.thesis.database.DatabaseHandler;
import com.icsd.game.thesis.database.GameDBEntry;
import com.icsd.game.thesis.database.User;
import com.icsd.game.thesis.pet.PopUpWindow;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    private static User user;
    private DatabaseHandler dh;
    private static SQLiteDatabase db;
    private PopUpWindow popUpWindow;
    public static String lan;
    private EditText nameText;
    private TextView textView;
    private Boolean isNew = false;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_layout);
        popUpWindow = new PopUpWindow(this, this);


        checkLocationPermission();

    }

    private void initGui() {
        nameText = findViewById(R.id.nameText);
        textView = findViewById(R.id.editText);
        this.spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sexs_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.spinner.setAdapter(adapter);
        this.spinner.setVisibility(View.INVISIBLE);
        dh = new DatabaseHandler(this);
        db = dh.getWritableDatabase();
        dh.onCreate(db);
        GameDBEntry.addGamesToDB(db, this);


    }


    public void doneOnClick(View view) {

        if (!isNew) {
            user = new User(nameText.getText().toString());
            if (dh.checkIfUserExists(db, user.getUsername())) {

                Log.e("MYDEBUG", "WELCOME ");
                this.nameText.setText("");
                this.nameText.setHint("Give age");
                this.spinner.setVisibility(View.VISIBLE);
                this.textView.setText(R.string.give_sex_age);
                this.isNew = true;
                // popUpWindow.showPopUp("Welcome Back");


            } else {
                Log.e("MYDEBUG", "WELCOME back");
                //popUpWindow.showPopUp("Have Fun in The Games ");
                Intent c = new Intent(LoginActivity.this, Menu.class);
                startActivity(c);
            }
        } else {
            user.setAge(Integer.parseInt(nameText.getText().toString()));
            user.setSex(this.spinner.getSelectedItem().toString());
            dh.addUserToDB(user, db);
            Intent c = new Intent(LoginActivity.this, Menu.class);
            startActivity(c);
        }


    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    public static User getUser() {
        return user;
    }

    public void chooseEnglish(View view) {
        String lang = "en";
        Configuration config = getBaseContext().getResources().getConfiguration();
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang)) {
            Locale locale = new Locale(lang);
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
        setContentView(R.layout.activity_login);
        initGui();
    }

    public void chooseGreek(View view) {

        lan = "el";
        Configuration config = getBaseContext().getResources().getConfiguration();
        if (!"".equals(lan) && !config.locale.getLanguage().equals(lan)) {
            Locale locale = new Locale("el", "GR");
            Locale.setDefault(locale);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }

        setContentView(R.layout.activity_login);
        initGui();

    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
                new AlertDialog.Builder(this)
                        .setTitle(R.string.title_location_permission)
                        .setMessage(R.string.text_location_permission)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 11);
                            }
                        })
                        .create()
                        .show();
            else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        11);
            }
            return false;
        } else {
            return true;
        }
    }

    public void nameTextOnClick(View view) {

    }
}
