class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] prev = previousSmaller(heights);
        int[] next = nextSmaller(heights);
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int diff = next[i] - prev[i] - 1;
            int area = heights[i] * diff;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int[] nextSmaller(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();

            st.push(i);
        }

        return ans;
    }

    public int[] previousSmaller(int[] arr) {
        
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();

            st.push(i);
        }

        return ans;
    }
}