package com.horus.algorithms.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HeapSortTest {

    @ParameterizedTest(name = "{index} {0}")
    @MethodSource("provideSortInstanceAndValues")
    void sort(AbstractSort<String> stringHeapSort, String[] values) {
        stringHeapSort.sort(values);
        assertTrue(stringHeapSort.isSorted(values), "Array not sorted!!!");
    }

    static Stream<Arguments> provideSortInstanceAndValues() {
        return Stream.of(
                Arguments.of(new HeapSort<String>(), SortTestDataProvider.stringArray()),
                Arguments.of(new HeapSortRec<String>(), SortTestDataProvider.stringArray()),
                Arguments.of(new HeapSort<String>(), "I J H G F E D C B A".split(" ")),
                Arguments.of(new HeapSort<String>(), "A B C D E F G H I J".split(" ")),
                Arguments.of(new HeapSortRec<String>(), "I J H G F E D C B A".split(" ")),
                Arguments.of(new HeapSortRec<String>(), "A B C D E F G H I J".split(" "))
        );
    }

}
