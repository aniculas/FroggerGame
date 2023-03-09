package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;

public class Player {
    ImageView sprite;
    int height;

    public Player (ImageView sprite) {
        this.sprite = sprite;
        sprite.setVisibility(View.VISIBLE);
        height = 0;
    }
    public int move(float upx, float upy, float downx, float downy) {
        final float outPX = 970;
        final float outNX = -50;
        final float outPY = 1900;
        final float outNY = 800;
        int yMovement = 120;
        int xMovement = 109;
        float countPX = sprite.getX() + xMovement;
        float countNX = sprite.getX() - xMovement;
        float countPY = sprite.getY() + yMovement;
        float countNY = sprite.getY() - yMovement;
        float deltax = downx - upx;
        float deltay = downy - upy;
        if (Math.abs(deltax) > Math.abs(deltay)) { //checks if swipe was vertical or horizontal
            if (downx > upx && countNX > outNX) { // checks if swipe was left to right
                sprite.setX(sprite.getX() - xMovement);
            }
            if (downx < upx && countPX < outPX){
                sprite.setX(sprite.getX() + xMovement);
            }
        } else {
            if (downy > upy && countNY > outNY) { //checks if swipe was top to bottom
                sprite.setY(sprite.getY() - yMovement);
                height++;
            } if (downy < upy && (countPY < outPY)) {
                sprite.setY(sprite.getY() + yMovement);
                height--;
            }
        }
        return height;
    }
}
