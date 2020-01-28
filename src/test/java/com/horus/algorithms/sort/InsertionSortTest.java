package com.horus.algorithms.sort;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

    private InsertionSort<String> stringInsertionSort = new InsertionSort<>();

    @Test
    void sort() {
        String[] values = SortTestDataProvider.stringArray();
        stringInsertionSort.sort(values);
        Assert.assertTrue("Array not sorted!!!", stringInsertionSort.isSorted(values));
    }
}