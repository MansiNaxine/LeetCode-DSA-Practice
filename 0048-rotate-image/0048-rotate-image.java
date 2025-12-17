class Solution {
    public void rotate(int[][] matrix) {
    
      //Time Complexity :-  O(2(n^2))
      //Space Complexity :-  O(n^2)
      //bruteForceApproach(matrix); 
    
      //Just to Avoid Space Complexity'
      optimalApproach(matrix);
    }

    public void optimalApproach(int[][] matrix) {

        int n = matrix.length;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix.length; j++) {
                if(i != j)  {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            reverese(matrix[i]);
        }

    }

    public void reverese(int[] arr) {
        int i = 0; 
        int j = arr.length - 1;

        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
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