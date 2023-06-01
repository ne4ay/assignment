package com.nechay.assignment.frontend.download;

import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;

/**
 * @author onechaev
 */
public class FileStreamResource extends StreamResource {

    public FileStreamResource(String name, InputStreamFactory factory) {
        super(name, factory);
    }
}
