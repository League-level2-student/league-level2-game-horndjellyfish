package SimonGame.SimonGame;

import java.awt.*;

public class SimonGreenButton extends SimonGPButton {
    //subclass
    public SimonGreenButton() {
        _name = "green";
        _buttonNumber = SimonPatternManager.GREEN;
    }
    protected Color getColor() {
        return (Color.GREEN.darker());
    }
    protected int getX() {
        return 0;
    }
    protected int getY() {
        return 0;
    }

}
