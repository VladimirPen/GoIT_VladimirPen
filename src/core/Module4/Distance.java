package core.module4;

/**
 * Created by vladi_000 on 12/20/2015.
 */
public class Distance {

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
