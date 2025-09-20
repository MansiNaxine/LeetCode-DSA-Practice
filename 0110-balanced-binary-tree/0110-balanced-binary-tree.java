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

    public int recursion(TreeNode root) {

        if(root == null) return 0;

        return Math.max(recursion(root.left), recursion(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true ;
        int Left = recursion(root.left);
        int Right = recursion(root.right);

        int answer = Math.abs((recursion(root.left) - recursion(root.right)));
        
        return answer > 1 ? false : isBalanced(root.left) && isBalanced(root.right);
    }
}