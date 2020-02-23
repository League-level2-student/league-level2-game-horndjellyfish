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
        this.addMouseListener(this);
        //this.addKeyListener( this);
        setVisible(true);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGame() {
        _layout.next(this.getContentPane());
        _gamePanel.alsoStartGame();
        _gamePanel.flashPattern();
        //simonButton.getFlashColor();
    }

    private void displayGamePanel() {
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
        System.out.println("clicked");
        _gamePanel.timer.start();
        if (e.getX() > 0 && e.getX() <300 && e.getY() > 0 && e.getY() < 290) {
            _gamePanel._patternManager.userPattern.add(0);
            _gamePanel._greenButton.startFlash();
            System.out.println("green button clicked");
        } else if (e.getX() < 600 && e.getX() > 300 && e.getY() < 600 && e.getY() > 290) {
            _gamePanel._patternManager.userPattern.add(1);
            _gamePanel._blueButton.startFlash();
            System.out.println("blue button clicked");
        } else if (e.getX() < 600 && e.getX() > 300 && e.getY() > 0 && e.getY() < 300) {
            _gamePanel._patternManager.userPattern.add(2);
            _gamePanel._redButton.startFlash();
            System.out.println("red button clicked");
        } else if (e.getX() > 0 && e.getX() < 290 && e.getY() < 600 && e.getY() > 290) {
            _gamePanel._patternManager.userPattern.add(3);
            _gamePanel._yellowButton.startFlash();
            System.out.println("yellow button clicked");
        }
        repaint();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}