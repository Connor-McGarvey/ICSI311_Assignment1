package com.mcgarvey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    /**
     * Driver for Expression Tree
     * Reads from txt file driver.txt
     * Takes each line and creates a tree, preforms traversals and prints the toString to console.
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        Scanner scan = new Scanner(new File("driver.txt"));
        while(scan.hasNextLine()){
            String input = scan.nextLine();
            ExpressionTree et3 = new ExpressionTree();
            NodeGeneric root3 = et3.constructTree(input+" ");
            System.out.print(et3.toString());
        }
        scan.close();
/**
 * uncomment below code for node equals testing
 */
//        NodeGeneric node1 = new NodeGeneric("55");
//        NodeGeneric node8 = new NodeGeneric("98",node1,node1);
//        NodeGeneric node2 = new NodeGeneric("89");
//        NodeGeneric node3 = new NodeGeneric("+");
//        NodeGeneric node4 = new NodeGeneric("55");
//        NodeGeneric node5 = new NodeGeneric("55");
//        NodeGeneric node6 = new NodeGeneric("44",node2,node1);
//        NodeGeneric node7 = new NodeGeneric("55", node2, node2);
//        NodeGeneric node9 = new NodeGeneric("98", node5, node5);
//
//        System.out.println(node1.equals(node2));
//        System.out.println(node1.equals(node1));
//        System.out.println(node1.equals(node5));
//        System.out.println(node5.equals(node6));
//        System.out.println(node4.equals(node5));
//        System.out.println(node3.equals(node4));
//        System.out.println(node7.equals(node8));
//        System.out.println(node8.equals(node9));

    }



}