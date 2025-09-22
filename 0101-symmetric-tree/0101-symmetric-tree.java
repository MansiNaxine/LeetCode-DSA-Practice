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

    public boolean recursion(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        int valP = p.val;
        int valQ = q.val;

        if(valP == valQ) {
            boolean leftpart = recursion(p.left, q.right);
            boolean rightpart = recursion(p.right, q.left);

            return leftpart && rightpart;
        } else {
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        
        return recursion(root.left, root.right);
    }
}