package tree;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Recursively build the binary tree from user input
    public Node buildTree(Scanner sc) {
        System.out.print("Enter data (-1 for no node): ");
        int val = sc.nextInt();
        if (val == -1) return null;

        Node newNode = new Node(val);
        System.out.println("Enter left child of " + val + ":");
        newNode.left = buildTree(sc);
        System.out.println("Enter right child of " + val + ":");
        newNode.right = buildTree(sc);
        return newNode;
    }

    // Inorder Traversal: Left -> Root -> Right
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal: Root -> Left -> Right
    public void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal: Left -> Right -> Root
    public void postorder(Node root) {
        if (root == null) return;
        postorder(root.left); 
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}

public class Binarytree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        System.out.println("Build your binary tree:");
        bt.root = bt.buildTree(sc);
        System.out.println("\n Inorder Traversal:");
        bt.inorder(bt.root);
        System.out.println("\n Preorder Traversal:");
        bt.preorder(bt.root);
        System.out.println("\n Postorder Traversal:");
        bt.postorder(bt.root);
    }
}

