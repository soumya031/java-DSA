package tree;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.Ellipse2D;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class MaxDepthTree {
    private JFrame frame;
    private JTextArea outputArea;
    private Queue<Node> queue;
    private Node root, root2;
    private TreePanel treePanel;

    public MaxDepthTree() {
        queue = new LinkedList<>();
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Binary Tree Visualizer + Operations");
        frame.setSize(900, 700);
        frame.setLayout(new BorderLayout());
        outputArea = new JTextArea(8, 20);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(outputArea);
        JButton buildButton = new JButton("Build First Tree");
        JButton sameTreeButton = new JButton("Build Second Tree & Compare");
        JButton symmetricButton = new JButton("Check if Tree is Symmetric");
        JButton deleteButton = new JButton("Delete Node");
        JButton updateButton = new JButton("Update Node");

        buildButton.addActionListener(e -> {
            root = buildTree("First");
            treePanel.repaint();
            showTreeInfo();
        });

        sameTreeButton.addActionListener(e -> {
            root2 = buildTree("Second");
            if (root != null && root2 != null) {
                boolean same = isSameTree(root, root2);
                outputArea.append("\n🌲 Same Tree? " + (same ? "Yes ✅" : "No ❌") + "\n");
            }
        });

        symmetricButton.addActionListener(e -> {
            boolean symmetric = isSymmetric(root);
            outputArea.append("\n🔄 Symmetric Tree? " + (symmetric ? "Yes ✅" : "No ❌") + "\n");
        });

        deleteButton.addActionListener(e -> {
            int val = getUserInt("Enter node value to DELETE:");
            root = deleteNode(root, val);
            treePanel.repaint();
            outputArea.append("\n🗑️ Node " + val + " deleted.\n");
            showTreeInfo();
        });

        updateButton.addActionListener(e -> {
            int oldVal = getUserInt("Enter node value to UPDATE:");
            int newVal = getUserInt("Enter new value:");
            updateNodeValue(root, oldVal, newVal);
            treePanel.repaint();
            outputArea.append("\n✏️ Node " + oldVal + " updated to " + newVal + ".\n");
            showTreeInfo();
        });

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        buttonPanel.add(buildButton);
        buttonPanel.add(sameTreeButton);
        buttonPanel.add(symmetricButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        treePanel = new TreePanel();

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.SOUTH);
        frame.add(treePanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void showTreeInfo() {
        if (root == null) return;
        outputArea.setText("✅ Max Depth: " + maxDepth(root) + "\n");
        outputArea.append("🔁 Inorder: ");
        inorder(root);
        outputArea.append("\n🚀 Preorder: ");
        preorder(root);
        outputArea.append("\n📥 Postorder: ");
        postorder(root);
        outputArea.append("\n🌐 Level Order: ");
        levelOrderTraversal(root);
        outputArea.append("\n🧠 Balanced? " + (isBalanced(root) ? "Yes ✅" : "No ❌") + "\n");
    }

    private Node buildTree(String label) {
        queue.clear();
        int rootVal = getUserInt("[" + label + " Tree] Enter root value:");
        if (rootVal == -1) return null;

        Node newRoot = new Node(rootVal);
        queue.offer(newRoot);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int leftVal = getUserInt("[" + label + "] Left child of " + current.data + " (-1 for null):");
            if (leftVal != -1) {
                current.left = new Node(leftVal);
                queue.offer(current.left);
            }

            int rightVal = getUserInt("[" + label + "] Right child of " + current.data + " (-1 for null):");
            if (rightVal != -1) {
                current.right = new Node(rightVal);
                queue.offer(current.right);
            }
        }
        return newRoot;
    }

    private int getUserInt(String msg) {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, msg);
            try {
                if (input == null || input.trim().isEmpty()) return -1;
                return Integer.parseInt(input.trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
            }
        }
    }

    private int maxDepth(Node r) {
        if (r == null) return 0;
        return 1 + Math.max(maxDepth(r.left), maxDepth(r.right));
    }

    private void inorder(Node r) {
        if (r == null) return;
        inorder(r.left);
        outputArea.append(r.data + " ");
        inorder(r.right);
    }

    private void preorder(Node r) {
        if (r == null) return;
        outputArea.append(r.data + " ");
        preorder(r.left);
        preorder(r.right);
    }

    private void postorder(Node r) {
        if (r == null) return;
        postorder(r.left);
        postorder(r.right);
        outputArea.append(r.data + " ");
    }

    private void levelOrderTraversal(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            outputArea.append(n.data + " ");
            if (n.left != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
    }

    private boolean isBalanced(Node root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(Node node) {
        if (node == null) return 0;
        int l = checkBalance(node.left);
        int r = checkBalance(node.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }

    private boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.data == q.data) &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    private boolean isSymmetric(Node root) {
        return isMirror(root, root);
    }

    private boolean isMirror(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.data == t2.data) &&
                isMirror(t1.left, t2.right) &&
                isMirror(t1.right, t2.left);
    }

    private Node deleteNode(Node root, int key) {
        if (root == null) return null;
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node minNode = findMin(root.right);
            root.data = minNode.data;
            root.right = deleteNode(root.right, minNode.data);
        }
        return root;
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private void updateNodeValue(Node root, int oldVal, int newVal) {
        if (root == null) return;
        if (root.data == oldVal) root.data = newVal;
        updateNodeValue(root.left, oldVal, newVal);
        updateNodeValue(root.right, oldVal, newVal);
    }

    class TreePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (root != null) drawTree(g, root, getWidth() / 2, 50, getWidth() / 4);
        }

        void drawTree(Graphics g, Node node, int x, int y, int xOffset) {
            g.setFont(new Font("Arial", Font.BOLD, 14));
            if (node.left != null) {
                g.drawLine(x, y, x - xOffset, y + 70);
                drawTree(g, node.left, x - xOffset, y + 70, xOffset / 2);
            }
            if (node.right != null) {
                g.drawLine(x, y, x + xOffset, y + 70);
                drawTree(g, node.right, x + xOffset, y + 70, xOffset / 2);
            }
            g.setColor(Color.CYAN);
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.BLACK);
            g.drawOval(x - 15, y - 15, 30, 30);
            g.drawString("" + node.data, x - 6, y + 5);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MaxDepthTree::new);
    }
}
