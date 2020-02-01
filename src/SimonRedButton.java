import java.awt.*;

public class SimonRedButton extends SimonGPButton {
    //subclass
    @Override
    protected Color getColor() {
        return( Color.RED.darker());
    }

    @Override
    protected int getX() {
        return 300;
    }

    @Override
    protected int getY() {
        return 0;
    }

}
