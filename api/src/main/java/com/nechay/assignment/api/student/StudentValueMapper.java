package com.nechay.assignment.api.student;

import javax.annotation.Nonnull;
import java.util.function.Function;

/**
 * @author onechaev
 */
public enum StudentValueMappers {
    BY_NAME("By name", ),
    BY_SCORE("By score", );

    private final String name;
    private final Function<Student, ? extends Comparable<?>> valueExtractor;

    StudentValueMappers(@Nonnull String name, @Nonnull Function<Student, ? extends Comparable<?>> valueExtractor) {
        this.name = name;
        this.valueExtractor = valueExtractor;
    }
}
