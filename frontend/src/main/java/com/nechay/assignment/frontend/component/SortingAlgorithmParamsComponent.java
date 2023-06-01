package com.nechay.assignment.frontend.component;

import com.nechay.assignment.frontend.presenter.SortingAlgorithmParamsPresenter;
import com.nechay.assignment.frontend.view.SortingAlgorithmParamsView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author onechaev
 */
@Tag("SortingAlgorithmParamsComponent")
@SpringComponent
@UIScope
public class SortingAlgorithmParamsComponent extends Component {

    private final SortingAlgorithmParamsView view;
    private final SortingAlgorithmParamsPresenter presenter;

    public SortingAlgorithmParamsComponent(@Autowired SortingAlgorithmParamsView view, @Autowired SortingAlgorithmParamsPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public Element getElement() {
        return view.getElement();
    }
}
