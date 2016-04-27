package enterprice.Module3.Part2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by vladi_000 on 4/27/2016.
 */
public class SquareSumImpl implements SquareSum {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        List<Callable<Long>> calls = new ArrayList<>();
        IntStream.range(0, numberOfThreads).forEach(i -> calls.add(() -> {
            int elementsPerThread = (int) Math.ceil((double) values.length / numberOfThreads);
            int fromIndex = elementsPerThread * i;
            int toIndex = Math.min(elementsPerThread * (i + 1), values.length);
            System.out.println("Thread " + Thread.currentThread().getName() + " start -> [" + fromIndex + " ," + toIndex + ")");
            Long result = (long) 0;
            for (int ind = fromIndex; ind < toIndex; ind++) {
                result += (long) Math.pow(values[ind], 2);
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " finish");
            return result;
        }));

        ExecutorService service = Executors.newCachedThreadPool();

        try {
            List<Future<Long>> squareSum = service.invokeAll(calls);
            Long sum = (long) 0;
            for (int i = 0; i < squareSum.size(); i++) {
                sum += squareSum.get(i).get();
            }
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return -1;
        } finally {
            service.shutdown();
        }


    }
}
