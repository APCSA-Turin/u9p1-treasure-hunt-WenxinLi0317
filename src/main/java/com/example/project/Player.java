package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y) { //set treasureCount = 0 and numLives = 2 
        super(x, y);
        treasureCount = 0;
        numLives = 2;
        win=false;
    }


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}

    
    public void move(String direction) { 
    
        if(direction.equals("w"))
        {
            this.setY(this.getY()+1);
        }else if(direction.equals("s")){
            this.setY(this.getY()-1);
        }else if(direction.equals("a")){
            this.setX(this.getX()-1);
        }else if(direction.equals("d")){
            this.setX(this.getX()+1);
        }
        
    }



    public void interact(int size, String direction, int numTreasures, Sprite sprite) { // interact with an object in the position you are moving to 
    //numTreasures is the total treasures at the beginning of the game
    int x = getX();
    int y = getY();
        if(direction.equals("w")){
            y++;
        }else if(direction.equals("s")) {
            y--;
        }else if (direction.equals("a")){
            x--;
        }else if(direction.equals("d")){
            x++;
        }
        /////////////////
    
        //if(((sprite.getX()) == x) && ((sprite.getY())==y)){
            if(sprite instanceof Enemy){
                numLives--;
                if(numLives<=0){
                    win = false;
                }
                
            }else if (sprite instanceof Treasure && !(sprite instanceof Trophy)){
                treasureCount++;
                //grid[size-1-y][x] = new Dot(x, y);
                //sprite = new Dot(x,y);
            }else if (sprite instanceof Trophy){
                if(treasureCount==numTreasures){
                    win = true;
                    //sprite = new Dot(x,y);
                }
            }
            //move(direction);
           
        //}
        //move(direction);

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
        if (direction.equals("w")) 
        {
            return (this.getY() < size - 1); 
        } else if (direction.equals("s")) {
            return (this.getY() -  1>= 0);  
        } else if (direction.equals("a"))
         {
            return (this.getX()-1 >= 0); 
        } else if (direction.equals("d")) {
            return (this.getX() < size - 1);  
        }
        return false;
    }
}



