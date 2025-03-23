class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        //we have to create transform of the given matrix
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        //then just reverse the ea ch row
        for(int i=0; i<n; i++) {
            reverse(matrix[i]);
        }
        
    }

    public void reverse(int matrix[]) {
        int i = 0;
        int j = matrix.length - 1;

        while(i < j) {
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;

            i++;
            j--;
        }
    }
}