package javase01.t04;

import java.util.Arrays;

public class Task4 {

    private static double algorithm(double[] array) {
        if (array == null)
            throw new NullPointerException();
        if (array.length % 2 != 0)
            throw new IllegalArgumentException("Array length must be only even");
        int N = array.length;
        double max = Double.MIN_VALUE;
        double current;
        for (int i = 0; i < N/2; i++) {
            current = array[i] + array[N-1-i];
            if (current > max)
                max = current;
        }
        return max;
    }

    public static void main(String[] args) {
        double[] a = new double[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random()*10;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(algorithm(a));
    }
}

