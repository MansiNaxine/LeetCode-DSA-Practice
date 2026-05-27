class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int m = edges.length;
        int q = edges[0].length;
        int[][] dist = new int[n][n];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int e = edges[i][2];
            
            dist[u][v] = e;
            dist[v][u] = e;
        }
        
        for(int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        //Apply Floyd Warshall Algo
        for(int k = 0; k < n; k++) {
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < n; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int cityNum = 0;
        int cityCnt = n;
        for(int i = 0 ; i < n; i++) {
            int cnt = 0;
                for(int j = 0 ; j < n; j++) {
                    if(dist[i][j] <= distanceThreshold) {
                        cnt++;
                    }
                }
            if(cnt <= cityCnt) {
                cityCnt = cnt;
                cityNum = i;
            }
        }

        return cityNum;

    }
}