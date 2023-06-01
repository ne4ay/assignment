package com.nechay.assignment.frontend.model;

import com.vaadin.flow.component.upload.SucceededEvent;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * @author onechaev
 */
public class FileModel {
    
    private final String name;
    private final String mimeType;
    private final String content;

    public FileModel(@Nonnull String name, @Nonnull String mimeType, @Nonnull String content) {
        this.name = name;
        this.mimeType = mimeType;
        this.content = content;
    }

    public static FileModel create(@Nonnull SucceededEvent event, @Nonnull String content) {
        return new FileModel(event.getFileName(), event.getMIMEType(), content);
    }

    public String getName() {
        return name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof FileModel fileModel))
            return false;
        return Objects.equals(name, fileModel.name) && Objects.equals(mimeType, fileModel.mimeType)
            && Objects.equals(content, fileModel.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mimeType, content);
    }
}
