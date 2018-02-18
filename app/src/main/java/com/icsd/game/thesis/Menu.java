package com.icsd.game.thesis;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void play13(View view) {
        Intent intent = new Intent(Menu.this,Game13.class);
        startActivity(intent);
    }
}
