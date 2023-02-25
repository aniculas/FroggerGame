package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Config extends AppCompatActivity {
    private static RadioGroup difficulty;
    private static RadioGroup spritepicker;
    private static RadioButton easy;
    private static RadioButton medium;
    private static RadioButton red;
    private static RadioButton green;
    private static RadioButton blue;
    private static EditText name;
    private static TextView warning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        Button next = (Button) findViewById(R.id.Next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            //Takes the player to the gameplay screen on button press
            public void onClick(View view) {
                name = (EditText) findViewById(R.id.name);
                warning = (TextView) findViewById(R.id.warning);
                difficulty = (RadioGroup) findViewById(R.id.difficulty);
                spritepicker = (RadioGroup) findViewById(R.id.spritepicker);
                easy = (RadioButton) findViewById(R.id.easy);
                medium = (RadioButton) findViewById(R.id.medium);
                red = (RadioButton) findViewById(R.id.sprite2);
                green = (RadioButton) findViewById(R.id.sprite1);
                blue = (RadioButton) findViewById(R.id.sprite3);
                checkSelected(name, difficulty, spritepicker);
            }
        });
    }
    public boolean checkSelected(EditText name, RadioGroup difficulty, RadioGroup spritepicker) {
        if (name == null || name.getText().toString().trim().length() == 0
                || difficulty.getCheckedRadioButtonId() == -1
                || spritepicker.getCheckedRadioButtonId() == -1) {
            warning.setVisibility(View.VISIBLE); //Warning message if name is invalid
            return false;
        } else {
            Intent nextScreen = new Intent(Config.this, Gameplay.class);
            startActivity(nextScreen);
            return true;
        }
    }
    public static RadioGroup getDifficulty() {
        return difficulty;
    }
    public static RadioGroup getSprite() {
        return spritepicker;
    }
    public static RadioButton getEasy() {
        return easy;
    }
    public static RadioButton getMedium() {
        return medium;
    }
    public static RadioButton getRed() {
        return red;
    }
    public static RadioButton getGreen() {
        return green;
    }
    public static RadioButton getBlue() {
        return blue;
    }
    public static EditText getName() {
        return name;
    }
    public static TextView getWarning() {
        return warning;
    }
}