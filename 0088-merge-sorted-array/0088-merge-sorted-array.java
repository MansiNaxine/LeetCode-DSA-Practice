class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;
        int index = 0;

        int answer[] = new int[m+n];

        while(i<m && j<n) {
            if(nums1[i] <= nums2[j]) {
                answer[index] = nums1[i];
                i++;
            } else {
                answer[index] = nums2[j];
                j++;
            }

            index++;
        }

        while(i<m) {
            answer[index] = nums1[i];
            i++;
            index++;
        }

        while(j<n) {
            answer[index] = nums2[j];
            j++;
            index++;
        }

        for(int k=0; k<answer.length; k++) {
            nums1[k] = answer[k];
        }
        
    }
}