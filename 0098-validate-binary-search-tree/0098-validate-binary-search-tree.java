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
    // List<Integer> list = new ArrayList<>();

    // void recursion(TreeNode root) {
    //     // base case
    //     if(root == null) return;

    //     // recursive case
    //     recursion(root.left);
    //     list.add(root.val);
    //     recursion(root.right);
    // }

    boolean recursion(TreeNode root, long start, long end) {
        if(root == null) return true;

        if(root.val < start || root.val > end) return false;

        //(Left, root.val - 1) <---- root.val ----> (root.val + 1, Right); all values should be in this range
        boolean leftPart = recursion(root.left, start, (long)root.val - 1);
        boolean rightPart = recursion(root.right, (long)root.val + 1, end);

        return leftPart && rightPart;

    }

    public boolean isValidBST(TreeNode root) {
        
        // recursion(root);
        // for(int i = 0 ; i < list.size() - 1; i++) {
        //     if(list.get(i) >= list.get(i + 1)) {
        //         return false;
        //     }
        // }

        // return true;

        return recursion(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}