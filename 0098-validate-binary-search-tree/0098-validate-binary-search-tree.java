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

    public boolean recursion(TreeNode root, long start, long end) {
        
        if(root == null) return true;

        if(start > root.val || end < root.val) return false;

        boolean left = recursion(root.left, start, (long)root.val - 1);
        boolean right = recursion(root.right, (long)root.val + 1, end);

        return left && right;
    }

    public boolean isValidBST(TreeNode root) {

        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;

        return recursion(root, min, max);

        
    }
}