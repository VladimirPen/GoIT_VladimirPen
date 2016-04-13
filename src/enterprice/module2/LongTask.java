package enterprice.Module2;

/**
 * Created by vladi_000 on 4/12/2016.
 */
public class LongTask<T extends Long> implements Task {

    private T aLong;


    public LongTask(T aLongIn) {
        aLong = aLongIn;
    }


    @Override
    public void execute() {
    }

    @Override
    public T getResult() {
        return aLong;
    }
}
