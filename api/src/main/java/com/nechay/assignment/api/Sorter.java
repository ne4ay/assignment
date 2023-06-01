package com.nechay.assignment.api;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Context of a strategy pattern
 *
 * @author onechaev
 */
public interface Sorter {
    @Nonnull
    <T> CompletableFuture<SortResult<T>> sort(@Nonnull List<T> elements, @Nonnull SortingParams<T> params);
}
