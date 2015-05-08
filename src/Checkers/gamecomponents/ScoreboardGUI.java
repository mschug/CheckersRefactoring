/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checkers.gamecomponents;

import Checkers.engine.PlayerScore;
import Checkers.engine.ScoreboardController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Displays listings from the ScoreboardController.
 * Provides an option to erase the scores.
 * 
 * @author mss9627
 */
public class ScoreboardGUI extends JFrame {
    
    private ScoreboardController controller;
    private final String[] columnNames = {
        "Name", "Wins", "Draws", "Losses", "Games", "Score", "Score per Game"
    };
    private JTable rankings;
    private final JScrollPane scroll;
    private final JButton update;
    private final JButton reset;
    
    public ScoreboardGUI( ScoreboardController sc ){
        this.setTitle( "Scoreboard" );
        controller = sc;
        updateScoreboard( controller.getScores() );
        
        update = new JButton("Update Scores");
        reset = new JButton("Erase Scores");
        
        update.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateScoreboard( controller.getScores() );
            }
        });
        
        reset.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                controller.resetScores();
                updateScoreboard( controller.getScores() );
            }
        });
        
        scroll = new JScrollPane( rankings );
        this.setLayout( new BorderLayout() );
        this.add( scroll, BorderLayout.CENTER );
        
        JPanel menu = new JPanel();
        menu.setLayout( new FlowLayout() );
        menu.add( update );
        menu.add( reset );
        this.add( menu, BorderLayout.SOUTH );
        
        this.pack();
    }   
    
    public void updateScoreboard( ArrayList<PlayerScore> players ){
        String[][] params = new String[ players.size() ][7];
        Collections.sort(players);
        
        int i = 0;
        for( PlayerScore p : players ){
            params[i][0] = p.getName();
            params[i][1] = Integer.toString( p.getWins() );
            params[i][2] = Integer.toString( p.getDraws() );
            params[i][3] = Integer.toString( p.getLosses() );
            params[i][4] = Integer.toString( p.getGames() );
            params[i][5] = Integer.toString( p.getScore() );
            params[i][6] = String.format( "%1.2f", p.getAverageScore() );
            i++;
        }
        
        rankings = new JTable( params, columnNames );
        rankings.getColumnModel().getColumn(0).setMinWidth(100);
        rankings.getColumnModel().getColumn(6).setMinWidth(100);
        /*  rankings.setModel( new DefaultTableModel(){
            @Override
            public boolean isCellEditable( int row, int column ){
                return false;
            }
        }); */
    }
    
}
