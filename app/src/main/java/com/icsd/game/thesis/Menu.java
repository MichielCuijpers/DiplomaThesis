package com.icsd.game.thesis;

        import android.content.Context;
        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.support.v4.view.GestureDetectorCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;


public class Menu extends AppCompatActivity {
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void goToMenu2(View view) {
        Intent c = new Intent(Menu.this,Menu2.class);
        startActivity(c);
    }


    public void game13(View view) {
        Intent c = new Intent(Menu.this,Game13.class);
        startActivity(c);
    }
}
