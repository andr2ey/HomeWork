package sort.quick;

/**
 * Created by Andrey on 07.01.2017.
 */
public class Quick {

    public static void sort(int[] a, int begin, int end) {
        if (a.length < 2) {
            return;
        }
        int left = begin;
        int right = end;
        int pivot = (a[(left + right) / 2] + a[left] + a[right]) / 3;
        while (left <= right) {
            while (a[left] < pivot)
                left++;
            while (a[right] > pivot)
                right--;
            if (left <= right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
                left++;
                right--;
            }
        }
        if (end > left)
            sort(a, left, end);
        if (begin < right)
            sort(a, begin, right);
    }



}
