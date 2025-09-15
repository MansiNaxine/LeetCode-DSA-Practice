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
    int answer = (int)-1e9;

    int recursion(TreeNode root) {

        if(root == null) return 0;
        int option1 = root.val;
        int left = root.left == null ? (int) -1e9 : recursion(root.left);
        int right = root.right == null ? (int)-1e9: recursion(root.right);
        int option2 = Math.max(option1, Math.max(left + option1, right + option1));
        int option3 = Math.max(left, right);
        int option4 = option1 + left + right;

        answer = Math.max(answer, Math.max(option1, Math.max(option2, Math.max(option3, option4))));

        return option2;

    }

    public int maxPathSum(TreeNode root) {
        
        recursion(root);

        return answer;
    }
}