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

    int count = 0;
    public int countNodes(TreeNode root) {
        
        //base case
        // if(root == null) return 0;

        // //recursive case
        // int left = countNodes(root.left);
        // int right = countNodes(root.right);

        // return 1 + left + right;
        helper(root);
        return count;
    }

    public void helper(TreeNode root) {
        //base case
        if(root == null) return;

        count += 1;
        helper(root.left);
        helper(root.right);
    }
}