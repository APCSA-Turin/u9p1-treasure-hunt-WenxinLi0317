package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        initialize();
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        while(true){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop
        }
    }

    public void initialize(){
        int sizeEasy = 5; //depend on the level player choose to player, there is different value for size, grid, enemy and numLives correspond with level of diffficulties
        int sizeMedium = 7;
        int sizeHard = 10;
        Grid gridEasy = new Grid(sizeEasy);
        Grid gridMedium = new Grid(sizeMedium);
        Grid gridHard = new Grid (sizeHard);
        Player player = new Player(0, 0);
        Enemy enemyEasy = new Enemy(4,4);
        Enemy enemyMedium = new Enemy(4,5);
        Enemy enemyHard = new Enemy(9,8);
        Treasure treasure = new Treasure(6, 6);
        Treasure treasure2 = new Treasure(1,2);
        Trophy trophy = new Trophy(3, 4);
        //Sprite list that conatins different level's of sprite
        Sprite [] easy = {player,enemyEasy, treasure, treasure2, trophy};
        Sprite [] medium = {player,enemyEasy, enemyMedium, treasure, treasure2, trophy};
        Sprite [] hard = {player,enemyEasy, enemyMedium,enemyHard, treasure, treasure2, trophy};
        Scanner scan = new Scanner(System.in);
        String level ="";

        System.out.println("Welcome to Treasure Founder! Press w/a/s/d to move; enter 'quit' to quit the game!");
        System.out.println("First choose the level of the game: easy/medium/hard");
        level = scan.nextLine(); 
        String movement = "";
        if(level.equals("easy")){ //if player choose easy
            player.setLives(1); //set numLives to 1 (there is only one enemy)
            for(Sprite sprite : easy){ //place sprite on grid
                gridEasy.placeSprite(sprite);
            }
            while(!movement.equals("quit")){ //if player didn't choose to quit
                    gridEasy.display(); //game will display grid
                    System.out.println("Enter w/a/s/d to move");
                    movement = scan.nextLine();

                    //set x and y value to the position player intend to move to
                    int x = player.getX();
                    int y = player.getY();
                    if(movement.equals("w")){
                        y++;
                    }else if(movement.equals("s")) {
                        y--;
                    }else if (movement.equals("a")){
                        x--;
                    }else if(movement.equals("d")){
                        x++;
                    }
                    //if not valid(out of bound), then display warning message
                    if(x < 0 || x >= sizeEasy || y < 0 || y >= sizeEasy) {
                        System.out.println("Can't move there! Try another direction.");
                        continue;
                    }
                    
                    // Get object at new position (using sizeEasy)
                    Sprite object = gridEasy.getGrid()[sizeEasy-1-y][x];
                    
                    // if the object interact with is not dot, then interact
                    if(!(object instanceof Dot)) {
                        player.interact(sizeEasy, movement, 1, object);
                    }
                    //if valid, then player's mosition is updated
                    player.move(movement);
                    //and place player sprite on grid
                    gridEasy.placeSprite(player, movement); 
                    System.out.println(player.getRowCol(sizeEasy)); //print out info about postion, lives, and current treasure count
                    System.out.println("Lives: "+ player.getLives());
                    System.out.println("Treasure Count:" + player.getTreasureCount());
                    
                    //if win is true(collect all treasure and trophy)
                    if(player.getWin() == true){
                        gridEasy.win(); //the player win the game
                        System.out.println("Do you want to play again?");
                        System.out.println("Enter quit to end!");
                        movement = scan.nextLine();
                        if(movement.equals("yes")){ //if player want to play again, call intialize one more time
                            initialize();
                            break;
                        }else if (movement.equals("quit")){
                            level = "quit"; //else, end the game
                            scan.close();
                            break;
                        }
                        
                    }
                    if(player.getLives() <= 0) { //if the player lose the game
                        gridEasy.gameover();
                        System.out.println("Do you want to play again?");
                        System.out.println("Enter quit to end!");
                        movement = scan.nextLine(); //ask if they want to play again
                        if(movement.equals("yes")){
                            initialize(); //if player want to play again, call intialize one more time
                            break;
                        }else if (movement.equals("quit")){
                            level = "quit";
                            scan.close();//else, end the game
                            break;
                        }
                    }
            }
                
        } else if (level.equals("medium")){ //if player choose medium
            for(Sprite sprite : medium){//place sprite on grid
                gridMedium.placeSprite(sprite);
            }
            while(!movement.equals("quit")){//if player didn't choose to quit
                gridMedium.display(); //game will display grid
                System.out.println("Enter w/a/s/d to move");
                movement = scan.nextLine();
                //set x and y value to the position player intend to move to
                int x = player.getX();
                int y = player.getY();
                if(movement.equals("w")){
                    y++;
                }else if(movement.equals("s")) {
                    y--;
                }else if (movement.equals("a")){
                    x--;
                }else if(movement.equals("d")){
                    x++;
                }
                //if not valid(out of bound), then display warning message
                if(x < 0 || x >= sizeMedium || y < 0 || y >= sizeMedium) {
                    System.out.println("Can't move there! Try another direction.");
                    continue;
                }
                // Get object at new position (using sizeMedium)
                Sprite object = gridMedium.getGrid()[sizeMedium-1-y][x];
                 // if the object interact with is not dot, then interact
                if(!(object instanceof Dot)) {
                    player.interact(sizeMedium, movement, 2, object);
                }
                //if valid, then player's mosition is updated
                player.move(movement);
                //and place player sprite on grid
                gridMedium.placeSprite(player, movement);  //print out info about postion, lives, and current treasure count
                System.out.println(player.getRowCol(sizeMedium));
                System.out.println("Lives: "+ player.getLives());
                System.out.println("Treasure Count:" + player.getTreasureCount());

                //if win is true(collect all treasure and trophy)
                if(player.getWin() == true){
                    gridMedium.win();
                    System.out.println("Do you want to play again?");//the player win the game
                    System.out.println("Enter quit to end!");
                    movement = scan.nextLine();
                    if(movement.equals("yes")){//if player want to play again, call intialize one more time
                        initialize();
                        break;
                    }else if (movement.equals("quit")){
                        level = "quit";//else, end the game
                        scan.close();
                        break;
                    }
                    
                }
                if(player.getLives() <= 0) { //if the player lose the game
                    gridMedium.gameover();
                    System.out.println("Do you want to play again?");
                    System.out.println("Enter quit to end!");
                    movement = scan.nextLine();
                    if(movement.equals("yes")){
                        initialize();//if player want to play again, call intialize one more time
                        break;
                    }else if (movement.equals("quit")){
                        level = "quit";
                        scan.close();
                        break;//else, end the game
                    }
                }
                
                
                
            }
            
        } else if (level.equals("hard")){//if player choose hard
            for(Sprite sprite : hard){//place sprite on grid
                gridHard.placeSprite(sprite);
            }
            while(!movement.equals("quit")){
                //if player didn't choose to quit
                gridHard.display();//game will display grid
                System.out.println("Enter w/a/s/d to move");
                    movement = scan.nextLine();
                //set x and y value to the position player intend to move to
                    int x = player.getX();
                    int y = player.getY();
                    if(movement.equals("w")){
                        y++;
                    }else if(movement.equals("s")) {
                        y--;
                    }else if (movement.equals("a")){
                        x--;
                    }else if(movement.equals("d")){
                        x++;
                    }
                       //if not valid(out of bound), then display warning message
                    if(x < 0 || x >= sizeHard || y < 0 || y >= sizeHard) {
                        System.out.println("Can't move there! Try another direction.");
                        continue;
                    }
                    // Get object at new position (using sizeMedium)
                    Sprite object = gridHard.getGrid()[sizeHard-1-y][x];
                    
                     // if the object interact with is not dot, then interact
                    if(!(object instanceof Dot)) {
                        player.interact(sizeHard, movement, 2, object);
                    }
                    //if valid, then player's mosition is updated
                    player.move(movement); //and place player sprite on grid
                    gridHard.placeSprite(player, movement); 
                    System.out.println(player.getRowCol(sizeHard));//print out info about postion, lives, and current treasure count
                    System.out.println("Lives: "+ player.getLives());
                    System.out.println("Treasure Count:" + player.getTreasureCount());
                         //if win is true(collect all treasure and trophy)
                    if(player.getWin() == true){
                        gridHard.win();
                        System.out.println("Do you want to play again?"); //the player win the game
                        System.out.println("Enter quit to end!");
                        movement = scan.nextLine();
                        if(movement.equals("yes")){
                            initialize();//if player want to play again, call intialize one more time
                            break;
                        }else if (movement.equals("quit")){
                            level = "quit";
                            scan.close();//else, end the game
                            break;
                        }
                        
                    }
                    if(player.getLives() <= 0) {//if the player lose the game
                        gridHard.gameover();
                        System.out.println("Do you want to play again?");
                        System.out.println("Enter quit to end!");
                        movement = scan.nextLine();
                        if(movement.equals("yes")){//if player want to play again, call intialize one more time
                            initialize();
                            break;
                        }else if (movement.equals("quit")){
                            level = "quit";//else, end the game
                            scan.close();
                            break;
                        }
                    }
                    
            
            } 
        }
        scan.close();

        
        }
        //scan.close();
      
    

    public static void main(String[] args) {
        
        Game game = new Game(10);
    }
}