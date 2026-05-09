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

    public void recoverTree(TreeNode root) {
        //BruteForceapproach
        bruteForceApproach(root);
        return ;
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