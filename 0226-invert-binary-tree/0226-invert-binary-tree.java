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

    public void helper(TreeNode root) {
        //base case
        if(root == null) return ;

        //recursive case
        TreeNode right = root.right != null ? root.right : null;
        TreeNode left = root.left != null ? root.left : null;
        root.left = right;
        root.right = left;

        helper(root.left);
        helper(root.right);


    }
    public TreeNode invertTree(TreeNode root) {
        
        
         helper(root);
         return root;

    }
}