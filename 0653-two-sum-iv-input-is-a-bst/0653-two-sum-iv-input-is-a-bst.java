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
    public boolean findTarget(TreeNode root, int k) {
        
        List<Integer> list = new ArrayList<>();
        insertAllNodesValues(root, list);
        boolean answer = false;

        int i = 0;
        int j = list.size() - 1;

        while( i < j) {
            int a = list.get(i);
            int b = list.get(j);

            if(a + b == k) {
                answer = true;
                break;
            }
            else if(a + b < k) i++;
            else j--;
        }

        return answer;

    }

    public void insertAllNodesValues(TreeNode root, List<Integer> list) {
        //base case
        if(root == null) return;

        //recursive case
        insertAllNodesValues(root.left, list);
        list.add(root.val);
        insertAllNodesValues(root.right, list);

    }
}