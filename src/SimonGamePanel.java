import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimonGamePanel extends JPanel implements ActionListener {

    public final int GREEN = 1;
    public final int BLUE = 2;
    public final int RED = 3;
    public final int YELLOW = 4;

    public final int PANEL_SIZE = SimonFrame.HEIGHT;
    protected static final int BUTTON_WIDTH = SimonFrame.WIDTH/2;
    protected static final int BUTTON_HEIGHT = SimonFrame.HEIGHT/2;

    SimonGPButton _greenButton = new SimonGreenButton();
    SimonGPButton _redButton = new SimonRedButton();
    SimonGPButton _yellowButton = new SimonYellowButton();
    SimonGPButton _blueButton = new SimonBlueButton();

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
