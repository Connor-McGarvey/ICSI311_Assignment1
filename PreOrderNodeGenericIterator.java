package com.mcgarvey;

public class PreOrderNodeGenericIterator extends AbstractNodeGenericIterator {
    /**
     * Iterates through expression tree in preorder
     * method next() each time it is called returns a node
     * @param root the node that contains the expression tree that is being passed into the iterator
     */
    public PreOrderNodeGenericIterator(NodeGeneric root) {
        currentPath.push(root);
    }

    public NodeGeneric next() {

        NodeGeneric node = currentPath.pop();

        if (node.hasRightChild()) {
            currentPath.push(node.getRight());
        }

        if (node.hasLeftChild()) {
            currentPath.push(node.getLeft());
        }

        if (currentPath.isEmpty()) {
            cleanup();
        }

        return node;
    }
}
