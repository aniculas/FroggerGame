package com.example.myapplication;

import static com.example.myapplication.Config.getDifficulty;
import static com.example.myapplication.Config.getName;
import static com.example.myapplication.Config.getSprite;

import android.widget.EditText;

import org.junit.Test;

public class ConfigTest {


    @Test
    public void checkSelected() {
        EditText name = getName();
        //Config.checkSelected(name, getDifficulty(), getSprite());
    }
}