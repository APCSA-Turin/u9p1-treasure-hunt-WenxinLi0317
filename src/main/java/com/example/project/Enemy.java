package com.example.project;

//Enemy only need constructor and getCoords() getRowCol()
public class Enemy extends Sprite { //child  of Sprite
    //constructor for Enemy
    public Enemy(int x, int y) { //call super to set x and y value
        super(x, y);
    }


    //the methods below should override the super class 
    @Override
    public String getCoords(){ //returns "Enemy:"+ coordinates
        return "Enemy:" + super.getCoords();
    }


    /* */
    @Override
    public String getRowCol(int size){ //return "Enemy:" +row col
    return "Enemy:" + super.getRowCol(size);
    }
}