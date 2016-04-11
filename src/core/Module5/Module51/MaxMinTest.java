package core.module5.Module51;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by corner on 02.02.2016.
 */
public class MaxMinTest {

    final int[] arr = {123, 1, 43461, 2134, 5345656, 9999, 35,};
    final int maxExpected = 5345656;
    final int minEXpected = 1;

    @Test(timeout = 1000)
    public void testMax() throws Exception {
        final int max = MaxMin.max(arr);
        Assert.assertEquals(max,maxExpected);
    }

    @Test(timeout = 1000)
    public void testMin() throws Exception {
        final int min = MaxMin.min(arr);
        Assert.assertEquals(min,minEXpected);
    }
}