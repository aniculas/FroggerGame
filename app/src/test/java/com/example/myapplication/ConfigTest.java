package com.example.myapplication;

import static com.example.myapplication.Config.*;
import static org.junit.Assert.*;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Test;

public class ConfigTest {

    @Test
    public void onCreate() {
        EditText name = getName();
        TextView warning = getWarning();
        name.setText(" ");
        assertEquals(warning.getVisibility(), View.VISIBLE);
    }
}