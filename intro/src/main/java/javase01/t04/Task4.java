package javase01.t04;

import java.util.Arrays;

public class Task4 {

    public static double searchMax(double[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        if (array.length == 0) {
            throw new EmptyArrayException();
        }
        if (array.length == 1) {
            return array[0];
        }
        return algorithm(array);
    }

    public static double algorithm(double[] array) {
        double maxValue = Double.MIN_VALUE;
        double currentValue = 0;
        int N = array.length;

        for (int i = 0; i < N/2; i++) {
            currentValue = array[i] + array[N-1-i];
            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
        }
        if (N % 2 != 0) {
            double centreValue = array[N/2];
            if (centreValue > maxValue) {
                maxValue = centreValue;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        double[] a = new double[9];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(searchMax(a));
    }
}

