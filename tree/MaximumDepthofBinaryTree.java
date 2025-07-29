 package tree;

import java.util.*;

class Node {
    int data;
    Node left, right;
    
    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class MaximumDepthofBinaryTree {
    static int maxDepth(Node root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    static Node buildTree(Scanner sc) {
        System.out.print("Enter root value: ");
        int val = sc.nextInt();
        if (val == -1) return null;
        Node root = new Node(val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print("Enter left child of " + current.data + " (-1 for null): ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new Node(leftVal);
                queue.add(current.left);
            }
            System.out.print("Enter right child of " + current.data + " (-1 for null): ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                current.right = new Node(rightVal);
                queue.add(current.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc);
        int depth = maxDepth(root);
        System.out.println("Maximum Depth of Binary Tree: " + depth);
    }
}
