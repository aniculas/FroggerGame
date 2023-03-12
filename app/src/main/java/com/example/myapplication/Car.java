package com.example.myapplication;

import android.os.Handler;
import android.widget.ImageView;

public class Car {
    ImageView sprite;

    int xPos = 0;
    int yPos = 0;


    public Car(ImageView sprite) {
        this.sprite = sprite;
    }
    public void moveLeft(int speed) {
        System.out.println(sprite.getX());
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                float x = sprite.getX();

                if (x < -50)
                    x = 960;
                else
                    x -= speed;
                sprite.setX(x);

                handler.postDelayed(this,0);
            }
        };
        handler.post(runnable);
    }
    public int test() {
        return 5;
    }
    public void moveRight(int speed) {
        System.out.println(sprite.getX());
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                float x = sprite.getX();
                if(x > 960)
                    x = -85;
                else
                    x += speed;
                sprite.setX(x);

                handler.postDelayed(this,0);
            }
        };
        handler.post(runnable);
    }
}
