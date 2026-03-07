class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[] nge = new int[m];
        // int[] ngeNw = new int[n]; Modifiying original array is not a good option but still to reduce time complexity i hv done that
        Stack<Integer> st = new Stack<>();

        for(int i = m - 1; i >= 0; i--) {

            while(!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                nge[i] = -1;
            }
            else {
                nge[i] = st.peek();
            }

            st.push(nums2[i]);
        }

        for(int i = 0; i < n ; i++ ) {
            for(int j = 0; j < m; j++) {
                if(nums2[j] == nums1[i]) {
                    nums1[i] = nge[j]; // break the inner loop to reduce time
                    break;
                }
            }
        }

        return nums1;
        
    }
}