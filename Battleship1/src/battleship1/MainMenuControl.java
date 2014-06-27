/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;

/**
 *
 * @author Jeremy and Melanie
 */
public class MainMenuControl {
    
    private static final String PLAYER_A_DEFAULT_MARKER = "X";
    private static final String PLAYER_B_DEFAULT_MARKER = "O";
    
    public Game create(String gameType) {
        Game game = null;
        Players playerA = null;
        Players playerB = null;
        
        if (gameType == null) {
            throw new IllegalArgumentException ("MainCommands - create: gameType is null");
        }
        
        if (gameType.equals(Game.ONE_PLAYER)) {
            game = new Game(Game.ONE_PLAYER);
            playerA = new Players(Players.REGULAR_PLAYER, PLAYER_A_DEFAULT_MARKER);
            playerB = new Players(Players.COMPUTER_PLAYER, PLAYER_B_DEFAULT_MARKER);
        }
        else if (gameType.equals(Game.TWO_PLAYER)) {
            game = new Game(Game.TWO_PLAYER);
            playerA = new Players(Players.REGULAR_PLAYER, PLAYER_A_DEFAULT_MARKER);
            playerB = new Players(Players.REGULAR_PLAYER, PLAYER_B_DEFAULT_MARKER);

        }
         
        game.setPlayerA(playerA);
        game.setPlayerB(playerB);
        
        game.setStatus(Game.CONTINUE);
        
        return game;
    } 
    
}
