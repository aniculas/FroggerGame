package com.example.myapplication;

import android.widget.ImageView;

public class Car extends Mover {

    public Car(ImageView sprite, int speedChoice, int direction, int row) {
        super(sprite, 2 * (speedChoice + 1), direction, row);
    }

    @Override
    public boolean checkCollision(float xPos, int height) {
        return xPos >= sprite.getX() - 55 && xPos <= sprite.getX() + 55 && height == row;
    }
}
