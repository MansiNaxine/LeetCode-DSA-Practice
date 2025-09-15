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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        int pVal = p.val;
        int qVal = q.val;

        if(pVal == qVal) {
            boolean leftPart = isSameTree(p.left, q.left);
            boolean rightPart = isSameTree(p.right, q.right);

            return (leftPart && rightPart);
        } else {
            return false;
        }
        
    }
}