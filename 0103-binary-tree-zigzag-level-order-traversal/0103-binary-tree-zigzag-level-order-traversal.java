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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        recursion(answer, root);
        return answer;
    }

    public void recursion(List<List<Integer>> answer, TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean flag = true;
        
        while(!que.isEmpty()) {
            int len = que.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < len; i++) {
                TreeNode node = que.peek();
                que.remove();
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
                list.add(node.val);

                
            }
            if(!flag) reverse(list);
            answer.add(new ArrayList<>(list));
            flag = !flag;
        }
    }

    public void reverse(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;

        while(start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }
}   