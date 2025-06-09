class Solution {

    public int[] previousSmallelement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            result[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

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

        for(int i = 0; i < n; i++) {
            result[i] = n;
        }

        Stack<Integer> st = new Stack<>();

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

        int[] nextSmall = nextSmallElement(heights);
        int[] previousSmall = previousSmallelement(heights);

        for(int i = 0; i < n; i++) {
            int area = heights[i] * (nextSmall[i] - previousSmall[i] - 1);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        
    }
}