package core.module4;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by corner on 02.02.2016.
 */
public class DistanceTest {

    @Test(timeout = 1000)
    public void testDistance() throws Exception {
        final double x1 = 0;
        final double x2 = 2;
        final double y1 = 0;
        final double y2 = 2;

        final double distance = Distance.distance(x1, y1, x2, y2);

        Assert.assertEquals(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)), distance);

    }
}