package com.mcgarvey;

/**
 * Represents a Generic Node for use in binary tree
 * @param <E>
 * @author Connor McGarvey
 * @version 1.0
 */
public class NodeGeneric<E> {
    /**
     * Generic type <E> element
     * Node liked to left
     * Node linked to right
     */
    private E element;
    public NodeGeneric<E> left;
    public NodeGeneric<E> right;
    //public NodeGeneric<E> parent;

    /**
     * Default Constructor
     * element and both children set to null
     */
    public NodeGeneric() {
        this(null, null, null);
    }

    /**
     * Constructs a node with the passed in element
     * @param element The element of the node
     */

    public NodeGeneric(E element) {
        this(element, null, null);
    }

    /**
     * Constructs a node with the passed element and left and right children
     * @param element the element of the constructed node
     * @param left the node that will be assigned to the left child of the node
     * @param right the node that will be assigned to the right child of the node
     */

    public NodeGeneric(E element, NodeGeneric<E> left, NodeGeneric<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    /**
     * Get method for Element
     * @return the element of the node
     */


    public E getElement() {
        return this.element;
    }

    /**
     * Get method for the left child
     * @return the left child of the node
     */

    public NodeGeneric<E> getLeft() {
        return this.left;
    }

    /**
     * Get method for the right child
     * @return the right child of the node
     */

    public NodeGeneric<E> getRight() {
        return this.right;
    }

    /**
     * Set method for the element
     * @param element the element to be set as the element of the node
     */

    public void setElement(E element) {
        this.element = element;
    }

    /**
     * Set method for the left child
     * @param left The node to be set as the left child of the node
     */
    public void setLeft(NodeGeneric<E> left) {
        this.left = left;
    }

    /**
     * Set method for the right child
     * @param right The node to be set as the right child of the node
     */
    public void setRight(NodeGeneric<E> right) {
        this.right = right;
    }

    /**
     * Indicates if this node is "Equal to" the parameter CompareNode. Nodes are considered equal if they
     * contain the same element and the element of the left child are the same and the element of the right child
     * are the same. The method has checks for if the children or the element are null
     * @param compareNode The node that will be compared to this node
     * @return Returns true if the nodes are equal, returns false if they are NOT equal
     */


    public boolean equals(NodeGeneric compareNode) {
        if (compareNode == null) {
            return false;
        }

        // Dif values
        if (this.element != compareNode.element) {
            return false;
        }

        if (this.left == null && compareNode.left != null) {
            return false;
        }

        if (this.left != null && !this.left.equals(compareNode.left)) {
            return false;
        }

        if (this.right == null && compareNode.right != null) {
            return false;
        }

        if (this.right != null && !this.right.equals(compareNode.right)) {
            return false;
        }

        return true;

    }

    /**
     * Indicates if this node has a right child.
     * @return Returns true if there is a right child, false if the right child is NULL
     */

    public boolean hasRightChild() {
        if (right != null) {
            return true;
        } else return false;
    }

    /**
     * Indicates if this node has a left child.
     * @return Returns true if there is a left child, false if the left child is NULL.
     */

    public boolean hasLeftChild() {
        if (left != null) {
            return true;
        } else return false;
    }

    /**
     * Returns a string representation of the element contained in this node. Has no concatenations, returns only what
     * is stored in the element of the node.
     * @return String representation of the element
     */

    public String toString() {
        return element.toString();
    }

}
