package javase01.t05;

import java.io.OutputStream;
import java.util.Formatter;

public class MultipleArray {

    public static int[][] multipleArray(int n) {
        if (n < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            int iK = (n - 1) - i;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    a[i][j] = 1;
                }
                if (iK == j) {
                    a[i][j] = 1;
                }
            }
        }
        return a;
    }

    public static void printArray(int[][] a, OutputStream os) {
        Formatter f = new Formatter(os);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                f.format("%d ", a[i][j]);
            }
            f.format("\n");
        }

    }

    public static void main(String[] args) {
        int[][] a = multipleArray(7);
        printArray(a, System.out);
    }
}
