package com.nechay.assignment.api.student;

import javax.annotation.Nonnull;

/**
 * @author onechaev
 */
public record Student(@Nonnull String name, double score) {

    public String toCsvRow() {
        return name + "," + score;
    }
}
