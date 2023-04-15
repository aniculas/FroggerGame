package com.example.myapplication;

import android.widget.ImageView;

public class Car extends Mover {

    public Car(ImageView sprite, int speed, int row) {
        super(sprite, 2 * speed, row);
    }

}
