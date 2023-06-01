package com.nechay.assignment.sorter.impl;

import com.nechay.assignment.api.ConcreteSorter;
import com.nechay.assignment.api.SortResult;
import com.nechay.assignment.api.utils.NanoClock;
import com.nechay.assignment.sorter.impl.auxiliary.Heap;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author onechaev
 */
public class SimpleHeapSorter extends AbstractTimeMeasuringSorter implements ConcreteSorter {
    public SimpleHeapSorter(@Nonnull NanoClock nanoClock) {
        super(nanoClock);
    }

    @Nonnull
    @Override
    public <T> CompletableFuture<SortResult<T>> sort(@Nonnull List<T> elements, @Nonnull Comparator<T> comparator) {
        long startNano = nanoClock.nanos();
        List<T> result = Heap.sort(elements, comparator);
        long endNano = nanoClock.nanos();
        return CompletableFuture.completedFuture(new SortResult<>(result, endNano - startNano));
    }
}
