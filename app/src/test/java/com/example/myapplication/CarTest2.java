package com.example.myapplication;

import static org.junit.Assert.*;

import android.widget.ImageView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class CarTest2 {
    private ImageView sprite;
    private Gameplay gameplay;


    private Car car;



    @Before
    public void setUp() {
        //sprite = (ImageView) gameplay.findViewById(R.id.frogb);
//        sprite.setImageResource(R.drawable.frogb); // still running into the issue that sprite is initially null

//        sprite = (ImageView) main.findViewById(R.id.frogb);
        //car = new Car();
    }
    @Test
    public void moveRight() {

        int test = car.test();
        //car.moveLeft(10);
        Assert.assertEquals(test, 5);
    }

}