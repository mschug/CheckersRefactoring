/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checkers.builders.settingsbuilder.secondscreen;

import Checkers.builders.Builder;
import Checkers.settings.Settings;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Thong
 */
public class TimeSettingsBuilder implements Builder {
    private JPanel panel;
    
    @Override
    public void build(Settings settingsscreen) {
        this.panel = new JPanel();
        this.panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        JLabel turnLengthLabel = new JLabel();
        JLabel warningLengthLabel = new JLabel();
        JSlider turnLengthField = new JSlider( 10, 300, 120 );
        JSlider warningLengthField = new JSlider( 10, 300, 120 );
        
        
        Checkbox timedGameBox = new Checkbox();
        timedGameBox.setBackground(new Color (204, 204, 204));
        timedGameBox.setName("timedGameBox");
        timedGameBox.setForeground(Color.black);
        timedGameBox.setLabel("Timed game");
        timedGameBox.setState( true );

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.ipadx = 7;
        constraints.ipady = 7;
        constraints.insets = new Insets(31, 0, 1, 0);
        constraints.anchor = GridBagConstraints.WEST;
        this.panel.add(timedGameBox, constraints);
        
        
        // turn length slider
        turnLengthField.setName("textfield3");
        //turnLengthField.addChangeListener( this );
     
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 6;
        this.panel.add(turnLengthField, constraints);
       
        
        // warning length slider
        warningLengthField.setName("textfield4");
        //warningLengthField.addChangeListener( this );
        
        constraints.gridx = 1;
        constraints.gridy = 8;
        this.panel.add(warningLengthField, constraints);
    
        
        // turn length label
        turnLengthLabel.setName("label3");
        turnLengthLabel.setBackground(new Color (204, 204, 204));
        turnLengthLabel.setForeground(Color.black);
        turnLengthLabel.setText("Turn Length ( " + turnLengthField.getValue() + " seconds )");
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.WEST;
        this.panel.add(turnLengthLabel, constraints);
     
        // warning length label
        warningLengthLabel.setName("label4");
        warningLengthLabel.setBackground(new Color (204, 204, 204));
        warningLengthLabel.setForeground(Color.black);
        warningLengthLabel.setText("Warning Length ( " + warningLengthField.getValue() + " seconds )");
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.anchor = GridBagConstraints.WEST;
        this.panel.add(warningLengthLabel, constraints);
    
    }
        
        
    public Component getProduct(Settings settingsscreen) {
        this.build(settingsscreen);
        return this.panel;
    }
    
}
