class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] answer = new int[n][m];
        int[][] visited = new int[n][m]; 
        Queue<Pair> que = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(mat[i][j] == 0) {
                    visited[i][j] = 1;
                    Pair p = new Pair(i, j);
                    que.add(p);
                }
            }
        }

        //Also we have to check for Adjacent four sides
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        //Breadth first traversal logic
        while(!que.isEmpty()) {
            int currRow = que.peek().row;
            int currCol = que.peek().col;
            que.remove();

            for(int i = 0; i < 4; i++) {
                int newRow = currRow + delRow[i];
                int newCol = currCol + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol] == 0) {
                    int cnt = answer[currRow][currCol];
                    cnt += mat[newRow][newCol];
                    visited[newRow][newCol] = 1;
                    answer[newRow][newCol] = cnt;
                    Pair p = new Pair(newRow, newCol);
                    que.add(p);
                }
            }
        }

        return answer;
    }
}

class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}