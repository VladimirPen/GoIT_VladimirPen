package enterprice.Module3.Part1;

/**
 * Created by vladi_000 on 4/18/2016.
 */
public class Worker implements Runnable{

    private int permits;

    public Worker(int permits) {
        this.permits = permits;
    }

    @Override
    public void run() {
        try {
            Module3Part1.semaphore.acquire(permits);
            Thread.sleep(4000);
            Module3Part1.semaphore.release(permits);

        } catch (InterruptedException e) {
            System.out.println("[ERROR] " + Thread.currentThread().getName() + ". " + e.getMessage());
        }
    }
}
