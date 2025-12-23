class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //Optimal Solution
        int i = m - 1;
        int j = 0;

        while(i >= 0 && j < n) {
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
            
        }

        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        //Copy all elements from nums2 to nums1
        int index = m ;
        for(int k = 0; k < n; k++) {
            nums1[index] = nums2[k];
            index++;
        }
        
    }
}