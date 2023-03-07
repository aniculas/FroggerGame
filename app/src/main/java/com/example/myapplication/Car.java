package com.example.myapplication;

import android.os.Handler;
import android.widget.ImageView;

public class Car {
    ImageView sprite;
    public Car(ImageView sprite) {
        this.sprite = sprite;
    }
    public void move() {
        System.out.println(sprite.getX());
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                float x = sprite.getX();
                if(x < -50)
                    x = 960;
                else
                    x -= 6;
                sprite.setX(x);

                handler.postDelayed(this,0);
            }
        };
        handler.post(runnable);
    }
}
