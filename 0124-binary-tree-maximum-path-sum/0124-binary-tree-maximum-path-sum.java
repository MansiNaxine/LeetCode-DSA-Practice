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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        recursion(root);
        return maxSum;
    }

    public int recursion(TreeNode root) {
        if(root == null) return 0;

        int leftVal = Math.max(0, recursion(root.left));
        int rightVal = Math.max(0, recursion(root.right));
        maxSum = Math.max(maxSum, root.val + leftVal + rightVal);

        return root.val + Math.max(leftVal, rightVal);
    }
}