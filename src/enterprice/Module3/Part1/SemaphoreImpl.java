package enterprice.Module3.Part1;

/**
 * Created by vladi_000 on 4/14/2016.
 */
public class SemaphoreImpl implements Semaphore {

    Permit permit;


    public SemaphoreImpl(int totalPermits) {
        this.permit = new Permit(totalPermits);
    }

    @Override
    public void acquire() throws InterruptedException {
        acquire(1);
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        if (permit.getTotalPermits() < permits) {
            throw new InterruptedException("Required number of permissions more than total available. Available " + permit.getTotalPermits() + ". Required " + permits);
        }
        while (true) {
            synchronized (permit) {
                if (permit.getPermits() < permits) {
                    System.out.println(Thread.currentThread().getName() + " waiting ........  Available " + permit.getPermits() + ". Required " + permits);
                    permit.wait();
                } else {
                    System.out.println(Thread.currentThread().getName() + " working ....... Available " + permit.getPermits() + ". Required " + permits);
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
            //permit.notify();
            permit.notifyAll();
        }
    }

    @Override
    public int getAvailablePermits() {
        return permit.getPermits();
    }
}
