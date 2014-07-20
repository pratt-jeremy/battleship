/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package group.cit260.bship.frames;
import jeremy.cit260.bship.control.GameMenuControl;
import jeremy.cit260.bship.control.Battleship;
import jeremy.cit260.bship.enume.GameType;
import jeremy.cit260.bship.enume.PlayerType;
import jeremy.cit260.bship.enume.StatusType;
import group.cit260.bship.exception.GameException;
import group.cit260.bship.exception.BattleshipException;
import jeremy.cit260.bship.models.Game;
import jeremy.cit260.bship.models.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Niethy
 */



public class GameFrame extends javax.swing.JFrame {

    private String currentMarker = null;
    private Game game = null;
    private GameMenuControl gameCommands = null;

    
    public GameFrame() {
        this.initComponents();
        this.initializeFrame();
        setLocationRelativeTo(null);
    }

    public GameFrame(Game game) {
        this();
        this.game = game;
        this.gameCommands = new GameMenuControl(game);
    }

    public void initializeFrame() {
        /* Create and display the form */
        

        battleshipTable.getTableHeader().setVisible(false);
        battleshipTable.getTableHeader().setPreferredSize(new Dimension(0, 0));
        battleshipTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Color backgroundColor = battleshipTable.getBackground();
        battleshipTable.setSelectionBackground(backgroundColor);

        CellRenderer cellRenderer = new CellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        TableColumnModel columnTableModel = battleshipTable.getColumnModel();
        for (int i = 0; i < battleshipTable.getColumnCount(); i++) {
            columnTableModel.getColumn(i).setCellRenderer(cellRenderer);
        }
        
    }

    public String getCurrentMarker() {
        return currentMarker;
    }

