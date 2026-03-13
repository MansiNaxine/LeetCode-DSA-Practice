class Solution {
    public long subArrayRanges(int[] nums) {
        
        return subArrayMaxSum(nums) - subArrayMinSum(nums);
    }

    public long subArrayMinSum(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int[] prev = previousSmall(nums);
        int[] next = nextSmall(nums);

        for(int i = 0 ; i < n ; i++) {
            long A = (long)(next[i] - i);
            long B = (long)(i - prev[i]);
            long total = (long)(A * B);
            sum = sum + (nums[i] * total);
        }

        return sum;


    }

    public long subArrayMaxSum(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int[] prev = previousGreater(nums);
        int[] next = nextGreater(nums);

        for(int i = 0 ; i < n ; i++) {
            long A = (long)(next[i] - i);
            long B = (long)(i - prev[i]);
            long total = (long)(A * B);
            sum = sum + (nums[i] * total);
        }

        return sum;


    }

    public int[] previousSmall(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] nextSmall(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = n;
            }
            else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] previousGreater(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

    public int[] nextGreater(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = n;
            }
            else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }

}