package Checkers.settings;

/*
 * Firstscreen.java
 *
 *  * Version:
 *   $Id: Firstscreen.java,v 1.1 2002/10/22 21:12:52 se362 Exp $
 *
 * Revisions:
 *   $Log: Firstscreen.java,v $
 *   Revision 1.1  2002/10/22 21:12:52  se362
 *   Initial creation of case study
 *
 */
import Checkers.builders.settingsbuilder.firstscreen.IPFieldBuilder;
import Checkers.builders.settingsbuilder.OKCancelBuilder;
import Checkers.builders.settingsbuilder.firstscreen.RadioButtonsBuilder;
import Checkers.builders.settingsbuilder.secondscreen.PlayersInfoBuilder;
import Checkers.builders.settingsbuilder.secondscreen.TimeSettingsBuilder;
import Checkers.engine.Facade;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static java.awt.BorderLayout.NORTH;

/**
 *
 * @author
 * @version 
 */

public class Settings extends JFrame implements ActionListener{

    Facade theFacade;
    Secondscreen next;
    
  
    // Variables declaration - do not modify
    private String gameModeSelected;
    
    private JComponent modeSelection; // first screen
    private JComponent gameOptions; // second screen
    private JButton OKButton;
    private JButton CancelButton;
    private ButtonGroup gameModes;
    // End of variables declaration


    /** 
     * Creates new form Firstscreen
     *
     * @param facade a facade object for the GUI to interact with
     *     
     */

    public Settings( Facade facade ) {

	super( "First screen" );
        theFacade = facade;
        initComponents();
        pack();
    }
    

    /** 
     * This method is called from within the constructor to
     * initialize the form.
     * 
     */

    private void initComponents() {
        this.gameModeSelected = "local";
        this.modeSelection = new javax.swing.JPanel(new java.awt.GridBagLayout());
        this.gameOptions = new javax.swing.JPanel(new java.awt.GridBagLayout());
        this.setLayout(new java.awt.BorderLayout());
        this.setResizable(false);
        
        // make Mode Selection screen
        this.modeSelection.setLayout(new java.awt.GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        
        // create radio buttons for game mode selection
        JPanel gameModeButtons = (JPanel) (new RadioButtonsBuilder()).getProduct(this);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridwidth = 3;
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.modeSelection.add(gameModeButtons, constraints);
        
        // create IP text field and instructions
        JLabel IPLabel = new JLabel();
        IPLabel.setName("label10");
        IPLabel.setBackground(new Color (204, 204, 204));
        IPLabel.setForeground(Color.black);
        IPLabel.setText("IP address:  ");
        JPanel IPAddressComponents = (JPanel) (new IPFieldBuilder()).getProduct(this);
        constraints.gridx = 2;
        constraints.gridy = 2;
        this.modeSelection.add(IPAddressComponents, constraints);
        
        

        // make game options screen
        this.gameOptions.setLayout(new java.awt.GridBagLayout());
        
        // create player info input fields
        JPanel playerInputFields = (JPanel) (new PlayersInfoBuilder()).getProduct(this);
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.gameOptions.add(playerInputFields, constraints);
        
        // create time options
        JPanel timeBasedOptions = (JPanel) (new TimeSettingsBuilder()).getProduct(this);
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.gameOptions.add(timeBasedOptions, constraints);
        
        
        // create OK/Cancel buttons
        JPanel OKCancelButtons = (JPanel) (new OKCancelBuilder()).getProduct(this);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 3;
        constraints.gridy = 4;
        this.gameOptions.add(OKCancelButtons, constraints);
        
        // configuration
        this.getContentPane().add(this.modeSelection, BorderLayout.NORTH);
        this.getContentPane().add(this.gameOptions, BorderLayout.SOUTH);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
    }

    public String getSelectedMode(){
        return this.gameModeSelected;
    }
    
    public void setSelectedMode(String mode){
        this.gameModeSelected = mode;
    }
    
    
    /**
     *  
     * Exit the Application
     * 
     * @param the event to close the window
     * 
     */

    private void exitForm(WindowEvent evt) {
        System.exit (0);
    }

    /**
     * This takes care of when an action takes place. It will check the 
     * action command of all components and then deicde what needs to be done.
     *
     * @param e the event that has been fired
     * 
     */
    public void actionPerformed( ActionEvent e ){

        try{
            //this code handles disabling the IP field unless
            //the join game radio button is selected
            if ( ( e.getActionCommand() ).equals( "join" ) ){
                System.out.println("lol");
            }else if( (e.getActionCommand() ).equals( "local" ) ){
                System.out.println("nope");
            

                //this next if statement takes care of when the 
                //OK button is selected and goes to the second 
                //screen settign the desired options          

            }else if( ( e.getActionCommand() ).equals( "ok" ) ){

                //a temporary button to use for determining the game type
                ButtonModel tempButton = gameModes.getSelection();

                //if check to see of the local radio button is selected
                if( tempButton.getActionCommand().equals( "local" ) ){

                    //set up a local game
                    theFacade.setGameMode( theFacade.LOCALGAME );

                    theFacade.createPlayer( 1, theFacade.LOCALGAME );
                    theFacade.createPlayer( 2, theFacade.LOCALGAME );

                    //hide the Firstscreen, make a Secondscreen and show it
                    this.hide();
                    //next = new Secondscreen( theFacade, this, theFacade.LOCALGAME );
                    next.show();

                    //if the host game button is selected
                } else if( tempButton.getActionCommand().equals( "host" ) ){

                    //set up to host a game
                    theFacade.setGameMode( theFacade.HOSTGAME );

                    theFacade.createPlayer( 1, theFacade.HOSTGAME );
                    theFacade.createPlayer( 2, theFacade.HOSTGAME );

                    //hide the Firstscreen, make the Secondscreen and show it
                    this.hide();
                    //next = new Secondscreen( theFacade, this, theFacade.HOSTGAME );
                    next.show();

                    //if the join game button is selected
                } else if( tempButton.getActionCommand().equals( "join" ) ){

                    //set up to join a game
                    theFacade.setGameMode( theFacade.CLIENTGAME );

                    theFacade.createPlayer( 1, theFacade.CLIENTGAME );
                    theFacade.createPlayer( 2, theFacade.CLIENTGAME );

                    this.hide();
                    next.show();
                }


                            //if they hit cancel exit the game
            } else if( e.getActionCommand().equals( "cancel" ) ){
                System.exit( 0 );
            } 

        } catch( Exception x ) {
            System.err.println( x.getMessage() );
        }//end of general catch statement

    }//end of actionPerformed
 }//Firstscreen.java
