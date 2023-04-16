package com.example.myapplication;

import static org.junit.Assert.*;

import android.provider.Settings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    Player easyPlayer;
    Player mediumPlayer;
    Player hardPlayer;
    Log fastLog;
    float startX = 478f;
    float startY = 1870f;
    @Before
    public void SetUp() {
        easyPlayer = new Player(478f,1870f, 3);
        mediumPlayer = new Player(478f,1870f, 2);
        hardPlayer = new Player(478f,1870f, 1);
        fastLog = new Log( 4, 3);
    }
    @Test
    public void finishScore() {
        easyPlayer.move(0,0,0,100f,478,1870f);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);

        assertEquals(115,easyPlayer.score);
    }
    @Test
    public void playerOnLogNoDeath() {
        Log log = new Log(2,10);
        boolean logTrue = true;
        easyPlayer.move(0,0,0,100f,478,1870f);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,easyPlayer.xPos, easyPlayer.yPos);
        easyPlayer.scoreReturn(3);
        assertTrue(log.checkCollision(easyPlayer.xPos));
    }
    @Test
    public void playerReachesEndResetPosition() {
        easyPlayer.move(0,0,0,100f,478,1870f);
        easyPlayer.scoreReturn(3);
        easyPlayer.move(0,0,0,100f,478,1870f);
        easyPlayer.scoreReturn(3);
        easyPlayer.resetPosition();
        assertTrue(startX == easyPlayer.xPos);
    }
    @Test
    public void playerPassesEdgeOfScreen() {
        easyPlayer.xPos = 100000000f;
        easyPlayer.checkPlacement(easyPlayer.xPos);
        assertEquals(easyPlayer.lives, 2);
    }
}