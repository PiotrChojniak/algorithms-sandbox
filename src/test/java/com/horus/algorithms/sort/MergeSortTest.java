package com.horus.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    private MergeSort<String> stringMergeSort = new MergeSort<>();

    @Test
    void sort() {
        String[] values = SortTestDataProvider.stringArray();
        stringMergeSort.sort(values);
        assertTrue(stringMergeSort.isSorted(values), "Array not sorted!!!");
    }
}