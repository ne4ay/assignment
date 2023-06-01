package com.nechay.assignment.sorter.impl;

import com.nechay.assignment.api.ConcreteSorter;
import com.nechay.assignment.api.SortResult;
import com.nechay.assignment.api.utils.NanoClock;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author onechaev
 */
public class SimpleBubbleSorter extends AbstractTimeMeasuringSorter implements ConcreteSorter {
    public SimpleBubbleSorter(@Nonnull NanoClock nanoClock) {
        super(nanoClock);
    }

    @Nonnull
    @Override
    public <T> CompletableFuture<SortResult<T>> sort(@Nonnull List<T> elements, @Nonnull Comparator<T> comparator) {
        int size = elements.size();
        long startNanos = nanoClock.nanos();
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (comparator.compare(elements.get(j), elements.get(j + 1)) > 0) {
                    T temp = elements.get(j);
                    elements.set(j, elements.get(j + 1));
                    elements.set(j + 1, temp);
                }
            }
        }
        long endNanos = nanoClock.nanos();
        return CompletableFuture.completedFuture(new SortResult<>(elements, endNanos - startNanos));
    }
}
