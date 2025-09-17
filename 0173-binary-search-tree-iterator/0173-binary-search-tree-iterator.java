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

    Queue<Integer> st;

    public BSTIterator(TreeNode root) {

        st = new LinkedList<>();
        insert(root);

    }
    
    public void insert(TreeNode root) {
        //base case
        if(root == null) return;

        //recursive case
        insert(root.left);
        st.add(root.val);
        insert(root.right);

    }
    public int next() {

        int answer = st.remove();

        return answer;
        
    }
    
    public boolean hasNext() {
        
        return st.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */