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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int lH = maxDepth(root.left);
        int rH = maxDepth(root.right);
        boolean right = isBalanced(root.right);

        if(Math.abs(rH - lH) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        int lH = maxDepth(root.left);
        int rH = maxDepth(root.right);

        return 1 + Math.max(lH, rH);
        
    }
}