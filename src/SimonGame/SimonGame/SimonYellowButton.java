package SimonGame.SimonGame;

import java.awt.*;

public class SimonYellowButton extends SimonGPButton {
    //subclass
    public SimonYellowButton() {
        _name = "yellow";
        _buttonNumber = SimonPatternManager.YELLOW;
    }

    protected Color getColor() {
        return (Color.YELLOW.darker());
    }

    protected int getX() {
        return (0);
    }

    protected int getY() {
        return (300);
    }
}
