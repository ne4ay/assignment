package com.nechay.assignment.api.student;

import javax.annotation.Nonnull;
import java.util.Comparator;

/**
 * @author onechaev
 */
public enum StudentValueMapper {
    BY_NAME("By name", Comparator.comparing(Student::name)),
    BY_SCORE("By score", Comparator.comparingDouble(Student::score))
    ;

    private final String name;
    private final Comparator<Student> comparator;

    StudentValueMapper(@Nonnull String name, @Nonnull Comparator<Student> comparator) {
        this.name = name;
        this.comparator = comparator;
    }

    public String getName() {
        return name;
    }

    public Comparator<Student> getComparator() {
        return comparator;
    }
}
