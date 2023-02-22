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
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Gameplay extends AppCompatActivity {

    float upx;
    float downx;
    float upy;
    float downy;
    float outPX;
    float outNX;
    float outPY;
    float outNY;

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
        } else if (difficulty.getCheckedRadioButtonId() == medium.getId()) {
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
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        ImageView playersprite;
        ImageView playerspriteg = (ImageView) findViewById(R.id.playerspriteg);
        ImageView playerspriter = (ImageView) findViewById(R.id.playerspriter);
        ImageView playerspriteb = (ImageView) findViewById(R.id.playerspriteb);
        if (playerspriteg.getVisibility() == View.VISIBLE) { //checks which sprite was selected
            playersprite = playerspriteg;
        } else if (playerspriter.getVisibility() == View.VISIBLE) {
            playersprite = playerspriter;
        } else {
            playersprite = playerspriteb;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: //when swipe started
                downx = event.getX(); //gets x of swipe start
                downy = event.getY(); //gets y of swipe start
                outPX = 1200;
                outNX = -180;
                outPY = -1200;
                outNY = 100;
                break;
            case MotionEvent.ACTION_UP: //when swipe ended
                upx = event.getX(); //gets x of swipe end
                upy = event.getY(); //gets y of swipe end
                float countPX = playersprite.getX() + 89;
                float countNX = playersprite.getX() - 89;
//                    float countPY = playersprite.getY() + 89;
                float countNY = playersprite.getY() - 89;
                float deltax = downx - upx;
                float deltay = downy - upy;
                if (Math.abs(deltax) > Math.abs(deltay)) { //checks if swipe was vertical or horizontal
                    if (downx > upx && countNX > outNX) { // checks if swipe was left to right
                        playersprite.setX(playerspriteg.getX() - 89);
                    }
                    if (downx < upx && countPX < outPX){
                        playersprite.setX(playerspriteg.getX() + 89);
                    }
                } else {
                    if (downy > upy && countNY > outNY) { //checks if swipe was top to bottom
                        playersprite.setY(playerspriteg.getY() - 89);
                    } if (downy < upy && (playerspriteg.getY() < 2300)) {
                        playersprite.setY(playerspriteg.getY() + 89);
                    }
                }
                break;
        }

        return super.onTouchEvent(event);
    }
}