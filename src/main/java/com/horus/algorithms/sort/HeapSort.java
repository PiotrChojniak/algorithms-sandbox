package com.horus.algorithms.sort;

public class HeapSort<V extends Comparable<V>> extends AbstractSort<V> {
    @Override
    protected void sortImpl(V[] values) {
        int len = values.length;
        for (int k = len / 2 - 1; k >= 0; k--)
            sink(values, k, len - 1);
        while (len >= 1) {
            swap(values, 0, --len);
            sink(values, 0, len - 1);
        }
    }

    private void sink(V[] values, int i, int len) {
        while (left(i) <= len) {
            int left = left(i);
            if (left < len && less(values[left], values[left + 1])) left++;
            if (!less(values[i], values[left])) break;
            swap(values, i, left);
            i = left;
        }
    }

    private int left(int i) {
        return 2 * i + 1;
    }

}
