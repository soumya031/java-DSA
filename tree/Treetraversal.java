package tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Treetraversal {
    TreeNode root;

    // Build tree using user input (null input = -1)
    public TreeNode buildTree(Scanner sc) {
        System.out.print("Enter node value (-1 for null): ");
        int val = sc.nextInt();
        if (val == -1) return null;

        TreeNode node = new TreeNode(val);
        System.out.println("Enter left child of " + val);
        node.left = buildTree(sc);
        System.out.println("Enter right child of " + val);
        node.right = buildTree(sc);
        return node;
    }

    // Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            result.add(level);
        }

        return result;
    }

    // Level Order Bottom-Up
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            result.addFirst(level); // Add to beginning for bottom-up
        }

        return result;
    }

    // Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (leftToRight) {
                    level.addLast(curr.val);
                } else {
                    level.addFirst(curr.val);
                }

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // Utility to print list of lists
    public void printLevelList(List<List<Integer>> levels) {
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Treetraversal bt = new Treetraversal();  // FIXED LINE
        System.out.println("Build your binary tree:");
        bt.root = bt.buildTree(sc);              // FIXED LINE

        System.out.println("\nLevel Order Traversal:");
        bt.printLevelList(bt.levelOrder(bt.root));

        System.out.println("\nLevel Order Bottom-Up Traversal:");
        bt.printLevelList(bt.levelOrderBottom(bt.root));

        System.out.println("\nZigzag Level Order Traversal:");
        bt.printLevelList(bt.zigzagLevelOrder(bt.root));
    }
}
