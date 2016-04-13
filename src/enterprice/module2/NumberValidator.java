package enterprice.Module2;

/**
 * Created by vladi_000 on 4/12/2016.
 */
public class NumberValidator<T extends Number> implements Validator {

    @Override
    public boolean isValid(Number result) {
        return false;
    }
}
