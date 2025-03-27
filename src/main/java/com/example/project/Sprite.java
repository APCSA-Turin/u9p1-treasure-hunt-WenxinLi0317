package com.example.project;

public class Sprite {
    private int x, y;

    //set the x and y coordinate of the Sprite constructor
    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //getter method of sprite's x and y coordinate
    public int getX(){return x;} 
    public int getY(){return y;}
    //setter method of sprite's x and y coordinate
    public void setX(int newX){x = newX;}
    public void setY(int newY){y = newY;}

    public String getCoords(){ //returns the coordinates of the sprite ->"(x,y)"
        return "" + "(" + x + "," + y +")";
    }


    public String getRowCol(int size){ //returns the row and column of the sprite -> "[row][col]"
        return "" + "[" +  (size-1-y)  +"]" + "[" +  x +"]";
    }
    

    public void move(String direction) { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }

    public void interact() { //you can leave this empty
        // Default behavior (can be overridden by subclasses)
    }



}
