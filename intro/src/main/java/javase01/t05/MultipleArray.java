package javase01.t05;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Formatter;

public class MultipleArray {

    public static int[][] matrixWithMainDiagonals1(int n) {
        if (n < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //filling 1 diagonal
                if (i == j) {
                    a[i][j] = 1;
                }
                //filling 2 diagonal
                int iK = (n - 1) - i;
                if (iK == j) {
                    a[i][j] = 1;
                }
            }
        }
        return a;
    }

    public static void printArray(int[][] a, PrintStream ps) {
        Formatter f = new Formatter(ps);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                f.format("%d ", a[i][j]);
            }
            f.format("\n");
        }

    }

    public static void main(String[] args) {
        int[][] a = matrixWithMainDiagonals1(7);
        printArray(a, System.out);
    }
}
