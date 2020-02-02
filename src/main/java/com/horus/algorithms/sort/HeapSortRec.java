package com.horus.algorithms.sort;

public class HeapSortRec<V extends Comparable<V>> extends AbstractSort<V> {
    @Override
    protected void sortImpl(V[] values) {
        int len = values.length;
        for (int i = len / 2 - 1; i >= 0; i--)
            heapify(values, len, i);
        for (int i = len - 1; i >= 0; i--) {
            swap(values, 0, i);
            heapify(values, i, 0);
        }
    }


    private void heapify(V[] values, int len, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < len && less(values[largest], values[l]))
            largest = l;

        if (r < len && less(values[largest], values[r]))
            largest = r;

        if (largest != i) {
            swap(values, i, largest);
            heapify(values, len, largest);
        }
    }
}
