package enterprice.Module2;

/**
 * Created by vladi_000 on 4/12/2016.
 */
public interface Task<T extends Number> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();

}
