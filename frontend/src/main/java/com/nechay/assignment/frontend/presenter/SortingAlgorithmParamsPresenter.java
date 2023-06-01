package com.nechay.assignment.frontend.presenter;

import com.nechay.assignment.api.SortingParams;
import com.nechay.assignment.api.student.Student;
import com.nechay.assignment.frontend.view.SortingAlgorithmView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author onechaev
 */
@Component
public class SortingAlgorithmPresenter {

    private final SortingAlgorithmView view;

    public SortingAlgorithmPresenter(@Autowired SortingAlgorithmView view) {
        this.view = view;
    }

    public SortingParams<Student> getSortingParams() {
        return new SortingParams<>(
            view.getAlgorithmComboBox().getValue(),
            view.getSortingDirectionComboBox().getValue(),
            view.getValueMapperComboBox().getValue().getComparator()
        );
    }
}
