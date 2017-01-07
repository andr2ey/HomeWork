package sort.selection;

/**
 * Created by Andrey on 06.01.2017.
 */
public class Selection {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int least = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[least]) {
                    least = j;
                }
            }
            int tmp = a[least];
            a[least] = a[i];
            a[i] = tmp;
        }
    }

}
