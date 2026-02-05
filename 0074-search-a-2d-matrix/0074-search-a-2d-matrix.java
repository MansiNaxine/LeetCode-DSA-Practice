class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        //Convert 2D matrix into 1D, by keeping below low and high at specified indexes
        int low = 0;
        int high = (n * m) - 1;

        while(low <= high) {
            int mid = (low + high)/2;
            //We have to get the row and column using mid
            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;

        }

        return false;
        
    }
}