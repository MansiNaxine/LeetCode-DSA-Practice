class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        //first insert all zeroes in resultant array
        for(int i = 0; i < n; i++) {
            result[i] = 0;
        }

        //now push the elements in array beased on nextGreater
        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                result[st.peek()] = i - st.pop();
            }

            st.push(i);
        }

        return result;
        
    }
}