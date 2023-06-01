package com.nechay.assignment.api;

import javax.annotation.Nonnull;

/**
 * @author onechaev
 */
public enum SortingAlgorithm {
    BUBBLE_SORT("Bubble sort"),
    HEAP_SORT("Heap sort"),
    MERGE_SORT("Merge sort")
    ;
    private final String visibleName;

    SortingAlgorithm(@Nonnull String name) {
        this.visibleName = name;
    }

    @Nonnull
    public String getVisibleName() {
        return visibleName;
    }
}
