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
        
    return helperHeight(root) == -1 ? false : true;
    }

    public int helperHeight(TreeNode root) {
         //base case
        if(root == null) return 0;


        //recursive case
        int left = helperHeight(root.left);
        int right = helperHeight(root.right);

        
        if(Math.abs(left - right) > 1) return -1;
        return (left == -1 || right == -1) ? -1 : Math.max(left, right) + 1;
    }
}