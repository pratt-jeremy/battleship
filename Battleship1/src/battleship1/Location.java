/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

import java.util.Scanner;

/**
 *
 * @author MBradshaw and Jpratt
 */
   public class Location {
    int row;
    int column;
    Players player;
    int currentPosX = 0;
    int currentPosY = 0;
    
    
    public Location () {
        
    }
    
    public void occupyLocation (Players player) {
        this.player = player;
    }
    
    public void displayMarker() {
        if (this.player != null) {
            System.out.println(this.player.marker);
        }
        else {
            System.out.println(" ");
        }
    }
    public int moveShips(){
       Scanner in = new Scanner(System.in); 
       System.out.printf("Enter X Coordinate:  ");
       int newPosX = in.nextInt();
       System.out.printf("Enter Y Coordinate:  ");
       int newPosY = in.nextInt();

	if (newPosX < 1){
		System.out.println("X cannot be below 1"); 
		return -1;
                }
	if (newPosX > 10){ 
		System.out.println("X cannot be above 10");
		return -1;
                }
	if (newPosY < 1){
		System.out.println("Y cannot be below 1");
		return -1;}
	if (newPosY > 10) {
		System.out.println("Y cannot be below 10");
		return -1;
        }
               
        
	int moveX = newPosX - currentPosX;
	int moveY = newPosY - currentPosY;
	
	System.out.println("You move " + moveX + " on the X axis and "
                + "" + moveY + " on the Y axis.");

	currentPosX=newPosX;
	currentPosY=newPosY;
        return 0;
                }

            
 }
