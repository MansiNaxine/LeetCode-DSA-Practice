class Solution {
    public int findJudge(int n, int[][] trust) {

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            st.push(i + 1);
        }

        int m = trust.length;
        int[] freqL = new int[1001];
        int[] freqR = new int[1001];

        for(int i = 0 ; i < m; i++) {

            int eleL = trust[i][0];
            int eleR = trust[i][1];
            freqL[eleL]++;
            freqR[eleR]++;
        }

        int ans = 0;

        while(!st.isEmpty()) {
            int a = st.peek();

            if(freqL[a] == 0 &&  freqR[a] == n-1) {
                ans = a;
                break;
            } else {
                st.pop();
            }

        }

        if(st.size() == 0) return -1;

        return ans;

    }

}