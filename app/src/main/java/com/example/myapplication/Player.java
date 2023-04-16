package com.example.myapplication;

public class Player {
    //ImageView sprite;
    int height;
    int maxHeight;
    int score;
    float xPos;
    float yPos;
    float[] position = new float[2];
    int lives;
    boolean logCollide;
    //lives
    //method to decrease life
    //decrease different amount per difficulty
    public Player(float xPos, float yPos, int lives) {
        this.xPos = xPos;
        this.yPos = yPos;
        height = 0;
        position[0] = 478f;
        position[1] = 1870f;
        this.lives = lives;
        logCollide = false;
    }


    public float[] resetPosition() {
        xPos = 478f;
        yPos = 1870f;
        position[0] = xPos;
        position[1] = yPos;
        height = 0;
        maxHeight = 0;
        return position;
    }
    public float[] move(float upx, float upy, float downx, float downy, float currX, float currY) {
        xPos = currX;
        yPos = currY;
        final float outPX = 970;
        final float outNX = -50;
        final float outPY = 1900;
        final float outNY = 650;
        int yMovement = 120;
        int xMovement = 109;
        float countPX = xPos + xMovement;
        float countNX = xPos - xMovement;
        float countPY = yPos + yMovement;
        float countNY = yPos - yMovement;
//        float countPX = sprite.getX() + xMovement;
//        float countNX = sprite.getX() - xMovement;
//        float countPY = sprite.getY() + yMovement;
//        float countNY = sprite.getY() - yMovement;
        float deltax = downx - upx;
        float deltay = downy - upy;
        if (Math.abs(deltax) > Math.abs(deltay)) { //checks if swipe was vertical or horizontal
            if (downx > upx && countNX > outNX) { // checks if swipe was left to right
                //sprite.setX(sprite.getX() - xMovement);
                xPos -= xMovement;
                position[0] = xPos;
            }
            if (downx < upx && countPX < outPX){
                //sprite.setX(sprite.getX() + xMovement);
                xPos += xMovement;
                position[0] = xPos;
            }
        } else {
            if (downy > upy && countNY > outNY) { //checks if swipe was top to bottom
                //sprite.setY(sprite.getY() - yMovement);
                yPos -= yMovement;
                position[1] = yPos;
                height++;
            } if (downy < upy && (countPY < outPY)) {
                //sprite.setY(sprite.getY() + yMovement);
                yPos += yMovement;
                position[1] = yPos;
                height--;
            }
        }
        return position;
        //return height;
    }
    public int scoreReturn(int numRoads) {
        int temp = 0;
        if (maxHeight < height) {
            maxHeight = height;
            if (height == 3) {
                score += 5;
                temp += 5;
            }
            if (height == 4 || (height == 6 && (numRoads == 5))) {
                score += 10;
                temp += 10;
            }
            score += 10;
            temp += 10;
        }
        return temp;
    }
    public void checkPlacement(float xPos) {
        if (xPos > 2000f) {
            lives--;
        }
    }
}
