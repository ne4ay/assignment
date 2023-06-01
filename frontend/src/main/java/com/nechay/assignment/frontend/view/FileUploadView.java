package com.nechay.assignment.frontend.view;

import com.nechay.assignment.frontend.environment.SuccessFileDownloadListener;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import javax.annotation.Nonnull;

/**
 * @author onechaev
 */
@SpringComponent
@UIScope
public class FileUploadView extends VerticalLayout {

    private final MemoryBuffer memoryBuffer = new MemoryBuffer();
    private final Upload singleFileUpload = new Upload(memoryBuffer);

    public FileUploadView() {
        singleFileUpload.setDropAllowed(true);
        add(singleFileUpload);
    }

    public Registration addSucceededListener(@Nonnull SuccessFileDownloadListener listener) {
        return singleFileUpload.addSucceededListener(event -> listener.onFileDownloading(event, memoryBuffer.getInputStream()));
    }

    public void showError() {
        Notification notification = Notification.show("Failed to upload the file.");
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    }
}
