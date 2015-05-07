package Checkers.builders.settingsbuilder;

import Checkers.builders.Builder;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author thn1069
 */
public class OKCancelBuilder implements Builder{
    private JPanel panel;
    
    @Override
    public void build(JFrame settingsscreen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Component getProduct(JFrame settingsscreen) {
        this.build(settingsscreen);
        return this.panel;
    }
}
