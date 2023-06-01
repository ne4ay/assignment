package com.nechay.assignment.sorter.impl;

import com.nechay.assignment.api.ConcreteSorter;
import com.nechay.assignment.api.SortResult;
import com.nechay.assignment.api.utils.NanoClock;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author onechaev
 */
public class SimpleMergeSorter extends AbstractTimeMeasuringSorter implements ConcreteSorter {
    public SimpleMergeSorter(@Nonnull NanoClock nanoClock) {
        super(nanoClock);
    }

    @Nonnull
    @Override
    public <T> CompletableFuture<SortResult<T>> sort(@Nonnull List<T> elements, @Nonnull Comparator<T> comparator) {
        long startNano = nanoClock.nanos();
        mergeSort(elements, comparator, elements.size());
        long endNano = nanoClock.nanos();
        return CompletableFuture.completedFuture(new SortResult<>(elements, endNano - startNano));
    }

    private <T> void mergeSort(List<T> wholeList, Comparator<T> comparator, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        List<T> l = new ArrayList<>(wholeList.subList(0, mid));
        List<T> r = new ArrayList<>(wholeList.subList(mid, length));

        mergeSort(l, comparator, mid);
        mergeSort(r, comparator, length - mid);

        merge(comparator, wholeList, l, r, mid, length - mid);
    }

    private <T> void merge(Comparator<T> comparator, List<T> wholeList, List<T> l, List<T> r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(l.get(i), r.get(j)) < 1) {
                wholeList.set(k++, l.get(i++));
            }
            else {
                wholeList.set(k++, r.get(j++));
            }
        }
        while (i < left) {
            wholeList.set(k++, l.get(i++));
        }
        while (j < right) {
            wholeList.set(k++, r.get(j++));
        }
    }
}
