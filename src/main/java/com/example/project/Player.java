package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y); // call super to set up x and y values
        treasureCount = 0; 
        numLives = 2;
        win=false;
    }
    //getter method from treasureCount
    public int getTreasureCount(){return treasureCount;}
    //set method to set numLives(for extra credit)
    public void setLives(int num){
        numLives = num;
    }
    //getter method for numLives and win
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

    //method to move/ update the position of player
    public void move(String direction) { 
    
        if(direction.equals("w"))//if "w" is entered/ if direction is "w"
        { 
            this.setY(this.getY()+1); //then y-value increment by one
        }else if(direction.equals("s")){ //if "s" key is pressed, decrease the value of y by 1
            this.setY(this.getY()-1);//use set and get method to update y value
        }else if(direction.equals("a")){ //similar logics applies here
            this.setX(this.getX()-1); // if "a", x decrease by one; if "d", x increase by 1
        }else if(direction.equals("d")){
            this.setX(this.getX()+1);
        }
        
    }



    public void interact(int size, String direction, int numTreasures, Sprite sprite) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
            // if the sprite player interact with is Enemy
            if(sprite instanceof Enemy){
                numLives--; //numLive decrease by one
                if(numLives<=0){ //if no more livs, the player lose the game
                    win = false; //set win to false
                }
                
            }else if (sprite instanceof Treasure && !(sprite instanceof Trophy)){
                treasureCount++; //if the player ois interact with treasure, then treasure count is incremented
            }else if (sprite instanceof Trophy){
                if(treasureCount==numTreasures && sprite instanceof Trophy){
                    win = true; //if the player collect all the treasure and is interact with trophy, the player win the game
                }
            }
    }


    @Override
    public String getCoords(){ //returns "Enemy:"+coordinates
        return "Player:" + super.getCoords();
    }

    @Override
    public String getRowCol(int size){ //return "Enemy:"+row col
    return "Player:" + super.getRowCol(size);
    }

    public boolean isValid(int size, String direction) {
        if (direction.equals("w")) { //if y-coor is less then the upper-bound of y, return true, vise versa
            return (this.getY() < size - 1); 
        } else if (direction.equals("s")) {
            return (this.getY() -  1>= 0);   //if y-coor is greater then the lower-bound of y, return true, vise versa
        } else if (direction.equals("a")){
            return (this.getX()-1 >= 0); //if x-coor is greater then the lower-bound of x, return true, vise versa
        } else if (direction.equals("d")) {
            return (this.getX() < size - 1);  //if x-coor is less then the upper-bound of x, return true, vise versa
        }
        return false; //return false as default
    }
}



