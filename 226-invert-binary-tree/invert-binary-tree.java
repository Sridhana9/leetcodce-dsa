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
public class Solution {
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
}
