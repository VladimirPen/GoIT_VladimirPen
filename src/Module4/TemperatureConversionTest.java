package Module4;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by corner on 02.02.2016.
 */
public class TemperatureConversionTest {

    double degreesFahrenheit;
    double degreesCelsius;

    @Test(timeout = 1000)
    public void testCelsiusToFahrenheit() throws Exception {
        degreesCelsius = 150;
        degreesFahrenheit = TemperatureConversion.celsiusToFahrenheit(degreesCelsius);
        Assert.assertEquals(degreesCelsius * Constant.coefficientConvertion + Constant.zeroByFarinhate, degreesFahrenheit);

    }

    @Test(timeout = 1000)
    public void testFahrenheitToCelsius() throws Exception {
        degreesFahrenheit = 150;
        degreesCelsius = TemperatureConversion.fahrenheitToCelsius(degreesFahrenheit);
        Assert.assertEquals((degreesFahrenheit - Constant.zeroByFarinhate) / Constant.coefficientConvertion, degreesCelsius);

    }
}