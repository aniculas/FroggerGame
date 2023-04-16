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
    }
    @Test
    public void startRight() {
        car = new Car(null, 0,0);
        //Assert.assertEquals(0, car.direction);
    }
    @Test
    public void startLeft() {
        car = new Car(null, 0,1);
        //Assert.assertEquals(1, car.direction);
    }
    @Test
    public void correctSpeed() {
        car = new Car(null, 6,0);
        Assert.assertEquals(6, car.speed);
    }

}