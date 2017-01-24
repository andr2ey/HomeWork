package javase01.t05;

import java.io.PrintStream;
import java.util.Formatter;

public class MultipleArray {

    public static int[][] matrixWithMainDiagonals1(int size) {
        int[][] a = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                int iK = (size - 1) - i; //for filling other diagonal
                if ((i == j) || (iK == j))
                    a[i][j] = 1;
            }
        return a;
    }

    public static void print(int[][] a, PrintStream ps) {
        Formatter f = new Formatter(ps);
        for (int[] ai : a) {
            for (int j : ai) f.format("%d ", j);
            f.format("\n");
        }
    }

    public static void main(String[] args) {
        print(matrixWithMainDiagonals1(7), System.out);
        print(matrixWithMainDiagonals1(0), System.out);
    }
}
