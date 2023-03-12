package com.example.myapplication;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    Player player;
    @Before
    public void SetUp() {
        player = new Player(500f,500f);
    }
//    @Test
//    public void downScore() {
//        int iScore = player.score;
//        player.move(0,0,0,0);
//        int fScore = player.score;
//        Assert.assertTrue(iScore == fScore);
//    }
//    @Test
//    public void upScore() {
//        int iScore = player.score;
//        player.move(0,0,0,0);
//        int fScore = player.score;
//        Assert.assertTrue(iScore > fScore);
//    }
//    @Test
//    public void leftScore() {
//        int iScore = player.score;
//        player.move(0,0,0,0);
//        int fScore = player.score;
//        Assert.assertTrue(iScore == fScore);
//    }
//    @Test
//    public void rightScore() {
//        int iScore = player.score;
//        player.move(0,0,0,0);
//        int fScore = player.score;
//        Assert.assertTrue(iScore == fScore);
//    }
//    @Test
//    public void safeSpace(){
//        int iScore = player.score;
//        player.move(0,0,0,0);
//        player.move(0,0,0,0);
//        player.move(0,0,0,0);
//        int fScore = player.score;
//        Assert.assertTrue(iScore == fScore);
//    }
}