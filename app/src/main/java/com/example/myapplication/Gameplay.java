package com.example.myapplication;


import static com.example.myapplication.Config.getBlue;
import static com.example.myapplication.Config.getDifficulty;
import static com.example.myapplication.Config.getEasy;
import static com.example.myapplication.Config.getGreen;
import static com.example.myapplication.Config.getMedium;
import static com.example.myapplication.Config.getName;
import static com.example.myapplication.Config.getRed;
import static com.example.myapplication.Config.getSprite;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Gameplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        RadioGroup difficulty = getDifficulty();
        RadioGroup spritepicker = getSprite();
        RadioButton medium = getMedium();
        RadioButton easy = getEasy();
        RadioButton green = getGreen();
        RadioButton blue = getBlue();
        RadioButton red = getRed();
        ImageView playersprite = (ImageView) findViewById(R.id.playerspriteg);
        ImageView heart1 = (ImageView) findViewById(R.id.heart1);
        ImageView heart2 = (ImageView) findViewById(R.id.heart2);
        ImageView heart3 = (ImageView) findViewById(R.id.heart3);
        ImageView playerspriteg = (ImageView) findViewById(R.id.playerspriteg);
        ImageView playerspriter = (ImageView) findViewById(R.id.playerspriter);
        ImageView playerspriteb = (ImageView) findViewById(R.id.playerspriteb);
        TextView diff = (TextView) findViewById(R.id.diff);
        if (difficulty.getCheckedRadioButtonId() == easy.getId()) {
            heart2.setVisibility(View.VISIBLE);
            heart3.setVisibility(View.VISIBLE);
            diff.setText("Easy");
        }else if (difficulty.getCheckedRadioButtonId() == medium.getId()) {
            heart2.setVisibility(View.VISIBLE);
            diff.setText("Medium");
        } else {
            diff.setText("Hard");
        }
        if (spritepicker.getCheckedRadioButtonId() == green.getId()) {
            playerspriteg.setVisibility(View.VISIBLE);
        } else if (spritepicker.getCheckedRadioButtonId() == red.getId()) {
            playerspriter.setVisibility(View.VISIBLE);
        } else if (spritepicker.getCheckedRadioButtonId() == blue.getId()) {
            playerspriteb.setVisibility(View.VISIBLE);
        }
        TextView playerName = (TextView) findViewById(R.id.playername);
        playerName.setText(getName().getText());
    }
}