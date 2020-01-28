package com.horus.algorithms.sort;

public class InsertionSort<V extends Comparable<V>> extends AbstractSort<V> {
    @Override
    protected void sortImpl(V[] values) {
        int len = values.length;
        for (int i = 1; i < len; i++)
            for (int j = i; j > 0 && less(values[j], values[j - 1]); j--) {
                swap(values, j, j - 1);
            }
    }
}
