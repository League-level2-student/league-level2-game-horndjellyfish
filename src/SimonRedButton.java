import java.awt.*;

public class SimonRedButton extends SimonGPButton {
	// subclass

	protected Color getColor() {
		return (Color.RED.darker());
	}

	protected int getX() {
		return 300;
	}

	protected int getY() {
		return 0;
	}

}
