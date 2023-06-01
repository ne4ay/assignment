package com.nechay.assignment.frontend.presenter;

import com.nechay.assignment.api.SortingParams;
import com.nechay.assignment.api.student.Student;
import com.nechay.assignment.frontend.view.SortingAlgorithmParamsView;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author onechaev
 */
@SpringComponent
@UIScope
public class SortingAlgorithmParamsPresenter {

    private final SortingAlgorithmParamsView view;

    public SortingAlgorithmParamsPresenter(@Autowired SortingAlgorithmParamsView view) {
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
