package com.horus.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortTestDataProvider {
    private static String TEST_DATA_SMALL_SAMPLE_FILE_NAME = "test_data.txt";
    private static String[] values;

    public static String[] stringArray() {
        if (values != null)
            return Arrays.copyOf(values, values.length);
        Scanner scanner = new Scanner(ClassLoader.getSystemResourceAsStream(TEST_DATA_SMALL_SAMPLE_FILE_NAME));
        List<String> input = new ArrayList<>();
        while (scanner.hasNext()) {
            input.add(scanner.next());
        }
        values = input.toArray(new String[0]);
        return Arrays.copyOf(values, values.length);
    }
}
