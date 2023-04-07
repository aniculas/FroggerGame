package com.example.myapplication;

import static com.example.myapplication.Gameplay.getMaxScore;
import static com.example.myapplication.Gameplay.getPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class End extends AppCompatActivity implements MainMenu {
    public static TextView scoreText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        scoreText = (TextView) findViewById(R.id.score);
        TextView winLoss = (TextView) findViewById(R.id.winloss);
        scoreText.setText("High Score: " + getMaxScore());
        if (getPlayer().lives == 0) {
            winLoss.setText("You Lose!");
        } else {
            winLoss.setText("You Win!");
        }
    }

    @Override
    public void playGame(View view) {
        Intent nextScreen = new Intent(End.this, Config.class);
        finish();
        startActivity(nextScreen);
    }

    @Override
    public void exitGame(View view) {
        finish();
        System.exit(0);
    }
}