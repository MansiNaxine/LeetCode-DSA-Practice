class Solution {
    public boolean isBipartite(int[][] graph) {
        
        // return bfsTraversal(graph);

        return dfsTraversal(graph);
    }

    public boolean dfsTraversal(int[][] graph) {
        int n = graph.length;
        int visited[] = new int[n];
        int visitedColour[] = new int[n];

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                visitedColour[i] = 0;
                if(!(dfsRecursion(visited, graph, i, n, visitedColour))) return false;
            }
        }

        return true;
    }

    public boolean dfsRecursion(int visited[], int[][] graph, int root, int n, int[] visitedColour) {
        visited[root] = 1;

        for(int ele : graph[root]) {
            if(visited[ele] == 0) {
                if (visitedColour[root] == 0) visitedColour[ele] = 1;
                else visitedColour[ele] = 0;
                if(!(dfsRecursion(visited, graph, ele, n, visitedColour))) return false;
            }
            else if (visitedColour[ele] == visitedColour[root]) return false;
        }

        return true;
    }

    public boolean bfsTraversal(int[][] graph) {
        int n = graph.length;
        //make sure that not traversing again
        int[] visited = new int[n];
        //maintain the colours
        int[] visitedColour = new int[n];
        
        //Apply BFs for each given node
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