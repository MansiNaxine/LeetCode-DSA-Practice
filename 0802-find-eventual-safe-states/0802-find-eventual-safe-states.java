class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        //solve by using Kahn's Algroithm
        int n = graph.length;
        int[] inArr = new int[n];

        //Adjancy List Implementation
        List<List<Integer>> adjancyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjancyList.add(new ArrayList<>());
        }

        //Create an adjancyList;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                adjancyList.get(graph[i][j]).add(i);
                inArr[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ; i < n; i++) {
            if(inArr[i] == 0) que.add(i);
        }

        List<Integer> topoSort = new ArrayList<>();

        while(!que.isEmpty()) {
            int top = que.remove();
            topoSort.add(top);

            for(int ele : adjancyList.get(top)) {
                inArr[ele]--;
                if(inArr[ele] == 0) que.add(ele);
            }
        }

        Collections.sort(topoSort);
        return topoSort;
        
    }
}