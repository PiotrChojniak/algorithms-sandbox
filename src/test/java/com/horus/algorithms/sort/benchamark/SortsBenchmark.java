package com.horus.algorithms.sort.benchamark;

import com.horus.algorithms.sort.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Thread)
@Fork(value = 2, jvmArgs = {"-Xms1G", "-Xmx1G"})
public class SortsBenchmark {

    private SelectionSort<String> stringSelectionSort;
    private InsertionSort<String> stringInsertionSort;
    private ShellSort<String> stringShellSort;
    private MergeSort<String> stringMergeSort;
    private QuickSort<String> stringQuickSort;
    private String[] values;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(SortsBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup(Level.Invocation)
    public void setup() {
        stringShellSort = new ShellSort<>(5);
        stringInsertionSort = new InsertionSort<>();
        stringSelectionSort = new SelectionSort<>();
        stringMergeSort = new MergeSort<>();
        stringQuickSort = new QuickSort<>();
        values = SortTestDataProvider.stringArray();
    }

    @Benchmark
    public void shellSort() {
        stringShellSort.sort(values);
    }

    @Benchmark
    public void selectionSort() {
        stringSelectionSort.sort(values);
    }

    @Benchmark
    public void insertionSort() {
        stringInsertionSort.sort(values);
    }

    @Benchmark
    public void mergeSort() {
        stringMergeSort.sort(values);
    }

    @Benchmark
    public void quickSort() {
        stringQuickSort.sort(values);
    }
}
