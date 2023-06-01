package com.nechay.assignment.frontend.presenter;

import com.nechay.assignment.frontend.model.FileModel;
import com.nechay.assignment.frontend.view.FileUploadView;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * @author onechaev
 */
@SpringComponent
@UIScope
public class FileUploadPresenter {

    private final FileUploadView view;
    @Nullable private volatile FileModel fileModel;

    public FileUploadPresenter(@Autowired FileUploadView view) {
        this.view = view;

        view.addSucceededListener(this::onFileDownloaded);
    }

    public Optional<FileModel> getFileModel() {
        return Optional.ofNullable(fileModel);
    }

    private void onFileDownloaded(@Nonnull SucceededEvent event, @Nonnull InputStream inputStream) {
        String text;
        try (inputStream) {
            text = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            view.showError();
            return;
        }
        this.fileModel = FileModel.create(event, text);
    }
}
