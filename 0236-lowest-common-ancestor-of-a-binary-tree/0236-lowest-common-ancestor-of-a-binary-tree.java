/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        if(root.val == p.val || root.val == q.val) return root;

        // int left = root.left == null ? 0 : root.left.val;
        // int right = root.right == null ? 0 : root.right.val;

        // if(left != p.val || right != q.val) {
            TreeNode leftPart = lowestCommonAncestor(root.left , p , q);
            TreeNode rightPart = lowestCommonAncestor(root.right , p , q);
        // }
            
        if(leftPart != null && rightPart != null) {
            return root;
        }
            
        if(leftPart != null) {
            return leftPart;
        }

        return rightPart;
        
    }
}