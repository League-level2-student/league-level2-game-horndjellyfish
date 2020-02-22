import java.util.ArrayList;
import java.util.Random;

public class SimonPatternManager {
    public final int GREEN = 0;
    public final int BLUE = 1;
    public final int RED = 2;
    public final int YELLOW = 3;
    SimonGamePanel _parent = null;
    ArrayList<Integer> compPattern;
    ArrayList<Integer> userPattern = new ArrayList<Integer>();
    Random rand = new Random();
    SimonGPButton simonButton = new SimonGPButton();
    SimonPatternManager(SimonGamePanel parent) {
    	System.out.println("something's running");
        _parent = parent;
        startNewPattern();
    }
    public ArrayList<Integer> startNewPattern() {
        compPattern = new ArrayList<Integer>();
        addToPattern();
        return compPattern;
    }
    public void addToPattern() {
        int nextColor = rand.nextInt(YELLOW);
        System.out.println("current color " + nextColor);
        compPattern.add(nextColor);
        //simonButton.getFlashColor();
    }
    public void addToUserPattern() {

    }
}
