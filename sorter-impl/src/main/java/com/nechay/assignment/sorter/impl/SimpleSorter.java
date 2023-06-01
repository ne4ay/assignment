package com.nechay.assignment.sorter.impl;

import com.nechay.assignment.api.ConcreteSorter;
import com.nechay.assignment.api.SortResult;
import com.nechay.assignment.api.Sorter;
import com.nechay.assignment.api.SortingAlgorithm;
import com.nechay.assignment.api.SortingParams;
import com.nechay.assignment.api.utils.NanoClock;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author onechaev
 */
public class SimpleSorter implements Sorter {
    private static final NanoClock CLOCK = NanoClock.systemUTC();

    @Nonnull
    @Override
    public <T> CompletableFuture<SortResult<T>> sort(@Nonnull List<T> elements, @Nonnull SortingParams<T> params) {
        SortingAlgorithm algorithm = params.algorithm();
        ConcreteSorter sorter = switch (algorithm) {
            case HEAP_SORT -> new SimpleHeapSorter(CLOCK);
            case MERGE_SORT -> new SimpleMergeSorter(CLOCK);
            case BUBBLE_SORT -> new SimpleBubbleSorter(CLOCK);
            default -> {throw new IllegalStateException("Unknown sorting type" + algorithm);}
        };
        Comparator<T> comparator = switch (params.direction()) {
            case ASCENDING -> params.comparator();
            case DESCENDING -> params.comparator().reversed();
            default -> {throw new IllegalStateException("Unknown direction" + params.direction());}
        };
        return sorter.sort(new ArrayList<>(elements), comparator);
    }
}
