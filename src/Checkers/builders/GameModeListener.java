/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Checkers.builders;

import Checkers.settings.Settings;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Thong
 */
public class GameModeListener implements ActionListener {
    private JPanel panel;
    private Settings settingsscreen;
    
    public GameModeListener(JPanel panelPassed, Settings settingsScreen){
        this.panel = panelPassed;
        this.settingsscreen = settingsScreen;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( ( ae.getActionCommand() ).equals( "local" ) ){
            for (int i = 0; i < 3; i++){
                JRadioButton button = (JRadioButton)(panel.getComponent(i));
                if (i == 0){
                    button.setSelected(true);
                    this.settingsscreen.setSelectedMode("local");
                }
                else{button.setSelected(false);}
            }
        }
        else if ( ( ae.getActionCommand() ).equals( "host" ) ){
            for (int i = 0; i < 3; i++){
                JRadioButton button = (JRadioButton)(panel.getComponent(i));
                if (i == 1){
                    button.setSelected(true);
                    this.settingsscreen.setSelectedMode("host");
                }
                else{
                    button.setSelected(false);
                }
            }   
        }
        else if ( ( ae.getActionCommand() ).equals( "join" ) ){
            for (int i = 0; i < 3; i++){
                JRadioButton button = (JRadioButton)(panel.getComponent(i));
                if (i == 2){
                    button.setSelected(true);
                    this.settingsscreen.setSelectedMode("join");
                }
                else{button.setSelected(false);}
            }
        }
    }
    
}
