class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1) return -1;

        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) distance[i][j] = 1;
            }
        }

        Queue<Pair> que = new LinkedList<>();
        Pair p = new Pair(1, new Pair(0, 0));
        que.add(p);

        int[] delRow = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delCol = {0, 1, 1, 1, 0, -1, -1, -1};

        while(!que.isEmpty()) {
            int step = que.peek().x;
            int innerRow = que.peek().inner.x;
            int innerCol = que.peek().inner.y;
            que.remove();

            if(innerRow == n - 1 && innerCol == m - 1) {
                return step;
            }

            for(int i = 0; i < 8; i++) {
                int currRow = innerRow + delRow[i];
                int currCol = innerCol + delCol[i];

                if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && grid[currRow][currCol] == 0 && distance[currRow][currCol] == 0) {
                    distance[currRow][currCol] = 1;
                    Pair innerP = new Pair(step + 1, new Pair(currRow,currCol));
                    que.add(innerP);
                }
            }
        }


        return -1;
    }
}

class Pair {

    int x;
    Pair inner;
    int y;

    Pair(int x, Pair inner) {
        this.x = x;
        this.inner = inner;
    }

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

}