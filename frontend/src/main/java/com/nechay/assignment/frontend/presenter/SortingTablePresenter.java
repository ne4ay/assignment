package com.nechay.assignment.frontend.presenter;

import com.nechay.assignment.api.SortResult;
import com.nechay.assignment.api.Sorter;
import com.nechay.assignment.api.SortingParams;
import com.nechay.assignment.api.student.Student;
import com.nechay.assignment.frontend.model.FileModel;
import com.nechay.assignment.frontend.view.SortingTableView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.server.AbstractStreamResource;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.frontend.installer.DefaultFileDownloader;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.olli.FileDownloadWrapper;

import javax.annotation.Nonnull;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author onechaev
 */
@SpringComponent
@UIScope
public class SortingTablePresenter {

    private final SortingTableView view;
    private final FileUploadPresenter fileUploadPresenter;
    private final SortingAlgorithmParamsPresenter sortingAlgorithmParamsPresenter;
    private final Sorter sorter;

    public SortingTablePresenter(
        @Autowired SortingTableView view,
        @Autowired FileUploadPresenter fileUploadPresenter,
        @Autowired SortingAlgorithmParamsPresenter sortingAlgorithmParamsPresenter,
        @Autowired Sorter sorter
    )
    {
        this.view = view;
        this.fileUploadPresenter = fileUploadPresenter;
        this.sortingAlgorithmParamsPresenter = sortingAlgorithmParamsPresenter;
        this.sorter = sorter;

        view.onSortButtonClick(this::sort);
    }

    private void sort(ClickEvent<Button> event) {
        Optional<FileModel> maybeFileModel = fileUploadPresenter.getFileModel();
        if (maybeFileModel.isEmpty()) {
            view.showError("The file is not uploaded!");
            return;
        }
        FileModel model = maybeFileModel.get();
        SortingParams<Student> sortingParams = sortingAlgorithmParamsPresenter.getSortingParams();
        List<Student> students;
        try {
            students = deserialize(model.getContent());
        } catch (Throwable t) {
            view.showError("Unable to parse the file: the content is corrupted.");
            return;
        }
        SortResult<Student> result = sorter.sort(students, sortingParams).join();

        prepareDownloadButton(result.resultCollection());
        view.showResultTable(result);
    }

    private void prepareDownloadButton(@Nonnull List<Student> students) {
        StreamResource resource = new StreamResource("sorting_result.csv", () -> createInputStream(students));
        FileDownloadWrapper buttonWrapper = new FileDownloadWrapper(resource);
        view.addDownloadWrapper(buttonWrapper);
    }

    private InputStream createInputStream(@Nonnull List<Student> students) {
        String serialized = serialize(students);
        return new ByteArrayInputStream(serialized.getBytes(StandardCharsets.UTF_8));
    }


    private String serialize(@Nonnull List<Student> students) {
        return students.stream()
            .map(Student::toCsvRow)
            .collect(Collectors.joining("\n"));
    }

    @Nonnull
    private List<Student> deserialize(@Nonnull String text) {
        return Arrays.stream(text.split("\n"))
            .map(line -> line.split(","))
            .map(columns -> new Student(columns[0], Double.parseDouble(columns[1])))
            .collect(Collectors.toList());
    }

}
