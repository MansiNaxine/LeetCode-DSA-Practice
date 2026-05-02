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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> que = new LinkedList<>();
        Pair pOuter = new Pair();
        pOuter.node = root;
        pOuter.index = 0;
        que.add(pOuter);
        int max = Integer.MIN_VALUE;

        while(!que.isEmpty()) {
            int size = que.size();
            int leftVal = Integer.MAX_VALUE;
            int rightVal = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode innerNode = que.peek().node;
                int indexVal = que.peek().index;
                min = Math.min(min, indexVal);
                indexVal = indexVal - min;
                que.remove();

                if(innerNode.left != null) {
                    Pair p  = new Pair();
                    p.node = innerNode.left;
                    p.index = (2 * indexVal) + 1;
                    leftVal = Math.min(leftVal, p.index);
                    if(innerNode.right == null) rightVal = Math.max(rightVal, p.index);
                    que.add(p);
                }

                if(innerNode.right != null) {
                    Pair p  = new Pair();
                    p.node = innerNode.right;
                    p.index = (2 * indexVal) + 2;
                    if(innerNode.left == null) leftVal = Math.min(leftVal, p.index);
                    rightVal = Math.max(rightVal, p.index);
                    que.add(p);
                }

                max = (leftVal == Integer.MAX_VALUE && rightVal == Integer.MIN_VALUE) ? Math.max(max, 1) : Math.max(max, rightVal - leftVal + 1);
                   

            }
        }


        return max;
        
    }
}

public class Pair {
    
    TreeNode node;
    int index;
    Pair() {
        this.node = null;
        this.index = 0;
    }
}