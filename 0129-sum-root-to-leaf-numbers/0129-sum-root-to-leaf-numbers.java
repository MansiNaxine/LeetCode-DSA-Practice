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
    int answer = 0;

    public void recursion(TreeNode root, int sum) {

        //base case
        if(root == null) return;

        sum = (sum * 10) + root.val;

        if(root.left == null && root.right == null) {
            answer += sum;
        }

        //recursive case
        recursion(root.left, sum);
        recursion(root.right, sum);
        sum /= 10;

    }
    public int sumNumbers(TreeNode root) {
        
        recursion(root, 0);
        return answer;
    }
}