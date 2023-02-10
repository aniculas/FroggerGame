package com.example.myapplication;


import static com.example.myapplication.Config.getDifficulty;
import static com.example.myapplication.Config.getSprite;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Gameplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        RadioGroup difficulty = getDifficulty();
        RadioGroup spritepicker = getSprite();
        ImageView playersprite = (ImageView) findViewById(R.id.playerspriteg);
        ImageView heart1 = (ImageView) findViewById(R.id.heart1);
        ImageView heart2 = (ImageView) findViewById(R.id.heart2);
        ImageView heart3 = (ImageView) findViewById(R.id.heart3);
        ImageView playerspriteg = (ImageView) findViewById(R.id.playerspriteg);
        ImageView playerspriter = (ImageView) findViewById(R.id.playerspriter);
        ImageView playerspriteb = (ImageView) findViewById(R.id.playerspriteb);
        switch (difficulty.getCheckedRadioButtonId()) {
            case 2131231219: //id of easy difficulty button
                heart2.setVisibility(View.VISIBLE);
                heart3.setVisibility(View.VISIBLE);
                break;
            case 2131231221: //id of medium difficulty button
                heart2.setVisibility(View.VISIBLE);
                break;
        }
        switch (spritepicker.getCheckedRadioButtonId()) {
            case 2131231231:
                playerspriteg.setVisibility(View.VISIBLE);
                break;
            case 2131231232:
                playerspriter.setVisibility(View.VISIBLE);
                break;
            case 2131231233:
                playerspriteb.setVisibility(View.VISIBLE);
                break;
        }
    }
}