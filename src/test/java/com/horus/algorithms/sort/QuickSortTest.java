package com.horus.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private QuickSort<String> stringQuickSort = new QuickSort<>();

    @Test
    void sort() {
        String[] values = SortTestDataProvider.stringArray();
        stringQuickSort.sort(values);
        assertTrue(stringQuickSort.isSorted(values), "Array not sorted!!!");
    }
}