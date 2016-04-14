package enterprice.Module3.Part1;

/**
 * Created by vladi_000 on 4/14/2016.
 */
public interface Semaphore {

    public void acquire() throws InterruptedException;

    public void acquire(int permits) throws InterruptedException;

    public void release();

    public void release(int permits) throws InterruptedException ;

    public int getAvailablePermits();

}
