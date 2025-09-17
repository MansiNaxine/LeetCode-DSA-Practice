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
    int index = 0;
    public TreeNode recursion(int[] preorder, int[] inorder, int start, int end) {
        //base case
        if(start > end) {
            return null;
        }

        //recursive case
        
        int newIndex = -1;
        for(int i = start; i <= end; i++) {
            if(inorder[i] == preorder[index]) {
                newIndex = i;
                index++;
                break;
            }

        }

        TreeNode root = new TreeNode(inorder[newIndex]);
        root.left = recursion(preorder, inorder, start, newIndex - 1);
        root.right = recursion(preorder, inorder, newIndex + 1, end);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = inorder.length;
        
        return recursion(preorder, inorder, 0, n - 1);
        
    }
}