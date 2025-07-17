/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        invertTree(root.right);
        return isSameTree(root.left,root.right);
        
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;

        if (!isSameTree(p.left, q.left)) return false;
        if (!isSameTree(p.right, q.right)) return false;

        return true;
    }
}