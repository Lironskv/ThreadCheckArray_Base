import java.util.ArrayList;

/**
 * ThreadCheckArray class that searches for a subset sum using an
 * ArrayList {@code <Integer>} instead of a primitive integer array.
 */
public class ThreadCheckArray implements Runnable {
    /**
     * A flag indicating whether the array has been matched with the target value.
     */
    private boolean flag;
    /**
     * An array of boolean values indicating which elements have been matched.
     */
    private boolean[] winArray;
    /**
     * Shared data object used by this thread and other threads.
     */
    SharedData sd;
    /**
     * An ArrayList of integers to be checked.
     */
    private ArrayList<Integer> array;
    /**
     * The remaining value to match with the elements in the array.
     */
    int b;

    /**
     * Constructs a new ThreadCheckArray object with the given shared data object.
     *
     * @param sd the shared data object
     */
    public ThreadCheckArray(SharedData sd) {
        this.sd = sd;
        synchronized (sd) {
            array = sd.getArray();
            b = sd.getB();
        }
        winArray = new boolean[array.size()];
    }

    /**
     * Recursive helper method to check the array.
     *
     * @param n   the current index in the array
     * @param b   the remaining value to match
     */
    void rec(int n, int b) {
        synchronized (sd) {
            if (sd.getFlag()) return;
        }
        if (n == 1) {
            if (b == 0 || b == array.get(n - 1)) {
                flag = true;
                synchronized (sd) { sd.setFlag(true); }
            }
            if (b == array.get(n - 1)) winArray[n - 1] = true;
            return;
        }

        rec(n - 1, b - array.get(n - 1));
        if (flag) winArray[n - 1] = true;
        synchronized (sd) {
            if (sd.getFlag()) return;
        }
        rec(n - 1, b);
    }

    /**
     * Runs the thread to check the array and update the shared data object accordingly.
     */
    @Override
    public void run() {
        if (array.size() != 1)
            if (Thread.currentThread().getName().equals("thread1"))
                rec(array.size() - 1, b - array.get(array.size() - 1));
            else
                rec(array.size() - 1, b);
        if (array.size() == 1)
            if (b == array.get(0) && !flag) {
                winArray[0] = true;
                flag = true;
                synchronized (sd) { sd.setFlag(true); }
            }
        if (flag) {
            if (Thread.currentThread().getName().equals("thread1"))
                winArray[array.size() - 1] = true;
            synchronized (sd) { sd.setWinArray(winArray); }
        }
    }
}
