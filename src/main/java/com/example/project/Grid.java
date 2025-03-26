package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid{
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size= size;
        grid = new Sprite[size][size];
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length;col++){
                grid[row][col] = new Dot(col, size-1-row) ;
            }
        }
    }

    public int getSize(){
        return size;
    }

    public Sprite[][] getGrid(){ return grid;}

    public void placeSprite(Sprite s){ //place sprite in new spot

        if (s.getX() >= 0 && s.getX() < size && s.getY() >= 0 && s.getY() < size){
            grid[size-1-s.getY()][s.getX()] = s;
        }
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction]
       for(int row = 0; row < grid.length; row++){
        for(int col = 0; col<grid[0].length; col++){
            if(grid[row][col] instanceof Player ){
                grid[row][col] = new Dot(col, size-1-row);
            }
        }
       }
        if (s.getX() >= 0 && s.getX() < size && s.getY() >= 0 && s.getY() < size){
            grid[size-1-s.getY()][s.getX()] = s;
        }
        int x = s.getX();
        int y = s.getY();
        
        if(direction.equals("w")){
            y--;
        }else if (direction.equals("s")){
            y++;
        }else if(direction.equals("a")){
            x++;
        }else if (direction.equals("d")){
            x--;
        }
        
            if(x>=0&& x < size && y>=0 &&y<size){
                grid[size-1-y][x] = new Dot(x,y);
            }
            
            
        
    }


    public void display() { //print out the current grid to the screen 
        for(Sprite[] row : grid){
            for(Sprite col : row){
                if(col instanceof Player)
                {
                    System.out.print("🦄");
                }
                else if(col instanceof Enemy)
                {
                    System.out.print("😠");
                }
                else if(col instanceof Trophy)
                {
                    System.out.print("🏆");
                }
                else if(col instanceof Treasure)
                {
                    
                        System.out.print("👾");
                }
                else if (col instanceof Dot)
                {
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