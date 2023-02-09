package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Config extends AppCompatActivity {
    private static RadioGroup difficulty;
    private static RadioGroup spritepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        Button next = (Button) findViewById(R.id.Next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            //Takes the player to the gameplay screen on button press
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.name);
                TextView warning = (TextView) findViewById(R.id.warning);
                difficulty = (RadioGroup) findViewById(R.id.difficulty);
                spritepicker = (RadioGroup) findViewById(R.id.spritepicker);
                if (name == null || name.getText().toString().trim().length() == 0 || difficulty.getCheckedRadioButtonId() == -1 || spritepicker.getCheckedRadioButtonId() == -1) {
                    warning.setVisibility(view.VISIBLE);    //Shows a warning message if name is invalid
                } else {
                    Intent nextScreen = new Intent(Config.this, Gameplay.class);
                    startActivity(nextScreen);
                }
            }
        });
    }
    public static RadioGroup getDifficulty() {
        return difficulty;
    }
    public static RadioGroup getSprite() {
        return spritepicker;
    }
}