package sort.selection;

import org.junit.Test;
import sort.insertion.Insertion;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Andrey on 06.01.2017.
 */
public class SelectionTest {
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
    public void verifiesSelectionSortOfIntArrays() {
        Selection.sort(a1);
        assertsThatArraysAreTheSame(a1, a1Result);
        Selection.sort(a2);
        assertsThatArraysAreTheSame(a2, a2Result);
        Selection.sort(a3);
        assertsThatArraysAreTheSame(a3, a3Result);
        Selection.sort(a4);
        assertsThatArraysAreTheSame(a4, a4Result);
        Selection.sort(a5);
        assertsThatArraysAreTheSame(a5, a5Result);
    }

    private void assertsThatArraysAreTheSame(int[] a1, int[] a1Result) {
        for (int i = 0; i < a1.length; i++) {
            assertThat(a1[i], is(a1Result[i]));
        }
    }
}