/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        findOutParentNodes(map, root);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(target);
        visited.put(target, true);

        while(!que.isEmpty()) {
            int size = que.size();
            if(k <= 0) break;
            for(int i = 0 ; i < size; i++) {
                TreeNode node = que.peek();
                que.remove();
                if(node.left != null && (!visited.containsKey(node.left))) {
                    que.add(node.left);
                    visited.put(node.left, true);
                }

                if(node.right != null && (!visited.containsKey(node.right))) {
                    que.add(node.right);
                    visited.put(node.right, true);
                }

                if(map.containsKey(node) && (!visited.containsKey(map.get(node)))) {
                    que.add(map.get(node));
                    visited.put(map.get(node), true);
                }
            }
            k--;
        }

        int size = que.size();
        for(int i = 0 ; i < size ; i++) {
            int innerVal = que.peek().val;
            que.remove();
            answer.add(innerVal);

        }

        return answer;
    }

    public void findOutParentNodes(Map<TreeNode, TreeNode> map, TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.peek();
                que.remove();
                if(node.left != null) {
                    que.add(node.left);
                    map.put(node.left, node);
                }

                if(node.right != null) {
                    que.add(node.right);
                    map.put(node.right, node);
                }
            }
        }
    }
}