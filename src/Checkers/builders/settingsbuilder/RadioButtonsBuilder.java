package Checkers.builders.settingsbuilder;

import Checkers.builders.Builder;
import java.awt.Component;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author thn1069
 */
public class RadioButtonsBuilder implements Builder{
    private JPanel panel = new JPanel();
    
    @Override
    public void build(JFrame settingsscreen) {
        JRadioButton LocalGameButton = new JRadioButton();
        JRadioButton HostGameButton = new JRadioButton();
        JRadioButton JoinGameButton = new JRadioButton();
        
        // construct Local Game radio Button
        LocalGameButton.setActionCommand("local");
        LocalGameButton.setText("Local game");
        LocalGameButton.setSelected( true );
        
        // construct Host Game radio button
        HostGameButton.setActionCommand("host");
        HostGameButton.setText("Host game");
        
        // construct Join Game radio button
        JoinGameButton.setActionCommand("join");
        JoinGameButton.setText("Join game");
        
        // add all components in the Button group
        this.panel.add(LocalGameButton);
        this.panel.add(HostGameButton);
        this.panel.add(JoinGameButton);
    }
    
    
    public Component getProduct(JFrame settingsscreen) {
        this.build(settingsscreen);
        return this.panel;
    }
}
