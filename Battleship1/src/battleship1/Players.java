/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship1;

/**
 *
 * @author J.Pratt
 */
public class Players {
    
    String name;
    String alias;
    long wins;
    long losses;
    String gender;
    double age;
        
    
    public Players() {    
}

    public void displayName() {
        System.out.println("\t\tAhoy! Me name is " + this.name);
}
}