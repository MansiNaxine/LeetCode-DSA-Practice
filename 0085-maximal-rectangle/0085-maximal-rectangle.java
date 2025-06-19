class Solution {

    public int[] previousSmallElement(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            result[i] = -1;
        }

        for(int i = n - 1; i>=0; i--) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                result[st.pop()] = i;
            }

            st.push(i);
        }

        return result;
    }


     public int[] nextGreaterElement(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            result[i] = n;
        }

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                result[st.pop()] = i;
            }

            st.push(i);
        }

        return result;
    }
    

    public int maxAreaByRow(int[] arr) {

        int n = arr.length;

        int[] prevSmall = previousSmallElement(arr);
        int[] nxtSmall = nextGreaterElement(arr);

        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            int area = arr[i] * (nxtSmall[i] - prevSmall[i] - 1);

            maxArea = Math.max(maxArea, area);

        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] result = new int[n][m];

        for(int i = 0; i < m; i++) {
            int sum = 0;
            for(int j = 0 ; j < n; j++) {
                if(matrix[j][i] == '1') {
                    sum += 1;
                } else {
                    sum = 0;
                }

                result[j][i] = sum;
            }
        }

        //now we will calculate maximum area by each row
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int area = maxAreaByRow(result[i]);

            maxArea = Math.max(maxArea, area);

        }

        return maxArea;
        
    }
}