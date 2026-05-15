class Solution {
    public int findCircleNum(int[][] isConnected) {

        //first calculate the adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int n = isConnected.length;
        int m = isConnected[0].length;
        int[] visited = new int[n];
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < m; j++) {
                if(i != j && isConnected[i][j] == 1) {
                    adjacencyList.get(i).add(j);
                }
            }
        }

        int answerCount = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                answerCount++;
                dfsTraversal(adjacencyList, visited, i);
            }
        }

        return answerCount;
    }

    public void dfsTraversal(List<List<Integer>> adjacencyList, int[] visited, int root) {
        visited[root] = 1;

        for(int city : adjacencyList.get(root)) {
            if(visited[city] == 0) {
                dfsTraversal(adjacencyList, visited, city);
            }
        }
    }
}