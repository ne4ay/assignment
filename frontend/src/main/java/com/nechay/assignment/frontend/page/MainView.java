package com.nechay.assignment.frontend.page;

import com.nechay.assignment.frontend.component.FileUploadComponent;
import com.nechay.assignment.frontend.component.SortingAlgorithmParamsComponent;
import com.nechay.assignment.frontend.component.SortingTableComponent;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author onechaev
 */
@PageTitle("Main")
@Route(value = "")
public class MainView extends HorizontalLayout {
    private final VerticalLayout leftBar = new VerticalLayout();
    private final VerticalLayout rightBar = new VerticalLayout();

    public MainView(
        @Autowired FileUploadComponent fileUploadComponent,
        @Autowired SortingAlgorithmParamsComponent sortingParamsComponent,
        @Autowired SortingTableComponent sortingTableComponent
    ) {
        setMargin(true);
        setAlignItems(Alignment.START);

        leftBar.setWidth(30f, Unit.PERCENTAGE);
        rightBar.setJustifyContentMode(JustifyContentMode.START);
        rightBar.setMinHeight(100f, Unit.PERCENTAGE);

        leftBar.add(fileUploadComponent, sortingParamsComponent);
        rightBar.add(sortingTableComponent);

        add(leftBar, rightBar);
    }

}

