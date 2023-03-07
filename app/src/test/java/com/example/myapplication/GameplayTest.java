package com.example.myapplication;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameplayTest {

    private int xPos = 0;
    Gameplay test;
    @Before
    public void setUp() {
        test.onCreate(null);
    }

    @Test
    public void scoreTest() {
        test.height = 10;
        test.maxHeight = 0;
        assertTrue(test.score == 10);
    }
}