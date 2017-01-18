package javase01.t05;

import java.io.PrintStream;
import java.util.Formatter;

public class MultipleArray {

    public static int[][] matrixWithMainDiagonals1(int size) {
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[][] a = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int iK = (size - 1) - i; //for filling 2 diagonal
                if ((i == j) || (iK == j)) {
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
