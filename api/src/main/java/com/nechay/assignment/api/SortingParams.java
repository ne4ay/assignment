package com.nechay.assignment.api;

import javax.annotation.Nonnull;
import java.util.Comparator;

/**
 * @author onechaev
 */
public record SortingParams<T> (
    @Nonnull SortingAlgorithm algorithm,
    @Nonnull SortingDirection direction,
    @Nonnull Comparator<T> comparator)
{
}
