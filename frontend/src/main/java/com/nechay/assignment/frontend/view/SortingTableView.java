package com.nechay.assignment.frontend.view;

import com.nechay.assignment.api.SortResult;
import com.nechay.assignment.api.student.Student;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.vaadin.olli.FileDownloadWrapper;

import javax.annotation.Nonnull;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author onechaev
 */
@SpringComponent
@UIScope
public class SortingTableView extends VerticalLayout {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm:ss.nnnnnnnnn");

    private final Button sortButton = new Button("Sort");

    private final Grid<Student> grid = new Grid<>(Student.class, false);
    private final Paragraph numberOfRecordsParagraph = new Paragraph();
    private final Paragraph sortingTimeParagraph = new Paragraph();
    private final Button downloadButton = new Button("Download result");

    private FileDownloadWrapper fileDownloadWrapper = null;
    private boolean isShown = false;

    public SortingTableView() {
        sortButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        downloadButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(sortButton);

        grid.addColumn(Student::name).setHeader("Name");
        grid.addColumn(Student::score).setHeader("Score");
    }

    public Registration onSortButtonClick(@Nonnull ComponentEventListener<ClickEvent<Button>> listener) {
        return sortButton.addClickListener(listener);
    }

    public void addDownloadWrapper(@Nonnull FileDownloadWrapper wrapper) {
        if (this.fileDownloadWrapper != null) {
            remove(fileDownloadWrapper);
        }
        wrapper.wrapComponent(downloadButton);
        add(wrapper);
    }


    public void showError(String text) {
        Notification notification = Notification.show(text);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    }

    public void showResultTable(@Nonnull SortResult<Student> sortResult) {
        List<Student> students = sortResult.resultCollection();
        grid.setItems(students);

        numberOfRecordsParagraph.setText("Number of records: " + students.size());
        sortingTimeParagraph.setText("Sorting time: " + nanosToFormat(sortResult.durationNanos()));
        if (isShown) {
            return;
        }
        isShown = true;
        add(grid);
        add(numberOfRecordsParagraph);
        add(sortingTimeParagraph);
        add(downloadButton);
    }

    private String nanosToFormat(long nanos) {
        return FORMATTER.format(nanosToLocalTime(nanos));
    }

    private LocalTime nanosToLocalTime(long nanos) {
        return LocalTime.ofNanoOfDay(nanos);
    }
}
