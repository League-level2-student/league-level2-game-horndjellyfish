package SimonGame.SimonGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimonGamePanel extends JPanel implements ActionListener, MouseListener {

    private  final int PANEL_SIZE = SimonFrame.HEIGHT;

    protected static final int BUTTON_WIDTH = SimonFrame.WIDTH / 2;
    protected static final int BUTTON_HEIGHT = SimonFrame.HEIGHT / 2;

    SimonFrame _parent = null;
    SimonGPButton _greenButton = new SimonGreenButton();
    SimonGPButton _redButton = new SimonRedButton();
    SimonGPButton _yellowButton = new SimonYellowButton();
    SimonGPButton _blueButton = new SimonBlueButton();
    SimonPatternManager _patternManager = new SimonPatternManager(this);


    // we need to keep two patterns arrays

    // one array that contain the user selection
    ArrayList<Integer> _userSelectionPattern = new ArrayList<Integer>();

    // one array so we can flash.
    // Note.  When flashing we will remove items from this array
    //        This way we can know when to stop flashing
    ArrayList<Integer> _flashClonePattern = new ArrayList<Integer>();

    // need a field to hold the next color to flash.  Used in the Timer ActionPerformed Method
    private int _flashColor = -1;
    Timer _timer = new Timer(1000, this);
    Timer mouseClickedTimer = new Timer(1000, new SimonColorClickedTimer(this));
    private int _score = 0;
    private boolean _startGame = false;

    public SimonGamePanel(SimonFrame parent) {
        _parent = parent;
        this.addMouseListener(this);
    }

    // start a new Game
    public void startGame() {
        _startGame = true;
        _score = 0;

        //  create new Pattern
        _patternManager.startNewPattern();

        // since pattern has changed, need to update our Flash Pattern
        UpdateFlashClonePattern();

        // make sure we redraw
        repaintTheGamePanel();
    }

    // Stop the Game
    public void stopGame() {
        _startGame = false;
        _parent.stopGame( _score );
    }

    // paint the Game Panel
    public void paintComponent(Graphics g) {
//System.out.println("***** GamePanel: Paint");
        super.paintComponent(g);

        // paint the background
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, PANEL_SIZE, PANEL_SIZE);

        // paint the buttons
        paintButtons(g);

        // paint the flash pattern, but only if game has been started
        if (_startGame) {
            // Flash Pattern
            paintFlashPattern(g);
        }
    }

    // paint all our buttons
    public void paintButtons (Graphics g ) {
//System.out.println("Painting all Buttons");
        _greenButton.paintComponent(g);
        _redButton.paintComponent(g);
        _yellowButton.paintComponent(g);
        _blueButton.paintComponent(g);
    }

    // check the copy of the FlashPattern (_flashClonePattern), for anymore colors to flash
    //  Note.  Every time we flash a color, we will remove it from the Array
    //         When we have remove the last color, then our flash pattern is complete
    private void paintFlashPattern(Graphics g ) {
        // check if there is anything left to flash
        if ( _flashClonePattern.size() <= 0 ) {
            // nothing to flash
            _flashColor = -1;
        }
        else  {
            // start time if not already stared
            if (!_timer.isRunning()) {
                _timer.start();
            }
        }
    }

    // need to update flash pattern that shown to user
    private void UpdateFlashClonePattern() {
        _flashClonePattern = _patternManager.getClonePattern();

        // reinitialize  the user selection pattern
        _userSelectionPattern = new ArrayList<Integer>();
    }

    // Set Button State to Start Flashing
    // Note.  This just set state, so on next Paint, it will Flash
    private void startFlashing( int color) {
        if (color == 0) {
            _greenButton.startFlash();
        } else if (color == 1) {
            _blueButton.startFlash();
        } else if (color == 2) {
            _redButton.startFlash();
        } else if (color == 3) {
            _yellowButton.startFlash();
        }
    }

    // Set ALL Button State to Stop Flashing
    // Note.  This just set state, so on next Paint, it will not Flash
    private void stopFlashing() {
        _greenButton.stopFlash();
        _blueButton.stopFlash();
        _redButton.stopFlash();
        _yellowButton.stopFlash();
    }

    // Something happen, so we need to FLASH all our colors
    public void flashPattern() {
        // In order to flash, we need to get Flash Pattern from our Pattern Manager
        // Note.  In this class we will be removing colors from the Array, so that we know when to stop flashing
        //        Hence, We DO NOT want the CHANGE original pattern in Pattern Manager
        //        Hence, this is a copy/clone of the original
        _flashClonePattern = _patternManager.getClonePattern();

        // force a repaint.  The paint() will then use the new flashClonePattern
        repaintTheGamePanel();
    }

    //  This is used for the Timer
    //  Set all Buttons to STOP Flashing to clear everything
    //  Then set specified button to START FLASHING
    public void actionPerformed(ActionEvent e) {
//        System.out.println("timer's on: " + System.currentTimeMillis() );
        // clear any flashing
        stopFlashing();

        if (_flashClonePattern.size() <= 0 ) {
            // if we have no more Colors to Flash, stop the timer
            _timer.stop();
        } else {
            // get the first item in the array to flash
            int flashColor = _flashClonePattern.get(0);
            startFlashing(flashColor);

            // remove the first item.  For Next time
            _flashClonePattern.remove( 0);
        }

        // Force a Repaint, so above action will be done
        repaintTheGamePanel();
    }

    // figure out what button was clicked
    private SimonGPButton getButtonClicked(int mouseX, int mouseY) {
        SimonGPButton button = null;

        //  check the mouseX and mouseY against each button
        //  whichever contains XY must be the button that was clicked
        if ( _blueButton.Contains( mouseX, mouseY) ) {
            button = _blueButton;
        } else if ( _redButton.Contains( mouseX, mouseY) )  {
            button = _redButton;
        } else if ( _greenButton.Contains( mouseX, mouseY) )  {
            button = _greenButton;
        } else if ( _yellowButton.Contains( mouseX, mouseY) )  {
            button = _yellowButton;
        }
        return button;
    }

    //  Make sure game panel is repainted
    public void repaintTheGamePanel() {
        this.paintImmediately(0, 0, SimonFrame.WIDTH, SimonFrame.HEIGHT);
//        revalidate();
//        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        // figure out what button was pressed
        SimonGPButton button = getButtonClicked( e.getX(), e.getY());
System.out.println( "MouseClicked: " + button.getButtonName() ) ;

        button.startFlash();
        mouseClickedTimer.start();
        // save off users selection
        _userSelectionPattern.add( button.getButtonNumber());

        // now check all of user selection against computer generated Pattern
        int patternStatus = _patternManager.checkPattern( _userSelectionPattern);

        if (patternStatus == SimonPatternManager.PATTERN_DIFFERENT) {
            // end the game
            stopGame();
        }  else {
            // User selected right Color

            // Did user get all Color Selections for current pattern
            if (patternStatus ==  SimonPatternManager.PATTERN_SAME_AND_DONE ) {
               // YES, so need to add another color to pattern
               _patternManager.addToPattern();

               // Since new color added, our seperate Flash Pattern needs updating
               UpdateFlashClonePattern();

               // since user selected correctly, update our score
                _score++;

               // redraw
               repaintTheGamePanel();
            } else {
               //  No he did not, so more button clicks/mouse clicks to check
            }
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

}

