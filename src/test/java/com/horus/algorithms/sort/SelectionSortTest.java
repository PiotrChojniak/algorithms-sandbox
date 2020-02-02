package com.horus.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    private SelectionSort<String> stringSelectionSort = new SelectionSort<>();

    @Test
    void sortImpl() {
        String[] values = SortTestDataProvider.stringArray();
        stringSelectionSort.sort(values);
        assertTrue(stringSelectionSort.isSorted(values), "Array not sorted!!!");
    }
}