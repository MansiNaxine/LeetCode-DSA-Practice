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

    class Pair {
    int num;
    boolean flag;

    Pair(int num,boolean flag) {
        this.num = num;
        this.flag = flag;
    }
}

    // public int recursion(TreeNode root) {

    //     if(root == null) return 0;

    //     return Math.max(recursion(root.left), recursion(root.right)) + 1;
    // }
    public boolean isBalanced(TreeNode root) {
        // if (root == null) return true ;

        // int Left = recursion(root.left);
        // int Right = recursion(root.right);

        // int answer = Math.abs((recursion(root.left) - recursion(root.right)));

        // return answer > 1 ? false : isBalanced(root.left) && isBalanced(root.right);

        Pair answer = isBalancedHelper(root);

        return answer.flag;
    }

    public Pair isBalancedHelper(TreeNode root) {

        if(root == null) {

            return new Pair(0, true);
        }

        Pair left = isBalancedHelper(root.left);
        Pair right = isBalancedHelper(root.right);

        int height = Math.max(left.num, right.num) + 1;

        int diff = Math.abs(left.num - right.num);

        if(diff > 1) {
            return new Pair(height, false);
        } else {

            return new Pair(height, left.flag && right.flag);
        }
    }
}

