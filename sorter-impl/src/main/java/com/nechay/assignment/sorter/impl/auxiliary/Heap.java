package com.nechay.assignment.sorter.impl.auxiliary;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author onechaev
 */
public class Heap<E> {

    private final List<E> elements = new ArrayList<>();
    private final Comparator<E> comparator;

    public Heap(@Nonnull Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private E elementAt(int index) {
        return elements.get(index);
    }

    private boolean isEmpty() {
        return elements.isEmpty();
    }

    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public void add(E e) {
        elements.add(e);
        int elementIndex = elements.size() - 1;
        while (!isRoot(elementIndex) && !isCorrectChild(elementIndex)) {
            int parentIndex = parentIndex(elementIndex);
            swap(elementIndex, parentIndex);
            elementIndex = parentIndex;
        }
    }

    private boolean isRoot(int index) {
        return index == 0;
    }

    private boolean isCorrectChild(int index) {
        return isCorrect(parentIndex(index), index);
    }

    private boolean isCorrect(int parentIndex, int childIndex) {
        if (!isValidIndex(parentIndex) || !isValidIndex(childIndex)) {
            return true;
        }

        return comparator.compare(elementAt(parentIndex),elementAt(childIndex)) < 0;
    }

    private boolean isValidIndex(int index) {
        return index < elements.size();
    }

    public void swap(int index1, int index2) {
        E element1 = elementAt(index1);
        E element2 = elementAt(index2);
        elements.set(index1, element2);
        elements.set(index2, element1);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("You cannot pop from an empty heap");
        }

        E result = elementAt(0);

        int lasElementIndex = elements.size() - 1;
        swap(0, lasElementIndex);
        elements.remove(lasElementIndex);

        int elementIndex = 0;
        while (!isLeaf(elementIndex) && !isCorrectParent(elementIndex)) {
            int smallerChildIndex = smallerChildIndex(elementIndex);
            swap(elementIndex, smallerChildIndex);
            elementIndex = smallerChildIndex;
        }

        return result;
    }

    private boolean isLeaf(int index) {
        return !isValidIndex(leftChildIndex(index));
    }

    private boolean isCorrectParent(int index) {
        return isCorrect(index, leftChildIndex(index)) && isCorrect(index, rightChildIndex(index));
    }

    private int smallerChildIndex(int index) {
        int leftChildIndex = leftChildIndex(index);
        int rightChildIndex = rightChildIndex(index);

        if (!isValidIndex(rightChildIndex)) {
            return leftChildIndex;
        }

        if (comparator.compare(elementAt(leftChildIndex),elementAt(rightChildIndex)) < 0) {
            return leftChildIndex;
        }

        return rightChildIndex;
    }

    public static <E> List<E> sort(Iterable<E> elements, @Nonnull Comparator<E> comparator) {
        Heap<E> heap = of(elements, comparator);

        List<E> result = new ArrayList<>();

        while (!heap.isEmpty()) {
            result.add(heap.pop());
        }

        return result;
    }

    public static <E> Heap<E> of(@Nonnull Iterable<E> elements, @Nonnull Comparator<E> comparator) {
        Heap<E> result = new Heap<>(comparator);
        for (E element : elements) {
            result.add(element);
        }
        return result;
    }
}
