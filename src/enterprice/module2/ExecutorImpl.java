package enterprice.Module2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladi_000 on 4/12/2016.
 */
public class ExecutorImpl<T extends Number> implements Executor{


    List<T> resultValid = new ArrayList<>();
    List<T> resultInValid = new ArrayList<>();


    @Override
    public void addTask(Task task) {
        task.execute();
        resultValid.add((T) task.getResult());

    }

    @Override
    public void addTask(Task task, Validator validator) {
        if (validator.isValid(task.getResult()))
        {
            resultValid.add((T) task.getResult());
        }
        else
        {
            resultInValid.add((T) task.getResult());
        }

    }

    @Override
    public void execute() {

    }

    @Override
    public List<T> getValidResults() {
        return resultValid;
    }

    @Override
    public List<T> getInvalidResults() {
        return resultInValid;
    }

}
