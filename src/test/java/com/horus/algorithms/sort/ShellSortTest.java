package com.horus.algorithms.sort;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ShellSortTest {
    private ShellSort<String> stringShellSort = new ShellSort<>(5);

    @Test
    void sort() {
        String[] values = SortTestDataProvider.stringArray();
        stringShellSort.sort(values);
        Assert.assertTrue("Array not sorted!!!", stringShellSort.isSorted(values));
    }
}