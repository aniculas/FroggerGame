package com.example.myapplication;

import android.os.Handler;
import android.widget.ImageView;

public abstract class Mover {
    ImageView sprite;
    int speed;
    int direction;
    int row;

    public Mover(ImageView sprite, int speed, int direction, int row) {
        this.sprite = sprite;
        this.speed = speed;
        this.direction = direction;
        this.row = row;
        move();
    }

    public void move() {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                float x = sprite.getX();

                if ((direction == 0) && (x < -100))
                    x = 1000;
                else if (direction == 0)
                    x -= speed;
                else if (x > 1000)
                    x = -100;
                else
                    x += speed;

                sprite.setX(x);

                handler.postDelayed(this,0);
            }
        };
        handler.post(runnable);
    }

    public boolean checkCollision(float xPos, int height) {
        return xPos >= sprite.getX() - 55 && xPos <= sprite.getX() + 55 && height == row;
    }

}
