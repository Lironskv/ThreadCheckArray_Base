import java.util.ArrayList;

/**
 * A class that represents shared data with an integer array and boolean arrays.
 */
public class SharedData {
    private ArrayList<Integer> array;
    private boolean[] winArray;
    private boolean flag;
    private final int b;

    /**
     * Constructs a new instance of SharedData with the given parameters.
     *
     * @param array the integer array to be stored
     * @param b         a constant value
     */
    public SharedData(ArrayList<Integer> array, int b) {
        this.array = array;
        this.b = b;
        this.winArray = new boolean[array.size()];
    }

    /**
     * Gets the boolean array.
     *
     * @return the winArray
     */
    public boolean[] getWinArray() {
        return winArray;
    }

    /**
     * Sets the boolean array.
     *
     * @param winArray the new winArray
     */
    public void setWinArray(boolean[] winArray) {
        this.winArray = winArray;
    }

    /**
     * Gets the integer array.
     *
     * @return the array
     */
    public ArrayList<Integer> getArray() {
        return array;
    }

    /**
     * Gets the constant value.
     *
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * Gets the flag.
     *
     * @return the flag
     */
    public boolean getFlag() {
        return flag;
    }

    /**
     * Sets the flag.
     *
     * @param flag the new flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
