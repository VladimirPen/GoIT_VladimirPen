package Module4;

/**
 * Created by vladi_000 on 12/20/2015.
 */
public class TemperatureConversion {

    public static double celsiusToFahrenheit(double degrees) {
        return degrees * Constant.coefficientConvertion + Constant.zeroByFarinhate;/*HardCode. It should be changed using constants*/
    }

    public static double fahrenheitToCelsius(double degrees) {
        return (degrees - Constant.zeroByFarinhate) / Constant.coefficientConvertion;/*HardCode. It should be changed using constants*/
    }

}
