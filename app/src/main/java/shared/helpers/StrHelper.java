package shared.helpers;

/**
 * Created by Victor on 15/03/2018.
 */

public class StrHelper {
    public static double toDouble(String str) {
        str = str.replace(",", ".");
        return Double.parseDouble(str);
    }
    public static String toString(Double dec) {
        return Double.toString(dec);
    }
}
