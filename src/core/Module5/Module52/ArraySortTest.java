package core.module5.Module52;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corner on 02.02.2016.
 */
public class ArraySortTest {

    final int[] basicArray = {1, 5, 2, 4, 6, 3, 4, 5};
    final int[] expectedArray = {1, 2, 3, 4, 4, 5, 5, 6};

    @Test
    public void testSort() throws Exception {
        int[] actualArray = basicArray.clone();
        ArraySort.Sort(actualArray);
        assertArrayEquals(actualArray, expectedArray);
    }
}