package enterprice.Module3.Part1;

import java.util.Random;

/**
 * Created by corner on 13.04.2016.
 */
public class Module3Part1 {

    static Semaphore semaphore = new SemaphoreImpl(10);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            (new Thread(new Worker(new Random().nextInt(15)))).start();
            Thread.sleep(1000);
        }
    }

}