    public void setCurrentMarker(String currentMarker) {
        this.currentMarker = currentMarker;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public JTable getBattlshipTable() {
        return battleshipTable;
    }

    public void setBattleshipTable(JTable battleshipTable) {
        this.battleshipTable = battleshipTable;
    }

    public JPanel getJpBody() {
        return jBody;
    }

    public void setJpBody(JPanel jpBody) {
        this.jBody = jpBody;
    }

    
    
    
    public void displayStatistics() {
        this.jtMessageArea.setForeground(Color.blue);
        String playerAStatistics = this.game.getPlayerA().getPlayerStastics();
        String playerBStatistics = this.game.getPlayerB().getPlayerStastics();
        this.jtMessageArea.setText(playerAStatistics + "\n\n" + playerBStatistics);
        this.jtMessageArea.setForeground(Color.black);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBody = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jpNewGame = new javax.swing.JButton();
        jbPreferences = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jbQuit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtMessageArea = new javax.swing.JTextArea();
        jbStatistics = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        battleshipTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Battleship Game");

        jBody.setBackground(new java.awt.Color(153, 153, 255));
        jBody.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jBody.setToolTipText("");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel4.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText(" battleship game");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jpNewGame.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 13)); // NOI18N
        jpNewGame.setText("New Game");
        jpNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpNewGameActionPerformed(evt);
            }
        });

        jbPreferences.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 13)); // NOI18N
        jbPreferences.setText("PREFERENCES");
        jbPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPreferencesActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 13)); // NOI18N
        jButton1.setText("HELP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbQuit.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 13)); // NOI18N
        jbQuit.setText("QUIT");
        jbQuit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbQuitMouseClicked(evt);
            }
        });

        jtMessageArea.setColumns(20);
        jtMessageArea.setRows(5);
        jScrollPane2.setViewportView(jtMessageArea);

        jbStatistics.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 13)); // NOI18N
        jbStatistics.setText("Statistics");
        jbStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStatisticsActionPerformed(evt);
            }
        });

        battleshipTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ));
        battleshipTable.setColumnSelectionAllowed(true);
        battleshipTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(battleshipTable);
        battleshipTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (battleshipTable.getColumnModel().getColumnCount() > 0) {
            battleshipTable.getColumnModel().getColumn(0).setResizable(false);
            battleshipTable.getColumnModel().getColumn(1).setResizable(false);
            battleshipTable.getColumnModel().getColumn(2).setResizable(false);
            battleshipTable.getColumnModel().getColumn(3).setResizable(false);
            battleshipTable.getColumnModel().getColumn(4).setResizable(false);
            battleshipTable.getColumnModel().getColumn(5).setResizable(false);
            battleshipTable.getColumnModel().getColumn(6).setResizable(false);
            battleshipTable.getColumnModel().getColumn(7).setResizable(false);
            battleshipTable.getColumnModel().getColumn(8).setResizable(false);
            battleshipTable.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout jBodyLayout = new javax.swing.GroupLayout(jBody);
        jBody.setLayout(jBodyLayout);
        jBodyLayout.setHorizontalGroup(
            jBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyLayout.createSequentialGroup()
                .addGroup(jBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBodyLayout.createSequentialGroup()
                        .addGroup(jBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbPreferences)
                            .addGroup(jBodyLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jpNewGame))
                            .addGroup(jBodyLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jbStatistics))
                            .addGroup(jBodyLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbQuit)
                                    .addComponent(jButton1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(jBodyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jBodyLayout.setVerticalGroup(
            jBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBodyLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBodyLayout.createSequentialGroup()
                        .addComponent(jpNewGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbPreferences)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbStatistics)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbQuit))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(380, 380, 380))
        );

        jBody.getAccessibleContext().setAccessibleParent(jBody);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPreferencesActionPerformed
        GamePreferencesFrame gamePreferencesFrame = new GamePreferencesFrame(this.game, this);
        gamePreferencesFrame.setVisible(true);
    }//GEN-LAST:event_jbPreferencesActionPerformed

    private void jbStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStatisticsActionPerformed
        this.displayStatistics();
    }//GEN-LAST:event_jbStatisticsActionPerformed

    private void jpNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpNewGameActionPerformed
        this.gameCommands.startNewGame(this.game);
        clearMarkers();
        takeFirstTurn();
        String nextPlayersMessage = this.game.getCurrentPlayer().getName()
        + " it is your turn.";
        this.jtMessageArea.setText(nextPlayersMessage);
    }//GEN-LAST:event_jpNewGameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      HelpFrame helpFrame = new HelpFrame();
        helpFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbQuitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbQuitMouseClicked
     Battleship.mainFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbQuitMouseClicked

      private void clearMarkers() {
        TableModel model = this.battleshipTable.getModel();
        int rowCount = this.battleshipTable.getRowCount();
        int colCount = this.battleshipTable.getColumnCount();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                model.setValueAt("", row, col);
            }
        }   
    }
    
    
    private String getNextPlayerMessage(Player player) {
        if (getGameType() == GameType.ONE_PLAYER) {
            return "The computer took it's turn. It is now your turn "
                    + player.getName();
        } else {
            return "It is now your turn "
                    + player.getName();
        }
    }

    
    
    
    private boolean gameOver() {
        if (getStatus() == StatusType.WINNER) { // a win?
            this.jtMessageArea.setText(this.game.getWinningMessage());
            return true;
        }

        return false;
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable battleshipTable;
    private javax.swing.JPanel jBody;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbPreferences;
    private javax.swing.JButton jbQuit;
    private javax.swing.JButton jbStatistics;
    private javax.swing.JButton jpNewGame;
    private javax.swing.JTextArea jtMessageArea;
    // End of variables declaration//GEN-END:variables
private void takeFirstTurn() {
        Player currentPlayer = this.game.getCurrentPlayer();
        
        
        
        String promptNextPlayer = getNextPlayerMessage(currentPlayer);
        this.jtMessageArea.setText(promptNextPlayer);
        this.game.setStatus(StatusType.PLAYING);
    }

    private void takeTurn(JTable table) {
        String playersMarker;
        int selectedRow = table.getSelectedRow();
        int selectedColumn = table.getSelectedColumn();
        Point selectedLocation = new Point(selectedRow, selectedColumn);

        Player currentPlayer = this.game.getCurrentPlayer();
        Player otherPlayer = this.game.getOtherPlayer();

        
    }

    private StatusType getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private GameType getGameType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class CellRenderer extends DefaultTableCellRenderer {

        public CellRenderer() {
            super();
        }

        public void setValue(Player player) {
            setText((player == null) ? "" : player.getMarker());
        }
    }
}
