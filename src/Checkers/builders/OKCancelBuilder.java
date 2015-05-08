package Checkers.builders;

import Checkers.builders.Builder;
import Checkers.settings.Settings;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author thn1069
 */
public class OKCancelBuilder implements Builder{
    private JPanel panel;
    
    @Override
    public void build(Settings settingsscreen) {
        this.panel = new JPanel();
        JButton OKButton = new JButton("OK");
        JButton CancelButton = new JButton("Cancel");
        GridBagConstraints constraints = new GridBagConstraints();
        
        
        // construct and add OK button
        OKButton.setText("OK");
        OKButton.setActionCommand("ok");
        OKButton.setName("button6");
        OKButton.setBackground(new Color (212, 208, 200));
        OKButton.setForeground(Color.black);
        //OKButton.addActionListener(this);
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.panel.add(OKButton, constraints);
        
        // construct add cancel button
        CancelButton.setText("Cancel");
        CancelButton.setActionCommand("cancel");
        CancelButton.setName("button7");
        CancelButton.setBackground(new Color (212, 208, 200));
        CancelButton.setForeground(Color.black);
        //CancelButton.addActionListener(this);
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.insets = new Insets(30, 0, 0, 0);
        this.panel.add(CancelButton, constraints);
    }
    
    
    public Component getProduct(Settings settingsscreen) {
        this.build(settingsscreen);
        return this.panel;
    }
}
