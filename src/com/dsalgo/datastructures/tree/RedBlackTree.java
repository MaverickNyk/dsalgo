package com.dsalgo.datastructures.tree;

public class RedBlackTree {
    RedBlackTree leftNode, rightNode;
    int data;
    Color color;

    RedBlackTree(int data){
        this(data, null, null);
    }

    public RedBlackTree(int data, RedBlackTree leftNode, RedBlackTree rightNode){
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.color = Color.BLACK;

    }

    public static void main(String[] args){
        RedBlackTree node = new RedBlackTree(2);
        System.out.println(node.data);
    }
}

enum Color{
    RED,
    BLACK
}