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

    TreeNode first = null;
    TreeNode middle = null;
    TreeNode last = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        //BruteForceapproach
        // bruteForceApproach(root);
        optimalApproach(root);
        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        return ;
    }

    public void optimalApproach(TreeNode root) {
        if(root == null) return;

        optimalApproach(root.left);
        if(prev != null && prev.val > root.val ) {
            if(first == null) {
                first = prev;
                middle = root;
            }
            else {
                last = root;
            }
        }

        prev = root;
        optimalApproach(root.right);

    }

    public void bruteForceApproach(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        insertAllNodesValues(root, list);
        Collections.sort(list);

        correctBST(root, list);

    }

    public void correctBST(TreeNode root, List<Integer> list) {
        //base case
        if(root == null) return;

        //recursive case
        correctBST(root.left, list);
        if(root.val != list.getFirst()) {
            root.val = list.getFirst();
        }
        list.remove(list.getFirst());
        correctBST(root.right, list);

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