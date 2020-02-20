import java.util.ArrayList;
import java.util.Random;

public class SimonPatternManager {
    public final int GREEN = 0;
    public final int BLUE = 1;
    public final int RED = 2;
    public final int YELLOW = 3;
    SimonFrame _parent = null;
    ArrayList<Integer> compPattern = new ArrayList<Integer>();
    ArrayList<Integer> userPattern = new ArrayList<Integer>();
    Random rand = new Random();
    SimonGPButton simonButton = new SimonGPButton();
    SimonPatternManager(SimonFrame parent) {
    	System.out.println("something's running");
        _parent = parent;
        addToPattern();
    }
    public void addToPattern() {
        int nextColor = rand.nextInt(YELLOW);
        System.out.println("current color " + nextColor);
        compPattern.add(nextColor);
        simonButton.getFlashColor();
    }
    public void addToUserPattern() {

    }
}
