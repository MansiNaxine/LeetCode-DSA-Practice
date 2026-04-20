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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        if(root == null) return list;
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode node = st.peek();
            while(node.left != null) {
                node = node.left;
                st.push(node);
            }
            while(!st.isEmpty() && (st.peek().right == null || (nodes.size() > 0 && nodes.get(list.size() - 1) == st.peek().right))) {
                nodes.add(st.peek());
                list.add(st.peek().val);
                st.pop();
            }
            if(st.isEmpty()) break;
            TreeNode node2 = st.peek();
            if(node2.right != null) {
                st.push(node2.right);
            }
        }

        return list;
    }
}