import java.awt.*;

public class SimonYellowButton extends SimonGPButton {
    //subclass
    protected Color getColor() {
        return (Color.YELLOW.darker());
    }

    protected int getX() {
        return (0);
    }

    protected int getY() {
        return (290);
    }
}
