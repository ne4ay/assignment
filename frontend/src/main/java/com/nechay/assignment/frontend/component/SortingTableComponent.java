package com.nechay.assignment.frontend.component;

import com.nechay.assignment.frontend.presenter.SortingTablePresenter;
import com.nechay.assignment.frontend.view.SortingTableView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author onechaev
 */
@Tag("SortingTableComponent")
@SpringComponent
@UIScope
public class SortingTableComponent extends Component {

    private final SortingTableView view;
    private final SortingTablePresenter presenter;

    public SortingTableComponent(@Autowired SortingTableView view, @Autowired SortingTablePresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public Element getElement() {
        return view.getElement();
    }
}
