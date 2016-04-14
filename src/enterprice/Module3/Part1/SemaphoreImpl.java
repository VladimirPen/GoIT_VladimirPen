package enterprice.Module3.Part1;

/**
 * Created by vladi_000 on 4/14/2016.
 */
public class SemaphoreImpl implements Semaphore {

    Permit permit;

    public SemaphoreImpl(int totalPermits) {
        permit = new Permit();
    }

    @Override
    public void acquire() throws InterruptedException {
        acquire(1);
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        synchronized (permit) {
            while (true) {
                if (permit.getPermits() < permits) {
                    permit.wait();
                } else {
                    permit.decreacePermitions(permits);
                    break;
                }
            }
        }
    }

    @Override
    public void release() {
        release(1);
    }

    @Override
    public void release(int permits) {
        synchronized (permit) {
            permit.increacePermitions(permits);
            permit.notifyAll();
        }
    }

    @Override
    public int getAvailablePermits() {
        return permit.getPermits();
    }
}
