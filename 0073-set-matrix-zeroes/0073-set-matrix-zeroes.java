class Solution {
    public void setZeroes(int[][] matrix) {

        //Total Time Complexity :- O(m * n) * O(m + n) + O(m * n)
        //Space Complexity :- O(m * n)
        //BruteForceApproach
        bruteForceApproach(matrix);
    }

    public void bruteForceApproach(int[][] matrix) {

        int n = matrix.length;
        int[][] answerMatrix = new int[n][matrix[0].length];
        
        
        //Check for zero value
        //And call function to mark complete corresponding row and column as -1
        //Time Complexity :-  O(m * n) * O(m + n)
        for(int i = 0; i < n; i++) {
                int row = -1;
                int col = -1;
            for(int j = 0 ; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    row = i;
                    col = j;
                    changeMatrix(answerMatrix, row, col);
                }
            }
        }

        //change all marked element as -1 to 0
        //Time Complexity :-  O(m * n)
        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < answerMatrix[i].length; j++) {
                if(answerMatrix[i][j] == -1) {
                    matrix[i][j] = 0;
                } 
            }
        }

    }

    public void changeMatrix(int[][] matrix, int row, int col) {

        for(int j = 0; j < matrix[0].length; j++) {
             matrix[row][j] = -1;
        }

        for(int i = 0; i < matrix.length; i++) {
             matrix[i][col] = -1;
        }
    }
}