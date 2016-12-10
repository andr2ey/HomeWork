package javase01.t02;

import javase01.t03.RangeException;

import java.io.OutputStream;
import java.util.Formatter;

public class Task2 {

    //finds the least element number of sequence which satisfy by condition a(n) < value;
    public static int searchOfLeastNumber(double value) {
        //минимальное условие подобрано, исходя из максимального результата выражения Math.pow(n + 1, 2),
        //при котором точность не теряется, т. е. для double это Double.MAX_VALUE/1E293 (15 значущих цифр)
        final double MIN_CONDITION = 5.562684646268004E-16;
        if (value < MIN_CONDITION) throw new RangeException();
        if (value > 0.25) {
            return 1;
        }
        double a;
        int n = 1;
        do {
            n++;
            a = 1 / Math.pow(n + 1, 2);
        } while (a >= value);
        return n;
    }

    //writes resulting string in PrintStream
    public static void getResultingString(double value, OutputStream os) {
        int n = searchOfLeastNumber(value);
        if (n < 1) return;
        Formatter f = new Formatter(os);
        f.format("Initial value is %.2e. Result is %d.\n", value, n);
        int k = 10;
        for (int i = 1; i < n + 1; i += 10) {
            if (n - i < 10) k = n - i + 1;
            for (int j = i; j < i + k; j++) {
                f.format(" %7d", j);
            }
            f.format("\n");
        }
        f.format("\n");
    }

    public static void main(String[] args) {
        getResultingString(0.26, System.out);
        getResultingString(0.004, System.out);
        getResultingString(0.0004, System.out);
    }
}
