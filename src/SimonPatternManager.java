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
        compPattern.add(nextColor);
    }
    // return if the two arrays are equal or not
    public boolean checkPattern() {
        for (int i = 0; i < compPattern.size(); i++) {
            if (compPattern.get(i) != userPattern.get(i)) {
                return false;
            }
        }
        return true;
    }


}
