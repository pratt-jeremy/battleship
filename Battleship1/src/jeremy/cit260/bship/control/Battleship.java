/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeremy.cit260.bship.control;

import group.cit260.bship.exception.BattleshipException;
import group.cit260.bship.frames.MainFrame;
import group.cit260.bship.menuview.GamePreferencesMenuView;
import group.cit260.bship.menuview.MainMenuView;
import java.util.Arrays;
import java.util.Scanner;
import jeremy.cit260.bship.enume.ErrorType;
import jeremy.cit260.bship.models.Player;


/**
 *
 * @author Jeremy & Melanie
 */
public class Battleship {
    public static MainFrame mainFrame = null;
    private GamePreferencesFrame gamePreferencesFrame = null;
    /**
     *
     */
    
    private Player[] players = new Player[10];

    public Battleship() {
        
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

        
    public static void main(String[] args) {
        Battleship battleship = null;
        try {  
            battleship = new Battleship ();
            
              /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Battleship.mainFrame = new MainFrame();
                    Battleship.mainFrame.setVisible(true);
                }
            });
        } 

        catch (Throwable ex) {     
            ErrorType.displayErorrMsg("Unexpected error: " + ex.getMessage());
            ErrorType.displayErorrMsg(Arrays.toString(ex.getStackTrace()));           
        } 
        finally {
            if (Battleship.mainFrame != null) {
                Battleship.mainFrame.dispose();
            }
        }
        
      
    }


}
