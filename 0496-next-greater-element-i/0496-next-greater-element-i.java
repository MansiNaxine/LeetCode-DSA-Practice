class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums2.length;
        int result[] = new int[n];

        for(int i = 0; i < n; i++) {
            result[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                result[st.pop()] = nums2[i];
            }

            st.push(i);
        }

        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < n; j++) {
                if(nums2[j] == nums1[i]) {
                    nums1[i] = result[j];
                    break;
                } 
            }
        }

        return nums1;
        
    }
}