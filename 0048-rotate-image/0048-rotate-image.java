class Solution {
    public void rotate(int[][] matrix) {

      bruteForceApproach(matrix); 
    }

    public void bruteForceApproach(int[][] matrix) {

        //though it's given that , no need to use anoth 2D matrix still for bruteForceApproach Using 1
        int n = matrix.length;
        int[][] answer = new int[n][n];

        for(int j = 0; j < n; j++) {
            for(int i = n - 1; i >= 0; i--) {
                answer[j][n - i - 1] = matrix[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = answer[i][j];
            }
        }
    }
}