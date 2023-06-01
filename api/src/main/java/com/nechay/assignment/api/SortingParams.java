package com.nechay.assignment.api;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author onechaev
 */
public record SortingInfo<T, R extends Comparable<R>>(
    @Nonnull SortingAlgorithm algorithm,
    @Nonnull SortingDirection direction,
    @Nonnull Function<T, R> sortingFieldExtractor)
{
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SortingInfo<?, ?> that))
            return false;
        return algorithm == that.algorithm && direction == that.direction && sortingFieldExtractor.equals(that.sortingFieldExtractor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithm, direction, sortingFieldExtractor);
    }
}
