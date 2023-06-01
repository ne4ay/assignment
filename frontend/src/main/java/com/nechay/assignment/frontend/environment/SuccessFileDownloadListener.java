package com.nechay.assignment.frontend.environment;

import com.vaadin.flow.component.upload.SucceededEvent;

import javax.annotation.Nonnull;
import javax.annotation.WillClose;
import java.io.InputStream;

/**
 * @author onechaev
 */
public interface SuccessFileDownloadListener {
    void onFileDownloading(@Nonnull SucceededEvent succeededEvent, @Nonnull @WillClose InputStream stream);
}
