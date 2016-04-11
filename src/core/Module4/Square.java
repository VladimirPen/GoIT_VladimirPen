package core.module4;

/**
 * Created by vladi_000 on 12/20/2015.
 */
public class Square {

    public static double squareTriangle(double h, double a) {
        return h * a / 2;
    }

    public static double squareCircle(double r) {
        return Math.pow(r, 2) * Math.PI;
    }

    public static double squareRectangle(double a, double b) {
        return a * b;
    }
}
