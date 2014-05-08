/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author MBradshaw
 */
   public class Location {
    int row;
    int column;
    Players player;
    
    
    public Location() {
        
    }
    
    public void occupyLocation(Players player) {
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
            
 }
