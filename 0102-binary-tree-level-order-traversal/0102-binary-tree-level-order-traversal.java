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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> currList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.peek();
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
                currList.add(node.val);
                que.remove();
            }
            answer.add(new ArrayList<>(currList));
        }
        
        return answer;
    }
}