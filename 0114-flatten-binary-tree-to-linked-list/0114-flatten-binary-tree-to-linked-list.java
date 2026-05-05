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

    public void flatten(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        recursiveApproach(list, root);
        for(int i = 1; i < list.size(); i++) {
            root.right = list.get(i);
            root.left = null;
            root = root.right;
        }
        return;
        
    }

    public void recursiveApproach(List<TreeNode> list, TreeNode root) {
        if(root == null) return;

        list.add(root);
        recursiveApproach(list, root.left);
        recursiveApproach(list, root.right);
    }
}