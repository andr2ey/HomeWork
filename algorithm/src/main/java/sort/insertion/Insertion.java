package sort.insertion;

import java.util.Arrays;

/**
 * Created by Andrey on 29.12.2016.
 */
public class Insertion {

    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j+1] < a[j]; j--) {
                swap(a, j);
            }
        }
    }

    private static void swap(int[] a, int i) {
        int tmp = a[i];
        a[i] = a[i + 1];
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
