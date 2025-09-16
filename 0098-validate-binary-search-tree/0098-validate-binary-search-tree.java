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
    List<Integer> list = new ArrayList<>();

    void recursion(TreeNode root) {
        // base case
        if(root == null) return;

        // recursive case
        recursion(root.left);
        list.add(root.val);
        recursion(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        
        recursion(root);
        for(int i = 0 ; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}