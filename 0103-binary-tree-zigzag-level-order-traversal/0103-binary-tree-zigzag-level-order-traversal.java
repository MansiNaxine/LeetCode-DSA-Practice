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

        List<List<Integer>> resultList=new ArrayList<>();
        if(root==null){
            return resultList;
        }
        
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int count=0;
        boolean reverse=false;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> list=new ArrayList<>(levelSize);
            
            for(int i=0;i<levelSize;i++){

                if(!reverse){
                         TreeNode node=queue.pollFirst();
                        list.add(node.val);
                        if(node.left!=null){
                            queue.addLast(node.left);
                        }
                        if(node.right!=null){
                            queue.addLast(node.right);
                        }
                }else{
                        TreeNode node=queue.pollLast();
                        list.add(node.val);
                        if(node.right!=null){
                            queue.addFirst(node.right);
                        }
                        if(node.left!=null){
                            queue.addFirst(node.left);
                        }

                }

                
            }
                reverse=!reverse;

            resultList.add(list);
        }

        return resultList;
    }
}