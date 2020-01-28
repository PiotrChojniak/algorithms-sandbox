package com.horus.algorithms.sort;

public class SelectionSort<V extends Comparable<V>> extends AbstractSort<V> {
    @Override
    protected void sortImpl(V[] values) {
        int len = values.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = min + 1; j < len; j++) {
                if (less(values[j], values[min])) min = j;
            }
            swap(values, i, min);
        }
    }

}
