import java.awt.*;

public class SimonBlueButton extends SimonGPButton {
    //subclass
    protected Color getColor() {
        return (Color.BLUE.darker());
    }

    protected int getX() {
        return (300);
    }

    protected int getY() {
        return (290);
    }
}
