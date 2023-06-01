package com.nechay.assignment.sorter.impl;

import com.nechay.assignment.api.Sorter;
import com.nechay.assignment.api.SorterFactory;
import com.nechay.assignment.api.student.Student;

/**
 * @author onechaev
 */
public class StudentSimpleSorterFactory implements SorterFactory<Student> {


    @Override
    public Sorter<Student> createSorter() {
        return null;
    }
}
