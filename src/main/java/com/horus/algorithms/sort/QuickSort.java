package com.horus.algorithms.sort;

public class QuickSort<V extends Comparable<V>> extends AbstractSort<V> {
    @Override
    protected void sortImpl(V[] values) {
        sortRec(values, 0, values.length - 1);
    }

    private void sortRec(V[] values, int lo, int hi) {
        if (hi <= lo) return;
        int pivotIdx = partition(values, lo, hi);
        sortRec(values, lo, pivotIdx - 1);
        sortRec(values, pivotIdx + 1, hi);
    }

    private int partition(V[] values, int lo, int hi) {
        int left = lo, right = hi + 1;
        V pivot = values[lo];
        while (true) {
            while (less(values[++left], pivot)) if (left == hi) break;
            while (less(pivot, values[--right])) if (right == lo) break;
            if (left >= right) break;
            swap(values, left, right);
        }
        swap(values, lo, right);
        return right;
    }
}
