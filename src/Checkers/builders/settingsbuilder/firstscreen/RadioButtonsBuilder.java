package Checkers.builders.settingsbuilder.firstscreen;

import Checkers.builders.Builder;
import Checkers.builders.GameModeListener;
import Checkers.settings.Firstscreen;
import Checkers.settings.Settings;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author thn1069
 */
public class RadioButtonsBuilder implements Builder{
    private Settings settingsScreen;
    private JPanel panel = new JPanel();
    
    @Override
    public void build(final Settings settingsscreen) {
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        
        JRadioButton LocalGameButton = new JRadioButton();
        JRadioButton HostGameButton = new JRadioButton();
        JRadioButton JoinGameButton = new JRadioButton();
        
        // construct Local Game radio Button
        LocalGameButton.setActionCommand("local");
        LocalGameButton.setName("local");
        LocalGameButton.setText("Local game");
        LocalGameButton.addActionListener(new GameModeListener(this.panel, settingsscreen));
        LocalGameButton.setSelected( true );
        
        // construct Host Game radio button
        HostGameButton.setActionCommand("host");
        HostGameButton.setName("host");
        HostGameButton.setText("Host game");
        HostGameButton.addActionListener(new GameModeListener(this.panel, settingsscreen));
        
        // construct Join Game radio button
        JoinGameButton.setActionCommand("join");
        JoinGameButton.setName("join");
        JoinGameButton.setText("Join game");
        JoinGameButton.addActionListener(new GameModeListener(this.panel, settingsscreen));
        
        // add all components in the Button group
        this.panel.add(LocalGameButton);
        this.panel.add(HostGameButton);
        this.panel.add(JoinGameButton);
    }
    
    
    public Component getProduct(Settings settingsscreen) {
        this.build(settingsscreen);
        return this.panel;
    }
}
