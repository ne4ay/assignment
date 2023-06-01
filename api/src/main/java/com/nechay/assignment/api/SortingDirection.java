package com.nechay.assignment.api;

import javax.annotation.Nonnull;

/**
 * @author onechaev
 */
public enum SortingDirection {
    ASCENDING("Ascending"),
    DESCENDING("Descending")
    ;
    private final String visibleName;

    SortingDirection(@Nonnull String name) {
        this.visibleName = name;
    }

    @Nonnull
    public String getVisibleName() {
        return visibleName;
    }
}
