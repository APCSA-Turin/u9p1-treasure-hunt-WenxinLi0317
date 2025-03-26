package com.example.project;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Grid grid;
        Player player;
        Enemy enemy;
        Enemy enemy2;
        Treasure treasure;
        Treasure treasure2;
        Trophy trophy;
        int size = 10;
        grid = new Grid(size);
        player = new Player(0, 0);
        enemy = new Enemy(5, 5);
        enemy2 = new Enemy(7,8);
        treasure = new Treasure(2, 2);
        treasure2 = new Treasure(1,7);
        trophy = new Trophy(9, 9);
        grid.placeSprite(player);
        grid.placeSprite(enemy);
        grid.placeSprite(enemy2);
        grid.placeSprite(treasure);
        grid.placeSprite(treasure2);
        grid.placeSprite(trophy);
        System.out.println(player.getRowCol(size));
        System.out.println("One:"+enemy.getRowCol(size));
        System.out.println("Two:"+enemy2.getRowCol(size));

        Scanner scan = new Scanner(System.in);
        String movement = "";
        while(! movement.equals("quit")){
            grid.display();
            movement = scan.nextLine();
     
            player.interact(size, movement, 1, enemy);
            player.interact(size, movement, 1, enemy2);
            player.interact(size, movement, 1, treasure);
            player.interact(size, movement, 1, treasure2);
            player.interact(size, movement, 1, trophy);
            player.move(movement);
            grid.placeSprite(player, movement);
            System.out.println(player.getRowCol(size));
            System.out.println("life" + player.getLives());
            System.out.println(enemy2.getRowCol(size));
            System.out.println("treasure" + player.getTreasureCount());
            
        }

        /*System.out.println("life"+ player.getLives());
        for(int i=0;i<5;i++){
            player.move("w"); //[9-5][0]
            grid.placeSprite(player, "w");
            
        }
       
        for(int i=0;i<4;i++){
            player.move("d");//[5][4]
            grid.placeSprite(player, "d");
        }

        System.out.println(player.getRowCol(size));
        player.interact(10, "d", 1, enemy);
        player.move("d");//[4][5]
        grid.placeSprite(player, "d");
        
        System.out.println(player.getRowCol(size));
        System.out.println("life"+ player.getLives());
    
        player.move("w");//[3][5]
        player.move("w");//[2][5]
        player.move("d");//[2][6]
        
        player.interact(10,"d",1,enemy2);
        player.move("d");//[2][7]
        grid.placeSprite(player,"d");
        grid.display();

        System.out.println(player.getRowCol(size));
        System.out.println(enemy2.getRowCol(size));
        System.out.println("life"+ player.getLives());
        
 */
        
    }
}