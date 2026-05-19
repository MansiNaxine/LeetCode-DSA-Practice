class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        //Create an adjancey List
        // List<List<Integer>> adjancyList = new ArrayList<>();
        // for(int i = 0; i < n; i++) {
        //     adjancyList.add(new ArrayList<>());
        // }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0 ; j < graph[i].length; j++) {
        //         adjancyList.get(i).add(graph[i][j]);
        //     }
        // }

        int[] visited = new int[n];
        int[] visitedColour = new int[n];
        

        for(int i = 0 ; i < n; i++) {

            if(visited[i] == 1) continue;
            Queue<Integer> que = new LinkedList<>();
            que.add(i);
            visited[i] = 1;
            visitedColour[i] = 0;

            while(!que.isEmpty()) {
                int root = que.remove();
                int colour = visitedColour[root];

                for(int element : graph[root]) {
                    if(visited[element] == 0) {
                        visited[element] = 1;
                        if(colour == 0) visitedColour[element] = 1;
                        else visitedColour[element] = 0;
                        que.add(element);
                    }
                    else if(visitedColour[element] == colour){
                        return false;
                    }
                }
            }
        }

        return true;

    }
}