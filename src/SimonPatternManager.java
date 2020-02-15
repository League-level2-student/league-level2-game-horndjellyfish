import java.math.BigInteger;
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
    SimonPatternManager(SimonFrame parent) {
        _parent = parent;
        addToPattern();
    }
    public void addToPattern() {
        int nextColor = rand.nextInt(YELLOW);
        compPattern.add(nextColor);
    }
    public void addToUserPattern() {

    }
}
