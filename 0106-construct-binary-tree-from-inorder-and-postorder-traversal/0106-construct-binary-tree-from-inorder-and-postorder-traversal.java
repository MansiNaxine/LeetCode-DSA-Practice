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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;

        for(int i = 0 ; i < n; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = recursiveApproach(postorder, 0, n - 1, inorder, 0, n - 1, map);

        return root;
    }

    public TreeNode recursiveApproach(int[] postorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> map) {
        //base case
        if(ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);
        int iRootIndex = map.get(root.val);
        int postOrderIndex = iRootIndex - is;

        root.left = recursiveApproach(postorder, ps, ps + postOrderIndex - 1, inorder, is, iRootIndex - 1, map);
        root.right = recursiveApproach(postorder, ps + postOrderIndex, pe - 1, inorder, iRootIndex + 1, ie, map);

        return root;
    }
}