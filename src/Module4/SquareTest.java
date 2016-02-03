package Module4;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corner on 02.02.2016.
 */
public class SquareTest {

    private double sqare;


    @Test(timeout = 1000)
    public void testSquareTriangle() throws Exception {
        final double a = 3;
        final double h = 3;
        sqare = Square.squareTriangle(h, a);
        Assert.assertEquals(h * a / 2, sqare);
    }

    @Test(timeout = 1000)
    public void testSquareCircle() throws Exception {
        final double r = 3;
        sqare = Square.squareCircle(r);
        Assert.assertEquals(sqare, Math.pow(r, 2) * Math.PI);
    }

    @Test(timeout = 1000)
    public void testSquareRectangle() throws Exception {
        final double a = 3;
        final double b = 3;
        sqare = Square.squareTriangle(a, b);
        Assert.assertEquals(a * b, sqare);
    }
}