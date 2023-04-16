package com.example.myapplication;

import android.widget.ImageView;

public class Log extends Mover {

    int speedReturn;
    int rowReturn;
    public Log(ImageView sprite, int speed, int row) {
        super(sprite, speed, row);
    }
    public Log(int speed, int row) {
        super();
        speedReturn = speed;
        rowReturn = row;
    }

}
