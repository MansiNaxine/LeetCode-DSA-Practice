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
    public int amountOfTime(TreeNode root, int start) {
        int answer = 0;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode startNode = findOutParentNodes(map, root, start);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(startNode);
        visited.put(startNode, true);

        while(!que.isEmpty()) {
            int size = que.size();
            boolean flag = false;
            for(int i = 0; i < size; i++) {
                TreeNode node = que.peek();
                que.remove();

                if(node.left != null && (!visited.containsKey(node.left))) {
                    que.add(node.left);
                    visited.put(node.left, true);
                    flag = true;
                }

                if(node.right != null && (!visited.containsKey(node.right))) {
                    que.add(node.right);
                    visited.put(node.right, true);
                    flag = true;
                }

                if(map.containsKey(node) && (!visited.containsKey(map.get(node)))) {
                    que.add(map.get(node));
                    visited.put(map.get(node), true);
                    flag = true;
                }
            }

            if(flag) answer += 1;

        }

        return answer;
        
    }

    public TreeNode findOutParentNodes(Map<TreeNode, TreeNode> map, TreeNode root, int start) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        TreeNode startNode = null;
        while(!que.isEmpty()) {
            int size = que.size();
            
            for(int i = 0 ; i < size; i++) {
                TreeNode node = que.peek();
                if(node.val == start) startNode = node;
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

        return startNode;
    }
}