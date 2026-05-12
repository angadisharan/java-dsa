package org.matools.java.tree.readblack;

public class RedBlackTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node {
        int data;
        Node left, right, parent;
        boolean color;

        Node(int data) {
            this.data = data;
            this.color = RED;
        }
    }

    private Node root;

    // Insert
    public void insert(int data) {

        Node node = new Node(data);

        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;

            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        node.parent = parent;

        if (parent == null) {
            root = node;
        } else if (data < parent.data) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        fixInsert(node);
    }

    // Fix Red Black violations
    private void fixInsert(Node node) {

        while (node != root && node.parent.color == RED) {

            Node parent = node.parent;
            Node grandParent = parent.parent;

            // Parent is left child
            if (parent == grandParent.left) {

                Node uncle = grandParent.right;

                // Case 1: Uncle is RED
                if (uncle != null && uncle.color == RED) {

                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandParent.color = RED;

                    node = grandParent;
                } else {

                    // Case 2
                    if (node == parent.right) {
                        node = parent;
                        leftRotate(node);
                    }

                    // Case 3
                    parent.color = BLACK;
                    grandParent.color = RED;

                    rightRotate(grandParent);
                }

            } else {

                Node uncle = grandParent.left;

                // Mirror Case 1
                if (uncle != null && uncle.color == RED) {

                    parent.color = BLACK;
                    uncle.color = BLACK;
                    grandParent.color = RED;

                    node = grandParent;
                } else {

                    // Mirror Case 2
                    if (node == parent.left) {
                        node = parent;
                        rightRotate(node);
                    }

                    // Mirror Case 3
                    parent.color = BLACK;
                    grandParent.color = RED;

                    leftRotate(grandParent);
                }
            }
        }

        root.color = BLACK;
    }

    // Left Rotate
    private void leftRotate(Node x) {

        Node y = x.right;

        x.right = y.left;

        if (y.left != null) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    // Right Rotate
    private void rightRotate(Node y) {

        Node x = y.left;

        y.left = x.right;

        if (x.right != null) {
            x.right.parent = y;
        }

        x.parent = y.parent;

        if (y.parent == null) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }

        x.right = y;
        y.parent = x;
    }

    // Inorder traversal
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {

        if (node != null) {

            inorder(node.left);

            System.out.println(
                    node.data + " " +
                            (node.color == RED ? "RED" : "BLACK"));

            inorder(node.right);
        }
    }

    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.insert(5);

        tree.inorder();
    }
}