import java.awt.*;

public class SimonGreenButton extends SimonGPButton {
    //subclass
    @Override
    protected Color getColor() {
        return( Color.GREEN.darker());
    }

    @Override
    protected int getX() {
        return 0;
    }

    @Override
    protected int getY() {
        return 0;
    }

}
