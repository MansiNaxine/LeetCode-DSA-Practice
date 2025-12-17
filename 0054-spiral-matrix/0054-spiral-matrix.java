class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> answer = new ArrayList<>();
        int n = matrix.length;
        boolean[][] visited = new boolean[n][matrix[0].length];
        int left = 0;
        int right = matrix[0].length - 1; ;
        int top = 0;
        int bottom = n - 1;

        //Left to Right
        while(left <= right && top <= bottom) {
            for(int i = left; i <= right; i++) {
                if(!visited[top][i]) {
                    answer.add(matrix[top][i]);
                    visited[top][i] = true;
                }

            }
            top += 1;

            //from Top to Bottom
            for(int i = top; i <= bottom; i++) {
                if(!visited[i][right]) {
                    answer.add(matrix[i][right]);
                    visited[i][right] = true;
                }
            }
            right -= 1;

            //from right to left
            for(int i = right; i >= left; i--) {
                if(!visited[bottom][i]) {
                    answer.add(matrix[bottom][i]);
                    visited[bottom][i] = true;
                }
            }
            bottom -= 1;

            //from bottom to top
            for(int i = bottom; i >= top; i--) {
                if(!visited[i][left]) {
                    answer.add(matrix[i][left]);
                    visited[i][left] = true;
                }

            }
            left += 1;

        }

        return answer;

    }
}