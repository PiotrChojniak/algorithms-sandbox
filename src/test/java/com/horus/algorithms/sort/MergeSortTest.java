package com.horus.algorithms.sort;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MergeSortTest {

    private MergeSort<String> stringMergeSort = new MergeSort<>();

    @Test
    void sort() {
        String[] values = SortTestDataProvider.stringArray();
        stringMergeSort.sort(values);
        Assert.assertTrue("Array not sorted!!!", stringMergeSort.isSorted(values));
    }
}