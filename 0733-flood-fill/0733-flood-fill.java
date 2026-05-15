class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;

        //never alter the data in original givem matrix
        int m = image[0].length;
        int[][] newImage = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                newImage[i][j] = image[i][j];
            }
        }

        int[][] visited = new int[n][m];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(i == sr && j == sc && visited[i][j] == 0) {
                    newImage[i][j] = color;
                    dfsTraversal(visited, i, j, newImage, delRow, delCol, image[sr][sc], color);
                }
            }
        }

        return newImage;
    }

    public void dfsTraversal(int[][] visited, int row, int col,int[][] newImage, int[] delRow, int[] delCol, int color, int newcolor) {
        visited[row][col] = 1;

        for(int i = 0 ; i < 4; i++) {
            int innerRow = row + delRow[i];
            int innerCol = col + delCol[i];
            if(innerRow >= 0 && innerRow < newImage.length && innerCol >= 0 && innerCol < newImage[0].length && visited[innerRow][innerCol] == 0 && newImage[innerRow][innerCol] == color) {
                newImage[innerRow][innerCol] = newcolor;
                dfsTraversal(visited, innerRow, innerCol, newImage, delRow, delCol, color, newcolor);
            }
        }
    }


}