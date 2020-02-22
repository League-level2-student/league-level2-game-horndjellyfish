import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimonFrame extends JFrame implements MouseListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    SimonMenuPanel _menuPanel = new SimonMenuPanel(this);
    SimonGamePanel _gamePanel = new SimonGamePanel(this);
    SimonEndPanel _endPanel = new SimonEndPanel(this);
    public CardLayout _layout = new CardLayout();
    SimonGPButton simonButton = new SimonGPButton();

    public SimonFrame() {
        super("Simon Frame");
        setup();
        displayMenuPanel();
        displayGamePanel();
        displayEndPanel();
    }


    private void setup() {
        this.setLayout(_layout);
        this.addKeyListener(_menuPanel);
        this.addMouseListener((MouseListener) this);

        //this.addKeyListener( this);
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGame() {
        _layout.next(this.getContentPane());
        _gamePanel.alsoStartGame();
    }

    private void displayGamePanel() {
        //_gamePanel.addMouseListener(this);

        this.add(_gamePanel);
    }

    private void displayMenuPanel() {
        this.add(_menuPanel);
    }

    private void displayEndPanel() {
        this.add(_endPanel);
    }


    public void mouseClicked(MouseEvent e) {


    }

    public void mousePressed(MouseEvent e) {
//        simonButton.startFlash();
//        simonButton.getFlashColor();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}