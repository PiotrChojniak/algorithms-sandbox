package com.horus.algorithms.sort;

public class ShellSort<V extends Comparable<V>> extends AbstractSort<V> {
    private int step;

    public ShellSort(int step) {
        this.step = step;
    }

    @Override
    protected void sortImpl(V[] values) {
        int len = values.length;
        int offset = 1;
        while (offset < len / step) offset = offset * step + 1;
        while (offset >= 1) {
            for (int i = offset; i < len; i++)
                for (int j = i; j >= offset && less(values[j], values[j - offset]); j -= offset) {
                    swap(values, j, j - offset);
                }
            offset /= step;
        }
    }
}
