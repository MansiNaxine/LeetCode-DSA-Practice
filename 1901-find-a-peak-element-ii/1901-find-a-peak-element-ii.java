class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while(low <= high) {

            int mid = (low + high)/2;
            int row = calculateRow(mid, mat);
            int col = mid;
            int left = col - 1 >= 0 ? mat[row][col - 1] : -1;
            int right = col + 1 <= m - 1 ? mat[row][col + 1] : -1;

            if (mat[row][col] > left && mat[row][col] > right) {
                return new int[]{row, col};
            }
            else if (mat[row][col] < left) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
        
    }

    public int calculateRow(int mid, int[][] mat) {

        int row = -1;
        int maxEle = Integer.MIN_VALUE;;

        for(int i = 0; i < mat.length; i++) {
            if(mat[i][mid] > maxEle) {
                maxEle = mat[i][mid];
                row = i;
            }
        }

        return row;                                                                                                 
    }
}