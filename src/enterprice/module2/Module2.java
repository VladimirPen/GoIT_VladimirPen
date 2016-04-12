package enterprice.module2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladi_000 on 4/12/2016.
 */
public class Module2 {


    public static void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<Number>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }

    public static void main(String... args)
    {
        List<Task<Integer>> intTasks = new ArrayList<Task<Integer>>();

        intTasks.add(new LongTask<Integer>(100));

        test(intTasks);
    }

}
