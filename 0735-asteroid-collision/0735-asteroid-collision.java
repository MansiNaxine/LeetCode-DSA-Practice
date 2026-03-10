class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(asteroids[i] > 0) {
                st.push(asteroids[i]);
            }
            else {
                int abs = Math.abs(asteroids[i]);
                while(!st.isEmpty() && st.peek()  > 0 && st.peek() < abs) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == abs) {
                    st.pop();
                    continue;
                }
                int top = st.isEmpty() ? 0 : st.peek();
                if(st.isEmpty() || top < abs) st.push(asteroids[i]);
            }
        }

        int[] ans = new int[st.size()];
        int m = st.size();
        for(int i = m - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}