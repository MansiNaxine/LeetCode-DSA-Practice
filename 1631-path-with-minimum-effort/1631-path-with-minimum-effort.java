class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int[][] distance = new int[n][m];
        for(int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int distanceAns = Integer.MAX_VALUE;

        PriorityQueue<Pair> que = new PriorityQueue<>((a, b) -> a.x - b.x);
        Pair p = new Pair(0, new Pair(0, 0));
        distance[0][0] = 0;
        que.add(p);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(!que.isEmpty()) {
            int diff = que.peek().x;
            int row = que.peek().inner.x;
            int col = que.peek().inner.y;
            que.remove();

            if(row == n - 1 && col == m - 1) {
                distanceAns = Math.min(distanceAns, diff);
            }

            for(int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newDist = Math.max(diff, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if(newDist < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newDist;
                        Pair innerP = new Pair(newDist, new Pair(newRow, newCol));
                        que.add(innerP);
                    }

                }
            }
        }

        return distanceAns;
    }
}

class Pair {
    int x;
    int y;
    Pair inner;

    Pair(int x, Pair inner) {
        this.x = x;
        this.inner = inner;
    }

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}