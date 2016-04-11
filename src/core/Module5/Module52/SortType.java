package core.module5.Module52;

/**
 * Created by corner on 24.12.2015.
 */
public enum SortType {
    BUBBLE,
    SELECTION,
    INSERTION,
    HEAP,
    MERGE,
    QUICKSORT;

    public static SortType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
