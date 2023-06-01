package com.nechay.assignment.api;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Common interface for sort strategy
 *
 * @author onechaev
 */
public interface ConcreteSorter {
    @Nonnull
    <T> CompletableFuture<SortResult<T>> sort(@Nonnull List<T> elements, @Nonnull Comparator<T> comparator);

}
