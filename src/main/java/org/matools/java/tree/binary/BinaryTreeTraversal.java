package org.matools.java.tree.binary;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
    }
}

public class BinaryTreeTraversal {

    // Inorder: Left -> Root -> Right
    public static void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    // Preorder: Root -> Left -> Right
    public static void preorder(TreeNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Postorder: Left -> Right -> Root
    public static void postorder(TreeNode node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.print("Inorder: ");
        inorder(root);       // 4 2 5 1 3 6

        System.out.print("\nPreorder: ");
        preorder(root);      // 1 2 4 5 3 6

        System.out.print("\nPostorder: ");
        postorder(root);     // 4 5 2 6 3 1
    }
}