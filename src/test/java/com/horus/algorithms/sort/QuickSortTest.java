package com.horus.algorithms.sort;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    private QuickSort<String> stringQuickSort = new QuickSort<>();

    @Test
    void sort() {
        String[] values = SortTestDataProvider.stringArray();
        stringQuickSort.sort(values);
        Assert.assertTrue("Array not sorted!!!", stringQuickSort.isSorted(values));
    }
}