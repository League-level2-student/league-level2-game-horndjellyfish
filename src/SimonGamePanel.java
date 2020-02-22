import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SimonGamePanel extends JPanel implements ActionListener, KeyListener {



    public final int PANEL_SIZE = SimonFrame.HEIGHT;
    protected static final int BUTTON_WIDTH = SimonFrame.WIDTH/2;
    protected static final int BUTTON_HEIGHT = SimonFrame.HEIGHT/2;

    SimonGPButton _greenButton = new SimonGreenButton();
    SimonGPButton _redButton = new SimonRedButton();
    SimonGPButton _yellowButton = new SimonYellowButton();
    SimonGPButton _blueButton = new SimonBlueButton();
    SimonFrame _parent = null;
    SimonGPButton simonButton = new SimonGPButton();
    ArrayList<Integer> newPattern;
    SimonPatternManager _patternManager = new SimonPatternManager(this);
    SimonGamePanel (SimonFrame parent) {

    }
    // paint the Game Panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // paint the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, PANEL_SIZE, PANEL_SIZE);

        // paint the buttons
        _greenButton.paintComponent(g);
        _redButton.paintComponent(g);
        _yellowButton.paintComponent(g);
        _blueButton.paintComponent(g);
    }
    Timer timer = new Timer(1000, this);
    public void alsoStartGame() {
        newPattern = _patternManager.startNewPattern();
    }
    public void flashPattern() {
        for (int i : newPattern) {
            timer.start();
            if ( i == 0) {
              _greenButton.startFlash();
           }
            // need to create a timer with a task to turn the flash off when the timer is up

        }
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            _parent.startGame();
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
