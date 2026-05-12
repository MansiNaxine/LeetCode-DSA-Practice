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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        //handle the root case i.e. root.val == key;
        if(root == null) return null;
        else {
            if(root.val == key) {
            TreeNode leftPart = root.left != null ? root.left : null;
            TreeNode rightPart = root.right != null ? root.right : null;

            if(leftPart != null && rightPart != null) {
                //get the rightMost Part of leftPart
                TreeNode rightMostPart = getTheRightMostPart(leftPart);
                rightMostPart.right = rightPart;

                return leftPart;
            }
            else if (leftPart == null && rightPart != null) return rightPart;
            else return leftPart;
        }
        else {
            TreeNode parentNode = findParentNode(root, key);
            TreeNode foundNode = null;
            if(parentNode!= null) {
                
                if(parentNode.left != null && key == parentNode.left.val) {
                    foundNode = parentNode.left;
                    TreeNode leftPart = foundNode.left != null ? foundNode.left : null;
                    TreeNode rightPart = foundNode.right != null ? foundNode.right : null;

                    //Left Part node 
                    if(leftPart != null && rightPart != null) {
                        //get the rightMost Part of leftPart
                        TreeNode rightMostPart = getTheRightMostPart(leftPart);
                        rightMostPart.right = rightPart;
                        parentNode.left = leftPart;

                        
                    }
                    else if (leftPart == null && rightPart != null) {
                        parentNode.left = rightPart;
                    }
                    else {
                        parentNode.left = leftPart;
                    } 
                }
                else {
                    foundNode = parentNode.right;
                    TreeNode leftPart = foundNode.left != null ? foundNode.left : null;
                    TreeNode rightPart = foundNode.right != null ? foundNode.right : null;

                    //Left Part node 
                    if(leftPart != null && rightPart != null) {
                        //get the rightMost Part of leftPart
                        TreeNode rightMostPart = getTheRightMostPart(leftPart);
                        rightMostPart.right = rightPart;
                        parentNode.right = leftPart;

                        
                    }
                    else if (leftPart == null && rightPart != null) {
                        parentNode.right = rightPart;
                    }
                    else {
                        parentNode.right = leftPart;
                    }
                }
            }
                return root;
            }
        }

        
    }

    public TreeNode getTheRightMostPart(TreeNode root) {
        if(root == null || root.right == null) return root;
        return getTheRightMostPart(root.right);
    }


    //First find out the parent node
    public TreeNode findParentNode(TreeNode root, int key) {
        // base case
        if(root == null || (root.left != null && root.left.val == key) || (root.right != null && root.right.val == key)) return root;

        return key < root.val ? findParentNode(root.left, key) : findParentNode(root.right, key);

    }
}