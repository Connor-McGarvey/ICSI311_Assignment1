package com.mcgarvey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Represents generic node iterator
 * must be implemented to support either preorder or postorder traversal
 */

abstract class AbstractNodeGenericIterator implements Iterator<NodeGeneric>, Iterable<NodeGeneric> {

    protected Deque<NodeGeneric> currentPath;

    public AbstractNodeGenericIterator() {
        this.currentPath = new ArrayDeque<>();
    }

    public boolean hasNext() {
        return currentPath != null;
    }

    public abstract NodeGeneric next();

    public Iterator<NodeGeneric> iterator() {
        return this;
    }


    protected void cleanup() {

        currentPath.clear();
        currentPath = null;
    }
}