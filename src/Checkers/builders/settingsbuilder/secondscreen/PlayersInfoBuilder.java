/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checkers.builders.settingsbuilder.secondscreen;

import Checkers.builders.Builder;
import Checkers.settings.Settings;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Thong
 */
public class PlayersInfoBuilder implements Builder {
    private JPanel panel;
    private Settings settingsScreen;
    
    @Override
    public void build(Settings settingsscreen) {
        this.panel = new JPanel();
        this.settingsScreen = settingsscreen;
        this.panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        
        JLabel playerOneLabel = new JLabel();
        JLabel playerTwoLabel = new JLabel();
        JTextField playerOneField = new JTextField();
        JTextField playerTwoField = new JTextField();
        
        // Player 1
        playerOneLabel.setName("playerOneLabel");
        playerOneLabel.setBackground(new Color (204, 204, 204));
        playerOneLabel.setForeground(Color.black);
        playerOneLabel.setText("Player 1:  ");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 0, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.panel.add(playerOneLabel, constraints);
        
        playerOneField.setBackground(Color.white);
        playerOneField.setName("textfield1");
        playerOneField.setForeground(Color.black);
        playerOneField.setText("Enter name");
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 0, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.panel.add(playerOneField, constraints);
     
        
        // Player 2
        playerTwoLabel.setName("playerTwoLabel");
        playerTwoLabel.setBackground(new Color (204, 204, 204));
        playerTwoLabel.setForeground(Color.black);
        playerTwoLabel.setText("Player 2:  ");
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(4, 0, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.panel.add(playerTwoLabel, constraints);
        
        
        playerTwoField.setBackground(Color.white);
        playerTwoField.setName("textfield2");
        playerTwoField.setForeground(Color.black);
        playerTwoField.setText("Enter name");
        constraints = new GridBagConstraints();
        constraints.gridwidth = 2;
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(4, 0, 0, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.panel.add(playerTwoField, constraints);
    }
    
    
    public Component getProduct(Settings settingsscreen){
        this.build(settingsscreen);
        return this.panel;
    }
}
