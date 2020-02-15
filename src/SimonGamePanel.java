import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class SimonGamePanel extends JPanel implements ActionListener, KeyListener {



    public final int PANEL_SIZE = SimonFrame.HEIGHT;
    protected static final int BUTTON_WIDTH = SimonFrame.WIDTH/2;
    protected static final int BUTTON_HEIGHT = SimonFrame.HEIGHT/2;

    SimonGPButton _greenButton = new SimonGreenButton();
    SimonGPButton _redButton = new SimonRedButton();
    SimonGPButton _yellowButton = new SimonYellowButton();
    SimonGPButton _blueButton = new SimonBlueButton();
    SimonFrame _parent = null;
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
    Timer timer = new Timer(20, this);


    public void actionPerformed(ActionEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            _parent.switchCard();
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
