package com.nechay.assignment.frontend.view;

import com.nechay.assignment.api.SortingAlgorithm;
import com.nechay.assignment.api.SortingDirection;
import com.nechay.assignment.api.student.StudentValueMapper;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.Nonnull;

/**
 * @author onechaev
 */
@SpringComponent
@UIScope
public class SortingAlgorithmParamsView extends VerticalLayout {
    private final ComboBox<SortingAlgorithm> algorithmComboBox = new ComboBox<>("Algorithm");
    private final ComboBox<SortingDirection> sortingDirectionComboBox = new ComboBox<>("Direction");
    private final ComboBox<StudentValueMapper> valueMapperComboBox = new ComboBox<>("Order by");

    public SortingAlgorithmParamsView() {
        algorithmComboBox.setItems(SortingAlgorithm.values());
        algorithmComboBox.setItemLabelGenerator(SortingAlgorithm::getVisibleName);
        algorithmComboBox.setValue(SortingAlgorithm.BUBBLE_SORT); // default value
        add(algorithmComboBox);

        sortingDirectionComboBox.setItems(SortingDirection.values());
        sortingDirectionComboBox.setItemLabelGenerator(SortingDirection::getVisibleName);
        sortingDirectionComboBox.setValue(SortingDirection.ASCENDING);
        add(sortingDirectionComboBox);

        valueMapperComboBox.setItems(StudentValueMapper.values());
        valueMapperComboBox.setItemLabelGenerator(StudentValueMapper::getName);
        valueMapperComboBox.setValue(StudentValueMapper.BY_SCORE);
        add(valueMapperComboBox);
    }

    @Nonnull
    public ComboBox<SortingAlgorithm> getAlgorithmComboBox() {
        return algorithmComboBox;
    }

    @Nonnull
    public ComboBox<SortingDirection> getSortingDirectionComboBox() {
        return sortingDirectionComboBox;
    }

    @Nonnull
    public ComboBox<StudentValueMapper> getValueMapperComboBox() {
        return valueMapperComboBox;
    }
}
