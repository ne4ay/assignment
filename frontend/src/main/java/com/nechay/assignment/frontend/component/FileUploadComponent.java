package com.nechay.assignment.frontend.component;

import com.nechay.assignment.frontend.presenter.FileUploadPresenter;
import com.nechay.assignment.frontend.view.FileUploadView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author onechaev
 */
@Tag("FileUploadComponent")
@SpringComponent
@UIScope
public class FileUploadComponent extends Component {

    private final FileUploadView view;
    private final FileUploadPresenter presenter;

    public FileUploadComponent(@Autowired FileUploadView view, @Autowired FileUploadPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public Element getElement() {
        return view.getElement();
    }
}
