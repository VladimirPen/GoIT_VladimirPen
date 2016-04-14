package enterprice.Module3.Part1;

/**
 * Created by vladi_000 on 4/14/2016.
 */
public class Permit {

    private int permits;

    public int getPermits() {
        return permits;
    }

    public void increacePermitions(int inputPermits) {
        permits += inputPermits;
    }

    public void decreacePermitions(int inputPermits) {
        permits -= inputPermits;
    }

}
