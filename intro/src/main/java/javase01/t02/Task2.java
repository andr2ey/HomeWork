package javase01.t02;

import java.io.PrintStream;
import java.util.Formatter;

public class Task2 {

    private static final int AMOUNT_IN_LINE = 10;

    //finds the least element number of sequence which satisfies by condition a(n) < e;
    public static int leastNumber(double e) {
        if (e <= 0)
            throw new IllegalArgumentException("e must be > 0");
        int n = 1;
        if (e > 0.25)
            return n;
        for (double a = 1; a >= e;)
            a = 1 / Math.pow(++n + 1, 2);
        return n;
    }

    public static void typeResult(double e, PrintStream ps) {
        Formatter f = new Formatter(ps);
        int n = leastNumber(e);
        f.format("e = %.2g. Result is %d.\n", e, n);
        int k = AMOUNT_IN_LINE;
        //output as table
        for (int i = 1; i < n; i += k) {
            for (int j = i; j < i + k && j <= n; j++)
                f.format(" %7d", j);
            f.format("\n");
        }
        f.format("\n");
    }

    public static void main(String[] args) {
        typeResult(0.26, System.out);
        typeResult(0.25, System.out);
        typeResult(0.004, System.out);
        typeResult(0.000004, System.out);
    }
}
