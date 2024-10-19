class NumMatrix {

    int pre_sum[][]=new int[200][200];
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(i==0 && j==0){
                    pre_sum[i][j]=matrix[i][j];
                }else if(i==0){
                    pre_sum[i][j]=pre_sum[i][j-1]+matrix[i][j];
                }else if(j==0){
                   pre_sum[i][j]=pre_sum[i-1][j]+matrix[i][j]; 
                }else{
                    pre_sum[i][j]=pre_sum[i][j-1]+pre_sum[i-1][j]-pre_sum[i-1][j-1]+matrix[i][j]; 
                }
            }
        }
    }
    
    public int sumRegion(int r0, int c0, int r1, int c1) {

        int ans=pre_sum[r1][c1];
        if(r0>0){
            ans -=pre_sum[r0-1][c1];
        }
         if(c0>0){
            ans -=pre_sum[r1][c0-1];
        }
        if(r0>0 && c0>0){
            ans +=pre_sum[r0-1][c0-1];
        }

        return ans;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */