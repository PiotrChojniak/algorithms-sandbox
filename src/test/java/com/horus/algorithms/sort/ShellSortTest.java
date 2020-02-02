package com.horus.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ShellSortTest {
    private ShellSort<String> stringShellSort = new ShellSort<>(5);

    @Test
    void sort() {
        String[] values = SortTestDataProvider.stringArray();
        stringShellSort.sort(values);
        assertTrue(stringShellSort.isSorted(values), "Array not sorted!!!");
    }
}