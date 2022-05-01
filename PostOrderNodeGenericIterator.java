package com.mcgarvey;

import java.util.ArrayDeque;
import java.util.Deque;

class PostOrderNodeGenericIterator extends AbstractNodeGenericIterator {
    /**
     * Iterates through expression tree in post order Using Recursion
     * Method next() returns a node each time it is called Using Recursion
     * @param  root the node that contains the expression tree being passed into the iterator
     */

    private enum TreeBranch {
        LEFT, RIGHT
    }

    private Deque<TreeBranch> currentNodePathBranch;

    public PostOrderNodeGenericIterator(NodeGeneric root) {

        currentNodePathBranch = new ArrayDeque<>();
        buildPathDownToLeftmostNodeFrom(root);
    }

    public NodeGeneric next() {

        NodeGeneric node = currentPath.peek();

        if (!node.hasRightChild() || currentNodePathBranch.peek() == TreeBranch.RIGHT) {

            NodeGeneric result = currentPath.pop();
            currentNodePathBranch.pop();

            if (currentPath.isEmpty()) {
                cleanup();
            }

            return result;
        }

        currentNodePathBranch.pop();
        currentNodePathBranch.push(TreeBranch.RIGHT);

        buildPathDownToLeftmostNodeFrom(node.getRight());

        return next();
    }

    protected void cleanup() {

        currentNodePathBranch.clear();
        currentNodePathBranch = null;

        super.cleanup();
    }

    protected void buildPathDownToLeftmostNodeFrom(NodeGeneric node) {

        while (node != null) {
            currentPath.push(node);
            currentNodePathBranch.push(TreeBranch.LEFT);
            node = node.getLeft();
        }
    }
}