class Solution {
    public void setZeroes(int[][] matrix) {

        //Total Time Complexity :- O(m * n) * O(m + n) + O(m * n)
        //Space Complexity :- O(m * n)
        //BruteForceApproach
        //bruteForceApproach(matrix);

        //To Optimize the Space Complexity
        optimalApproach(matrix);
    }

    public void optimalApproach(int[][] matrix) {
        int n = matrix.length;
        int colZero = 0;
        int[] rows = new int[n];
        int[] cols = new int[matrix[0].length];

        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(j != 0) {
                    if(matrix[i][j] == 0) {
                        cols[j] = 1;
                        rows[i] = 1;
                    }
                }
                else if (j == 0) {
                    if(matrix[i][j] == 0) {
                        colZero = 1;
                        rows[i] = 1;
                    }
                }
            }
        }

        for(int j = 1; j < cols.length; j++) {
            if(cols[j] == 1) {
                setEntireColumntoZero(matrix, j);
            }
        }

         for(int i = 0; i < rows.length; i++) {
            if(rows[i] == 1) {
                setEntireRowtoZero(matrix, i);
            }
        }

        if(colZero == 1) {
            setEntireColumntoZero(matrix, 0);
        }
    }

    public void setEntireColumntoZero(int[][] matrix, int col) {

        for(int i = 0; i < matrix.length ; i++) {
            if(matrix[i][col] != 0) matrix[i][col] = 0;
        }
    }

    public void setEntireRowtoZero(int[][] matrix, int row) {

        for(int j = 0 ; j < matrix[0].length; j++) {
            if(matrix[row][j] != 0) matrix[row][j] = 0;
        }
        
    }

    public void bruteForceApproach(int[][] matrix) {

        int n = matrix.length;
        int[][] answerMatrix = new int[n][matrix[0].length];
        int row = -1;
        int col = -1;
        
        //Check for zero value
        //And call function to mark complete corresponding row and column as -1
        //Time Complexity :-  O(m * n) * O(m + n)
        for(int i = 0; i < n; i++) {
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