package tree;

import javax.swing.*;
import java.awt.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BalancedBinaryTree {
    private JFrame frame;
    private JTextArea outputArea;
    private Queue<Node> queue;
    private Node root;

    public BalancedBinaryTree() {
        queue = new LinkedList<>();
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Balanced Binary Tree Checker");
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(outputArea);

        JButton buildButton = new JButton("Build Tree and Check Balance");
        buildButton.addActionListener(e -> buildAndCheckTree());

        frame.add(buildButton, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void buildAndCheckTree() {
        queue.clear();
        outputArea.setText("");

        int rootVal = getUserInt("Enter root value:");
        if (rootVal == -1) {
            outputArea.append("Tree is empty.\n");
            return;
        }

        root = new Node(rootVal);
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int leftVal = getUserInt("Enter left child of " + current.data + " (-1 for null):");
            if (leftVal != -1) {
                current.left = new Node(leftVal);
                queue.offer(current.left);
            }

            int rightVal = getUserInt("Enter right child of " + current.data + " (-1 for null):");
            if (rightVal != -1) {
                current.right = new Node(rightVal);
                queue.offer(current.right);
            }
        }

        outputArea.append("🔁 Inorder Traversal: ");
        inorder(root);
        outputArea.append("\n");

        outputArea.append("📏 Maximum Depth: " + maxDepth(root) + "\n");

        boolean balanced = isBalanced(root);
        outputArea.append("⚖️ Balanced Tree: " + (balanced ? "✅ Yes" : "❌ No") + "\n");
    }

    private int getUserInt(String message) {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, message);
            try {
                if (input == null) return -1;
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid integer.");
            }
        }
    }

    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        outputArea.append(root.data + " ");
        inorder(root.right);
    }

    private int maxDepth(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Optimized balance check using height
    private boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(Node node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BalancedBinaryTree::new);
    }
}

