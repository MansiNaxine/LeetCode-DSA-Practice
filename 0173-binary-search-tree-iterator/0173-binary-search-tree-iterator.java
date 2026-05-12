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
class BSTIterator {

    TreeNode root;
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        this.root = root;
        pushAll(root, st);
    }
    
    public int next() {
        return !st.isEmpty() ? st.pop().val : 0;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void pushAll(TreeNode root, Stack<TreeNode> st) {
        if(root == null) return;

        
        pushAll(root.right, st);
        st.push(root);
        pushAll(root.left, st);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */