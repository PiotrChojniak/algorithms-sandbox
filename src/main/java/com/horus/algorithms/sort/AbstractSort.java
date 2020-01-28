package com.horus.algorithms.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public abstract class AbstractSort<V extends Comparable<V>> {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private int lessC = 0;
    private int swapC = 0;

    public void sort(V[] values) {
        logger.debug("starting {}", getClass().getSimpleName());
        logger.debug("Source array: {}", Arrays.toString(values));
        sortImpl(values);
        logger.debug("Sorted array: {}", Arrays.toString(values));
        logger.debug("Operations sum: {},  less: {}, swap: {}", lessC + swapC, lessC, swapC);
    }

    boolean isSorted(V[] values) {
        for (int i = 1; i < values.length; i++) {
            if (less(values[i], values[i - 1])) return false;
        }
        return true;
    }

    public void show(V[] a) {
        logger.info(Arrays.toString(a));
    }

    boolean less(V v1, V v2) {
        lessC++;
        return v1.compareTo(v2) < 0;
    }

    void swap(V[] values, int i, int j) {
        swapC++;
        V tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    protected abstract void sortImpl(V[] values);

}
