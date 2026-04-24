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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        answer.add(root.val);
        if(isLeaf(root)) return answer;
        collectLeftNodes(root.left, answer);
        collectLeafNodes(root, answer);
        List<Integer> rightList = new ArrayList<>();
        collectRightNodes(root.right, rightList);
        reverseFunc(rightList);
        answer.addAll(rightList);

        return answer;
    }

    public void reverseFunc(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        while(i < j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);

            i++;
            j--;
        }
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void collectLeafNodes(TreeNode root, List<Integer> list) {

        if(root == null) return;

        if(isLeaf(root)) list.add(root.val);
        collectLeafNodes(root.left, list);
        collectLeafNodes(root.right, list);
        
    }
    
    public void collectLeftNodes(TreeNode root, List<Integer> list) {

        if(root == null) return;
        if(!isLeaf(root)) list.add(root.val);
        collectLeftNodes(root.left, list);
        if(root.left == null) collectLeftNodes(root.right, list);

    }

    public void collectRightNodes(TreeNode root, List<Integer> list) {

        if(root == null) return;
        if(!isLeaf(root)) list.add(root.val);
        collectRightNodes(root.right, list);
        if(root.right == null) collectRightNodes(root.left, list);

    }

    
}