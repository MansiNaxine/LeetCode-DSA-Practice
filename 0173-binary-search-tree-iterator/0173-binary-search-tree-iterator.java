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
    List<TreeNode> list = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        this.root = root;
        addElements(root, list);
    }
    
    public int next() {
        int ans = 0;
        if(!list.isEmpty()) {
            ans = list.get(0).val;
        }

        list.remove(list.get(0));
        return ans;

    }
    
    public boolean hasNext() {

        return !list.isEmpty();
    }

    public void addElements(TreeNode root, List<TreeNode> list) {
        if(root == null) return;

        
        addElements(root.left, list);
        list.add(root);
        addElements(root.right, list);

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */