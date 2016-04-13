package enterprice.Module2;

/**
 * Created by vladi_000 on 4/12/2016.
 */
public interface Validator<T extends Number> {

    // Валидирует переданое значение
    boolean isValid(T result);

}