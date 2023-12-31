package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class Gameplay extends AppCompatActivity {

    float upx;
    float downx;
    float upy;
    float downy;
    Player player;
    Sprite sprite;
    int height = 0;
    int score = 0;
    static int maxScore = 0;
    int numRoads;
    int playerID;
    float[] position;
    ImageView heart2;
    ImageView heart3;
    Log log0, log1,log2,log3,log4,log5,log6,log7,log8,log9,log10,log11,log12;
    static int retLives;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String data = getIntent().getStringExtra("data");
        height = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        heart2 = (ImageView) findViewById(R.id.heart2);
        heart3 = (ImageView) findViewById(R.id.heart3);
        ImageView playerspriteg = (ImageView) findViewById(R.id.playerspriteg);
        ImageView playerspriter = (ImageView) findViewById(R.id.playerspriter);
        ImageView playerspriteb = (ImageView) findViewById(R.id.playerspriteb);
        TextView diff = (TextView) findViewById(R.id.diff);
        //SET HEARTS---------------------------------------------------------------------------
        int numLives;
        if (data.charAt(0) == '3') {
            heart2.setVisibility(View.VISIBLE);
            heart3.setVisibility(View.VISIBLE);
            diff.setText("Easy");
            numLives = 3;
        } else if (data.charAt(0) == '2') {
            heart2.setVisibility(View.VISIBLE);
            diff.setText("Medium");
            numLives = 2;
        } else {
            diff.setText("Hard");
            numLives = 1;
        }
        //SET SPRITE---------------------------------------------------------------------------
        if (data.charAt(1) == 'g') {
            //player = new Player(playerspriteg);
            sprite = new Sprite(playerspriteg);
            player = new Player(sprite.sprite.getX(), sprite.sprite.getY(), numLives);
            playerspriteg.setVisibility(View.VISIBLE);
        } else if (data.charAt(1) == 'r') {
            //player = new Player(playerspriter);
            sprite = new Sprite(playerspriter);
            player = new Player(sprite.sprite.getX(), sprite.sprite.getY(), numLives);
            playerspriter.setVisibility(View.VISIBLE);
        } else {
            //player = new Player(playerspriteb);
            sprite = new Sprite(playerspriteb);
            player = new Player(sprite.sprite.getX(), sprite.sprite.getY(), numLives);
            playerspriteb.setVisibility(View.VISIBLE);
        }
        player.height = 0;
        TextView playerName = (TextView) findViewById(R.id.playername);
        playerName.setText(data.substring(2));
        // Background
        numRoads = (int) (Math.random() * 3) + 3;
        backgroundCreate(numRoads);
        checkLogCollision();
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
        ImageView logView = (ImageView) findViewById(R.id.log);
        ImageView logView1 = (ImageView) findViewById(R.id.log1);
        ImageView logView2 = (ImageView) findViewById(R.id.log2);
        ImageView logView3 = (ImageView) findViewById(R.id.log3);
        ImageView logView4 = (ImageView) findViewById(R.id.log4);
        ImageView logView5 = (ImageView) findViewById(R.id.log5);
        ImageView logView6 = (ImageView) findViewById(R.id.log6);
        ImageView logView7 = (ImageView) findViewById(R.id.log7);
        ImageView logView8 = (ImageView) findViewById(R.id.log8);
        ImageView logView9 = (ImageView) findViewById(R.id.log9);
        ImageView logView10 = (ImageView) findViewById(R.id.log10);
        ImageView logView11 = (ImageView) findViewById(R.id.log11);
        ImageView logView12 = (ImageView) findViewById(R.id.log12);
        log0 = new Log(logView, -1,9);
        log1 = new Log(logView1, -1,9);
        log2 = new Log(logView2, -1,9);
        log3 = new Log(logView3, 2,8);
        log4 = new Log(logView4, 2,8);
        log5 = new Log(logView5, -3,7);
        log6 = new Log(logView6, -3,7);
        log7 = new Log(logView7, -3,7);
        ImageView bg1 = (ImageView) findViewById(R.id.bg1);
        Car car1 = new Car(slowcar1, -1,1);
        Car car2 = new Car(slowcar2, -1,1);
        Car car3 = new Car(slowcar3, -1,1);
        checkCollision(car1);
        checkCollision(car2);
        checkCollision(car3);
        ImageView bg2 = (ImageView) findViewById(R.id.bg2);
        Car car4 = new Car (medcar1,-2, 2);
        Car car5 = new Car (medcar2,-2, 2);
        Car car6 = new Car (medcar3,-2, 2);
        checkCollision(car4);
        checkCollision(car5);
        checkCollision(car6);
        ImageView bg3 = (ImageView) findViewById(R.id.bg3);
        Car car7 = new Car(fastcar1,3, 3);
        Car car8 = new Car(fastcar2,3, 3);
        Car car9 = new Car(fastcar3,3, 3);
        checkCollision(car7);
        checkCollision(car8);
        checkCollision(car9);
        ImageView bg4 = (ImageView) findViewById(R.id.bg4);
        if (numRoads > 3) {
            bg4.setImageResource(getResources().getIdentifier("road_row", "drawable", getPackageName()));
            slowcar4.setVisibility(View.VISIBLE);
            slowcar5.setVisibility(View.VISIBLE);
            slowcar6.setVisibility(View.VISIBLE);
            Car car10 = new Car(slowcar4,-1, 4);
            Car car11 = new Car(slowcar5,-1, 4);
            Car car12 = new Car(slowcar6,-1, 4);
            checkCollision(car10);
            checkCollision(car11);
            checkCollision(car12);
        } else {
            bg4.setImageResource(getResources().getIdentifier("grass_row", "drawable", getPackageName()));
        }
        ImageView bg5 = (ImageView) findViewById(R.id.bg5);
        if (numRoads == 3) {
            bg5.setImageResource(getResources().getIdentifier("river_row_new", "drawable", getPackageName()));
            log10 = new Log(logView10, -2,5);
            log11 = new Log(logView11, -2,5);
            log12 = new Log(logView12, -2,5);
            log10.sprite.setVisibility(View.VISIBLE);
            log11.sprite.setVisibility(View.VISIBLE);
            log12.sprite.setVisibility(View.VISIBLE);
        } else if (numRoads == 4) {
            bg5.setImageResource(getResources().getIdentifier("grass_row", "drawable", getPackageName()));
        } else {
            bg5.setImageResource(getResources().getIdentifier("road_row", "drawable", getPackageName()));
            fastcar4.setVisibility(View.VISIBLE);
            fastcar5.setVisibility(View.VISIBLE);
            fastcar6.setVisibility(View.VISIBLE);
            Car car13 = new Car(fastcar4, 3, 5);
            Car car14 = new Car(fastcar5, 3, 5);
            Car car15 = new Car(fastcar6, 3, 5);
            checkCollision(car13);
            checkCollision(car14);
            checkCollision(car15);
        }
        ImageView bg6 = (ImageView) findViewById(R.id.bg6);
        if (numRoads == 5) {
            bg6.setImageResource(getResources().getIdentifier("grass_row", "drawable", getPackageName()));
        } else {
            bg6.setImageResource(getResources().getIdentifier("river_row_new", "drawable", getPackageName()));
            log8 = new Log(logView8, 1, 6);
            log9 = new Log(logView9, 1, 6);
            log8.sprite.setVisibility(View.VISIBLE);
            log9.sprite.setVisibility(View.VISIBLE);
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
                if (height == 10) {
                    setScore(true);
                    retLives = player.lives;
                    Intent nextScreen = new Intent(Gameplay.this, End.class);
                    finish();
                    startActivity(nextScreen);
                } else {
                    setScore(false);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setScore(boolean win) {
        TextView scoreText = (TextView) findViewById(R.id.score);
        int temp = player.scoreReturn(numRoads);
        score += temp;
        if (win) {
            score = score + 150;
        }
        if (score > maxScore)
            maxScore = score;
        if (temp < 0) {
            reduceLife();
        }
        scoreText.setText("Score: " + player.score);
    }
    public void reduceLife() {
        TextView scoreText = (TextView) findViewById(R.id.score);
        player.lives = player.lives - 1;
        if (heart3.getVisibility() == View.VISIBLE) {
            heart3.setVisibility(View.INVISIBLE);
            player.score = 0;
            score = 0;
            scoreText.setText("Score: " + player.score);
            position = player.resetPosition();
            height = player.height;
            sprite.sprite.setX(position[0]);
            sprite.sprite.setY(position[1]);
        } else if (heart2.getVisibility() == View.VISIBLE) {
            heart2.setVisibility(View.INVISIBLE);
            player.score = 0;
            score = 0;
            scoreText.setText("Score: " + player.score);
            position = player.resetPosition();
            height = player.height;
            sprite.sprite.setX(position[0]);
            sprite.sprite.setY(position[1]);
        } else {
            score = player.score;
            retLives = player.lives;
            Intent nextScreen = new Intent(Gameplay.this, End.class);
            finish();
            startActivity(nextScreen);
        }
    }
    public void swipeValue(float downx, float downy, float upx, float upy) {
        TextView swipeNums = (TextView) findViewById(R.id.score);
        swipeNums.setText(downx +", "+downy +", "+upx +", "+upy);
    }
    public void checkCollision(Mover mover) {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (player.lives != 0 && mover.checkCollision(player.xPos, player.height)) {
                    if (mover instanceof Car) {
                        reduceLife();
                        handler.postDelayed(this, 500);
                    }
                } else {
                    handler.postDelayed(this, 0);
                }

            }
        };
        handler.post(runnable);
    }
    public void checkLogCollision() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (height > numRoads + 1 && player.lives != 0) {
                    ArrayList<Log> logs = new ArrayList<>();
                    switch (height) {
                        case 5:
                            logs = new ArrayList<>(Arrays.asList(log10, log11, log12));
                            break;
                        case 6:
                            logs = new ArrayList<>(Arrays.asList(log8, log9));
                            break;
                        case 7:
                            logs = new ArrayList<>(Arrays.asList(log5, log6, log7));
                            break;
                        case 8:
                            logs = new ArrayList<>(Arrays.asList(log3, log4));
                            break;
                        case 9:
                            logs = new ArrayList<>(Arrays.asList(log0, log1, log2));
                            break;
                    }
                    boolean onLog = false;
                    for (Log log : logs)
                        onLog = onLog || checkOnLog(log);
                    if (!onLog) {
                        reduceLife();
                    } else {
                        sprite.sprite.setX(sprite.sprite.getX() + logs.get(0).speed);
                        player.xPos = sprite.sprite.getX();
                        position[0] = sprite.sprite.getX();
                    }
                }
                handler.postDelayed(this, 0);
            }
        };
        handler.post(runnable);
    }

    public static int getMaxScore() {
        int temp = maxScore;
        maxScore = 0;
        return temp;
    }
    public static int getPlayerLives() {
        return retLives;
    }
    public boolean checkOnLog(Log log) {
        if (((log.sprite.getX() - 90 <= sprite.sprite.getX() && log.sprite.getX() + 90 >= sprite.sprite.getX()))) {
            return true;
        }
        return false;
    }
}