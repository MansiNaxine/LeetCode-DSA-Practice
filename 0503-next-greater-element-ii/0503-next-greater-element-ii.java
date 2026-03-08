class Solution {
    public int[] nextGreaterElements(int[] nums) {

        // return bruteForceApproach(nums);
        return optimalApproach(nums);
        
    }

    public int[] optimalApproach(int[] nums) {

        int n = nums.length;
        int newN = 2 * n;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        for(int i = newN - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i%n]) {
                st.pop();
            }

            if(st.isEmpty()) {
                nge[i%n] = -1;
            }
            else {
                nge[i%n] = st.peek();
            }

            st.push(nums[i%n]);
        }

        return nge;
    }

    public int[] bruteForceApproach(int[] nums) {

        int n = nums.length;
        int[] nge = new int[n];

        for(int i = 0 ; i < n; i++) {
            nge[i] = nums[i];
        }

        for(int i = 0; i < n; i++) {
            int ele = nums[i];
            for(int j = i + 1; j < (2 * n); j++) {
                if(nums[j%n] > nums[i]) {
                    nge[i] = nums[j%n];
                    break;
                }
            }

            if(nge[i] == ele) nge[i] = -1;
            
        }

        return nge;
    }
}