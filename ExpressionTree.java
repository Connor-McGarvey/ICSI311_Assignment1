package com.mcgarvey;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Representing a binary tree with a infix expression and a root
 * @author Connor McGarvey
 * @version 1.0
 */

public class ExpressionTree {
    /**
     * the infix expression
     * the root of the tree
     */
    String infixExpression;
    NodeGeneric root;

    /**
     * Default constructor sets all to NULL
     */

    public ExpressionTree() {
        infixExpression = null;
        root = null;
    }

    /**
     * Determines precedence of + - * / and has catch all for anything else passed into it (numbers or letters or ( ))
     * @param c the character passed into method
     * @return returns 1 if passed + or - , returns 2 if passed * or / , returns -1 if anything else is passed
     */

    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
//            case '^':
//                return 3;
        }
        return -1;
    }
    /**
     * Indicates if the passed string is an operator ( + - * /)
     * @param ch the string passed to the method that will be compared to + - * /
     * @return returns true if operator returns false if non operator
     */
    static boolean isOperator(String ch) {
        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
    }

    /**
     * preforms the shunting yard algorithm on a given infix Expression. Takes a string containing a fully parenthesized
     * expression and outputs a string containing the expression in postfix notation
     * @param infixExpression the string containing the infix expression
     * @return returns a string containing the postfix expression
     */

    static String infixToPostFix(String infixExpression) {
        StringBuilder postFixExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            //check if char is operator
            if (precedence(c) > 0) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postFixExpression.append(stack.pop());
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    postFixExpression.append(x);
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                //character is neither operator nor (
                postFixExpression.append(c);
            }
        }
        for (int i = 0; i <= stack.size(); i++) {
            postFixExpression.append(stack.pop());
        }
        return postFixExpression.toString();
    }

    /**
     * Takes infix expression and returns a node, this node is the root to the tree that represents the input expression.
     * Takes infix expression and calls infixToPostFix on it to convert to post fix
     * Splits the postfix string on blank space, storing those elements in an array
     * Creates nodes for each element of that array
     * Sets the children for the root node
     * @param infixExpression The string containing the input expression in infix notation
     * @return returns the node that is the root of the tree that represents the expression
     */


    NodeGeneric constructTree(String infixExpression) {
        this.infixExpression = infixExpression;
        String postFixExpression = infixToPostFix(infixExpression);
        String[] postFixExpressionArray = postFixExpression.split("\\s+");
        Stack<NodeGeneric> st = new Stack<>();
        NodeGeneric t, t1, t2;

        // traverse through postfix expression
        for (int i = 0; i < postFixExpressionArray.length; i++) {
            // if operand push into stack
            if (!isOperator(postFixExpressionArray[i])) {
                t = new NodeGeneric(postFixExpressionArray[i]);
                st.push(t);
            } else {
                //must be operator
                t = new NodeGeneric(postFixExpressionArray[i]);
                // pop top two nodes
                // store top
                t1 = st.pop();
                t2 = st.pop();
                // make them children
                t.setRight(t1);
                t.setLeft(t2);
                // make t the parent
               // t1.setParent(t);
               // t2.setParent(t);
                //System.out.println(t1 + "" + t2);
                st.push(t);
            }
        }
        t = st.peek();
        st.pop();
        root = t;
        return t;
    }

//    public void inorder(NodeGeneric root) {
//        if (root != null) {
//            //if (isOperator(root.getData())) {
//            if (isOperator(root.getElement().toString())) {
//                System.out.print("(");
//            }
//            inorder(root.left);
//            System.out.print(root.getElement().toString() + " ");
//            inorder(root.right);
//            if (isOperator(root.getElement().toString())) {
//                System.out.print(")");
//            }
//        }
//    }

    /**
     * Performs preorder traversal on the tree, storing the nodes in a list as it traverses the tree
     * @return returns the list of nodes in preorder.
     */

    public LinkedList<NodeGeneric> preorder() {
        PreOrderNodeGenericIterator iterator = new PreOrderNodeGenericIterator(root);
        LinkedList<NodeGeneric> list = new LinkedList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * Performs postorder traversal on the tree, storing the nodes in a list as it traverses the tree
     * @return returns the list of nodes in postorder.
     */

    public LinkedList<NodeGeneric> postorder() {
        PostOrderNodeGenericIterator iterator = new PostOrderNodeGenericIterator(root);
        LinkedList<NodeGeneric> list = new LinkedList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * Returns a string representation of the Expression Tree
     * the string contains:
     * Name of the class
     * "Infix Expression:" + the infix expression
     * "Postfix Expression:" + the postfix expression
     * @return returns the string described above
     */

    public String toString() {
        String s = getClass().getSimpleName();
        s = s + "\n" +"Infix Expression: "+ infixExpression;
        s = s + "\nPrefix Expression: "+preorder();
        s = s + "\nPostfix Expression: "+postorder()+"\n\n";

        return s;
    }

}