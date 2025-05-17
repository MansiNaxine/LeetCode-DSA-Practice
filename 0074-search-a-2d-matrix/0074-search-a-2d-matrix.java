class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //we have to find the solution in O(log (m * n))
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0; 
        int j = n - 1;

        //first get the row by performing binary search on last column
        int row = 0;
        int start = 0;
        int end = m - 1;

        //if row i single then no need to apply binary search over last column
        if(m > 1) {
            while(start <= end) {
                int mid = (start + end) / 2;
                 if(matrix[mid][n - 1] >= target) {
                    row = mid; 
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
             }
        } 

        //row = (row == -1) ? 0 : row;
        

        start = 0;
        end = n - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}