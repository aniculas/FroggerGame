package com.example.myapplication;

import android.os.Handler;
import android.widget.ImageView;

public class Car extends Mover {

    public Car(ImageView sprite, int speedChoice, int direction) {
        super(sprite, 2 * (speedChoice + 1), direction);
    }

    @Override
    public void checkForPlayer() {

    }

    @Override
    public void handlePlayer() {

    }
}
