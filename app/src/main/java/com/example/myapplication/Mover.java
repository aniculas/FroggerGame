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

    public abstract boolean checkCollision(float xPos, int height);

/* Old Move Methods
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
*/
}
