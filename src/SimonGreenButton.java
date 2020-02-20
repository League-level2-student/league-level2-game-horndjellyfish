import java.awt.*;

public class SimonGreenButton extends SimonGPButton {
    //subclass
	
    protected Color getColor() {
    	System.out.println("GREEN");
        return (Color.GREEN.darker());
    }


    protected int getX() {
        return 0;
    }


    protected int getY() {
        return 0;
    }

}
