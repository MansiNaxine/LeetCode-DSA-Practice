class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;

        while(low <= high) {
            int mid = (low + high)/2;
            int row = calculateMaxElementInColumn(mat, mid, n, m);
            int left = (mid - 1) >= 0 ? mat[row][mid - 1] : -1;
            int right = (mid + 1) < m ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid};
            }
            else if (mat[row][mid] < left ) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
        
    }

    public int calculateMaxElementInColumn(int[][] mat, int col, int n, int m) {
        
        int maxElement = Integer.MIN_VALUE;
        int row = -1;
        
        for(int i = 0; i < n; i++) {
            if(mat[i][col] > maxElement) {
                maxElement = mat[i][col];
                row = i;
            }
        }

        return row;
    }
}