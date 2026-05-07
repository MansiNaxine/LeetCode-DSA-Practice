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
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) return true;

        TreeNode left = helperLeft(root.left);
        TreeNode right = helperRight(root.right);

        if(left != null && left.val >= root.val) return false;
        else if(right != null && right.val <= root.val) return false;

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public TreeNode helperRight(TreeNode root) {

        if(root == null) return null;

        return (root.left != null && root.left.val < root.val) ? helperRight(root.left) : (root.right != null && root.right.val < root.val) ? helperRight(root.right) : root;

    }

    public TreeNode helperLeft(TreeNode root) {

        if(root == null) return null;

        return (root.left != null && root.left.val > root.val) ? helperLeft(root.left) : (root.right != null && root.right.val > root.val) ? helperLeft(root.right) : root;

    }
}