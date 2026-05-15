class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;

        //never alter the data in original givem matrix
        int m = image[0].length;
        int[][] newImage = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(image[i][j] == image[sr][sc]) {
                    newImage[i][j] = -1;
                }
            }
        }

        // int[][] visited = new int[n][m];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(i == sr && j == sc) {
                    newImage[i][j] = color;
                    dfsTraversal( i, j, newImage, delRow, delCol, -1, color);
                    break;
                }
            }
        }

        for(int i = 0 ; i < n; i++) {
            for(int j =0 ; j < m; j++) {
                if(newImage[i][j] != color) {
                    newImage[i][j] = image[i][j];
                }
            }
        }

        return newImage;
    }

    public void dfsTraversal(int row, int col,int[][] newImage, int[] delRow, int[] delCol, int color, int newcolor) {
        // visited[row][col] = 1;

        for(int i = 0 ; i < 4; i++) {
            int innerRow = row + delRow[i];
            int innerCol = col + delCol[i];
            if(innerRow >= 0 && innerRow < newImage.length && innerCol >= 0 && innerCol < newImage[0].length && newImage[innerRow][innerCol] == color) {
                newImage[innerRow][innerCol] = newcolor;
                dfsTraversal( innerRow, innerCol, newImage, delRow, delCol, color, newcolor);
            }
        }
    }


}