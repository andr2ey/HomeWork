package sort.quick;

import org.junit.Test;
import sort.selection.Selection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 07.01.2017.
 */
public class QuickTest {
    int[] a1 = {};
    int[] a1Result = {};

    int[] a2 = {1};
    int[] a2Result = {1};

    int[] a3 = {2, 1};
    int[] a3Result = {1, 2};

    int[] a4 = {2, 3, 1};
    int[] a4Result = {1, 2, 3};

    int[] a5 = {5, 1, 2, 2, 2, 34, 34, 4};
    int[] a5Result = {1, 2, 2, 2, 4, 5, 34, 34};

    @Test
    public void verifiesQuickSortOfIntArrays() {
        Quick.sort(a1, 0, a1.length-1);
        assertsThatArraysAreTheSame(a1, a1Result);
        Quick.sort(a2, 0, a2.length-1);
        assertsThatArraysAreTheSame(a2, a2Result);
        Quick.sort(a3, 0, a3.length-1);
        assertsThatArraysAreTheSame(a3, a3Result);
        Quick.sort(a4, 0, a4.length-1);
        assertsThatArraysAreTheSame(a4, a4Result);
        Quick.sort(a5, 0, a5.length-1);
        assertsThatArraysAreTheSame(a5, a5Result);
    }

    private void assertsThatArraysAreTheSame(int[] a1, int[] a1Result) {
        for (int i = 0; i < a1.length; i++) {
            assertThat(a1[i], is(a1Result[i]));
        }
    }
}