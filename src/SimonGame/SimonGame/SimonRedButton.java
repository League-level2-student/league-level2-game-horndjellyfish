package SimonGame.SimonGame;

import java.awt.*;

public class SimonRedButton extends SimonGPButton {
	// subclass

	public SimonRedButton() {
		_name = "red";
		_buttonNumber = SimonPatternManager.RED;
	}

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
