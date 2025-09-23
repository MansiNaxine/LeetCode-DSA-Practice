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
    int answer = -1000;
    public int recursion(TreeNode root) {

        if(root == null) return 0;

        int option1 = root.val;
        int left = root.left != null ? recursion(root.left) : -1000;
        int right = root.right != null ? recursion(root.right) : -1000;
        int option2 = Math.max(option1, Math.max(option1 + left, option1 + right));
        int option3 = option1 + left + right;

         answer = Math.max(answer, Math.max(option2, option3));

        return option2;
    }
    public int maxPathSum(TreeNode root) {
        
        recursion(root);
        return answer;
    }
}