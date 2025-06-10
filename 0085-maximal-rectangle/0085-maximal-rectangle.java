class Solution {

    public int[] previousSmallElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            result[i] = -1;
        }

        for(int i = n-1 ; i >= 0; i--) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                result[st.pop()] = i;
            }

            st.push(i);
        }

        return result;
    }

    public int[] nextSmallElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            result[i] = n;
        }

        for(int i = 0 ; i < n; i++) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                result[st.pop()] = i;
            }

            st.push(i);
        }

        return result;
    }

    public int maximalRectangle(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        //List<List<Integer>> list = new ArrayList<>();

        int result[][] = new int[row][col];

        //outer we will take column loop and inner will be for row
        for(int j = 0; j < col; j++) {
            int sum = 0;
            for(int i = 0; i < row; i++) {
                if(matrix[i][j] == '1') {
                    sum += 1;
                } else {
                    sum = 0;
                }

                result[i][j] = sum;
            } 
        }

        int maxArea = 0;
       for(int i = 0; i < row; i++) {
        int area = maxSumForEachRow(result[i]);
        maxArea = Math.max(area, maxArea);

       }

       return maxArea;
        
    }

    private int maxSumForEachRow(int[] result) {
        int n = result.length;
         int[] previuosSmall = previousSmallElement(result);
        int[] nextSmall = nextSmallElement(result);

        int maxSum = 0;

        for(int i = 0; i < n; i++) {
            int width = nextSmall[i] - previuosSmall[i] - 1;
            int area = result[i] * width;

            maxSum = Math.max(maxSum, area);

        }

        return maxSum;
    }
}