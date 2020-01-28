package com.horus.algorithms.sort;

import java.lang.reflect.Array;

public class MergeSort<V extends Comparable<V>> extends AbstractSort<V> {
   private V[] copy;

    @Override
    protected void sortImpl(V[] values) {
        this.copy = (V[]) new Comparable[values.length];
        sort(values, 0, values.length - 1);
    }

    private void sort(V[] values, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(values, lo, mid);
        sort(values, mid + 1, hi);
        merge(values, lo, mid, hi);
    }

    private void merge(V[] values, int lo, int mid, int hi) {
        int left = lo, right = mid + 1;
        if (hi + 1 - lo >= 0) System.arraycopy(values, lo, copy, lo, hi + 1 - lo);
        for (int i = lo; i <= hi; i++) {
            swapC++;
            if (left > mid) values[i] = copy[right++];
            else if (right > hi) values[i] = copy[left++];
            else if (less(copy[left], copy[right])) values[i] = copy[left++];
            else values[i] = copy[right++];
        }

    }
}
