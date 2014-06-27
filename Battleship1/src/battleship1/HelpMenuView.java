/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship1;



/**
 *
 * @author jacksonrkj
 */
public class HelpMenuView extends Menu {
        
    public static final String BOARD = "BOARD";
    public static final String GAME = "GAME";
    public static final String REAL_PLAYER = "REAL_PLAYER";
    public static final String COMPUTER_PLAYER = "COMPUTER_PLAYER";
    public static final String LOCATION = "LOCATION";
    public static final String MARKER = "MARKER";
   
    private final static String[][] menuItems = {
        {"B", "The board"},
        {"C", "A computer player"}, 
        {"G", "The Tic-Tac-Toe game"},
        {"L", "A location"},
        {"M", "A marker"},
        {"R", "A regular player"},        
        {"Q", "Quit Help"}        
    };
    
    public HelpMenuView() {
        super(HelpMenuView.menuItems);
    } 
    
    @Override
    public String executeCommands(Object object) {       
        
        String gameStatus = Game.PLAYING;
        do {
            this.display();
            // get commaned entered
            String command = this.getCommand();
            switch (command) {
                case "B":
                    this.displayHelp(HelpMenuView.BOARD);
                    break;
                case "C":
                    this.displayHelp(HelpMenuView.COMPUTER_PLAYER);
                    break;
                case "G":
                    this.displayHelp(HelpMenuView.GAME);
                    break;                  
                case "L":
                    this.displayHelp(HelpMenuView.LOCATION);
                    break;
                case "M":
                    this.displayHelp(HelpMenuView.MARKER);
                    break;
                 case "R":
                    this.displayHelp(HelpMenuView.REAL_PLAYER);
                    break; 
                case "Q": 
                    return Game.QUIT;
            }
        } while (!gameStatus.equals(Game.QUIT));  
        
         return gameStatus;
    }
    
    private void displayHelp(String helpType) {

        String helpText = null;
        switch (helpType) {
            case HelpMenuView.BOARD: helpText = 
                "\tThe game board for Battleship. It consist of a grid of "
                + "\n\tlocations. Players place there ships on the different locations "
                + "\n\ton the board in an effort to conceal them from their opponent. The default board is "
                + "\n\t10 rows by 10 columns.";
                break;
                
            case HelpMenuView.GAME: helpText = 
                "\tThe objective of the game is to be the first player to guess "
                + "\n\tthe location of all the other players ships " ;
                break; 
                
            case HelpMenuView.REAL_PLAYER: helpText = 
                "\tA real player manually takes their turn by placing their mark "
                + "\n\tin an unused location on the board.";
                break;
                
            case HelpMenuView.COMPUTER_PLAYER: helpText = 
                "\tA computer based player utomatically takes its turn "
                + "\n\timmediatly after a real player in a single player game.";
                break;
                
            case HelpMenuView.LOCATION: helpText = 
                "\tA location on the board where a player can place their marker or make a guess";
                break;
                
            case HelpMenuView.MARKER: helpText = 
                "\tA symbol that \"marks\" the locations in the board that are occupied "
                + "by a player. ";
                break;
        }   
        
        StringBuilder dividerLine = new StringBuilder(80);
        for (int i = 0; i < 80; i++) {
            dividerLine.insert(i, '~');
        }
        
        System.out.println("\t" + dividerLine.toString());
        System.out.println(helpText);
        System.out.println("\t" + dividerLine.toString());
    }
  
}
