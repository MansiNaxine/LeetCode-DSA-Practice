class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        //  return bruteForceApproach(arr);

        return optimalApproach(arr);
        
    }

    public int optimalApproach(int[] arr) {
        long MOD = 1000000007;
        long sum = 0;
        //Calculate prevSmaller index
        int n = arr.length;
        int[] prev = pse(arr);
        int[] next = nse(arr);

        for(int i = 0; i < n; i++) {
            int A = next[i] - i;
            int B = i - prev[i];
            long pro = (long)(A * B);

            sum = (sum + (arr[i] * pro)%MOD)%MOD;
        }

        return (int)sum;


    }

    public int[] nse(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                answer[i] = n;
            }
            else {
                answer[i] = st.peek();
            }

            st.push(i);
        }

        return answer;
    }

    public int[] pse(int[] arr) {
        
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[n];

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                answer[i] = -1;
            }
            else {
                answer[i] = st.peek();
            }

            st.push(i);
        }

        return answer;
    }


    public int bruteForceApproach(int[] arr) {
        int n = arr.length;
        //BruteForce Approach
        long sum = 0;
        long MOD = 1000000007;

        for(int i = 0 ; i < n; i++) {
            long min = arr[i];
            for(int j = i ; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum = (long)(sum + min)%MOD;
            }
        }

        return (int)sum;
    }
}