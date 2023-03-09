package com.example.myapplication;

import android.widget.ImageView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest extends Car{

    private ImageView sprite;

    public CarTest(ImageView sprite) {
        super(sprite);
    }

    @Before
    public void Car(ImageView sprite) {
        this.sprite = sprite;
    }

    @Test
    public void moveLeftTest() {
        sprite.setX(10);
        sprite.setY(10);
        Assert.assertEquals(10, sprite.getX());
    }

}