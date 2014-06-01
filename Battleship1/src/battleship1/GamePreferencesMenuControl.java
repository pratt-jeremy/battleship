/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;




/**
 *
 * @author JPratt
 */
public class GamePreferencesMenuControl {
    
    private final Game game;

    public GamePreferencesMenuControl(Game game) {
        this.game = game;
    }
    
    
    public void getMarker(Players player) { 
        
        GetMarkerView getMarkerView = new GetMarkerView(this.game);
        String marker = getMarkerView.getInput(player);
        
        if (marker == null) { // user changed there mind and quit??
            return;
        }
      
        player.marker = marker; // update the players markers
        
        return;
    }
    
    public void getShips() { 
        
    }
        
    

    
    
    
}
