package com.example.myapplication;


import static com.example.myapplication.Config.getBlue;
import static com.example.myapplication.Config.getDifficulty;
import static com.example.myapplication.Config.getEasy;
import static com.example.myapplication.Config.getGreen;
import static com.example.myapplication.Config.getMedium;
import static com.example.myapplication.Config.getName;
import static com.example.myapplication.Config.getRed;
import static com.example.myapplication.Config.getSprite;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;


public class Gameplay extends AppCompatActivity {

    float upx;
    float downx;
    float upy;
    float downy;
    float outPX = 970;
    float outNX = -50;
    float outPY = 1900;
    float outNY = 800;
    int maxHeight = 0;
    int height = 0;
    int score = 0;


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
        ImageView heart2 = (ImageView) findViewById(R.id.heart2);
        ImageView heart3 = (ImageView) findViewById(R.id.heart3);
        ImageView playerspriteg = (ImageView) findViewById(R.id.playerspriteg);
        ImageView playerspriter = (ImageView) findViewById(R.id.playerspriter);
        ImageView playerspriteb = (ImageView) findViewById(R.id.playerspriteb);
        ImageView slowcar1 = (ImageView) findViewById(R.id.slowcar1);
        ImageView slowcar2 = (ImageView) findViewById(R.id.slowcar2);
        ImageView slowcar3 = (ImageView) findViewById(R.id.slowcar3);
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
        // Background
        int numRoads = (int) (Math.random() * 2);
        backgroundCreate(numRoads);
        carAnimation(slowcar1, 3000);
        slowcar2.setX(slowcar2.getX() + 400);
        carAnimation(slowcar2, 3000);
        slowcar3.setX(slowcar3.getX() + 800);
        carAnimation(slowcar3, 3000);
        //ExecutorService executor
    }
//    protected void difficultySelect() {
//
//    }
    protected void backgroundCreate(int numRoads) {

        ImageView safe = (ImageView) findViewById(R.id.safe);
        safe.setImageResource(getResources().getIdentifier("grass_row", "drawable", getPackageName()));
        ImageView bg1 = (ImageView) findViewById(R.id.bg1);
        bg1.setImageResource(getResources().getIdentifier("road_row", "drawable", getPackageName()));
        ImageView bg2 = (ImageView) findViewById(R.id.bg2);
        bg2.setImageResource(getResources().getIdentifier("road_row", "drawable", getPackageName()));
        ImageView bg3 = (ImageView) findViewById(R.id.bg3);
        bg3.setImageResource(getResources().getIdentifier("road_row", "drawable", getPackageName()));
        ImageView bg4 = (ImageView) findViewById(R.id.bg4);
        if (numRoads > 0) {
            bg4.setImageResource(getResources().getIdentifier("road_row", "drawable", getPackageName()));
        } else {
            bg4.setImageResource(getResources().getIdentifier("grass_row", "drawable", getPackageName()));
        }
        ImageView bg5 = (ImageView) findViewById(R.id.bg5);
        if (numRoads == 0) {
            bg5.setImageResource(getResources().getIdentifier("river_row_new", "drawable", getPackageName()));
        } else if (numRoads == 1) {
            bg5.setImageResource(getResources().getIdentifier("grass_row", "drawable", getPackageName()));
        } else {
            bg5.setImageResource(getResources().getIdentifier("road_row", "drawable", getPackageName()));
        }
        ImageView bg6 = (ImageView) findViewById(R.id.bg6);
        if (numRoads == 2) {
            bg6.setImageResource(getResources().getIdentifier("grass_row", "drawable", getPackageName()));
        } else {
            bg6.setImageResource(getResources().getIdentifier("river_row_new", "drawable", getPackageName()));
        }
        ImageView bg7 = (ImageView) findViewById(R.id.bg7);
        bg7.setImageResource(getResources().getIdentifier("river_row_new", "drawable", getPackageName()));
        ImageView bg8 = (ImageView) findViewById(R.id.bg8);
        bg8.setImageResource(getResources().getIdentifier("end_row_new", "drawable", getPackageName()));
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int yMovement = 120;
        int xMovement = 109;
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
                break;
            case MotionEvent.ACTION_UP: //when swipe ended
                upx = event.getX(); //gets x of swipe end
                upy = event.getY(); //gets y of swipe end
                float countPX = playersprite.getX() + xMovement;
                float countNX = playersprite.getX() - xMovement;
                float countPY = playersprite.getY() + yMovement;
                float countNY = playersprite.getY() - yMovement;
                float deltax = downx - upx;
                float deltay = downy - upy;
                if (Math.abs(deltax) > Math.abs(deltay)) { //checks if swipe was vertical or horizontal
                    if (downx > upx && countNX > outNX) { // checks if swipe was left to right
                        playersprite.setX(playersprite.getX() - xMovement);
                    }
                    if (downx < upx && countPX < outPX){
                        playersprite.setX(playersprite.getX() + xMovement);
                    }
                } else {
                    if (downy > upy && countNY > outNY) { //checks if swipe was top to bottom
                        playersprite.setY(playersprite.getY() - yMovement);
                        height++;
                        setScore();
                    } if (downy < upy && (countPY < outPY)) {
                        playersprite.setY(playersprite.getY() + yMovement);
                        height--;
                    }
                }
                break;
        }

        return super.onTouchEvent(event);
    }
    public void setScore() {
        TextView scoreText = (TextView) findViewById(R.id.score);
        if (maxHeight < height) {
            maxHeight = height;
            score = score + 10;
            scoreText.setText("Score: " + score);
        }
    }
    public void carAnimation(ImageView car, long carSpeed) {
        TranslateAnimation moveCar = new TranslateAnimation(100, -1200, 0, 0);
        moveCar.setDuration(carSpeed);
        moveCar.setFillAfter(true);
        moveCar.setRepeatCount(-1);
        car.startAnimation(moveCar);
    }
}