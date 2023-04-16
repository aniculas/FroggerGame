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
    @Before
    public void SetUp() {
        easyPlayer = new Player(478f,1870f, 3);
        mediumPlayer = new Player(478f,1870f, 2);
        hardPlayer = new Player(478f,1870f, 1);
        fastLog = new Log( 4, 3);
    }
//    @Test
//    public void downScore() {
//        int iScore = player.score;
//        player.move(0,100f,0,0,478f, 1870f);
//        player.scoreReturn(false);
//        int fScore = player.score;
//        Assert.assertTrue(iScore == fScore);
//    }
//    @Test
//    public void upScore() {
//        int iScore = player.score;
//        player.move(0f,0f,0f,100f,478f,1870f);
//        player.scoreReturn(false);
//        int fScore = player.score;
//        Assert.assertTrue( iScore < fScore);
//    }
//    @Test
//    public void leftScore() {
//        int iScore = player.score;
//        player.move(100,0,0,0,478f, 1870f);
//        player.scoreReturn(false);
//        int fScore = player.score;
//        Assert.assertTrue(iScore == fScore);
//    }
//    @Test
//    public void rightScore() {
//        int iScore = player.score;
//        player.move(0,0,100f,0,478f, 1870f);
//        player.scoreReturn(false);
//        int fScore = player.score;
//        assertEquals(iScore, fScore);
//    }
//    @Test
//    public void fastlanePoints(){
//        int eScore = 35;
//        player.move(0,0,0,100f,478f, 1870f);
//        player.scoreReturn(false);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(false);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(false);
//        int fScore = player.score;
//        Assert.assertTrue(eScore == fScore);
//    }
//    @Test
//    public void returnToPreviousRowNoPoints() {
//        player.move(0,0,0,100f,478f,1870f);
//        int iScore = player.scoreReturn(false);
//        player.move(0,100f,0,0,player.xPos,player.yPos);
//        player.scoreReturn(false);
//        player.move(0, 0, 0, 100f, player.xPos, player.yPos);
//        int fScore = player.scoreReturn(false);
//        Assert.assertTrue(iScore == fScore);
//    }
//    @Test
//    public void multFastLanePoints() {
//        int eScore = 125;
//        player.move(0,0,0,100f,478f, 1870f);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        player.move(0,0,0,100f,player.xPos, player.yPos);
//        player.scoreReturn(true);
//        int fScore = player.score;
//        assertEquals(eScore, fScore);
//    }
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

}