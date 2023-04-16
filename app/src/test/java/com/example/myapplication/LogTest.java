package com.example.myapplication;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogTest {

    Log fastLog;
    Log mediumLog;
    Log slowLog;
    @Before
    public void SetUp() {
       fastLog = new Log( 4, 4);
       mediumLog = new Log( 3, 3);
       slowLog = new Log(2, 2);
    }

    @Test
    public void correctSlowLogSpeed() {
        assertTrue(2 == slowLog.speedReturn);
    }
    @Test
    public void correctMediumLogSpeed() {
        assertTrue(3 == mediumLog.speedReturn);
    }
    @Test
    public void correctFastLogSpeed() {
        assertTrue(4 == fastLog.speedReturn);
    }
    @Test
    public void correctSlowLogRow() {
        assertTrue(2 == slowLog.rowReturn);
    }
    @Test
    public void correctMediumLogRow() {
        assertTrue(3 == mediumLog.rowReturn);
    }
    @Test
    public void correctFastLogRow() {
        assertTrue(4 == fastLog.rowReturn);
    }
}
