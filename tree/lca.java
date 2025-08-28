package tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class lca {
    public TreeNode lowestcommonAncester(TreeNode root, TreeNode p, TreeNode q){
        //base case
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestcommonAncester(root.left, p, q);
        TreeNode right = lowestcommonAncester(root.right, p, q);

        //result 
        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }else{
            //both left and right are not null , we found our result
            return root;
        }
    }

    public static void main(String[] args) {
        /*
                 3
               /   \
              5     1
             / \   / \
            6   2 0   8
               / \
              7   4
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        lca obj = new lca();
        // Example test
        TreeNode lcaNode = obj.lowestcommonAncester(root, root.left, root.right);
        System.out.println("LCA of 5 and 1 is: " + lcaNode.val);
        TreeNode lcaNode2 = obj.lowestcommonAncester(root, root.left.left, root.left.right.right);
        System.out.println("LCA of 6 and 4 is: " + lcaNode2.val);
    }
}
