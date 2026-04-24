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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<Pair> que = new LinkedList<>();
        Map<Integer, List<int[]>> map = new TreeMap<>();//vertical-horizontal-listof nodes
        Pair p = new Pair();
        p.node = root;
        p.cnt = 0;
        que.add(p);
        int hLevel = 0;

        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0 ; i < size; i++) {
                Pair newP = que.peek();
                TreeNode newNode = newP.node;
                int count = newP.cnt;
                
                que.remove();
                if(!map.containsKey(count)) {
                    List<int[]> curr = new ArrayList<>();
                    int[] arr = new int[2];
                    arr[0] = hLevel;
                    arr[1] = newNode.val;
                    curr.add(arr);
                    map.put(count, curr);
                }
                else {
                    List<int[]> curr = map.get(count);
                     int[] arr = new int[2];
                    arr[0] = hLevel;
                    arr[1] = newNode.val;
                    curr.add(arr);
                    map.put(count, curr);
                }

                if(newNode.left != null) {
                    Pair p1 = new Pair();
                    p1.node = newNode.left;
                    p1.cnt = count - 1;
                    que.add(p1);
                }

                if(newNode.right != null) {
                    Pair p1 = new Pair();
                    p1.node = newNode.right;
                    p1.cnt = count + 1;
                    que.add(p1);
                }

            }
            hLevel++;
        }
        
        
        for(Map.Entry<Integer, List<int[]>> mp : map.entrySet()) {
            List<int[]> list = mp.getValue();
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0]; // sort by row
            });
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < list.size(); i++) {
                int[] arr = list.get(i);
                curr.add(arr[1]);
            }
            answer.add(new ArrayList<>(curr));
        }

    
        return answer;
    }

    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
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