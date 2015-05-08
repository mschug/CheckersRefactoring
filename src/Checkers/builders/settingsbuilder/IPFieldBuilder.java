/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checkers.builders.settingsbuilder.firstscreen;

import Checkers.builders.Builder;
import Checkers.settings.Settings;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author thn1069
 */
public class IPFieldBuilder implements Builder {
    private JPanel panel;
    
    @Override
    public void build(Settings settingsscreen) {
        this.panel = new JPanel();
        this.panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        JLabel IPLabel = new JLabel();
        JTextField IPField = new JTextField();
        JLabel IPExampleLabel = new JLabel();
        
        IPLabel.setName("label10");
        IPLabel.setBackground(new Color (204, 204, 204));
        IPLabel.setForeground(Color.black);
        IPLabel.setText("IP address:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.panel.add(IPLabel, constraints);
        
        // add IP address text field
        IPField.setBackground( Color.white );
        IPField.setName("textfield5");
        IPField.setForeground( Color.black);
        IPField.setText("IP address goes here");
        IPField.setEnabled( false );
        //IPField.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.panel.add(IPField, constraints);
        
        // add IP example
        IPExampleLabel.setName("label11");
        IPExampleLabel.setBackground(new Color (204, 204, 204));
        IPExampleLabel.setForeground(Color.black);
        IPExampleLabel.setText("Ex: 123.456.789.123");
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.panel.add(IPExampleLabel, constraints);
    }
    
    
    public Component getProduct(Settings settingsscreen) {
        this.build(settingsscreen);
        return this.panel;
    }
}
