package com.horus.algorithms.sort;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

    private SelectionSort<String> stringSelectionSort = new SelectionSort<>();

    @Test
    void sortImpl() {
        String[] values = SortTestDataProvider.stringArray();
        stringSelectionSort.sort(values);
        Assert.assertTrue("Array not sorted!!!", stringSelectionSort.isSorted(values));
    }
}