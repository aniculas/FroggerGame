package com.example.myapplication;

import android.os.Handler;
import android.widget.ImageView;

public class Car {
    ImageView sprite;

    int xPos = 0;
    int yPos = 0;
    int slow = 6;
    int medium = 8;
    int fast = 10;
    int speed;
    int direction;


    public Car(ImageView sprite, int speedChoice, int direction) {
        this.sprite = sprite;
        if (speedChoice == 0) {
            speed = slow;
        } else if (speedChoice == 1) {
            speed = medium;
        } else if (speedChoice == 2) {
            speed = fast;
        }
        this.direction = direction;
    }
    public void move() {
        if (direction == 0) {
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
        } else if (direction == 1) {
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
//    public void moveLeft(int speed) {
//        System.out.println(sprite.getX());
//        final Handler handler = new Handler();
//        final Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                float x = sprite.getX();
//
//                if (x < -50)
//                    x = 960;
//                else
//                    x -= speed;
//                sprite.setX(x);
//
//                handler.postDelayed(this,0);
//            }
//        };
//        handler.post(runnable);
//    }
//    public int test() {
//        return 5;
//    }
//    public void moveRight(int speed) {
//        System.out.println(sprite.getX());
//        final Handler handler = new Handler();
//        final Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                float x = sprite.getX();
//                if(x > 960)
//                    x = -85;
//                else
//                    x += speed;
//                sprite.setX(x);
//
//                handler.postDelayed(this,0);
//            }
//        };
//        handler.post(runnable);
//    }
}
