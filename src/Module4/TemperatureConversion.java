package Module4;

/**
 * Created by vladi_000 on 12/20/2015.
 */
public class TemperatureConversion {

    public static double celsiusToFahrenheit(double degrees) {
        return degrees * 1.8 + 32;/*HardCode. It should be changed using constants*/
    }

    public static double fahrenheitToCelsius(double degrees) {
        return (degrees - 32) / 1.8;/*HardCode. It should be changed using constants*/
    }

}
