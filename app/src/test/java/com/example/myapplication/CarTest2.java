package com.example.myapplication;

import static org.junit.Assert.*;

import android.widget.ImageView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest2 {
    private ImageView sprite;


    private Car car;
    @Before
    public void setUp() {

//        sprite.setImageResource(R.drawable.frogb); // still running into the issue that sprite is initially null
        car = new Car(sprite);
    }
    @Test
    public void moveRight() {
        //car.moveRight(10);
        Assert.assertTrue(car.xPos == 0);
    }

}