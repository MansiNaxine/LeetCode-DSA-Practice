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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode ans = null;
        return helper(root, p, ans);

    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode ans) {
        if(root == null) return ans;

        if(root.val <= p.val) {
            return helper(root.right, p, ans);
        }
        else {
            ans = root;
            return helper(root.left, p, ans);
        }
    }
}