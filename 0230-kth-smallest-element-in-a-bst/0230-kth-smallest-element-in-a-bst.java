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

    void recursion(TreeNode root, int k) {
        if(root == null) {
            return ;
        }
        recursion(root.left, k);
        list.add(root.val);
        recursion(root.right, k);
       

    }
    public int kthSmallest(TreeNode root, int k) {
        recursion(root, k);
        return list.get(k-1);
    }
}