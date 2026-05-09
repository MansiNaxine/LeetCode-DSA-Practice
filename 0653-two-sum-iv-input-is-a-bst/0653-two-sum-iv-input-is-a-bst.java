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
    boolean flag;
    Stack<TreeNode> st1 = new Stack<>();
    Stack<TreeNode> st2 = new Stack<>();

    BSTIterator(TreeNode root, boolean flag) {
        this.root = root;
        this.flag = flag;
        addAllNodesToStack(root);
    }

    public int next() {
        TreeNode newNode = null;
        int val = 0;
        if(!flag && !st1.isEmpty()) {
            newNode = st1.pop();
            val = newNode.val;
            if(newNode.right != null) addAllNodesToStack(newNode.right);
        }
        else if (!st2.isEmpty()) {
            newNode = st2.pop();
            val = newNode.val;
            if(newNode.left != null) addAllNodesToStack(newNode.left);
        }
        return val;
    }

    public void addAllNodesToStack(TreeNode root) {
        if(root == null) return;

        if (!flag) {
            st1.push(root);
            addAllNodesToStack(root.left);
        }
        else {
            st2.push(root);
            addAllNodesToStack(root.right);
        }
        
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {

        if(root == null || (root.left == null && root.right == null)) return false;
        BSTIterator bs1 = new BSTIterator(root, false);
        BSTIterator bs2 = new BSTIterator(root, true);
        int val1 = bs1.next();
        int val2 = bs2.next();

        while(val1 < val2) {
            if(val1 + val2 == k) return true;
            else if (val1 + val2 < k) {
                val1 = bs1.next();
            }
            else {

                val2 = bs2.next();
            }
        }

        return false;

        
        // return findAnswer(root, k);
    }

    // public boolean findAnswer(TreeNode root, int k) {


    //     List<Integer> list = new ArrayList<>();
    //     insertAllNodesValues(root, list);
    //     boolean answer = false;

    //     int i = 0;
    //     int j = list.size() - 1;

    //     while( i < j) {
    //         int a = list.get(i);
    //         int b = list.get(j);

    //         if(a + b == k) {
    //             answer = true;
    //             break;
    //         }
    //         else if(a + b < k) i++;
    //         else j--;
    //     }

    //     return answer;
    // }

    // public void insertAllNodesValues(TreeNode root, List<Integer> list) {
    //     //base case
    //     if(root == null) return;

    //     //recursive case
    //     insertAllNodesValues(root.left, list);
    //     list.add(root.val);
    //     insertAllNodesValues(root.right, list);

    // }
}

