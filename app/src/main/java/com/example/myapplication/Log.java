package com.example.myapplication;

import android.widget.ImageView;

public class Log extends Mover {


    public Log(ImageView sprite, int speed, int direction, int row) {
        super(sprite, speed + 1, direction, row);
    }

}