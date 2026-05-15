class Solution {
    public int orangesRotting(int[][] grid) {

        //Can Go with breadth first search
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] newGrid = new int[n][m]; //Always prefer not to modify the original array
        int cnt = 0;
        int cntOfRotOranges = 0;
        Queue<Pair> que = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                newGrid[i][j] = grid[i][j];

                if(grid[i][j] == 2) {
                    Pair inner = new Pair(i, j);
                    que.add(inner);
                    visited[i][j] = 2;
                }
                else if(grid[i][j] == 1) {
                    visited[i][j] = 1;
                    cnt++;
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};
        int cntTwo = 0;


        while(!que.isEmpty()) {
            int size = que.size();
            boolean rot = false;
            for(int i = 0; i < size; i++) {
                Pair top = que.remove();
                int innerR = top.row;
                int innerC = top.col;
                for(int j = 0 ; j < 4; j++) {
                    int delR = innerR + delRow[j];
                    int delC = innerC + delCol[j];

                    if(delR >= 0 && delR < n && delC >= 0 && delC < m && visited[delR][delC] == 1 && newGrid[delR][delC] == 1) {
                        visited[delR][delC] = 2;
                        newGrid[delR][delC] = 2;
                        rot = true;
                        cntTwo++;
                        Pair inner = new Pair(delR, delC);
                        que.add(inner);
                    }
                }
            }

            if(rot) cntOfRotOranges += 1;
        }  


        return cntTwo != cnt ? -1 : cntOfRotOranges;
        
    }
}

class Pair {
    int row = 0;
    int col = 0;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

}