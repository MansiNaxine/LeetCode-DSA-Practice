class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int answer[][] = new int[n][n];

        int k = 0;

       // while(k<n){
            for(int j=0; j<n; j++) {
                int l = 0;
                for(int i=n-1; i>=0; i--) {
                    answer[k][l] = matrix[i][j];
                    l++;
                }
             k++;
            }
       // }
        
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = answer[i][j];
            }
        }
    }
}