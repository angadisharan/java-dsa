package org.matools.java.tree.avl;

public class AVLTree {

    class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    // Height
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // Balance factor
    private int getBalance(Node node) {
        return node == null ? 0 :
                height(node.left) - height(node.right);
    }

    // Right Rotate
    private Node rightRotate(Node node) {

        Node x = node.left;
        Node temp = x.right;

        // rotation
        x.right = node;
        node.left = temp;

        // update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left Rotate
    private Node leftRotate(Node node) {

        Node y = node.right;
        Node temp = y.left;

        // rotation
        y.left = node;
        node.right = temp;

        // update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {

        // normal BST insert
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        }
        else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        else {
            return node;
        }

        // update height
        node.height =
                1 + Math.max(height(node.left), height(node.right));

        // get balance factor
        int balance = getBalance(node);

        // LEFT LEFT
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // RIGHT RIGHT
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // LEFT RIGHT
        if (balance > 1 && data > node.left.data) {

            node.left = leftRotate(node.left);

            return rightRotate(node);
        }

        // RIGHT LEFT
        if (balance < -1 && data < node.right.data) {

            node.right = rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    // Inorder traversal
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {

        if (node != null) {

            inorder(node.left);

            System.out.println(
                    node.data + " Height:" + node.height);

            inorder(node.right);
        }
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        tree.inorder();
    }
}