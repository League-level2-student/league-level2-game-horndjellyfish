import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimonGamePanel extends JPanel implements KeyListener, ActionListener, MouseListener {


    public final int PANEL_SIZE = SimonFrame.HEIGHT;
    protected static final int BUTTON_WIDTH = SimonFrame.WIDTH / 2;
    protected static final int BUTTON_HEIGHT = SimonFrame.HEIGHT / 2;
    public int score = 0;
    SimonGPButton _greenButton = new SimonGreenButton();
    SimonGPButton _redButton = new SimonRedButton();
    SimonGPButton _yellowButton = new SimonYellowButton();
    SimonGPButton _blueButton = new SimonBlueButton();
    SimonFrame _parent = null;
    ArrayList<Integer> newPattern;
    SimonPatternManager _patternManager = new SimonPatternManager(this);

    SimonGamePanel(SimonFrame parent) {

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
        timer.start();

        for(int i : _patternManager.compPattern) {
System.out.println(" for loop " + i );
            try {
                if (i == 0) {
                    _greenButton.startFlash();
                    //Thread.sleep(1000);
                    //_greenButton.stopFlash();
                } else if (i == 1) {
                    _blueButton.startFlash();
                    //Thread.sleep(1000);
                    //_blueButton.stopFlash();
                } else if (i == 2) {
                    _redButton.startFlash();
                    //Thread.sleep(1000);
                    //redButton.stopFlash();
                } else if (i == 3) {
                    _yellowButton.startFlash();
                    //Thread.sleep(1000);
                    //_yellowButton.stopFlash();

                }
            } catch(Exception ex) {

            }

        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("timer's on:" );
        _greenButton.stopFlash();
        _blueButton.stopFlash();
        _redButton.stopFlash();
        _yellowButton.stopFlash();
        timer.stop();
        repaint();
        System.out.println("timer's off:" );
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

    public void mouseClicked(MouseEvent e) {

    }


    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
