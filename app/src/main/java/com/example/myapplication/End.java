package com.example.myapplication;

import static com.example.myapplication.Gameplay.getScore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class End extends AppCompatActivity {
    public static TextView scoreText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        scoreText = (TextView) findViewById(R.id.score);
        scoreText.setText("Final Score: " + getScore());
        Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            // Takes the player to config screen on button press
            public void onClick(View view) {
                Intent nextScreen = new Intent(End.this, Config.class);
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
    }
}