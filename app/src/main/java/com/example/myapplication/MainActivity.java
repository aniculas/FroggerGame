package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MainMenu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/* Old Button Checker
        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            // Takes the player to config screen on button press
            public void onClick(View view) {
                Intent nextScreen = new Intent(MainActivity.this, Config.class);
                finish();
                startActivity(nextScreen);
            }
        });
        Button exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
 */
    }

    @Override
    public void playGame(View view) {
        Intent nextScreen = new Intent(MainActivity.this, Config.class);
        finish();
        startActivity(nextScreen);
    }

    @Override
    public void exitGame(View view) {
        finish();
        System.exit(0);
    }
}