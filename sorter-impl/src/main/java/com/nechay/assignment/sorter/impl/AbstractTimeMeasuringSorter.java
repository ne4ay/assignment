package com.nechay.assignment.sorter.impl;

import com.nechay.assignment.api.utils.NanoClock;

import javax.annotation.Nonnull;
import java.time.ZoneId;

/**
 * @author onechaev
 */
public class AbstractTimeMeasuringSorter {

    protected final NanoClock nanoClock;

    public AbstractTimeMeasuringSorter(@Nonnull NanoClock nanoClock) {
        this.nanoClock = nanoClock;
    }
}
