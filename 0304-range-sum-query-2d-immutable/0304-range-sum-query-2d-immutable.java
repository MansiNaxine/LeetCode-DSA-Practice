class NumMatrix {

        int[][] prefix ;
    public NumMatrix(int[][] matrix) {

        int n = matrix.length;
        prefix = new int[200][200];

       for(int i = 0; i < n; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == 0 && j == 0) {
                    prefix[i][j] = matrix[i][j];
                } else if (i == 0) {
                    prefix[i][j] = prefix[i][j - 1] + matrix[i][j];
                } else if (j == 0) {
                    prefix[i][j] = prefix[i - 1][j] + matrix[i][j];
                } else {
                    prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] + matrix[i][j] - prefix[i - 1][j - 1];
                }
            }
       }
        
    }
    
    public int sumRegion(int r0, int c0, int r1, int c1) {

        int ans = prefix[r1][c1];
        if(r0 > 0) ans -= prefix[r0-1][c1];
        if(c0 > 0) ans -= prefix[r1][c0-1];
        if(r0 > 0 && c0 > 0) ans += prefix[r0-1][c0-1];

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */