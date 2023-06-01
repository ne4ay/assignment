package com.nechay.assignment.sorter.impl;

import com.nechay.assignment.api.Sorter;
import com.nechay.assignment.api.SorterFactory;

/**
 * @author onechaev
 */
public class SimpleSorterFactory implements SorterFactory {
    @Override
    public Sorter createSorter() {
        return new SimpleSorter();
    }
}
