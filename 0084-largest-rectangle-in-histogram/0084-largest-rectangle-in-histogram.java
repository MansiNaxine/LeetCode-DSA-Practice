class Solution {

    public int[] previousSmallElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            result[i] = -1;
        }

        for(int i = n-1; i >= 0; i--) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                result[st.pop()] = i;
            }

            st.push(i);
        }

        return result;
    }

     public int[] nextSmallElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

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

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;

        int[] prevSmall = previousSmallElement(heights);
        int[] nextSmall = nextSmallElement(heights);

        for(int i = 0; i < n; i++) {
            int area = heights[i] * (nextSmall[i] - prevSmall[i] - 1);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        
    }
}