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
    public int diameterOfBinaryTree(TreeNode root) {
        int maxDia = 0;
        if(root == null) return maxDia;
        int lH = height(root.left);
        int rH = height(root.right);

        maxDia = Math.max(maxDia, lH + rH);
        int lDia = diameterOfBinaryTree(root.left);
        int rDia = diameterOfBinaryTree(root.right);

        return Math.max(maxDia, Math.max(lDia , rDia));
    }

    public int height(TreeNode root) {
        if(root == null) return 0;

        int lH = height(root.left);
        int rH = height(root.right);

        return 1 + Math.max(lH, rH);
    }
}