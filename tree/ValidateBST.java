package tree;

import java.util.*;

class Solution {
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);        
    }

    private boolean valid(TreeNode node, long minimum, long maximum) {
        if (node == null) return true;
        if (!(node.val > minimum && node.val < maximum)) return false;
        return valid(node.left, minimum, node.val) && valid(node.right, node.val, maximum);
    }    
}

public class ValidateBST {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(s.isValidBST(root)); 
    }
}
