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
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class Gameplay extends AppCompatActivity {

    float upx;
    float downx;
    float upy;
    float downy;
    Player player;
    Sprite sprite;
    int height = 0;
    int score = 0;
    boolean row5car = false;
    int playerID;
    float[] position;


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
        TextView diff = (TextView) findViewById(R.id.diff);
        //SET HEARTS---------------------------------------------------------------------------
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
        //SET SPRITE---------------------------------------------------------------------------
        if (spritepicker.getCheckedRadioButtonId() == green.getId()) {
            //player = new Player(playerspriteg);
            sprite = new Sprite(playerspriteg);
            player = new Player(sprite.sprite.getX(), sprite.sprite.getY());
            playerspriteg.setVisibility(View.VISIBLE);
        } else if (spritepicker.getCheckedRadioButtonId() == red.getId()) {
            //player = new Player(playerspriter);
            sprite = new Sprite(playerspriter);
            player = new Player(sprite.sprite.getX(), sprite.sprite.getY());
            playerspriter.setVisibility(View.VISIBLE);
        } else if (spritepicker.getCheckedRadioButtonId() == blue.getId()) {
            //player = new Player(playerspriteb);
            sprite = new Sprite(playerspriteb);
            player = new Player(sprite.sprite.getX(), sprite.sprite.getY());
            playerspriteb.setVisibility(View.VISIBLE);
        }
        TextView playerName = (TextView) findViewById(R.id.playername);
        playerName.setText(getName().getText());
        // Background
        int numRoads = (int) (Math.random() * 3);
        backgroundCreate(numRoads);

    }

    protected void backgroundCreate(int numRoads) {

        ImageView slowcar1 = (ImageView) findViewById(R.id.slowcar1);
        ImageView slowcar2 = (ImageView) findViewById(R.id.slowcar2);
        ImageView slowcar3 = (ImageView) findViewById(R.id.slowcar3);
        ImageView slowcar4 = (ImageView) findViewById(R.id.slowcar4);
        ImageView slowcar5 = (ImageView) findViewById(R.id.slowcar5);
        ImageView slowcar6 = (ImageView) findViewById(R.id.slowcar6);
        ImageView medcar1 = (ImageView) findViewById(R.id.medcar1);
        ImageView medcar2 = (ImageView) findViewById(R.id.medcar2);
        ImageView medcar3 = (ImageView) findViewById(R.id.medcar3);
        ImageView fastcar1 = (ImageView) findViewById(R.id.fastcar1);
        ImageView fastcar2 = (ImageView) findViewById(R.id.fastcar2);
        ImageView fastcar3 = (ImageView) findViewById(R.id.fastcar3);
        ImageView fastcar4 = (ImageView) findViewById(R.id.fastcar4);
        ImageView fastcar5 = (ImageView) findViewById(R.id.fastcar5);
        ImageView fastcar6 = (ImageView) findViewById(R.id.fastcar6);

        ImageView safe = (ImageView) findViewById(R.id.safe);
        ImageView bg1 = (ImageView) findViewById(R.id.bg1);
        Car car1 = new Car(slowcar1, 0,0);
        Car car2 = new Car(slowcar2, 0,0);
        Car car3 = new Car(slowcar3, 0,0);
        car1.move();
        car2.move();
        car3.move();
        ImageView bg2 = (ImageView) findViewById(R.id.bg2);
        Car car4 = new Car (medcar1, 1,0);
        Car car5 = new Car (medcar2,1,0);
        Car car6 = new Car (medcar3,1,0);
        car4.move();
        car5.move();
        car6.move();
        ImageView bg3 = (ImageView) findViewById(R.id.bg3);
        Car car7 = new Car(fastcar1, 2,1);
        Car car8 = new Car(fastcar2,2,1);
        Car car9 = new Car(fastcar3,2,1);
        car7.move();
        car8.move();
        car9.move();
        ImageView bg4 = (ImageView) findViewById(R.id.bg4);
        if (numRoads > 0) {
            bg4.setImageResource(getResources().getIdentifier("road_row", "drawable", getPackageName()));
            slowcar4.setVisibility(View.VISIBLE);
            slowcar5.setVisibility(View.VISIBLE);
            slowcar6.setVisibility(View.VISIBLE);
            Car car10 = new Car(slowcar4,0, 0);
            Car car11 = new Car(slowcar5,0, 0);
            Car car12 = new Car(slowcar6,0, 0);
            car10.move();
            car11.move();
            car12.move();
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
            fastcar4.setVisibility(View.VISIBLE);
            fastcar5.setVisibility(View.VISIBLE);
            fastcar6.setVisibility(View.VISIBLE);
            Car car13 = new Car(fastcar4, 2, 1);
            Car car14 = new Car(fastcar5, 2, 1);
            Car car15 = new Car(fastcar6, 2, 1);
            car13.move();
            car14.move();
            car15.move();
            row5car = true;
        }
        ImageView bg6 = (ImageView) findViewById(R.id.bg6);
        if (numRoads == 2) {
            bg6.setImageResource(getResources().getIdentifier("grass_row", "drawable", getPackageName()));
        } else {
            bg6.setImageResource(getResources().getIdentifier("river_row_new", "drawable", getPackageName()));
        }
        ImageView bg7 = (ImageView) findViewById(R.id.bg7);
        ImageView bg8 = (ImageView) findViewById(R.id.bg8);
        ImageView bg9 = (ImageView) findViewById(R.id.bg9);
        ImageView bg10 = (ImageView) findViewById(R.id.bg10);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: //when swipe started
                downx = event.getRawX(); //gets x of swipe start
                downy = event.getRawY(); //gets y of swipe start

                break;
            case MotionEvent.ACTION_UP: //when swipe ended

                upx = event.getRawX(); //gets x of swipe end
                upy = event.getRawY(); //gets y of swipe end
                position = player.move(upx, upy, downx, downy, sprite.sprite.getX(),sprite.sprite.getY());
                height = player.height;
                sprite.sprite.setX(position[0]);
                sprite.sprite.setY(position[1]);
//                playerSprite.setX(position[0]);
//                playerSprite.setY(position[0]);
                //swipeValue(downx,downy,upx,upy);
                setScore();
                break;
        }

        return super.onTouchEvent(event);
    }

    public void setScore() {
        TextView scoreText = (TextView) findViewById(R.id.score);
        score = player.scoreReturn(row5car);
        scoreText.setText("Score: " + player.score);
    }
    public void swipeValue(float downx, float downy, float upx, float upy) {
        TextView swipeNums = (TextView) findViewById(R.id.score);
        swipeNums.setText(downx +", "+downy +", "+upx +", "+upy);
    }
    public void carRun() {

    }
}