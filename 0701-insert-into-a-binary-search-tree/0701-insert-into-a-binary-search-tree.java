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
  public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode ans = new TreeNode(val);
        if(root == null) return ans;
        TreeNode ans1 = null;
        TreeNode leftNode = findMaxFork(root, val, ans1);
        

        if(leftNode != null && val > leftNode.val) {
                TreeNode newNode = leftNode.right;
                leftNode.right = new TreeNode(val);
                leftNode.right.right = newNode;
                // if(rightNode != null && val < rightNode.val) newNode.right = rightNode;
        }
        else {
            TreeNode ans2 = null; 
            TreeNode rightNode = findCeil(root, val, ans2);
            if(rightNode != null && val < rightNode.val) rightNode.left = new TreeNode(val);
        }

        return root;

        
    }

    public TreeNode findCeil(TreeNode root, int x, TreeNode ans2) {
        
        if(root == null) return ans2;
        if(root.val >= x) {
            ans2 = root;
            return findCeil(root.left, x, ans2);
        }
        else return findCeil(root.right, x, ans2);
    }

    
    public TreeNode findMaxFork(TreeNode root, int k , TreeNode ans1) {
        
        if(root == null) return ans1;
        if(root.val <= k) {
            ans1 = root;
            return findMaxFork(root.right, k, ans1);
        }
        else return findMaxFork(root.left, k, ans1);
       
    }
}