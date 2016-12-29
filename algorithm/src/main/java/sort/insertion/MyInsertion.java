package sort.insertion;

import java.util.Arrays;

/**
 * Created by Andrey on 29.12.2016.
 */
public class MyInsertion {

    public static void mySort(int[] array) {
        int N = array.length;
        if (N < 2)
            return;
        int previousMaxVal = Integer.MIN_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            int maxVal = array[i];
            if (previousMaxVal == maxVal)
                continue;
            int maxValIndex = i;
            for (int j = i; j >= 0; j--) {
                int val = array[j];
                if (val > maxVal) {
                    maxVal = val;
                    maxValIndex = j;
                }
            }
            previousMaxVal = maxVal;
            if (maxValIndex == i)
                continue;
            int tmp = array[i];
            array[i] = maxVal;
            array[maxValIndex] = tmp;
        }
    }

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            final int val = a[i];
            for (int j = i - 1; j >= 0 && val < a[j]; j--) {
                swap(a, j, val);
            }
        }
    }

    private static void swap(int[] a, int i, int val) {
        int tmp = a[i];
        a[i] = val;
        a[i + 1] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {44, 11, 1, 2, 4, 1, 5, 44};
        sort(a);
        System.out.println(Arrays.toString(a));

        int[] a1 = {44};
        sort(a1);
        System.out.println(Arrays.toString(a1));

        int[] a2 = {};
        sort(a2);
        System.out.println(Arrays.toString(a2));
    }
}
