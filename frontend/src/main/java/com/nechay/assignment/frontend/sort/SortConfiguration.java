package com.nechay.assignment.frontend.sort;

import com.nechay.assignment.api.Sorter;
import com.nechay.assignment.sorter.impl.SimpleSorterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author onechaev
 */
@Configuration
public class SortConfiguration {

    @Bean
    public Sorter sorter() {
        return new SimpleSorterFactory().createSorter();
    }
}
