package com.nechay.assignment.api;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author onechaev
 */
public record SortResult<T>(@Nonnull List<T> resultCollection, long durationNanos) {
}
