package com.horus.algorithms.searching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTreeTest {

    @ParameterizedTest(name = "{index}: {0} get({1}) = {2}")
    @MethodSource("testPutAndGet")
    void testPutAndGet(char[] chars, Character key, Integer solution) {
        BinarySearchTree<Character, Integer> bst = new BinarySearchTree<>();
        int i = 0;
        for (Character c : chars) {
            bst.put(c, i++);
        }
        Integer result = bst.get(key);
        assertEquals(solution, result, "Wrong solution!!!");
    }

    static Stream<Arguments> testPutAndGet() {
        return Stream.of(
                Arguments.of("qwertyuiopasdfghjklzxcvbnm".toCharArray(), 'j', 16),
                Arguments.of("qwertyuiopasdfghjklzxcvbnm".toCharArray(), 'z', 19),
                Arguments.of("qwertyuiopasdfghjklzxcvbnm".toCharArray(), 'q', 0),
                Arguments.of("qwertyuiopasdfghjklzxcvbnm".toCharArray(), '1', null)
        );
    }

    @ParameterizedTest(name = "{index}: {0} floor({1}) = {2} ceiling({1}) = {3}")
    @MethodSource("testFloorAndCeiling")
    void testFloorAndCeiling(int[] ints, Integer key, Integer floor, Integer ceiling) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        int i = 0;
        for (Integer number : ints) {
            bst.put(number, i++);
        }
        Integer result = bst.floor(key);
        assertEquals(floor, result, "Wrong floor!!!");
        result = bst.ceiling(key);
        assertEquals(ceiling, result, "Wrong ceiling!!!");
    }

    static Stream<Arguments> testFloorAndCeiling() {
        return Stream.of(
                Arguments.of(new int[]{1, 13, 5, 17, 9}, 2, 1, 5),
                Arguments.of(new int[]{15, 17, 13, 19, 11}, 1, null, 11),
                Arguments.of(new int[]{15, 17, 13, 19, 11}, 21, 19, null),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 2, 1, 3),
                Arguments.of(new int[]{5, 7, 3, 9, 1}, 2, 1, 3),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 3, 3, 3),
                Arguments.of(new int[]{5, 7, 3, 9, 1}, 7, 7, 7),
                Arguments.of(new int[]{1, 3, 5, 7, 9}, 8, 7, 9),
                Arguments.of(new int[]{5, 7, 3, 9, 1}, 8, 7, 9)
        );
    }

    @ParameterizedTest(name = "{index}: {0} rank({1}) = {2}")
    @MethodSource("testRank")
    void testRank(int[] ints, Integer key, Integer rank) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        int i = 0;
        for (Integer number : ints) {
            bst.put(number, i++);
        }
        Integer result = bst.rank(key);
        assertEquals(rank, result, "Wrong rank!!!");
    }

    static Stream<Arguments> testRank() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 1, 0),
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 9, 2),
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 15, 5),
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 17, 6),
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 18, 7)
        );
    }

    @ParameterizedTest(name = "{index}: {0} select({1}) = {2}")
    @MethodSource("testSelect")
    void testSelect(int[] ints, Integer key, Integer select) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        int i = 0;
        for (Integer number : ints) {
            bst.put(number, i++);
        }
        Integer result = bst.select(key);
        assertEquals(select, result, "Wrong select!!!");
    }

    static Stream<Arguments> testSelect() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 0, 1),
                Arguments.of(new int[]{17, 11, 5, 15, 1, 9, 13}, 0, 1),
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 2, 9),
                Arguments.of(new int[]{17, 11, 5, 15, 1, 9, 13}, 2, 9),
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 5, 15),
                Arguments.of(new int[]{17, 11, 5, 15, 1, 9, 13}, 5, 15),
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 6, 17),
                Arguments.of(new int[]{17, 11, 5, 15, 1, 9, 13}, 6, 17),
                Arguments.of(new int[]{17, 11, 5, 15, 1, 9, 13}, 7, null)
        );
    }

    @ParameterizedTest(name = "{index}: {0} min() = {1} max() = {2}")
    @MethodSource("testMinAndMax")
    void testMinAndMax(int[] ints, Integer min, Integer max) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        int i = 0;
        for (Integer number : ints) {
            bst.put(number, i++);
        }
        Integer result = bst.min();
        assertEquals(min, result, "Wrong min!!!");
        result = bst.max();
        assertEquals(max, result, "Wrong max!!!");
    }

    static Stream<Arguments> testMinAndMax() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 9, 11, 13, 15, 17}, 1, 17),
                Arguments.of(new int[]{17, 11, 5, 15, 1, 9, 13}, 1, 17),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 100}, 1, 100),
                Arguments.of(new int[]{99, 98, 91, 92, 93, 94, 95, 100}, 91, 100)
        );
    }
}
