package com.horus.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    private InsertionSort<String> stringInsertionSort = new InsertionSort<>();

    @Test
    void sort() {
        String[] values = SortTestDataProvider.stringArray();
        stringInsertionSort.sort(values);
        assertTrue(stringInsertionSort.isSorted(values), "Array not sorted!!!");
    }
}