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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // if(preorder.length == 0){
        //     return null;
        // }

        // int root=preorder[0];
        // int index=0;

        // for(int i=0;i<inorder.length;i++){
        //     if(inorder[i]==root){
        //         index=i;
        //     }
        // }

        // TreeNode node=new TreeNode(root);

        // node.left=buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        // node.right=buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));

        // return node;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int[] index={0};
        return helper(preorder,inorder,map,0,preorder.length-1,index);
 
    }


    public TreeNode helper(int[] preOrder, int[] inOrder,HashMap<Integer,Integer> map,int left,int right,int[] index ){

        if(left>right){
            return null;
        }
        int current=preOrder[index[0]];
        index[0]++;

        TreeNode node=new TreeNode(current);
        

        //leaf node condition
        if(left==right){
            return node;
        }
        int CurrentIndex=map.get(current);
        node.left=helper(preOrder,inOrder,map,left,CurrentIndex-1,index);
        node.right=helper(preOrder,inOrder,map,CurrentIndex+1,right,index);

        return node;
    }
}