class Solution {
    public void rotate(int[][] matrix) {

        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //transpose matrix
                if(i<j){
                    int temp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }
            }
        }

        //traverse through each row to swap the elements
        for(int i=0;i<n;i++){
            move(matrix[i]);
        }
        
    }

    public void move(int[] matrix){
        int i=0;
        int j=matrix.length-1;

        while(i<j){
            int temp=matrix[i];
            matrix[i]=matrix[j];
            matrix[j]=temp;


            i++;
            j--;
        }
    }
}