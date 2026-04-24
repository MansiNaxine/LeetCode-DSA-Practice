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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Pair> que = new LinkedList<>();
        Pair p =new Pair();
        p.node = root;
        p.cnt = 0;
        que.add(p);
        Map<Integer, Integer> map = new TreeMap<>();
        
        while(!que.isEmpty()) {
            int size = que.size();
            
            for(int i = 0; i < size; i++) {
                Pair pNew = que.peek();
                TreeNode newNode = pNew.node;
                int count = pNew.cnt;
                que.remove();
                
                if(!map.containsKey(count)) {
                    map.put(count, newNode.val);
                }
                
                if(newNode.right != null) {
                    Pair innerP = new Pair();
                    innerP.node = newNode.right;
                    innerP.cnt = count + 1;
                    que.add(innerP);
                }

                if(newNode.left != null) {
                    Pair innerP = new Pair();
                    innerP.node = newNode.left;
                    innerP.cnt = count + 1;
                    que.add(innerP);
                }
                
            }
        }
        
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
        
    }
}

class Pair {
    TreeNode node;
    int cnt;

    Pair() {
        this.node = null;
        cnt = 0;
    }

}