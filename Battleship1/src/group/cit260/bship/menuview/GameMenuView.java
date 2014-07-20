/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group.cit260.bship.menuview;

import group.cit260.bship.exception.GameException;
import group.cit260.bship.exception.MenuException;
import jeremy.cit260.bship.control.Battleship;
import jeremy.cit260.bship.control.BattleshipsError;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeremy & Melanie
 */
//public class GameMenuView extends Menu {
    
   // private jeremy.cit260.bship.models.Game game;
   // private final jeremy.cit260.bship.control.GameMenuControl gameCommands; 
   // private final GetLocationView getLocation = new GetLocationView();
  //  private jeremy.cit260.bship.gameview.BoardView displayBoard = new jeremy.cit260.bship.gameview.BoardView();

  //  private final static String[][] menuItems = {
   //     {"T", "Take your turn"},
   //     {"D", "Display the board"},
    //    {"N", "New Game"},
      //  {"R", "Report stastics"},
      //  {"P", "Change game preferences"},
       // {"H", "Help"},
     //   {"Q", "Quit"}
  //  };

  //  public GameMenuView(jeremy.cit260.bship.models.Game game) {
   //     super(GameMenuView.menuItems);
   //     this.gameCommands = new jeremy.cit260.bship.control.GameMenuControl(game);
  //  }

  //  public jeremy.cit260.bship.gameview.BoardView getDisplayBoard() {
  //      return displayBoard;
  //  }

//    public void setDisplayBoard(jeremy.cit260.bship.gameview.BoardView displayBoard) {
   //     this.displayBoard = displayBoard;
 //   }

    

  //  @Override
  //  public String executeCommands(Object object) {
   //     this.game = (jeremy.cit260.bship.models.Game) object;

    //    String gameStatus = jeremy.cit260.bship.models.Game.CONTINUE;
    //    do {
     
     //       this.display();
            
            // get commaned entered
      //      String command = null;
      //      try {
       //         command = this.getCommand();
        //    } catch (MenuException ex) {
          //      Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
          //  }
          //  switch (command) {
          //      case "T":
          //  try {
          //      this.takeTurn();
         //   } catch (GameException ex) {
         //       Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
         //   }
         //           break;
         //       case "D":
         //           this.displayBoard.display(game.getBoard());
         //           break;
         //       case "N":
         //           gameCommands.startNewGame(game);
           //         this.displayBoard.display(game.getBoard());
           //         break;
           //     case "R":
             //       this.displayStatistics();
            //        break;
            //    case "P":
              //      GamePreferencesMenuView gamePreferencesMenu = Battleship.getGamePreferencesMenu();
              //      gamePreferencesMenu.display();
               //     gamePreferencesMenu.executeCommands(this.game);
               //     break;
             //   case "H":
              //      group.cit260.bship.menuview.HelpMenuView helpMenu = Battleship.getHelpMenu();
              //      helpMenu.executeCommands(null);
              //      break;
              //  case "Q":
          //          gameStatus = jeremy.cit260.bship.models.Game.QUIT;
          //          break;
      //      }
      //  } while (!gameStatus.equals(jeremy.cit260.bship.models.Game.QUIT));

    //    return jeremy.cit260.bship.models.Game.PLAYING;
   // }
    
    
   //private void takeTurn() throws GameException {
      //  String playersMarker;
      //  Point selectedLocation;

      //  if (!this.game.getStatus().equals(jeremy.cit260.bship.models.Game.NEW_GAME) && 
       //     !this.game.getStatus().equals(jeremy.cit260.bship.models.Game.PLAYING)) {
       //     new BattleshipsError().displayError(
         //           "There is no active game. You must start a new game before "
         //           + "you can take a turn");
     //       return;
     //   }
     //   jeremy.cit260.bship.models.Player currentPlayer = this.game.getCurrentPlayer();
    //    jeremy.cit260.bship.models.Player otherPlayer = this.game.getOtherPlayer();

        // get location for first player
      //  selectedLocation = (Point) getLocation.getLocation(this.game);
      //  if (selectedLocation == null) {
         //   return;
      //  }

        // regular players turn
     //   Point locationMarkerPlaced = 
         //       this.gameCommands.playerTakesTurn(currentPlayer, selectedLocation);

     //   if (this.gameOver()) { // game won or tied?  
      //      return;
    //    }

       // if (this.game.getGameType() == null ? jeremy.cit260.bship.models.Game.ONE_PLAYER == null : this.game.getGameType().equals(jeremy.cit260.bship.models.Game.ONE_PLAYER)) {
            // computers turn
         //   locationMarkerPlaced = this.gameCommands.playerTakesTurn(otherPlayer, null);

        //    if (this.gameOver()) { // game won or tied?
        //        return;
       //     }
      //  }


        // display board and prompt for next player's turn
     //   this.displayBoard.display(game.getBoard());
       // String promptNextPlayer = getNextPlayerMessage(otherPlayer);
    //    System.out.println("\n\n\t" + promptNextPlayer);


  //  }

   // private boolean gameOver() {
     //   boolean done = false;
       // switch (this.game.getStatus()) {
         //   case jeremy.cit260.bship.models.Game.TIE:
                // a tie?
         //       System.out.println("\n\n\t" + this.game.getTiedMessage());
       //         done = true;
       //         break;
       //     case jeremy.cit260.bship.models.Game.WINNER:
                // a win?
        //        System.out.println("\n\n\t" + this.game.getWinningMessage());
       //         done = true;
       //         break;
      //  }
        
      //  if (done) {
      //      this.displayBoard.display(this.game.getBoard());
      //  }
        

   //     return done;
  //  }
    
        
 //   private String getNextPlayerMessage(jeremy.cit260.bship.models.Player player) {
   //     if (this.game.getGameType().equals(jeremy.cit260.bship.models.Game.ONE_PLAYER)) {
         //   return "The computer took it's turn. It is now your turn. "
     //               + player.getName();
      //  } else {
         //   return "It is now your turn "
          //          + player.getName();
   //     }
 //   }
    
    
   // private void displayStatistics() {
    //    String playerAStatistics = this.game.getPlayerA().getPlayerStastics();
     //   String playerBStatistics = this.game.getPlayerB().getPlayerStastics();
     //   System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
   //     System.out.println("\t " + playerAStatistics);
   //     System.out.println("\n\t " + playerBStatistics);
   //     System.out.println("\t+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
   // }


   
//}

//