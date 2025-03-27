package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size=size;
        grid = new Sprite[size][size]; //set grid to a 2D array of size*size
        for(int row = 0; row < grid.length; row++){ 
            for(int col = 0; col < grid[0].length;col++){
                grid[row][col] = new Dot(col, size-1-row) ; //for each item in grid, assign it to a Dot object
            }
        }
    }

    public int getSize(){ //getter method for size
        return size;
    }

    public Sprite[][] getGrid(){ return grid;} //getter method for grid

    public void placeSprite(Sprite s){ //place sprite in new spot
        //if the x and y value of Sprite s is valid
        if (s.getX() >= 0 && s.getX() < size && s.getY() >= 0 && s.getY() < size){
            grid[size-1-s.getY()][s.getX()] = s; //then place sprite in the grid of sprite's x and y value by converting it from
                                                 //coordinate system to roCol system
        }
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction]
       for(int row = 0; row < grid.length; row++){
        for(int col = 0; col<grid[0].length; col++){
            if(grid[row][col] instanceof Player ){//clear out any existed player sprite(since we're placing it at a new position this time)
                grid[row][col] = new Dot(col, size-1-row); //replace it with a Dot object
            }
        }
       }
        if (s.getX() >= 0 && s.getX() < size && s.getY() >= 0 && s.getY() < size){
            grid[size-1-s.getY()][s.getX()] = s; //if the given position is valid, then place player at the new position
        }

        //we need the x and y value of sprite to fill sprite's previous position with a Dot
        int x = s.getX();
        int y = s.getY();
        if(direction.equals("w")){ //based on the direction/movement of player
            y--; //we can minus y by one to figure out its previous position
        }else if (direction.equals("s")){
            y++;//we can add y by one to figure out its previous position
        }else if(direction.equals("a")){
            x++;//we can add x by one to figure out its previous position
        }else if (direction.equals("d")){
            x--;//we can minus x by one to figure out its previous position
        }
        if(x>=0&& x < size && y>=0 &&y<size){
            grid[size-1-y][x] = new Dot(x,y); //replace sprite's previous pos with Dot
        }
    }

    public void display() { //print out the current grid to the screen 
        for(Sprite[] row : grid){
            for(Sprite col : row){ //for every sprite in grid
                if(col instanceof Player)
                { //if it's an instance of player, place "🦄"
                    System.out.print("🦄");
                }
                else if(col instanceof Enemy)
                {//if it's an instance of enemy, place "😠"
                    System.out.print("😠");
                }
                else if(col instanceof Trophy)
                {//if it's an instance of trophy, place "🏆"
                    System.out.print("🏆");
                }
                else if(col instanceof Treasure)
                {//if it's an instance of treasure, place "👾"
                    System.out.print("👾");
                }
                else if (col instanceof Dot)
                {//if it's an instance of Dot, place "⬜"
                    System.out.print("⬜");
                }
            }
            System.out.println();
        }
    }

    
    public void gameover(){ //use this method to display a loss
        System.out.println("You lose!");
    }

    public void win(){ //use this method to display a win 
        System.out.println("You win!");
    }


}